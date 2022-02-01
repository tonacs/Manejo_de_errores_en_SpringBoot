package com.tona.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tona.springboot.error.app.errors.UsuarioNoEncontradoException;

//@Controlleradvice maneja los errores, mapea los errores a métodos
@ControllerAdvice
public class ErrorHandlerController {
	
	
	@ExceptionHandler(ArithmeticException.class)
	public String artimeticaError(ArithmeticException e, Model model) {
		model.addAttribute("error","Error de aritmética");
		model.addAttribute("message",e.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp",new Date());
		return "error/generica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException(NumberFormatException ex,Model model) {
		model.addAttribute("error","Error: Formato número inválido");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp",new Date());
		return "error/generica";
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String UsuarioNoEncontradoException(UsuarioNoEncontradoException ex,Model model) {
		model.addAttribute("error","Error: Usuario NO ENCONTRADO");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp",new Date());
		return "error/usuario";
	}
	
	
}
