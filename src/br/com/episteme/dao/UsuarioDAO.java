package br.com.episteme.dao;

import java.util.List;

import br.com.episteme.model.Usuario;

public class UsuarioDAO implements GenericDAO{
	public void create(Object o) {
		
	}
	public List<Object> read(Object o) {
		Usuario usuario = new Usuario();
		usuario.setNome("Lucas");
		// ajustar os atributos necessários:
		return (List<Object>) usuario;
	}
	public void update(Object o) {
		
	}
	public void delete(Object o) {
		
	}
}
