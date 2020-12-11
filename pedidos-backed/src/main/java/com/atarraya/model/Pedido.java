package com.atarraya.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información referente al pedido")
@Entity
@Table (name ="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	
		@ManyToOne  
		@JoinColumn(name = "id_empleado", nullable = false, foreignKey  = @ForeignKey(name = "FK_pedido_empleado"))
		private Empleado empleado;
	
	@ApiModelProperty(notes = "Se refiere al número de pedido el cual es consecutivo")
	@Column(name = "numero", nullable = false,length = 11)
	private int numero;
	
	private LocalDateTime fecha;
	
	@ApiModelProperty(notes = "Precio total delpedido")
	@Column(name = "total_pedido", nullable = false)
	private double totalPedido;
	
	@ApiModelProperty(notes = "Observacion debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Observacion debe tener minimo 3 caracteres")
	@Column(name = "observacion", nullable = false, length = 170)
	private String observacion;
	
	@OneToMany(mappedBy = "pedido", cascade = {CascadeType.ALL}, orphanRemoval = true) //orphanRemoval para que no quede ningun espacio werfano en bd
	private List<DetallePedido> detallePedido; // se trabaja con List

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}
	
	

}
