package com.consiti.lavadodinero.repository;


import com.consiti.lavadodinero.documents.Transaccional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransaccionalRepository extends MongoRepository<Transaccional, Integer> {
}
