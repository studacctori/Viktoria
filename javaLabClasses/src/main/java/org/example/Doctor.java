package org.example;

import java.util.Arrays;

public class Doctor extends Employee {
    public enum Specialization{
        cats,
        dogs,
        perots,
        hamsters
    }

    private Specialization[] specialization;

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization=" + Arrays.toString(specialization) +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", payment=" + this.getPayment()+
                '}';
    }



    public Doctor(Specialization[] specialization) {
        this.specialization = specialization;
    }

    public Doctor(int id, String name, String phone, String email, double payment, Specialization[] specialization) {
        super(id, name, phone, email, payment);
        this.specialization = specialization;
    }

    private void startAppointment(String animalName){
        System.out.print(this.getName());
        System.out.print(" start Appointment ");
        System.out.print(animalName);
    }

    public Specialization[] getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization[] specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Arrays.equals(specialization, doctor.specialization);
    }

}
