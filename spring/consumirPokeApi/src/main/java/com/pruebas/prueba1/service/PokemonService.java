package com.pruebas.prueba1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pruebas.prueba1.model.Pokemon;

@Service
public class PokemonService {
    @Value("${pokeapi.url}")
    private String pokeApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Pokemon getPokemonInfo(String pokemonName) {
        String apiUrl = pokeApiUrl + "/pokemon/" + pokemonName;
        return restTemplate.getForObject(apiUrl, Pokemon.class);
    }
}