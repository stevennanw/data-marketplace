package dataMarketplace;

public class SQLInformationMapper {
    private int server_port = 8080;
    private String username = "root";
    private String password = "pass";
    private String url = "jdbc:mysql://localhost:3306/tempdb?serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public int getServer_port() {
        return server_port;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

}
