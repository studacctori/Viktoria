package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AnimalTest {

    @Test
    public void testGetId() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        assertEquals(1, a1.getId());
    }

    @Test
    public void testSetId() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        a1.setId(2);
        assertEquals(2, a1.getId());
    }

    @Test
    public void testIdNotNull() {
        assertThrows(IllegalArgumentException.class, ()-> new Animal.AnimalBuilder(-1).build());
    }

    @Test
    public void testSetIdNotNull() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();

        assertThrows(IllegalArgumentException.class, () -> {
            a1.setId(-1);
        });
    }

    @Test
    public void testGetKind() {
        Animal a1 = new Animal.AnimalBuilder(1).setKind(Doctor.Specialization.cats).build();
        assertEquals(Doctor.Specialization.cats, a1.getKind());
    }

    @Test
    public void testSetKind() {
        Animal a1 = new Animal.AnimalBuilder(1).setKind(Doctor.Specialization.cats).build();
        assertEquals(Doctor.Specialization.cats, a1.getKind());
    }

    @Test
    public void testSetNameLenShort() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        assertThrows(IllegalArgumentException.class, ()-> {
            a1.setName(" ");
        });
    }
    @Test
    public void testSetNameLenLong() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        assertThrows(IllegalArgumentException.class, ()-> {
            a1.setName("123456789012345678901234567890123456789012345678901234567890");
        });
    }

    @Test
    public void testGetName() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        a1.setName("Fluffy");
        assertEquals("Fluffy", a1.getName());
    }

    @Test
    public void testSetName() {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        a1.setName("Fluffy");
        assertEquals("Fluffy", a1.getName());
    }
}