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
	 *
	 * Serviço para disponibilizar lista de todos jogadores 
	 * sem exceção de status  
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
	 * Serviço para buscar dados(nome,posicao,mercado,
	 * valor,ataque,defesa,altura,peso,cond_fisica,
	 * forca,drible,desarme e sucess) de 1 
	 * jogador atraves do id.
	 * 
	 * 
	 * 
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
	 * Serviço para disponibilizar lista
	 * de jogadores com status disponiveis
	 * ou seja prontos para
	 * serem escalados. 
	 * 
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
	 * Serviço que
	 * possibilita compra de jogador,
	 * atualiza status do jogador DISPONIVEL
	 * para ESCALADO e o atributo sucess como TRUE. 
	 * Jogadores que ja foram escalados, retornam
	 * um objeto vazio e com atributo
	 * sucess como false
	 * 
	 * @author denilson.oliveira
	 * @param id do jogador
	 * @return Objeto jogador.
	 */

	@RequestMapping(method=RequestMethod.GET, value="json/comprar-jogador/{id}")
	public @ResponseBody Jogador comprarJogadorPorId(@PathVariable("id") Long id){
		Jogador jogador = null;
		jogador =  js.comprarJogadorPorId(id.intValue());
		
		return jogador;
	}		
}
