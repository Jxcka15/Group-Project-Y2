package com.napier.sem;
import java.sql.*;
import java.util.ArrayList;

import static com.napier.sem.App.con;

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


    public World getWorld(int population, String city, String continent, String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT population, city, continent, country "
                            + "FROM World "
                            + "WHERE country = " + country;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                World w = new World();
                w.population = rset.getInt("population");
                w.city = rset.getString("city");
                w.continent = rset.getString("continent");
                w.country = rset.getString("country");

                return w;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }



        }

