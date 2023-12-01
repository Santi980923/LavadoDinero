package com.consiti.lavadodinero.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="declaracion-jurada")
@TypeAlias("DeclaracionJurada") 
public class DeclaracionJurada {
    @Id
    private String id;

    @JsonProperty("header")
    private Map<String, Object> header;
    
    @JsonProperty("fields")
    private Map<String, Object> fields;

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
    
    public DeclaracionJurada() {
    }
}
