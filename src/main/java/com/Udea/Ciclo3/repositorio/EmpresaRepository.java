package com.Udea.Ciclo3.repositorio;

import com.Udea.Ciclo3.Clases.Empleado;
import com.Udea.Ciclo3.Clases.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {


}
