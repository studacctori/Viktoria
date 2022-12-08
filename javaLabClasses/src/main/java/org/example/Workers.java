package org.example;

public class Workers extends Employee{
    public enum WorkPosition{
        Admin,
        Manager,
        Cleaner,
        Guardian
    }

    private WorkPosition position;

    public Workers(WorkPosition position) {
        this.position = position;
    }
    public Workers(WorkPosition position, int id, String name, String phone, String email, double payment) {
        this.position = position;
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setPayment(payment);
    }

    public WorkPosition getPosition() {
        return position;
    }

    public void setPosition(WorkPosition position) {
        this.position = position;
    }

    public void startWorkDay()
        {
            System.out.println(this.position);
            System.out.print(this.getName());
        System.out.print(" start work day");
    }

    @Override
    public String toString() {
        return "Workers{" +
                "position=" + position + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Workers workers = (Workers) o;
        return position == workers.position;
    }

}
