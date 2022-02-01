package com.tona.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tona.springboot.error.app.entity.Usuario;
import com.tona.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.tona.springboot.error.app.services.UserService;

@Controller
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
//		Integer valor=100/0;
		Integer valor=Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		//Usuario usuario=userService.obtenerPorId(id);
		/*if (usuario==null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		Usuario usuario=userService.obtenerPorIdOptional(id).orElseThrow(()->new UsuarioNoEncontradoException(id.toString()));
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
