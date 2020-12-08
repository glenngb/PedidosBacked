package com.atarraya.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atarraya.model.ProductoPedido;
import com.atarraya.service.IProductoPedidoService;

@RestController
@RequestMapping("/productopedido")
public class ProductoPedidoController {

	@Autowired
	private IProductoPedidoService service;
	
	
	@GetMapping(value = "/{idPedido}")
	public ResponseEntity<List<ProductoPedido>> listar(@PathVariable("idPedido") Integer idpedido) {
		List<ProductoPedido> productopedido = new ArrayList<>();
		productopedido = service.listarProductosPorPedido(idpedido);
		return new ResponseEntity<List<ProductoPedido>>(productopedido, HttpStatus.OK);
	}
}
