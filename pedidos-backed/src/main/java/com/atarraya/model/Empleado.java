package com.atarraya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información referente al empleado") 
@Entity
@Table (name ="empleado")
public class Empleado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	
	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@ApiModelProperty(notes = "cargo debe tener minimo 3 caracteres")
	@Column(name = "cargo", nullable = false)
	private String cargo;
	
	
	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
}
