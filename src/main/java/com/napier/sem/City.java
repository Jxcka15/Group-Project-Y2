package com.napier.sem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class City {
    private int id;
    private String name;
    private String country;
    private String district;
    private int population;
    private String countryCode;
    private String continent;

    public City() {}

    public City(int id, String name, String country, String district, int population, String countryCode, String continent) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
        this.countryCode = countryCode;
        this.continent = continent;
    }

    public City(int id, String name, String countryCode, String district, int population) {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Country: " + getCountry());
        System.out.println("District: " + getDistrict());
        System.out.println("Population: " + getPopulation());
        System.out.println("Continent: " + getContinent());
        System.out.println();
    }



    // Method to get top N populated cities in the world
    public static City[] getNMostPopulatedCitiesInWorld(int n) throws SQLException {
        City[] cities = null;
        try {
            // Create a prepared statement
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM city ORDER BY population DESC LIMIT ?");
            stmt.setInt(1, n);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // Initialize the array of cities
            cities = new City[n];

            // Iterate over the result set and populate the array of cities
            int i = 0;
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                cities[i] = city;
                i++;
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving cities: " + e.getMessage());
        }
        return cities;
    }



    public static City[] getNMostPopulatedCitiesInContinent(int n, String continent) {
        City[] cities = null;
        try {
            // Create a prepared statement
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Continent = ? " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT ?");
            stmt.setString(1, continent);
            stmt.setInt(2, n);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // Initialize the array of cities
            cities = new City[n];

            // Iterate over the result set and populate the array of cities
            int i = 0;
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                cities[i] = city;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cities: " + e.getMessage());
        }
        return cities;
    }


    public static City[] getNMostPopulatedCitiesInRegion(int n, String region) {
        City[] cities = null;
        try {
            // Create a prepared statement
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement("SELECT city.*, country.Continent FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Region = ? ORDER BY city.Population DESC LIMIT ?");
            stmt.setString(1, region);
            stmt.setInt(2, n);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // Initialize the array of cities
            cities = new City[n];

            // Iterate over the result set and populate the array of cities
            int i = 0;
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountry(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                city.setContinent(rs.getString("Continent"));
                cities[i] = city;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cities: " + e.getMessage());
        }
        return cities;
    }


    public static City[] getNMostPopulatedCitiesInCountry(int n, String country) {
        City[] cities = null;
        try {
            // Create a prepared statement
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement("SELECT city.*, country.Continent FROM city JOIN country ON city.CountryCode = country.Code WHERE country.Name = ? ORDER BY city.Population DESC LIMIT ?");
            stmt.setString(1, country);
            stmt.setInt(2, n);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // Initialize the array of cities
            cities = new City[n];

            // Iterate over the result set and populate the array of cities
            int i = 0;
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountry(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                city.setContinent(rs.getString("Continent"));
                cities[i] = city;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cities: " + e.getMessage());
        }
        return cities;
    }


    public static City[] getNMostPopulatedCitiesInDistrict(int n, String district) {
        City[] cities = null;
        try {
            // Create a prepared statement
            Connection con = null;
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM city WHERE District = ? ORDER BY Population DESC LIMIT ?");
            stmt.setString(1, district);
            stmt.setInt(2, n);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // Initialize the array of cities
            cities = new City[n];

            // Iterate over the result set and populate the array of cities
            int i = 0;
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountry(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                cities[i] = city;
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cities: " + e.getMessage());
        }
        return cities;
    }

    public class ReportWriter {

        public static void writeCitiesToMarkdown(City[] cities, String reportTitle, String filePath) throws IOException, IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("# " + reportTitle + "\n\n");
            writer.write("| ID | Name | Country | District | Population | Continent |\n");
            writer.write("| -- | ---- | ------- | -------- | ---------- | --------- |\n");

            for (City city : cities) {
                writer.write("| " + city.getId() + " | " + city.getName() + " | " + city.getCountry() + " | " + city.getDistrict() + " | " + city.getPopulation() + " | " + city.getContinent() + " |\n");
            }

            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
