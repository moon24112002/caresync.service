package com.CareSync.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private boolean status;
    private String message;
    private T data;

    // success response
    public ApiResponse(String message, T data) {
        this.status = true;
        this.message = message;
        this.data = data;
    }

    // error response
    public ApiResponse(String message){
        this.status = false;
        this.message = message;
        this.data = null;
    }
}
