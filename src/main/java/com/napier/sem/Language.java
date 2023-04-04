package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

import static com.napier.sem.App.con;

public class Language {
    private int countryCode;
    private String language;
    private boolean isOfficial;
    private double percentage;

    public Language getLanguage(int countryCode, String language, Boolean isOfficial, double percentage)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countryCode, language, isOfficial, percentage "
                            + "FROM World "
                            + "WHERE language = " + language;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Language l = new Language();
                l.countryCode = rset.getInt("countryCode");
                l.language = rset.getString("language");
                l.isOfficial = rset.getBoolean("isOfficial");
                l.percentage = rset.getDouble("percentage");

                return l;
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

