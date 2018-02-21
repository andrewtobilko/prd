package com.tobilko.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Assignment {

    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:Cache://127.0.0.1:1972/SAMPLES";
        final String user = "Andrew";
        final String password = "Tobilko";

        final Connection connection = DriverManager.getConnection(url, user, password);




    }

}
