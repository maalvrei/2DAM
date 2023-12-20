package com.pruebas.prueba1.service;

import java.util.List;
import java.util.Optional;

import com.pruebas.prueba1.model.entity.Cliente;

public interface IClienteService {

	List<Cliente> todosLosClientes();
	Optional<Cliente> clientePorId(Long id);
	
}
