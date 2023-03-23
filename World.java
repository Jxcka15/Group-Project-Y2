package com.napier.sem;

/**
 * Represents an employee
 */
@Test
public class World
{
    /**
     * City Population
     */
    public int population;

    /**
     * City name
     */
    public String City;

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

}

    @Test
    public World getWorld(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city, continent, country "
                            + "FROM world ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                World world = new Employee();
                world.city = rset.getInt("city");
                world.continent = rset.getString("continent");
                world.country = rset.getString("country");
                return World;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
            return null;
        }
    }