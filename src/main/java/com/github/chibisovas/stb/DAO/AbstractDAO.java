package com.github.chibisovas.stb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/java_rush_news";
    private static final String USERNAME ="root";
    private static final String PASSWORD = "Overmight_4140";

    protected static Connection connection;

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
