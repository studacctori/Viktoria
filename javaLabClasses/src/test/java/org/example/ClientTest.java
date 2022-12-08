package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClientTest {

    @Test
    public void testGetId() {
        Client c1 = new Client.ClientBuilder(1).build();
    }

    @Test
    public void testSetId() {
    }

    @Test
    public void testSetName() {
    }

    @Test
    public void testSetPhone() {
    }

    @Test
    public void testSetEmail() {
    }

    @Test
    public void testSetAnimals() {
    }
}