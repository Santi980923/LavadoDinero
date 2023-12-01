package com.consiti.lavadodinero.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="maestro-saldos")
@TypeAlias("MaestroSaldos") 
public class MaestroSaldos{
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
    
    public MaestroSaldos() {
    }
}
