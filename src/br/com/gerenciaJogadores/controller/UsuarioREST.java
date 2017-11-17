package br.com.gerenciaJogadores.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaJogadores.model.Jogador;
import br.com.gerenciaJogadores.model.Usuario;
import br.com.gerenciaJogadores.service.JogadorService;
import br.com.gerenciaJogadores.service.UsuarioService;




@RestController
public class UsuarioREST {
	
	private JogadorService js;
	private UsuarioService us;
	
	@Autowired
	public UsuarioREST(JogadorService js, UsuarioService us) {
		this.js = js;
		this.us = us;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="json/all-jogadores")
	public @ResponseBody List<Jogador> listagem() {
		List<Jogador> lista = null;
		lista = js.listarJogadores();
		return lista;
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="json/jogadores/{id}")
	public @ResponseBody Jogador listaJogadorPorId(@PathVariable("id") Long id) {
		Jogador jogador = null, param;
		try{
			param = new Jogador();
			param.setId(id.intValue());
			jogador = js.exibirJogador(param);
		} catch(IOException e){
			e.printStackTrace();
		}
		return jogador;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="json/jogadores-disponiveis")
	public @ResponseBody List<Jogador> listarJogadoresDisponiveis() {
		List<Jogador> lista = null;
		lista = js.listarJogadoresDisponiveis();
		return lista;
	}
	

	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="json/comprar-jogador")
	public @ResponseBody Jogador comprarJogador(@RequestBody Jogador jogador){
			jogador =  js.comprarJogador(jogador);
			return jogador;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="login")
	public @ResponseBody Usuario fazerLogin(@RequestBody Usuario usuario) {
		System.out.println(usuario);
		Usuario param = null;
		try{
			param = us.fazerLogin(usuario);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return param;
	}
	
	
	
	
	
	
	
}
