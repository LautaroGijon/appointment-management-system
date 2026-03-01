package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import enums.AppointmentStatus;

public class Appointment {

    private LocalDate date;
    private LocalTime time;
    private int id;
    private AppointmentStatus status;
    private Client client;
    private Professional professional;

    // Constructor
    public Appointment(int id, LocalDate date, LocalTime time,
                       Client client, Professional professional) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.client = client;
        this.professional = professional;
        this.status = AppointmentStatus.PENDING;
    }

    public boolean confirm() {
        boolean confirmed = false;

        if (this.status == AppointmentStatus.PENDING) {
            this.status = AppointmentStatus.CONFIRMED;
            confirmed = true;
        }

        return confirmed;
    }

    public boolean cancel() {
        boolean cancelled = false;

        if (this.status == AppointmentStatus.PENDING
                || this.status == AppointmentStatus.CONFIRMED) {

            this.status = AppointmentStatus.CANCELLED;
            cancelled = true;
        }

        return cancelled;
    }

    public boolean isSameDateAndTime(LocalTime otherTime, LocalDate otherDate) {
        return this.date.equals(otherDate) && this.time.equals(otherTime);
    }

    public boolean attend() {
        boolean attended = false;

        if (this.status == AppointmentStatus.CONFIRMED) {
            this.status = AppointmentStatus.COMPLETED;
            attended = true;
        }

        return attended;
    }

    public boolean hasSameId(int otherId) {
        return this.id == otherId;
    }

    // Getters (no setters to protect integrity)

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public Professional getProfessional() {
        return professional;
    }

    public boolean hasSameStatus(AppointmentStatus otherStatus) {
        return this.status == otherStatus;
    }

    @Override
    public String toString() {
        return "Appointment [date=" + date +
                ", time=" + time +
                ", id=" + id +
                ", status=" + status +
                ", client=" + client + "]";
    }

	public int getId() {
	
		return this.id;
	}
}