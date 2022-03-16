package dataMarketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class DataMarketplaceApplication{
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		SpringApplication.run(DataMarketplaceApplication.class, args);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(url, "root", "pass");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE [IF NOT EXISTS] customers;");
		stmt.executeUpdate("CREATE TABLE [IF NOT EXISTS] owners;");
		stmt.executeUpdate("CREATE TABLE [IF NOT EXISTS] datasets;");
		stmt.close();
		conn.close();
	}

}
