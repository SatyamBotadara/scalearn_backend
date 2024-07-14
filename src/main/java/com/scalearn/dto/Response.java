package com.scalearn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class Response {
    private String message;
    private Object data;
    private HttpStatus httpStatus;

    public Response(HttpStatus httpStatus,String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public Response(Object data , HttpStatus httpStatus,String message) {
        this.data = data;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
