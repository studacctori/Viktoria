package org.example;

import java.util.Arrays;
import java.util.Objects;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;


public class Client {

    @NotNull
    private  int id;

    @Size
    private String name;
    private String phone;
    private String email;
    public Animal[] animals;


    public Client(ClientBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.animals = builder.animals;
    }

    public static class ClientBuilder{
        @NotNull
        private  int id;

        @Size
        private String name;
        private String phone;
        private String email;
        public Animal[] animals;

        public ClientBuilder(int id){
            if ( id < 0) {
                throw new IllegalArgumentException("Illegal id");
            }
            this.id = id;
        }

        public ClientBuilder setName(String name) {
            if(name.length() < 2 || name.length() > 50){
                throw new IllegalArgumentException("Name incorrect");
            }
            this.name = name;
            return this;
        }

        public ClientBuilder setPhone(String phone) {
            if(phone.length() != 10){
                throw new IllegalArgumentException("Phone incorrect");
            }
            this.phone = phone;
            return this;
        }

        public ClientBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder setAnimals(Animal[] animals) {
            this.animals = animals;
            return this;
        }
        public Client build() {return  new Client(this); }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 2 || name.length() > 50){
            throw new IllegalArgumentException("Name incorrect");
        }
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone.length() != 10){
            throw new IllegalArgumentException("Phone incorrect");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && name.equals(client.name) && phone.equals(client.phone) && email.equals(client.email) && Arrays.equals(animals, client.animals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", animals=" + Arrays.toString(animals) +
                '}';
    }
}
