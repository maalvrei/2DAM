package com.pruebas.prueba1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.prueba1.model.Pokemon;
import com.pruebas.prueba1.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{name}")
    public Pokemon getPokemonInfo(@PathVariable String name) {
        return pokemonService.getPokemonInfo(name);
    }
}
