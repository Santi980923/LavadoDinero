package com.consiti.lavadodinero.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseData {
    
    private String id;
    private String message;
    
    public ApiResponseData(String message) {
        this.message = message;
    }
}
