package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static World world;

    static Connection con;


    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        world = new World();

    }

    @Test
    void testGetWorld() throws SQLException {
        ArrayList<World> w = world.getWorld(con.createStatement());
        assertEquals(world.country, "France");
        assertEquals(world.city, "Paris");
        assertEquals(world.continent, "Europe");
    }
}