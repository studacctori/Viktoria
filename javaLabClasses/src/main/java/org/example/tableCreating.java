package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class tableCreating {
    static final String DB_URL = "jdbc:postgresql://localhost/javavetdb";
    static final String USER = "myuser";
    static final String PASS = "mypass";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sqlCREATE = "CREATE TABLE Animals " +
                    "(id INTEGER not NULL, " +
                    " phone INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " birthDate DATE, " +
                    " PRIMARY KEY ( id ))";

            String sqlALTER = "ALTER TABLE Animals " +
                    "ADD FOREIGN KEY (phone) REFERENCES clients(id)"
                    ;

            stmt.executeUpdate(sqlALTER);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clientTableCrating(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE clients " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " phone INTEGER not NULL, " +
                    " email VARCHAR(50), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
