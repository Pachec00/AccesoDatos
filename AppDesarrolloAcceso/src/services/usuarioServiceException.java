package services;

public class usuarioServiceException extends Exception {

	private static final long serialVersionUID = 4862538502807374881L;

	public usuarioServiceException() {
		super();
	}

	public usuarioServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public usuarioServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public usuarioServiceException(String message) {
		super(message);
	}

	public usuarioServiceException(Throwable cause) {
		super(cause);
	}

}
