package br.com.gerenciaJogadores.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaJogadores.DAO.JogadorDAO;
import br.com.gerenciaJogadores.model.Jogador;



@Service
public class JogadorService {
	private JogadorDAO jogadorDAO;

	@Autowired
	public JogadorService(JogadorDAO jogadorDAO) {
		this.jogadorDAO = jogadorDAO;
	}
	
	public List<Jogador> listarJogadores() {
		return jogadorDAO.listarJogadores();
		
	}
	public Jogador exibirJogador(Jogador jogador) throws IOException {
		return jogadorDAO.exibirJogador(jogador.getId());
	}
	
	public List<Jogador> listarJogadoresDisponiveis() {
		return jogadorDAO.listarJogadoresDisponiveis();
		
	}
	
	public void comprarJogador(Jogador jogador){
			jogadorDAO.comprarJogador(jogador);		
	}
	
	
}