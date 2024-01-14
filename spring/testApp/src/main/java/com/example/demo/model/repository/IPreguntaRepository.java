package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Pregunta;

public interface IPreguntaRepository extends CrudRepository<Pregunta, Long>{

}