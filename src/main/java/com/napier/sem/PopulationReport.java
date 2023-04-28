package com.napier.sem;

import java.sql.*;

public class PopulationReport {

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
                    "root", "Coursework");
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

    // Display all the countries in the world organized by largest population to smallest
    public void displayAllCountriesByPopulation() {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM country " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the countries in the world organized by largest population to smallest:");
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

    // Display all the countries in a continent organized by largest population to smallest
    public void displayCountriesByContinentPopulation(String continent) {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM country " +
                            "WHERE continent = '" + continent + "' " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the countries in " + continent + " organized by largest population to smallest:");
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

    // Display all the countries in a region organized by largest population to smallest
    public void displayCountriesByRegionPopulation(String region) {
        try {
            // Create a SQL statement
            Statement stmt = con.createStatement();

            // Execute the SQL query
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, population " +
                            "FROM country " +
                            "WHERE region = '" + region + "' " +
                            "ORDER BY population DESC");

            // Print the results
            System.out.println("All the countries in " + region + " organized by largest population to smallest:");
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

    // Main method
    public static void main(String[] args) {
        // Create a new PopulationReport object
        PopulationReport pr = new PopulationReport();

        // Connect to the database
        pr.connect("localhost:33060", "root", "password");

        // Display all the countries in the world organized by largest population to smallest
        pr.displayAllCountriesByPopulation();

        // Display all the countries in Europe organized by largest population to smallest
        pr.displayCountriesByContinentPopulation("Europe");

        // Display all the countries in the Caribbean organized by largest population to smallest
        pr.displayCountriesByRegionPopulation("Caribbean");

        // Disconnect from the database
        pr.disconnect();
    }
}