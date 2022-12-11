package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SerializeTest {

    @Test
    public void testSerialize() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
    }

    @Test
    public void testDeserialize() {
    }

    @Test
    public void testWriteToFile() {
    }

    @Test
    public void testSerializeToFile() {
    }

    @Test
    public void testReadFromFile() {
    }

    @Test
    public void testDeserializeFromFile() {
    }
}