package com.atarraya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atarraya.model.Proveedores;

public interface IProveedoresRepo extends JpaRepository<Proveedores, Integer> {

}
