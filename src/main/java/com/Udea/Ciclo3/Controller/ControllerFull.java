package com.Udea.Ciclo3.Controller;




import com.Udea.Ciclo3.Clases.Empleado;
import com.Udea.Ciclo3.Clases.Empresa;
import com.Udea.Ciclo3.Servicio.EmpleadoService;
import com.Udea.Ciclo3.Servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFull {
    @Autowired
    EmpresaService empresaService;
    @Autowired
    EmpleadoService empleadoService;

    // empresas
    @GetMapping("/enterprises") //Ver json de todas las empresas
    public List<Empresa> verEmpresas() {
        return empresaService.getAllEmpresa();
    }

    @PostMapping("/enterprises") //Guardar el json del body como una nueva empresa o registro en nuestra bd
    public Empresa guardarEmpresa(@RequestBody Empresa emp) {
        return this.empresaService.saveOrUpdateEmpresa(emp);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id) {
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.saveOrUpdateEmpresa(emp);
    }

    @DeleteMapping(path = "enterprises/{id}") //Eliminar registro de la bd
    public String DeleteEmpresa(@PathVariable("id") Integer id) {
        boolean respuesta = this.empresaService.deleteEmpresa(id);
        if (respuesta) {  //Si respuesta es true?
            return "Se elimino la empresa con id" + id;
        } else {
            return "No se pudo eliminar la empresa con id" + id;
        }
    }

    //Empleados
    @GetMapping("/empleados") //Ver json de todas las empleados
    public List<Empleado> verEmpleados() {
        return empleadoService.getAllEmpleado();
    }
    @PostMapping ("/empleados")//guardar un empleado
    public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
        return  Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
    }
    @GetMapping(path = "empleados/{id}")//Consultar empleado por ID
    public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id) {
        return this.empleadoService.getEmpleadoById(id);
    }
    @GetMapping("/enterprises/{id}/empleados")// Consultar empleados por empresa
    public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id){
        return this.empleadoService.obtenerPorEmpresa(id);
    }
}