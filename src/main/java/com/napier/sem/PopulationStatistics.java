package com.napier.sem;

import java.sql.*;

public class PopulationStatistics {
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

    // Returns a ResultSet containing the population statistics for each continent
    public ResultSet getPopulationStatisticsByContinent() {
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT continent, SUM(population) AS total_population, " +
                    "FROM country " +
                    "GROUP BY continent";
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
            return null;
        }
    }

    // Returns a ResultSet containing the population statistics for each region
    public ResultSet getPopulationStatisticsByRegion() {
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT region, SUM(population) AS total_population, " +
                    "FROM country " +
                    "GROUP BY region";
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
            return null;
        }
    }

    // Returns a ResultSet containing the population statistics for each country
    public ResultSet getPopulationStatisticsByCountry(String canada) {
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT name, population, " +
                    "FROM city " +
                    "JOIN country ON city.country_code = country.code " +
                    "GROUP BY name";
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
            return null;
        }
    }

    // Prints out the population statistics for each continent
    public void displayPopulationStatisticsByContinent(String europe) {
        ResultSet rs = getPopulationStatisticsByContinent();
        try {
            System.out.println("Population statistics by continent:");
            System.out.printf("%-15s%-20s%-20s%-20s\n", "Continent", "Total Population", "Urban Population", "Rural Population");
            while (rs.next()) {
                String continent = rs.getString("continent");
                int totalPopulation = rs.getInt("total_population");
                int urbanPopulation = rs.getInt("urban_population");
                int ruralPopulation = rs.getInt("rural_population");
                System.out.printf("%-15s%-20d%-20d%-20d\n", continent, totalPopulation, urbanPopulation, ruralPopulation);
            }
        } catch (SQLException e) {
            System.err.println("Error displaying results: " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        // Create a new CityReport object
        PopulationStatistics ps = new PopulationStatistics();

        // Connect to the database
        ps.connect("localhost:33060", "root", "Coursework");

        // Display all the cities in the world organized by largest population to smallest
        ps.getPopulationStatisticsByContinent();

        // Display all the cities in Europe organized by largest population to smallest
        ps.getPopulationStatisticsByCountry("Canada");

        // Display all the cities in the Caribbean organized by largest population to smallest
        ps.displayPopulationStatisticsByContinent("Europe");

        // Disconnect from the database
        ps.disconnect();
    }
}
