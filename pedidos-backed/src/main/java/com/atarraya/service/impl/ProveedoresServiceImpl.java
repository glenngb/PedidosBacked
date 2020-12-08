package com.atarraya.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atarraya.model.Proveedores;
import com.atarraya.repo.IProveedoresRepo;
import com.atarraya.service.IProveedoresService;

@Service
public class ProveedoresServiceImpl implements IProveedoresService {

	@Autowired
	private IProveedoresRepo repo;

	@Override
	public Proveedores registrar(Proveedores pro) {
		return repo.save(pro);
	}
	
	@Override
	public Proveedores modificar(Proveedores pro) {
		return repo.save(pro);
	}
	
	@Override 
	public List<Proveedores> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Proveedores> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Proveedores leerPorId(Integer id) {
		Optional<Proveedores> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Proveedores(); 
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
