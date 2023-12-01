package com.consiti.lavadodinero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.consiti.lavadodinero.documents.MaestroSaldos;

public interface MaestroSaldosRepository extends MongoRepository<MaestroSaldos, String>{
}
