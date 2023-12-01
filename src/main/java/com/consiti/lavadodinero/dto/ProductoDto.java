package com.consiti.lavadodinero.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ProductoDto {

    private String id;
    private Map<String, Object> header;
    private Map<String, Object> fields;

    // Constructores, getters y setters según sea necesario

    public ProductoDto() {
        // Constructor vacío necesario para deserialización
    }

    public ProductoDto(String id, Map<String, Object> header, Map<String, Object> fields) {
        this.id = id;
        this.header = header;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
