package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.napier.sem.App.con;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String language;
    private int capitalID;

    public Country getCountry(String code, String name, String continent, String region, int population, String language, int capitalID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT code, name, continent, region, population, language, capitalID "
                            + "FROM World "
                            + "WHERE Continent = " + continent;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country c = new Country();
                c.code = rset.getString("code");
                c.name = rset.getString("name");
                c.continent = rset.getString("continent");
                c.region = rset.getString("region");
                c.population = rset.getInt("population");
                c.language = rset.getString("language");
                c.capitalID = rset.getInt("CapitalID");

                return c;
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

