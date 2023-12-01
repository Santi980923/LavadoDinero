package com.consiti.lavadodinero.repository;

import com.consiti.lavadodinero.documents.ClienteProductos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoClienteRepository extends MongoRepository<ClienteProductos, Integer> {
}
