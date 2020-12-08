package com.atarraya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atarraya.model.Pedido;

public interface IPedidoRepo extends JpaRepository<Pedido, Integer> {
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)  //fn_listarResumen()  funcion en bd
	List<Object[]> listarResumen(); 
}
