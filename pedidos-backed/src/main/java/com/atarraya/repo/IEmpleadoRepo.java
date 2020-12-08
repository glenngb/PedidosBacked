package com.atarraya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atarraya.model.Empleado;

public interface IEmpleadoRepo extends JpaRepository<Empleado, Integer>{

}
