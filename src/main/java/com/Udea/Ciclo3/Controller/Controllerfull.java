package com.Udea.Ciclo3.Controller;

import com.Udea.Ciclo3.Clases.Empresa;
import com.Udea.Ciclo3.Servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Controllerfull {
    @Autowired
     EmpresaService empresaService;

    @GetMapping({"/Empresas","/VerEmpresas"})
    public String viewEmpresas(Model model) {
        List<Empresa> listempresas = empresaService.getAllEmpresa();
        model.addAttribute("emplist", listempresas);
        return "verEmpresas";
    }

}
