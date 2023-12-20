package com.pruebas.prueba1.controller;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pruebas.prueba1.model.entity.Cliente;
import com.pruebas.prueba1.service.ClienteService;
import com.pruebas.prueba1.service.IClienteService;

@Controller
public class ControllerRandom {
	
	@Autowired
	IClienteService clienteService;
	
	@GetMapping("/dummy")
	public String m() {
		for (Cliente c : clienteService.todosLosClientes()) {
			System.out.println(c);
		};
		
		return "dummy";
	}
	
	@GetMapping("/dummy2")
	public String m2() {
		
		Cliente c = clienteService.clientePorId(2L).orElse(null);
		System.out.println(c);
		
		return "dummy";
	}
	
}
