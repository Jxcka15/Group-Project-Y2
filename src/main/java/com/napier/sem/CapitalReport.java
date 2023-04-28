package com.napier.sem;

import java.sql.*;

public class CapitalReport {
    private Connection conn;

    // Connect to the database
    public void connect(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + url + "/world?user=" + user + "&password=" + password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Unable to connect to database: " + e.getMessage());
        }
    }

    // Disconnect from the database
    public void disconnect() {
        try {
            conn.close();
            System.out.println("Disconnected from database");
        } catch (SQLException e) {
            System.out.println("Unable to disconnect from database: " + e.getMessage());
        }
    }

    // Display all the capital cities in the world organized by largest population to smallest
    public void displayAllCapitalCitiesByPopulation() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital ORDER BY city.Population DESC");

            System.out.println("All the capital cities in the world organized by largest population to smallest:");
            System.out.println("City\t\t\tPopulation");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t\t" + rs.getString("Population"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying all capital cities in the world: " + e.getMessage());
        }
    }

    // Display all the capital cities in a continent organized by largest population to smallest
    public void displayCapitalCitiesByContinentPopulation(String continent) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Continent = ? ORDER BY city.Population DESC");
            stmt.setString(1, continent);

            ResultSet rs = stmt.executeQuery();

            System.out.println("All the capital cities in " + continent + " organized by largest population to smallest:");
            System.out.println("City\t\t\tPopulation");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t\t" + rs.getString("Population"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying capital cities in " + continent + ": " + e.getMessage());
        }
    }

    // Display all the capital cities in a region organized by largest population to smallest
    public void displayCapitalCitiesByRegionPopulation(String region) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT city.Name, city.Population FROM city JOIN country ON city.ID = country.Capital WHERE country.Region = ? ORDER BY city.Population DESC");
            stmt.setString(1, region);

            ResultSet rs = stmt.executeQuery();

            System.out.println("All the capital cities in " + region + " organized by largest population to smallest:");
            System.out.println("City\t\t\tPopulation");
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t\t" + rs.getString("Population"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying capital cities in " + region + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create a new CityReport object
        CapitalReport cr = new CapitalReport();

        // Connect to the database
        cr.connect("localhost:33060", "root", "Coursework");

        // Display all the cities in the world organized by largest population to smallest
        cr.displayAllCapitalCitiesByPopulation();

        // Display all the cities in Europe organized by largest population to smallest
        cr.displayCapitalCitiesByContinentPopulation("Europe");

        // Display all the cities in the Caribbean organized by largest population to smallest
        cr.displayCapitalCitiesByRegionPopulation("Caribbean");

        // Disconnect from the database
        cr.disconnect();
    }
}