package LinkDatabase.LinkMySQL.LinkTool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkMySQL8_0_16 implements LinkMySQL {

    //声明Connection对象
    private Connection connection;
    //驱动程序名
    private String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private String url = "jdbc:mysql://114.116.4.196:3306/mingxiuDataBase?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    //MySQL配置时的用户名
    private String user = "root";
    //MySQL配置时的密码
    private String password = "Lp184126";

    public LinkMySQL8_0_16(String url, String user, String password) throws SQLException, ClassNotFoundException {
        //加载驱动程序
        Class.forName(this.driver);
        this.createConnection(url, user, password);
    }

    public LinkMySQL8_0_16() throws SQLException, ClassNotFoundException {
        //加载驱动程序
        Class.forName(this.driver);
        this.createConnection();
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void createConnection() throws ClassNotFoundException, SQLException {

        //1.getConnection()方法，连接MySQL数据库！！
        this.connection = DriverManager.getConnection(this.url,this.user,this.password);
    }

    @Override
    public void createConnection(String url, String userName, String password) throws SQLException, ClassNotFoundException {
        this.setPassword(password);
        this.setUser(userName);
        this.setUrl(url);
        this.createConnection();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
