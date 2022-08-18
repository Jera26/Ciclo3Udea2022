package com.Udea.Ciclo3.Servicio;

import com.Udea.Ciclo3.Clases.Empresa;
import com.Udea.Ciclo3.repositorio.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public List <Empresa>getAllEmpresa(){
        List<Empresa> empresalist = new ArrayList<>();
        empresaRepository.findAll().forEach(Empresa-> empresalist.add(Empresa));
        return empresalist;
    }

    //Metodo que me trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepository.save(empresa);
        if (empresaRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    //metodo delete pendiente
}

