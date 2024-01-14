package com.example.demo.model.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	private String enunciado;
	
	@Column(name = "respuesta_correcta")
	private String respuestaCorrecta;
	
	@Column(name = "respuesta_1")
	private String respuesta1;
	
	@Column(name = "respuesta_2")
	private String respuesta2;
	
	@Column(name = "respuesta_3")
	private String respuesta3;
	
	@Column(name = "respuesta_4")
	private String respuesta4;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public String getRespuesta4() {
		return respuesta4;
	}

	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
