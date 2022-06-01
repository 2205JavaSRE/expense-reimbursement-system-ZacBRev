package com.revature.util;

import org.postgresql.ds.PGConnectionPoolDataSource;

import javax.sql.PooledConnection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String URL = System.getenv("db_url");
    private static String DB_USERNAME = System.getenv("db_username");
    private static String DB_PASSWORD = System.getenv("db_password");

    private static PooledConnection connection;

    public static PooledConnection getConnection() {
        PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setServerNames(new String[]{URL});
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        try {
            connection = dataSource.getPooledConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
