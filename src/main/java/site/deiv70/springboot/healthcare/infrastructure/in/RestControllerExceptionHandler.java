package site.deiv70.springboot.healthcare.infrastructure.in;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.deiv70.springboot.healthcare.infrastructure.in.model.ApiErrorResponseDtoModel;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorResponseDtoModel> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		List<String> errors = fieldErrors.stream()
			.map(fieldError -> "`" + fieldError.getField() + "`: " + fieldError.getDefaultMessage())
			.toList();

		ApiErrorResponseDtoModel apiErrorResponseDtoModel = new ApiErrorResponseDtoModel();
		apiErrorResponseDtoModel.setMessages(errors);

		return new ResponseEntity<>(apiErrorResponseDtoModel, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApiErrorException.class)
	public ResponseEntity<ApiErrorResponseDtoModel> handleApiErrors(ApiErrorException ex) {
		ApiErrorResponseDtoModel apiErrorResponseDtoModel = new ApiErrorResponseDtoModel();
		apiErrorResponseDtoModel.setMessages(Collections.singletonList(ex.getMessage()));

		return new ResponseEntity<>(apiErrorResponseDtoModel, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
