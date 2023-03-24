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
                ArrayList<Employee> employees = new ArrayList<Employee>();
                while (rset.next())
                {
                    Employee emp = new Employee();
                    emp.emp_no = rset.getInt("employees.emp_no");
                    emp.first_name = rset.getString("employees.first_name");
                    emp.last_name = rset.getString("employees.last_name");
                    emp.salary = rset.getInt("salaries.salary");
                    employees.add(emp);
                }
                return employees;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get salary details");
                return null;

            }
        }

        /**
         * Prints a list of cities.
         * @param.
         */
        public void printSalaries(ArrayList<Employee> employees)
        {
            // Check employees is not null
            if (employees == null)
            {
                System.out.println("No employees");
                return;
            }
            // Print header
            System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
            // Loop over all employees in the list
            for (Employee emp : employees)
            {
                if (emp == null)
                    continue;
                String emp_string =
                        String.format("%-10s %-15s %-20s %-8s",
                                emp.emp_no, emp.first_name, emp.last_name, emp.salary);
                System.out.println(emp_string);
            }
        }
    }