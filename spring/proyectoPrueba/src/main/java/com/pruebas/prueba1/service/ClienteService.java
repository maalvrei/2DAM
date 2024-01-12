package com.pruebas.prueba1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.prueba1.model.entity.Cliente;
import com.pruebas.prueba1.model.repository.IClienteDAO;

@Service
public class ClienteService implements IClienteService{
	 
	@Autowired
	private IClienteDAO clienteDAO;
	
	public List<Cliente> todosLosClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Optional<Cliente> clientePorId(Long id) {
		return clienteDAO.findById(id);
	}
}
