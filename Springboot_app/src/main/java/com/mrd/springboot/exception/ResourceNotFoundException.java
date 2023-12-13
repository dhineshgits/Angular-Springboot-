package com.mrd.springboot.exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.lang.String;

@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}



	

	

}
