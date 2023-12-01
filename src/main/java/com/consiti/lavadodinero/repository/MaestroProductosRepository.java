package com.consiti.lavadodinero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.consiti.lavadodinero.documents.MaestroProductos;

public interface MaestroProductosRepository extends MongoRepository<MaestroProductos, String>{
}
