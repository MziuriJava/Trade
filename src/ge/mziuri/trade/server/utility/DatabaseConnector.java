package ge.mziuri.trade.server.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(DatabaseUtility.url, DatabaseUtility.username, DatabaseUtility.password);
    }
}
