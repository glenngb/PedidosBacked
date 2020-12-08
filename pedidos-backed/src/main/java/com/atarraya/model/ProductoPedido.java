package com.atarraya.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity 
@Table (name = "producto_pedido")
@IdClass(ProductoPedidoPK.class)
public class ProductoPedido {
	
	@Id
	private Producto producto;
	
	@Id
	private Pedido pedido;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
