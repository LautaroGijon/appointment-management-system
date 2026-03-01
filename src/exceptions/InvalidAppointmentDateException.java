package exceptions;

public class InvalidAppointmentDateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAppointmentDateException(String message) {
        super(message);
    }
}
