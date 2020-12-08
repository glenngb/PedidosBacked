package com.atarraya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atarraya.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {

}
