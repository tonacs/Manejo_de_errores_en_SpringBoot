package com.tona.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.tona.springboot.error.app.entity.Usuario;

public interface UserService {
	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
	public Optional<Usuario> obtenerPorIdOptional(Integer id);
}
