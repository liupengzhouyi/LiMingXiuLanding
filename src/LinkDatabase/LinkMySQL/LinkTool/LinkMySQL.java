package LinkDatabase.LinkMySQL.LinkTool;

import java.sql.Connection;
import java.sql.SQLException;

public interface LinkMySQL{

    Connection getConnection();

    void createConnection() throws ClassNotFoundException, SQLException;

    void createConnection(String url, String userName, String password) throws SQLException, ClassNotFoundException;

}


