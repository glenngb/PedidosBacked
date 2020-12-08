package com.atarraya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atarraya.model.ProductoPedido;
import com.atarraya.repo.IProductoPedidoRepo;
import com.atarraya.service.IProductoPedidoService;

@Service
public class ProductoPedidoServiceImpl implements IProductoPedidoService {

	@Autowired
	private IProductoPedidoRepo repo;

	@Override
	public List<ProductoPedido> listarProductosPorPedido(Integer idpedido) {
		return repo.listarProductosPorPedido(idpedido);
	}

}
