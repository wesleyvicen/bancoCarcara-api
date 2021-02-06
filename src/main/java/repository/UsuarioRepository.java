package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {
	public List<Usuario> usuarios = new ArrayList<Usuario>();	
	public UsuarioRepository() {
		usuarios.add(new Usuario( "jpsilva", "123456", "João da Silva", "12345678910"));
		
	}
	public boolean AddUser(Usuario usuario) {
		//Precisamos verificar se o usário não existe no sistema.
		Usuario usuarioRepetido = this.getUser(usuario.getLogin());
		if(usuarioRepetido == null) {
			usuarios.add(usuario);
			return true;
		}		
		else {
			return false;
		}		
	}
	
	public Usuario getUser(String login) {		
		for(Usuario usuario : usuarios) {
			if(usuario.getLogin().equals(login)) {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario getUser(String login, String senha) {
		for(Usuario usuario : usuarios) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}
}
