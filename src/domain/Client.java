package domain;

import java.util.ArrayList;

public class Client {

    private String name;
    private String dni;
    private String phone;

    private ArrayList<Appointment> appointments;

    // Constructor
    public Client(String name, String dni, String phone) {
        this.name = name;
        this.dni = dni;
        this.phone = phone;
        this.appointments = new ArrayList<Appointment>();
    }

    public boolean hasSameDni(String otherDni) {
        return this.dni.equals(otherDni);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}