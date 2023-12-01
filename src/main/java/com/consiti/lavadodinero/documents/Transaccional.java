package com.consiti.lavadodinero.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="transaccional")
@TypeAlias("transaccional")

public class Transaccional {

    @Id
    private String id; //Identificador en mongodb

    @JsonProperty("header")
    private Map<String, Object> header;

    @JsonProperty("fields")
    private Map<String, Object> fields;

}
