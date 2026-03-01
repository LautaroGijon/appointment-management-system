package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import enums.Specialty;
import enums.AppointmentStatus;

import exceptions.ClientNotFoundException;
import exceptions.ProfessionalNotFoundException;
import exceptions.AppointmentNotFoundException;
import exceptions.InvalidAppointmentDateException;
import exceptions.ProfessionalUnavailableException;

public class AppointmentSystem {

    private ArrayList<Client> clients;
    private ArrayList<Professional> professionals;
    private ArrayList<Appointment> appointments;

    private int nextAppointmentId = 1;

    // Constructor
    public AppointmentSystem() {
        this.clients = new ArrayList<Client>();
        this.professionals = new ArrayList<Professional>();
        this.appointments = new ArrayList<Appointment>();
    }

    // CLIENT METHODS

    public boolean registerClient(String dni, String name, String phone) {

        Client client;
        boolean registered = false;

        client = this.findClient(dni);

        if (client == null) {
            this.clients.add(new Client(name, dni, phone));
            registered = true;
        }

        return registered;
    }

    private Client findClient(String dni) {

        int i = 0;
        Client foundClient = null;
        Client client;

        while (i < this.clients.size() && foundClient == null) {
            client = this.clients.get(i);

            if (client.hasSameDni(dni)) {
                foundClient = client;
            } else {
                i++;
            }
        }

        return foundClient;
    }

    // PROFESSIONAL METHODS

    public boolean registerProfessional(String name, int id, Specialty specialty) {

        Professional professional;
        boolean registered = false;

        professional = this.findProfessional(id);

        if (professional == null) {
            this.professionals.add(new Professional(name, id, specialty));
            registered = true;
        }

        return registered;
    }

    private Professional findProfessional(int id) {

        int i = 0;
        Professional foundProfessional = null;
        Professional professional;

        while (i < this.professionals.size() && foundProfessional == null) {
            professional = this.professionals.get(i);

            if (professional.hasSameId(id)) {
                foundProfessional = professional;
            } else {
                i++;
            }
        }

        return foundProfessional;
    }

    public Appointment createAppointment(
            LocalDate date,
            LocalTime time,
            String clientDni,
            int professionalId
    ) {

        Client client = this.findClient(clientDni);

        if (client == null) {
            throw new ClientNotFoundException(
                    "Client with DNI " + clientDni + " not found."
            );
        }

        Professional professional = this.findProfessional(professionalId);

        if (professional == null) {
            throw new ProfessionalNotFoundException(
                    "Professional with ID " + professionalId + " not found."
            );
        }

        // Validate date
        if (date.isBefore(LocalDate.now())) {
            throw new InvalidAppointmentDateException(
                    "Cannot create appointment in the past."
            );
        }

        // Validate availability
        if (!professional.checkAvailability(date, time)) {
            throw new ProfessionalUnavailableException(
                    "Professional is not available on " + date + " at " + time
            );
        }

        Appointment appointment = new Appointment(
                nextAppointmentId++,
                date,
                time,
                client,
                professional
        );

        professional.takeAppointment(appointment);
        this.appointments.add(appointment);

        return appointment;
    }

    public boolean confirmAppointment(int appointmentId) {

        boolean confirmed = false;
        Appointment appointment = this.findAppointment(appointmentId);

        if (appointment == null) {
            throw new AppointmentNotFoundException(
                    "Appointment with ID " + appointmentId + " not found."
            );
        }

        confirmed = appointment.confirm();

        return confirmed;
    }

    public boolean cancelAppointment(int appointmentId) {

        boolean cancelled = false;
        Appointment appointment = this.findAppointment(appointmentId);

        if (appointment == null) {
            throw new AppointmentNotFoundException(
                    "Appointment with ID " + appointmentId + " not found."
            );
        }

        if (appointment.cancel()) {

            Professional professional = appointment.getProfessional();
            professional.cancelAppointment(appointment);
            cancelled = true;
        }

        return cancelled;
    }

    public boolean attendAppointment(int appointmentId) {

        boolean attended = false;
        Appointment appointment = this.findAppointment(appointmentId);

        if (appointment != null) {
            Professional professional = appointment.getProfessional();
            attended = professional.attendAppointment(appointment);
        }else {
       	 throw new AppointmentNotFoundException(
                 "Appointment with ID " + appointmentId + " not found."
         );
    }

        return attended;
    }

    public Appointment findAppointment(int id) {

        int i = 0;
        Appointment foundAppointment = null;
        Appointment appointment;

        while (i < this.appointments.size() && foundAppointment == null) {
            appointment = this.appointments.get(i);

            if (appointment.hasSameId(id)) {
                foundAppointment = appointment;
            } else {
                i++;
            }
        }

        return foundAppointment;
    }

    public ArrayList<Appointment> listAppointmentsByStatus(AppointmentStatus status) {

        ArrayList<Appointment> filteredAppointments = new ArrayList<Appointment>();

        for (Appointment appointment : this.appointments) {
            if (appointment.hasSameStatus(status)) {
                filteredAppointments.add(appointment);
            }
        }

        return filteredAppointments;
    }
}