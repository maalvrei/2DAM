package com.pruebas.prueba1.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.pruebas.prueba1.model.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {

}
