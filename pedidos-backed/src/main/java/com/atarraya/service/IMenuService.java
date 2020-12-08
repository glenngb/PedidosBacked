package com.atarraya.service;

import java.util.List;

import com.atarraya.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
