package com.Udea.Ciclo3;

import com.Udea.Ciclo3.Clases.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public String hell (){
		return "Hola ciclo 3 ...Saldremos vivos";
	}

	@GetMapping("/test")
	public String test () {
		Empresa emp = new Empresa("SOLAR SAS", "Calle la geta", "3213213211","800212132-3");
		emp.setNombre("SOLAR LTDA");
		return emp.getNombre();
	}

	public static void main(String[] args) {
           SpringApplication.run(Ciclo3Application.class,args);

	}

}
