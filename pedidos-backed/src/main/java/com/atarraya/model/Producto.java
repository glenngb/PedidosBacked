package com.atarraya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información referente al producto")
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@ManyToOne  
	@JoinColumn(name = "id_proveedor", nullable = false, foreignKey  = @ForeignKey(name = "FK_producto_proveedor"))
	private Proveedores proveedores;
	
	@ApiModelProperty(notes = "Codigo del producto debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Codigo del producto debe tener minimo 3 caracteres")
	@Column(name = "codigo_producto", nullable = false, length = 4)
	private String codigoProducto;
	
	@ApiModelProperty(notes = "Nombre del producto debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre del producto debe tener minimo 3 caracteres")
	@Column(name = "nombre_producto", nullable = false, length = 15)
	private String nombreProducto;
	
	@ApiModelProperty(notes = "Marca del producto debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Marca del producto debe tener minimo 3 caracteres")
	@Column(name = "marca", nullable = false, length = 15)
	private String marca;
	
	@ApiModelProperty(notes = "Descripción debe tener minimo 5 caracteres")
	@Size(min = 5, message = "Descripción debe tener minimo 5 caracteres")
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;
	
	@Column(name = "precio_unidad", nullable = false)
	private double precioUnidad;
	
	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;
	

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Proveedores getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}
}
