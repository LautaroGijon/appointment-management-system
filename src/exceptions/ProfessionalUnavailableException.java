package exceptions;

public class ProfessionalUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProfessionalUnavailableException(String message) {
        super(message);
    }
}
