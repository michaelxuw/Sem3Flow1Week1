package CI_Exercise;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {
    private HikariDataSource ds;
    private static final String USER = "dev";
    private static final String PASSWORD = "ax2";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/startcode_test?serverTimezone=Europe/Copenhagen";


    public ConnectionPool() {
        this(USER, PASSWORD, URL);
        setupConnection(USER, PASSWORD, URL);
    }

    public ConnectionPool(String user, String password, String url) {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            // Prod: hent variabler fra setenv.sh i Tomcats bin folder
            user = System.getenv("JDBC_USER");
            password = System.getenv("JDBC_PASSWORD");
            url = System.getenv("JDBC_CONNECTION_STRING");
        }
        setupConnection(user, password, url);
    }

    private void setupConnection(String user, String password, String url) {
        String logMsg = String.format("Connection Pool created for: (%s, %s, %s)", user, password, url);
        Logger.getLogger("web").log(Level.INFO, logMsg);
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(5);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        this.ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        Logger.getLogger("web").log(Level.INFO, ": get data connection");
        return ds.getConnection();
    }

    public void close() {
        Logger.getLogger("web").log(Level.INFO, "Shutting down connection pool");
        ds.close();
    }

}
