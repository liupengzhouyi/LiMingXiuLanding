package LinkDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public interface LinkDatabase {

    Connection getConnection();

}
