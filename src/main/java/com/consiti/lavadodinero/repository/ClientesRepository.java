package com.consiti.lavadodinero.repository;

import com.consiti.lavadodinero.documents.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientesRepository extends MongoRepository<Clientes, Integer> {
}