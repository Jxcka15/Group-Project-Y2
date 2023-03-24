package com.napier.sem;

import com.napier.sem.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void GetWorldTest()
    {
        app.getWorld(null);
    }

    public void printSalaries(ArrayList<World> countries)
    {
        // Check employees is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Continent", "Country", "City"));
        // Loop over all employees in the list
        for (World world : countries.toArray(new World[0]))
        {
            if (world == null)
                continue;
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            world.continent, world.city, world.country);
            System.out.println(world_string);
        }

    }
}

