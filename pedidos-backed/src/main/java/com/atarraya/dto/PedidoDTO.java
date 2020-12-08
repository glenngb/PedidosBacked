package com.atarraya.dto;

import org.springframework.hateoas.ResourceSupport;

import com.atarraya.model.Empleado;


public class PedidoDTO extends ResourceSupport{
	private Integer idPedido;
	private Empleado empleado;
	public Integer getIdPedido() {
		return idPedido;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
				}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
}
