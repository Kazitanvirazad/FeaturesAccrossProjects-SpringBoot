package com.featuresaccrossprojects.featuresdata.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.hibernate.TransientPropertyValueException;

import com.featuresaccrossprojects.featuresdata.util.ResponseObject;

@RestControllerAdvice
public class HandleValidation {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseObject> handleValidationErrors(MethodArgumentNotValidException ex) {
		List<Map<String, String>> fieldErrorList = new ArrayList<>();
		Map<String, List<Map<String, String>>> errorMap = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			Map<String, String> errors = new HashMap<>();
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put("field_name", fieldName);
			errors.put("field_error_description", errorMessage);
			fieldErrorList.add(errors);
		});

		errorMap.put("fields", fieldErrorList);
		return new ResponseEntity<>(new ResponseObject(true, "Form Field error", errorMap), new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseObject> handleHttpMessageNotReadableErrors(HttpMessageNotReadableException ex) {
		return new ResponseEntity<>(
				new ResponseObject(true, "Invalid/Not Acceptable JSON format in service request body"),
				new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TransientPropertyValueException.class)
	public ResponseEntity<ResponseObject> handleTransientPropertyValueExceptionErrors(TransientPropertyValueException ex) {
		return new ResponseEntity<>(
				new ResponseObject(true, "Missing request body JSON attributes"),
				new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
