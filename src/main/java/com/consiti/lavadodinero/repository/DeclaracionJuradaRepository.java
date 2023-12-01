package com.consiti.lavadodinero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.consiti.lavadodinero.documents.DeclaracionJurada;

public interface DeclaracionJuradaRepository extends MongoRepository<DeclaracionJurada, String>{
}
