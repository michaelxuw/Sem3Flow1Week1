package CI_Exercise;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnector {
    private static ConnectionPool connectionPool;
    private static Connection singleton;

    public static void setConnection(ConnectionPool conn) {
        connectionPool = conn;
        singleton = null;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            //Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = connectionPool.getConnection();
        }
        return singleton;
    }

}
