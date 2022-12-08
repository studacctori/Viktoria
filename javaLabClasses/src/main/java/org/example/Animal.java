package org.example;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparable<Animal>{
    @NotNull(message = "Can't be NULL")
    @Positive(message = "Can`t be negative")
    private int id;

    @NotNull(message = "Can't be NULL")
    private int owner;


    @NotNull(message = "Can't be NULL")
    @Size(min=2, max=50, message = "Min length = 2 characters; Max length = 50")
    private String name;
    private LocalDate birthDate;

    private Doctor.Specialization kind;

    private Animal(AnimalBuilder builder) {
        this.id = builder.id;
        this.owner = builder.owner;
        this.name = builder.name;
        this.kind = builder.kind;

    }

    public static class AnimalBuilder{
        @NotNull(message = "Can't be NULL")
        @Positive(message = "Can`t be negative")
        private int id;
        private int owner;
        private String name;
        private LocalDate birthDate;
        private Doctor.Specialization kind;

        public AnimalBuilder(int id) {
            if ( id < 0) {
                throw new IllegalArgumentException("Illegal id");
            }
            this.id = id;
        }

        public AnimalBuilder setOwner(int owner) {
            this.owner = owner;
            return this;
        }

        public AnimalBuilder setName(String name) {
            if(name.length() < 2 || name.length() > 50){
                throw new IllegalArgumentException("Name incorrect");
            }
            this.name = name;
            return this;
        }

        public AnimalBuilder setBirthDate(LocalDate birthDate) {
            int curYear = 2022;
            if (curYear - birthDate.getYear() < 0 ){
                throw new IllegalArgumentException("AGE Error");
            }
            this.birthDate = birthDate;
            return this;
        }

        public AnimalBuilder setKind(Doctor.Specialization kind) {
            this.kind = kind;
            return  this;
        }

        public Animal build(){
            return new Animal(this);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if ( id < 0) {
            throw new IllegalArgumentException("Illegal id");
        }
        this.id = id;
    }

    public Doctor.Specialization getKind() {
        return kind;
    }

    public void setKind(Doctor.Specialization kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name.length() < 2 || name.length() > 50){
            throw new IllegalArgumentException("Name incorrect");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", kind=" + kind +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && Objects.equals(name, animal.name) && Objects.equals(birthDate, animal.birthDate) && kind == animal.kind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kind);
    }

    @Override
    public int compareTo(Animal a){return this.id - a.id;}

    public void doGet() throws SQLException
    {

    }
}

class CompareAnimal implements Comparator<Animal>{
    @Override
    public int compare(Animal o1, Animal o2){
        return o1.getName().compareTo(o2.getName());
    }
}
