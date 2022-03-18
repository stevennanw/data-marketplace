package dataMarketplace;

import java.sql.*;

public class Validate {
    public static boolean checkCustomerID(int id) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from customers where customer_id=?");
        ps.setInt(1, id);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }

    public static boolean checkOwnerID(int id) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from owners where owner_id=?");
        ps.setInt(1, id);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }

    public static boolean checkOrderID(int id) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from orders where orderid=?");
        ps.setInt(1, id);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }

    public static boolean checkCustomer(int id,String pass) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from customers where customer_id=? and password=?");
        ps.setInt(1, id);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }

    public static boolean checkOwner(int id,String pass) throws ClassNotFoundException, SQLException {
        boolean status =false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        //creating connection with the database
        String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, "root", "pass");
        PreparedStatement ps = conn.prepareStatement("select * from owners where owner_id=? and password=?");
        ps.setInt(1, id);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        status = rs.next();
        return status;
    }
}