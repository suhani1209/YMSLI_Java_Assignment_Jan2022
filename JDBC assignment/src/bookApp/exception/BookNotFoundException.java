package bookApp.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 685025442025149581L;

	public BookNotFoundException(String s) {
		super(s);
	}
}