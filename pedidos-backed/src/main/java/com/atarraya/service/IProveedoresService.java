package com.atarraya.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.atarraya.model.Proveedores;

public interface IProveedoresService  extends ICRUD<Proveedores> {

	Page<Proveedores> listarPageable (Pageable pegeable);
}
