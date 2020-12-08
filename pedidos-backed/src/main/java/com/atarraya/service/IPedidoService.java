package com.atarraya.service;

import java.util.List;


import com.atarraya.dto.PedidoListaProductoDTO;
import com.atarraya.dto.PedidoResumenDTO;
import com.atarraya.model.Pedido;

public interface IPedidoService extends ICRUD<Pedido>{
	
	Pedido registrarTransaccional(PedidoListaProductoDTO  dto);
	List<PedidoResumenDTO> listarResumen();
	byte[] generarReporte();

	

	
}
