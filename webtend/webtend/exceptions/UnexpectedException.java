package webtend.exceptions;

/**
 * An unexpected exception
 */
public class UnexpectedException extends RuntimeException {

	public UnexpectedException(String message) {
		super(message);
	}

	public UnexpectedException(Throwable exception) {
		super("Unexpected Error", exception);
	}

	public UnexpectedException(String message, Throwable cause) {
		super(message, cause);
	}

}
