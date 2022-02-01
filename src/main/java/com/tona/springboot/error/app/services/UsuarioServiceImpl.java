package com.tona.springboot.error.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tona.springboot.error.app.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UserService{
	
	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista=Arrays.asList(
				new Usuario(1,"Juan","Perez"),
				new Usuario(2,"Alberto","Rodriguez"),
				new Usuario(3,"R","RRR"),
				new Usuario(4,"D","D"),
				new Usuario(5,"E","E"),
				new Usuario(6,"F","F"),
				new Usuario(7,"G","G")
				);
	}
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado=null;
		for (Usuario usuario : this.lista) {
			if (usuario.getId().equals(id)) {
				resultado=usuario;
				break;
			}
		}
		return resultado;
	}
	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario=this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
