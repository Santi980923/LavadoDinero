package com.consiti.lavadodinero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteProductoDto {
    private String id;
    private Map<String, Object> header;
    private Map<String, Object> fields;

}
