package app;

import enums.Specialty;
import enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import domain.AppointmentSystem;
import domain.Appointment;

public class App {

    public static void main(String[] args) {

        AppointmentSystem system = new AppointmentSystem();

        // Register clients
        system.registerClient("123", "Juan Perez", "111-222");
        system.registerClient("456", "Maria Lopez", "333-444");

        // Register professionals
        system.registerProfessional("Ana Smith", 1, Specialty.DERMATOLOGY);
        system.registerProfessional("Carlos Brown", 2, Specialty.NUTRITION);

        // Create appointment
        Appointment appointment = system.createAppointment(
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                "123",
                1
        );

        if (appointment != null) {

            System.out.println("Appointment created:");
            System.out.println(appointment);

            // Confirm appointment
            boolean confirmed = system.confirmAppointment(appointment.getId());
            System.out.println("Confirmed: " + confirmed);

            // Attend appointment
            boolean attended = system.attendAppointment(appointment.getId());
            System.out.println("Attended: " + attended);

        } else {
            System.out.println("Appointment could not be created.");
        }

        // List completed appointments
        ArrayList<Appointment> completed =
                system.listAppointmentsByStatus(AppointmentStatus.COMPLETED);

        System.out.println("\nCompleted appointments:");
        for (Appointment appt : completed) {
            System.out.println(appt);
        }
    }
}