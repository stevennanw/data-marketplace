package dataMarketplace;

import java.sql.*;

public class Validate {
    public static boolean checkCustomer(String pass,String email) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from customers where password=? and email=?");
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }

    public static boolean checkOwner(String pass,String email) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from owners where password=? and email=?");
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }
}