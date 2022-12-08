package org.example;

import java.time.LocalDate;
import java.util.Objects;


public class Employee {

    private int id;
    private String name;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate workStartDate;
    private double payment;

    private double countSalery(int hours){
        return hours*payment;
    }
    public void giveSalery(int hours){
        System.out.println(countSalery(hours));
        System.out.print("was given");
        System.out.print(name);
    }

    public Employee() {
    }

    public Employee(int id, String name, String phone, String email, double payment) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(LocalDate workStartDate) {
        this.workStartDate = workStartDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", workStartDate=" + workStartDate +
                ", payment=" + payment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.payment, payment) == 0 && name.equals(employee.name) && phone.equals(employee.phone) && email.equals(employee.email) && birthDate.equals(employee.birthDate) && workStartDate.equals(employee.workStartDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email, birthDate, workStartDate);
    }
}
