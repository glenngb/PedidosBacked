package com.atarraya.service;

import java.util.List;

import com.atarraya.model.ProductoPedido;

public interface IProductoPedidoService {
	List<ProductoPedido> listarProductosPorPedido(Integer idPedido);
}
