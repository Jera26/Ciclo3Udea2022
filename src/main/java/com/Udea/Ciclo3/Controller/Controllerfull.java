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
    public String viewEmpresas(Model model, @ModelAttribute("mensaje")String mensaje) {
        List<Empresa> listempresas = empresaService.getAllEmpresa();
        model.addAttribute("emplist", listempresas);
        model.addAttribute("mensaje",mensaje);
        return "verEmpresas";
    }
    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje")String mensaje){
        Empresa emp= new Empresa ();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "agregarEmpresa";
    }
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id,@ModelAttribute ("mensaje")String mensaje) {
        Empresa emp=empresaService.getEmpresaById(id);
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }
    @PostMapping ("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp,RedirectAttributes redirectAttributes){

        if(empresaService.saveOrUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa";
    }
    @GetMapping ("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        if(empresaService.deleteEmpresa(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }


    }

