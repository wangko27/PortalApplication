package net.filippov.newsportal.exception;

/**
 * Throws if user with specified field (login, email) already exists
 * 
 * @author Oleg Filippov
 */
public class NotUniqueUserFieldException extends RuntimeException {

	private static final long serialVersionUID = 7464088027168044522L;

	public NotUniqueUserFieldException(String message) {
		super(message);
	}

	public NotUniqueUserFieldException(Throwable cause) {
		super(cause);
	}
	
	public NotUniqueUserFieldException(String message, Throwable cause) {
		super(message, cause);
	}
}
