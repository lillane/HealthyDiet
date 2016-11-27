package com.healthydiet.utils;

import java.sql.Connection;

/**
 * Created by Яна on 29.10.2016.
 */
public class dbUtils {
    //    public static void CreateDBconnection() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://hostname:3306/FirstBase", "root", "root");
//        conn.close();
//    }
    private static final String DB_CONNECTION = "com.mysql.jdbc.Driver";
    private static final String DB_DRIVER = "jdbc:mysql://hostname:3306/FirstBase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        Connection statement = null;

        String createTableSQL = "CREATE TABLE DB_USER IF NOT EXIST ("
                + "USER_ID NUMBER(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";
 /*       try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        */
        return dbConnection;
    }
}
