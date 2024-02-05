package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.entity.Pregunta;

public interface IPreguntaRepository extends CrudRepository<Pregunta, Long>, PagingAndSortingRepository<Pregunta, Long>{

}