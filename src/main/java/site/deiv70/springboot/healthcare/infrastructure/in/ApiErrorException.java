package site.deiv70.springboot.healthcare.infrastructure.in;

import java.io.Serial;

public class ApiErrorException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public ApiErrorException(String message) {
		super(message);
	}

	public ApiErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
