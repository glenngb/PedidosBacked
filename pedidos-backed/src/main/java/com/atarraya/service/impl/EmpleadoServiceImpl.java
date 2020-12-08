package com.atarraya.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atarraya.model.Empleado;
import com.atarraya.repo.IEmpleadoRepo;
import com.atarraya.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService  {
	
	@Autowired
	private IEmpleadoRepo repo;
	
	@Override
	public Empleado registrar(Empleado emplea) {
		return repo.save(emplea);
	}
	
	@Override
	public Empleado modificar(Empleado emplea) {
		return repo.save(emplea);
	}
	
	@Override 
	public List<Empleado> listar() {
		return repo.findAll();
	}

	@Override
	public Empleado leerPorId(Integer id) {
		Optional<Empleado> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Empleado(); 
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
