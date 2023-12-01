package com.consiti.lavadodinero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consiti.lavadodinero.documents.MaestroProductos;
import com.consiti.lavadodinero.models.ApiResponse;
import com.consiti.lavadodinero.models.ApiResponseData;
import com.consiti.lavadodinero.repository.MaestroProductosRepository;

@RestController
@RequestMapping("/maestroProductos")
public class MaestroProductosController {
    
    @Autowired
    private MaestroProductosRepository maestroProductosRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> saveMaestroProductos(@RequestBody MaestroProductos maestroProductos){
        try {
            if (maestroProductos.getFields() == null || maestroProductos.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar peticion enviada");
                ApiResponse errorResponse = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
            }

            maestroProductosRepository.save(maestroProductos);

            String generatedId = maestroProductos.getId();

            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
