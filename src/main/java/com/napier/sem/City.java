package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.napier.sem.App.con;

public class City {
    private int iD;

    private String name;

    private String countryCode;

    private String district;

    private int population;


    public City getCity(int iD, String name, String countryCode, String district, int population )
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT iD, name, countryCode, district, population "
                            + "FROM World "
                            + "WHERE Name = " + name;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City cc = new City();
                cc.iD = rset.getInt("iD");
                cc.name = rset.getString("name");
                cc.countryCode = rset.getString("countryCode");
                cc.district = rset.getString("district");
                cc.population = rset.getInt("population");

                return cc;
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
