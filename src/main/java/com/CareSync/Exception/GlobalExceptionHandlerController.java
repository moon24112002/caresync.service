package com.CareSync.Exception;

import com.CareSync.Models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<ApiResponse> handleResourceAlreadyExist(ResourceAlreadyExist ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse( ex.getMessage()));
    }
}
