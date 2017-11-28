package br.com.gerenciaJogadores.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaJogadores.model.Usuario;

import br.com.gerenciaJogadores.service.UsuarioService;




@RestController
public class UsuarioREST {
	
	
	private UsuarioService us;
	
	@Autowired
	public UsuarioREST(UsuarioService us) {
		this.us = us;
	}
	/**
	 * @author denilson.oliveira
	 * @param username e senha
	 * @return retorna usuario da base de dados
	 */
	@RequestMapping(method=RequestMethod.GET, value="login/{username}/{senha}")
	public @ResponseBody Usuario fazerLogin(@PathVariable(value = "username") String username, @PathVariable(value = "senha") String senha) {
		Usuario param = new Usuario();
		Usuario user;
		param.setUsername(username);
		param.setSenha(senha);

		user = us.fazerLogin(param);

		return user;
	}
}
