package com.atarraya.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atarraya.model.Archivo;
import com.atarraya.repo.IArchivoRepo;
import com.atarraya.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService {
	
	@Autowired  // inyeccion de dependencias para trabajar con la capa repo
	private IArchivoRepo repo;
	
	@Override // sobreescribimos IArchivoService
	public int guardar(Archivo archivo) {
		Archivo ar = repo.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}
	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		Optional<Archivo> op = repo.findById(idArchivo);
		return op.isPresent() ? op.get().getValue() :new byte[0]; // si esta presente el archivo obtenemos su valor, en caso contrarionos devuel una estructurasin nada 
	}
		
	

}
