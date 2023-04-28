package com.napier.sem;

import java.sql.*;

public class CityReport {

    // Connection to MySQL database
    private Connection con = null;

    // Connect to the MySQL database
    public void connect(String location, String user, String password) {
        try {
            // Load database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                    user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    // Disconnect from the MySQL database
    public void disconnect() {
        if (con != null) {
            try {
                // Close the database connection
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Display all the cities in the world organized by largest population to smallest
    public void displayAllCitiesByPopulation() {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM city " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the cities in the world organized by largest population to smallest:");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                String name = rs.getString("name");
                int population = rs.getInt("population");
                System.out.printf("%-40s %d\n", name, population);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display all the cities in a continent organized by largest population to smallest
    public void displayCitiesByContinentPopulation(String continent) {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM city " +
                            "WHERE countrycode IN (SELECT code FROM country WHERE continent = '" + continent + "') " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the cities in " + continent + " organized by largest population to smallest:");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                String name = rs.getString("name");
                int population = rs.getInt("population");
                System.out.printf("%-40s %d\n", name, population);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display all the cities in a region organized by largest population to smallest
    public void displayCitiesByRegionPopulation(String region) {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM city " +
                            "WHERE countrycode IN (SELECT code FROM country WHERE region = '" + region + "') " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the cities in " + region + " organized by largest population to smallest:");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                String name = rs.getString("name");
                int population = rs.getInt("population");
                System.out.printf("%-40s %d\n", name, population);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a new CityReport object
        CityReport cr = new CityReport();

        // Connect to the database
        cr.connect("localhost:33060", "root", "Coursework");

        // Display all the cities in the world organized by largest population to smallest
        cr.displayAllCitiesByPopulation();

        // Display all the cities in Europe organized by largest population to smallest
        cr.displayCitiesByContinentPopulation("Europe");

        // Display all the cities in the Caribbean organized by largest population to smallest
        cr.displayCitiesByRegionPopulation("Caribbean");

        // Disconnect from the database
        cr.disconnect();
    }

}
