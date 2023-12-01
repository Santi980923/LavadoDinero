package com.consiti.lavadodinero.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String status;
    private ApiResponseData data;

     public ApiResponse(String id, String message) {
        this.status = "Success";
        this.data = new ApiResponseData(id, message);
    }
    
    public ApiResponse(String message) {
        this.status = "Error";
        this.data = new ApiResponseData(message);
    }
}
