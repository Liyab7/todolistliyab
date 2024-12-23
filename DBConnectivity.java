package com.freddie.to_do_list_app.DBConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectivity {

    private final String HOST = "localhost:3306"; //change to your port number
    private final String USERNAME = "root";
    private final String PASSWORD = "Fred8080"; // change to your password
    private final String DATABASENAME = "db_to_do_list"; // database name
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://" + HOST + "/" + DATABASENAME;
    private Connection connection;

    private static DBConnectivity connectivity;

    private DBConnectivity() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnectivity getInstance() {
        if (connectivity == null) {
            connectivity = new DBConnectivity();
        }
        return connectivity;
    }

    public Connection getConnection() {
        return connection;
    }


}

