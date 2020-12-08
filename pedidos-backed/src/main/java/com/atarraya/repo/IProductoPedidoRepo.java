package com.atarraya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atarraya.model.ProductoPedido;

public interface IProductoPedidoRepo extends JpaRepository<ProductoPedido, Integer>{

	@Modifying  
	@Query(value = "INSERT INTO producto_pedido (id_pedido, id_producto) VALUES (:idPedido, :idProducto)", nativeQuery = true)
	Integer registrar(@Param("idPedido") Integer idPedido, @Param("idProducto") Integer idProducto);
	
	@Query("from ProductoPedido pp where pp.pedido.idPedido = :idPedido")
	List<ProductoPedido> listarProductosPorPedido(@Param("idPedido") Integer idpedido);
}
