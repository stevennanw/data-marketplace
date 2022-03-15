package dataMarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class DataMarketplaceApplication{

	public static boolean tableExists(String tableName, Connection conn) throws SQLException {
		boolean found = false;
		DatabaseMetaData databaseMetaData = conn.getMetaData();
		ResultSet rs = databaseMetaData.getTables(null, null, tableName, null);
		while (rs.next()) {
			String name = rs.getString("TABLE_NAME");
			if (tableName.equals(name)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		SpringApplication.run(DataMarketplaceApplication.class, args);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(url, "root", "pass");
		Statement stmt = conn.createStatement();
		if(!tableExists("customers", conn)){
			stmt.executeUpdate("CREATE TABLE customer;");
		}
		if(!tableExists("owners", conn)){
			stmt.executeUpdate("CREATE TABLE owner;");
		}
		if(!tableExists("datasets", conn)){
			stmt.executeUpdate("CREATE TABLE dataset;");
		}

		stmt.close();
		conn.close();
	}

}
