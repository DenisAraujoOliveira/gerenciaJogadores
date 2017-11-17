package br.com.gerenciaJogadores.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaJogadores.DAO.UsuarioDAO;
import br.com.gerenciaJogadores.model.Usuario;




@Service
public class UsuarioService {
	private UsuarioDAO usuarioDAOdao;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAOdao) {
		this.usuarioDAOdao = usuarioDAOdao;
	}
	
	public Usuario fazerLogin(Usuario usuario) throws IOException{
		return usuarioDAOdao.fazerLogin(usuario);
	}
	

}
