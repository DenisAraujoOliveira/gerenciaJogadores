package br.com.gerenciaJogadores.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciaJogadores.DAO.JogadorDAO;
import br.com.gerenciaJogadores.model.Jogador;
import br.com.gerenciaJogadores.model.Mercado;



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
	

	public Jogador comprarJogadorPorId(int id) {	
		Jogador jogador = new Jogador();
		jogador.setId(id);
		try {
			jogador = exibirJogador(jogador);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(jogador.getMercado() == Mercado.escalado){
				jogador = new Jogador();
				jogador.setSucess(false);
				return jogador;
		}else if(jogador.getMercado() == Mercado.disponivel){
				jogador.setMercado(Mercado.escalado);
				jogador.setSucess(true);
				return jogadorDAO.comprarJogador(jogador);
		}else{
			jogador = new Jogador();
			jogador.setSucess(false);
			return jogador;
		}
						
	}
	
	
	
}
