package com.napier.sem;

import java.sql.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class App {

    public static void main(String[] args) {

        {
            // Connect to database
            if (args.length < 1)
            {
                connect("localhost:33060");
            }
            else
            {
                connect(args[0]);
            }

            SpringApplication.run(App.class, args);
        }



        // Print top N most populated cities in the world
        try {
            City[] cities = City.getNMostPopulatedCitiesInWorld(10);
            System.out.println("Top 10 most populated cities in the world:");
            for (City city : cities) {
                city.display();
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cities: " + e.getMessage());
        }

        // Print top N most populated cities in a continent
        City[] cities = City.getNMostPopulatedCitiesInContinent(10, "Europe");
        System.out.println("Top 10 most populated cities in Europe:");
        for (City city : cities) {
            city.display();
        }


    }

    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;
    /**
     * Connect to the MySQL database.
     */
    public static void connect(String arg)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Coursework");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public static void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}