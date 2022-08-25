package com.Udea.Ciclo3.Controller;

import com.Udea.Ciclo3.Clases.Empresa;
import com.Udea.Ciclo3.Servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Controllerfull {
    @Autowired
     EmpresaService empresaService;

    @GetMapping({"/","/VerEmpresas"})
    public String viewEmpresas(Model model) {
        List<Empresa> listempresas = empresaService.getAllEmpresa();
        model.addAttribute("emplist", listempresas);
        return "verEmpresas";
    }
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp= new Empresa ();
        model.addAttribute("emp",emp);
        return "agregarEmpresa";
    }
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";
    }
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id) {
        Empresa emp=empresaService.getEmpresaById(id);
        model.addAttribute("emp",emp);
        return "editarEmpresa";
    }
    @PostMapping ("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp){
        if(empresaService.saveOrUpdateEmpresa(emp)){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/EditarEmpresa";
    }
    @GetMapping ("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id){
        try{
            empresaService.deleteEmpresa(id);
        }catch (Exception e){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/VerEmpresas";
        }


    }

