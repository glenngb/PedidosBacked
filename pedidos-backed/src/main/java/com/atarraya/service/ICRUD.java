package com.atarraya.service;

import java.util.List;

public interface ICRUD<T> {   // Se le agrega<T> porque es una estructura generica
	
	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	T leerPorId(Integer id);
	boolean eliminar(Integer id);

}
