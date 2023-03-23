package com.napier.sem;

/**
 * Represents an employee
 */
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

    public World getWorld(int country)
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
                World world = new World();
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

        /**
         * Gets all the current countries and cities.
         * @return A list of all countries and cities, or null if there is an error.
         */
        public ArrayList<World> getWorld()
        {
            try
            {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                                + "FROM employees, salaries "
                                + "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' "
                                + "ORDER BY employees.emp_no ASC";
                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Extract employee information
                ArrayList<Employee> world = new ArrayList<World>();
                while (rset.next())
                {
                    World world = new World();
                    world.country = rset.getInt("employees.emp_no");
                    world.continent = rset.getString("employees.first_name");
                    world.city = rset.getString("employees.last_name");
                    world.add(world);
                }
                return employees;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get Country details");
                return null;

            }
        }

        /**
         * Prints a list of cities.
         * @param. CHANGE THIS
         */
        public void printWorld(ArrayList<World> world)
        {
            // Check employees is not null
            if (world == null)
            {
                System.out.println("No matches");
                return;
            }
            // Print header
            System.out.println(String.format("%-10s %-15s %-20s %-8s", "Country", "City", "Continent"));
            // Loop over all employees in the list
            for (World world : world)
            {
                if (world == null)
                    continue;
                String world_string =
                        String.format("%-10s %-15s %-20s %-8s",
                                world.country, world.city, world.continent);
                System.out.println(world_string);
            }
        }
    }