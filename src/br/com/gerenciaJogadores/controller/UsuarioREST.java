package br.com.gerenciaJogadores.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="login")
	public @ResponseBody Usuario fazerLogin(@RequestParam(value = "username", required=true) String username, @RequestParam(value = "senha",required=true)String senha) {
		Usuario param = new Usuario();
		Usuario user = new Usuario();
		param.setUsername(username);
		param.setSenha(senha);
		try{
			user = us.fazerLogin(param);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
