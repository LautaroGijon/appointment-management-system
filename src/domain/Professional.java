package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.Specialty;

public class Professional {

    private String name;
    private int id;
    private Specialty specialty;

    private boolean available;

    private ArrayList<Appointment> pendingAppointments;
    private ArrayList<Appointment> completedAppointments;

    // Constructor
    public Professional(String name, int id, Specialty specialty) {
        this.name = name;
        this.id = id;
        this.specialty = specialty;
        this.available = true;
        this.pendingAppointments = new ArrayList<Appointment>();
        this.completedAppointments = new ArrayList<Appointment>();
    }

    public boolean hasSameId(int otherId) {
        return this.id == otherId;
    }

    // Methods to control availability
    public boolean isAvailable() {
        return available;
    }

    public void occupy() {
        this.available = false;
    }

    public void release() {
        this.available = true;
    }

    public boolean checkAvailability(LocalDate date, LocalTime time) {
        int i = 0;
        boolean isAvailable = true;

        while (i < this.pendingAppointments.size() && isAvailable) {
            Appointment appointment = this.pendingAppointments.get(i);

            if (appointment.isSameDateAndTime(time, date)) {
                isAvailable = false;
            } else {
                i++;
            }
        }

        return isAvailable;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public ArrayList<Appointment> getPendingAppointments() {
        return pendingAppointments;
    }

    public ArrayList<Appointment> getCompletedAppointments() {
        return completedAppointments;
    }

    public void takeAppointment(Appointment appointment) {
        this.pendingAppointments.add(appointment);
    }

    public boolean attendAppointment(Appointment appointment) {
        boolean operationCompleted = false;

        if (appointment != null) {
            if (this.pendingAppointments.contains(appointment) && appointment.attend()) {
                this.pendingAppointments.remove(appointment);
                this.completedAppointments.add(appointment);
                operationCompleted = true;
            }
        }

        return operationCompleted;
    }

    public boolean cancelAppointment(Appointment appointment) {
        boolean cancelled = false;

        if (appointment != null && this.pendingAppointments.contains(appointment)) {
            if (appointment.cancel()) {
                this.pendingAppointments.remove(appointment);
                cancelled = true;
            }
        }

        return cancelled;
    }
}