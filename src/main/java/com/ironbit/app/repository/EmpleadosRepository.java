package com.ironbit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironbit.app.entity.Empleado;

public interface EmpleadosRepository extends JpaRepository<Empleado,Long> {

}
