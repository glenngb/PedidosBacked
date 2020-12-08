package com.atarraya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proveedores")
public class Proveedores {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedores;
	
	
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombre_proveedor", nullable = false, length = 70)
	private String nombreProvedor;
	
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;
	
	@Email //validacion de email
	@Column(name = "email", nullable = true, length = 55)
	private String email;
	
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	
	@Size(min = 8, max = 9, message = "RUT debe tener 9 caracteres")
	@Column(name = "rut", nullable = false, length = 9)
	private String rut;

	public Integer getIdProveedores() {
		return idProveedores;
	}

	public void setIdProveedores(Integer idProveedores) {
		this.idProveedores = idProveedores;
	}

	public String getNombreProvedor() {
		return nombreProvedor;
	}

	public void setNombreProvedor(String nombreProvedor) {
		this.nombreProvedor = nombreProvedor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
}
