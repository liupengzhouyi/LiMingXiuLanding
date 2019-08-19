package LinkDatabase.LinkMySQL.LinkTool;

import java.sql.Connection;
import java.sql.SQLException;

public class LinkMySQLImpl implements LinkMySQL {

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void createConnection() throws ClassNotFoundException, SQLException {

    }

    @Override
    public void createConnection(String url, String userName, String password) throws SQLException, ClassNotFoundException {

    }
}
