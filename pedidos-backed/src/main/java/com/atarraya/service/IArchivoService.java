package com.atarraya.service;

import com.atarraya.model.Archivo;

public interface IArchivoService {
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);	
}
