package server;

import java.sql.*;

// https://www.tutorialspoint.com/sqlite/sqlite_java.htm

public class TestSQLite {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/test.db");

           

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Database connection open");
    }
    
    private void createHouseTable(Connection conn) throws SQLException {
        Statement stmt  = conn.createStatement();
        String sql = "CREATE TABLE HOUSE " + 
                    "(ID INT PRIMARY KEY NOT NULL, " + 
                    "LOCATION TEXT NOT NULL, " +
                    "ADMIN_COMPANY TEXT NOT NULL, " +
                    "WASTE REAL, " +
                    "RECYCLABLE_WASTE REAL, " +
                    "WATER_IN REAL, " +
                    "WATER_OUT REAL, " +
                    "ENERGY REAL)";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    private void createPricesTable(Connection conn) throws SQLException {
        Statement stmt  = conn.createStatement();
        String sql = "CREATE TABLE HOUSE " + 
                    "(ID INT PRIMARY KEY NOT NULL, " + 
                    "LOCATION TEXT NOT NULL, " +
                    "ADMIN_COMPANY TEXT NOT NULL, " +
                    "WASTE REAL, " +
                    "RECYCLABLE_WASTE REAL, " +
                    "WATER_IN REAL, " +
                    "WATER_OUT REAL, " +
                    "ENERGY REAL)";
        stmt.executeUpdate(sql);
        stmt.close();
    }
    
}
