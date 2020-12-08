package com.atarraya.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.atarraya.exception.ModeloNotFoundException;
import com.atarraya.model.Proveedores;
import com.atarraya.service.IProveedoresService;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	private IProveedoresService service;
	
	@GetMapping
	public ResponseEntity<List<Proveedores>> listar(){
		List<Proveedores> lista = service.listar();
		return new ResponseEntity<List<Proveedores>>(lista,HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proveedores> listarPorId(@PathVariable("id") Integer id) {
		Proveedores pro = service.leerPorId(id);
		if (pro.getIdProveedores() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Proveedores>(pro, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Proveedores>> listarPageable(Pageable pageable) {
		Page<Proveedores> proveedores = service.listarPageable(pageable);
		return new ResponseEntity<Page<Proveedores>>(proveedores, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Proveedores proveedores) {
		Proveedores pro = service.registrar(proveedores);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proveedores.getIdProveedores()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Proveedores> modificar(@Valid @RequestBody Proveedores proveedores) {
		Proveedores pro = service.modificar(proveedores);
		return new ResponseEntity<Proveedores>(pro, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Proveedores pro = service.leerPorId(id);
		if (pro.getIdProveedores() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
