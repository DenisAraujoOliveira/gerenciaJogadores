package br.com.gerenciaJogadores.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciaJogadores.model.Jogador;
import br.com.gerenciaJogadores.model.Mercado;
import br.com.gerenciaJogadores.service.JogadorService;




@RestController
public class UsuarioREST {
	
	private JogadorService js;
	
	@Autowired
	public UsuarioREST(JogadorService js) {
		this.js = js;
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
	public ResponseEntity<Jogador> criarLocal(@RequestBody Jogador jogador){
		String time = jogador.getTime();
		try {
			jogador = js.exibirJogador(jogador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(jogador.getMercado() == Mercado.escalado){
			return new ResponseEntity<Jogador>(jogador, HttpStatus.INTERNAL_SERVER_ERROR);
		}else{
			jogador.setMercado(Mercado.escalado);
			jogador.setTime(time);
			js.comprarJogador(jogador);
			return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
		}
	}
	
	
	
}
