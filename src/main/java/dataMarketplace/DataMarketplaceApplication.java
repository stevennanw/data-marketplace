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
		Connection conn = DriverManager.getConnection(url, "user", "pass");
		Statement stmt = conn.createStatement();
		if(!tableExists("customer", conn)){
			stmt.executeUpdate("CREATE TABLE customer(customerId int unsigned not null, password varchar(255) not null, email varchar(255) not null);");
		}
		if(!tableExists("owner", conn)){
			stmt.executeUpdate("CREATE TABLE owner(ownerId int unsigned not null, password varchar(255) not null, email varchar(255) not null);");
		}
		if(!tableExists("dataset", conn)){
			stmt.executeUpdate("CREATE TABLE dataset(datasetid int unsigned not null, name varchar(255) not null, price int unsigned not null, description varchar(255) not null, ownerId int unsigned not null);");
		}
	//	stmt.executeUpdate("insert into customer(customerId, password, email) values(1, ‘alice', 'a@google.com');");
	//	stmt.executeUpdate("INSERT INTO customer(id, name, email) VALUES(2, ‘bob', 'b@google.coom');");
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + ": " + rs.getString(2));
		}
//		stmt.close();
//		conn.close();
	}

}
