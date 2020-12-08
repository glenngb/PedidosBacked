package com.atarraya.dto;

import java.util.List;

import com.atarraya.model.Pedido;
import com.atarraya.model.Producto;

public class PedidoListaProductoDTO {
	private Pedido pedido;
	private List<Producto> lstProducto;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<Producto> getLstProducto() {
		return lstProducto;
	}
	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
}
