package exceptions;

public class ProfessionalNotFoundException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

	
	 public ProfessionalNotFoundException(String message) {
	        super(message);
	    }

}
