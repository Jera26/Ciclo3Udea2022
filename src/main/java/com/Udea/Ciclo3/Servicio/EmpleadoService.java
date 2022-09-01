package com.Udea.Ciclo3.Servicio;


import com.Udea.Ciclo3.Clases.Empleado;
import com.Udea.Ciclo3.repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }
    //metodo para buscar empleados por ID
    public Optional <Empleado>getEmpleadoById(Integer id ){
        return empleadoRepository.findById(id);
    }
    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return empleadoRepository.findByEmpresa(id);
    }
    // Guardad o actualizar registro empleado
    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    // eliminar usuario por ID

    public boolean deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
        if(this.empleadoRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }


}
