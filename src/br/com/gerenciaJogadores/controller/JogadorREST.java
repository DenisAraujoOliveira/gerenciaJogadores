package br.com.gerenciaJogadores.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaJogadores.model.Jogador;

import br.com.gerenciaJogadores.service.JogadorService;





@RestController
public class JogadorREST {
	
	private JogadorService js;
	
	@Autowired
	public JogadorREST(JogadorService js) {
		this.js = js;
	}
	
	/**
	 * @author denilson.oliveira
	 * @return List de jogadores. Todos cadastrados na base de dados. 
	 */
	@RequestMapping(method=RequestMethod.GET, value="json/all-jogadores")
	public @ResponseBody List<Jogador> listagem() {
		List<Jogador> lista = null;
		lista = js.listarJogadores();
		return lista;
	}
	
	/**
	 * @author denilson.oliveira
	 * @param id do jogador
	 * @return Objeto jogador.
	 */
	@RequestMapping(method=RequestMethod.GET, value="json/jogadores/{id}")
	public @ResponseBody Jogador listaJogadorPorId(@PathVariable("id") Long id) {
		Jogador jogador = null, param;
		try{
			param = new Jogador();
			param.setId(id.intValue());
			jogador = js.exibirJogador(param);
		} catch(IOException e){
			jogador = new Jogador();
			jogador.setSucess(false);
			e.printStackTrace();
		}
		return jogador;
	}
	
	
	/**
	 * @author denilson.oliveira
	 * @return List de jogadores disponiveis na base de dados.
	 */
	@RequestMapping(method=RequestMethod.GET, value="json/jogadores-disponiveis")
	public @ResponseBody List<Jogador> listarJogadoresDisponiveis() {
		List<Jogador> lista = null;
		lista = js.listarJogadoresDisponiveis();
		return lista;
	}
	


	/**
	 * @author denilson.oliveira
	 * @param id do jogador
	 * @return Objeto jogador.
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="json/comprar-jogador/{id}")
	public @ResponseBody Jogador comprarJogadorPorId(@PathVariable("id") Long id){
		Jogador jogador = null;
		jogador =  js.comprarJogadorPorId(id.intValue());
		
		return jogador;
	}
		
}
