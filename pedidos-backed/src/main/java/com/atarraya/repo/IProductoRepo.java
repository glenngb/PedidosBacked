package com.atarraya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atarraya.model.Producto;

public interface IProductoRepo extends JpaRepository <Producto, Integer> {

}
