package com.napier.sem;
import java.sql.*;
import java.util.ArrayList;
/**
 * Represents an employee
 */
public class World {
    /**
     * City Population
     */
    public int population;

    /**
     * City name
     */
    public String city;

    /**
     * Continent of city
     */
    public String continent;

    /**
     * Country
     */
    public String country;

    /**
     * Language Spoken in Country
     */
    public String language;

    public World getWorld(Statement stmt, String country) {
        try {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city, continent, country "
                            + "FROM world "
                            + "WHERE country = "
                            +  country;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                World world = new World();
                world.city = rset.getString("city");
                world.continent = rset.getString("continent");
                world.country = rset.getString("country");
                return world;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }

        /**
         * Gets all the current countries and cities.
         * @return A list of all countries and cities, or null if there is an error.
         */
        public ArrayList<World> getWorld (Statement stmt)
        {
            try {
                // Create string for SQL statement
                String strSelect =
                        "SELECT ID, CountryCode, District, Population"
                                + "FROM World";

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<World> worlds = new ArrayList<World>();
                while (rset.next()) {
                    World world = new World();
                    world.country = rset.getString("country");
                    world.continent = rset.getString("continent");
                    world.city = rset.getString("city");
                    worlds.add(world);

                }
                return worlds;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get Country details");
                return null;

            }
        }

        /**
         * Prints a list of cities.
         * @param.
         */
        public void printWorld(ArrayList <World> worlds)
        {
            // Check employees is not null
            if (worlds == null) {
                System.out.println("No matches");
                return;
            }
            // Print header
            System.out.println(String.format("%-10s %-15s %-20s %-8s", "Country", "City", "Continent"));
            // Loop over all employees in the list
            for (World world : worlds) {
                if (world == null)
                    continue;
                String world_string =
                        String.format("%-10s %-15s %-20s %-8s",
                                world.country, world.city, world.continent);
                System.out.println(world_string);
            }
        }
    }
}