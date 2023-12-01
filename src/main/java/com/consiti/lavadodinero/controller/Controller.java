package com.consiti.lavadodinero.controller;

import com.consiti.lavadodinero.documents.ClienteProductos;
import com.consiti.lavadodinero.documents.Clientes;
import com.consiti.lavadodinero.documents.Productos;
import com.consiti.lavadodinero.documents.Transaccional;
import com.consiti.lavadodinero.dto.ClienteDto;
import com.consiti.lavadodinero.dto.ClienteProductoDto;
import com.consiti.lavadodinero.dto.ProductoDto;
import com.consiti.lavadodinero.dto.TransaccionalDto;
import com.consiti.lavadodinero.models.ApiResponse;
import com.consiti.lavadodinero.models.ApiResponseData;
import com.consiti.lavadodinero.repository.ClientesRepository;
import com.consiti.lavadodinero.repository.ProductoClienteRepository;
import com.consiti.lavadodinero.repository.ProductosRepository;
import com.consiti.lavadodinero.repository.TransaccionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class Controller {
    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProductoClienteRepository productoClienteRepository;

    @Autowired
    private TransaccionalRepository transaccionalRepository;


    @PostMapping("/clientes")
    public ResponseEntity<ApiResponse> saveCliente(@RequestBody ClienteDto clienteDTO) {
        try {
            // Verificar si cliente no es nulo
            if (clienteDTO.getFields() == null || clienteDTO.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar Petición enviada");
                ApiResponse response = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            // Mapear DTO a la entidad Clientes
            Clientes cliente = new Clientes();
            cliente.setId(clienteDTO.getId());
            cliente.setHeader(clienteDTO.getHeader());
            cliente.setFields(clienteDTO.getFields());

            // Guardar Json
            clientesRepository.save(cliente);

            // Obtén el ID generado
            String generatedId = cliente.getId();

            // Construye la respuesta exitosa
            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            // Construye la respuesta de error
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/productos")
    public ResponseEntity<ApiResponse> saveProducto(@RequestBody ProductoDto productoDTO) {
        try {
            // Verificar si cliente no es nulo
            if (productoDTO.getFields() == null || productoDTO.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar Petición enviada");
                ApiResponse response = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            // Mapear DTO a la entidad productos
            Productos producto = new Productos();
            producto.setId(productoDTO.getId());
            producto.setHeader(productoDTO.getHeader());
            producto.setFields(productoDTO.getFields());

            // Guardar Json
            productosRepository.save(producto);

            // Obtén el ID generado
            String generatedId = producto.getId();

            // Construye la respuesta exitosa
            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            // Construye la respuesta de error
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/clienteproducto")
    public ResponseEntity<ApiResponse> saveClienteProducto(@RequestBody ClienteProductoDto clienteProductoDto) {
        try {
            // Verificar si cliente no es nulo
            if (clienteProductoDto.getFields() == null || clienteProductoDto.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar Petición enviada");
                ApiResponse response = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            // Mapear DTO a la entidad clienteProductos
            ClienteProductos clienteProductos = new ClienteProductos();
            clienteProductos.setId(clienteProductoDto.getId());
            clienteProductos.setHeader(clienteProductoDto.getHeader());
            clienteProductos.setFields(clienteProductoDto.getFields());

            // Guardar Json
            productoClienteRepository.save(clienteProductos);

            // Obtén el ID generado
            String generatedId = clienteProductos.getId();

            // Construye la respuesta exitosa
            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            // Construye la respuesta de error
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/transaccional")
    public ResponseEntity<ApiResponse> saveTransaccional(@RequestBody TransaccionalDto transaccionalDto) {
        try {
            // Verificar si cliente no es nulo
            if (transaccionalDto.getFields() == null || transaccionalDto.getFields().isEmpty()) {
                ApiResponseData responseData = new ApiResponseData(null, "Validar Petición enviada");
                ApiResponse response = new ApiResponse("BadRequest", responseData);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            // Mapear DTO a la entidad productos
            Transaccional transaccional = new Transaccional();
            transaccional.setId(transaccionalDto.getId());
            transaccional.setHeader(transaccionalDto.getHeader());
            transaccional.setFields(transaccionalDto.getFields());

            // Guardar Json
            transaccionalRepository.save(transaccional);

            // Obtén el ID generado
            String generatedId = transaccional.getId();

            // Construye la respuesta exitosa
            ApiResponseData responseData = new ApiResponseData(generatedId, "Queued");
            ApiResponse response = new ApiResponse("Success", responseData);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {

            // Construye la respuesta de error
            ApiResponse errorResponse = new ApiResponse("Error", "Hubo un error al procesar la solicitud");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
