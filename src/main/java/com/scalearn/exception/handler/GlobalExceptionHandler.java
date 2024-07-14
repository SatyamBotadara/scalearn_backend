package com.scalearn.exception.handler;

import com.scalearn.dto.Response;
import com.scalearn.exception.custom.CustomException;
import com.scalearn.exception.custom.DuplicateIdException;
import com.scalearn.exception.custom.ItemNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { DuplicateIdException.class } )
    public ResponseEntity<Response> globalHandler(DuplicateIdException duplicateIdException , WebRequest webRequest) {
        Response response = new Response(HttpStatus.BAD_REQUEST,duplicateIdException.getMessage());
        log.error("Duplicate id Exception occur {}",duplicateIdException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { CustomException.class } )
    public ResponseEntity<Response> customExceptionHandler(CustomException customException , WebRequest webRequest) {
        Response response = new Response(HttpStatus.BAD_REQUEST,customException.getMessage());
        log.error("Duplicate id Exception occur {}",customException);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { ItemNotFoundException.class })
    public ResponseEntity<Response> itemNotFoundHandler(ItemNotFoundException itemNotFoundException, WebRequest webRequest) {
        Response response = new Response(HttpStatus.NOT_FOUND,itemNotFoundException.getMessage());
        log.error("Item Not Found Exception occur {}",itemNotFoundException);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
