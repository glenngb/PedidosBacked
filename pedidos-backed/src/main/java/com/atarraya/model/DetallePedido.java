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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	//Relación tabla DetallePedido con tabla pedido, de uno a muchos
		@JsonIgnore //para que no caiga en bucle y no exista informacion redundande
		@ManyToOne
		@JoinColumn(name = "id_pedido", nullable = false,foreignKey  = @ForeignKey(name = "FK_pedido_detalle"))
		private Pedido pedido;
	
	@Size(min = 3, message = "	Precio debe tener minimo 3 caracteres")
	@Column(name = "precio_unidad", nullable = false, length = 70)
	private double precioUnidad;
	
	@Size(min = 3, message = "Cantidad debe ser minimo 1 caracter")
	@Column(name = "cantidad", nullable = false, length = 70)
	private int cantidad;
	
	
	@Column(name = "descuento", nullable = false)
	private double descuento;
	
	@Column(name = "num_pedido", nullable = false,length = 11)
	private int numPedido;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
}
