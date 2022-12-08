package org.example;


public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal.AnimalBuilder(1).setName("Barsik").build();
        Animal a2 = new Animal.AnimalBuilder(4).setName("Murzik").build();
        Animal a3 = new Animal.AnimalBuilder(3).setName("Florian").build();
        Animal a4 = new Animal.AnimalBuilder(5).setName("Akostakioaye").build();
        Animal a5 = new Animal.AnimalBuilder(2).setName("Barsikdva").build();

    }
}