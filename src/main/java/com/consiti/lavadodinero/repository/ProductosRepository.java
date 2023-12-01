package com.consiti.lavadodinero.repository;

import com.consiti.lavadodinero.documents.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosRepository extends MongoRepository<Productos, Integer> {
}
