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
                World emp = new World();
                emp.population = rset.getInt("population");
                emp.city = rset.getString("city");
                emp.continent = rset.getString("continent");
                emp.country = rset.getString("country");

                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }



        }

