package com.consiti.lavadodinero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consiti.lavadodinero.documents.DeclaracionJurada;
import com.consiti.lavadodinero.models.ApiResponse;
import com.consiti.lavadodinero.models.ApiResponseData;
import com.consiti.lavadodinero.repository.DeclaracionJuradaRepository;

@RestController
@RequestMapping("/declaracionJurada")
public class DeclaracionJuradaController {

    @Autowired
    private DeclaracionJuradaRepository declaracionJuradaRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> saveDeclaracionJurada(@RequestBody DeclaracionJurada declaracionJurada){
        try {
            if (declaracionJurada.getFields() == null || declaracionJurada.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar peticion enviada");
                ApiResponse errorResponse = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
            }

            declaracionJuradaRepository.save(declaracionJurada);

            String generatedId = declaracionJurada.getId();

            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
