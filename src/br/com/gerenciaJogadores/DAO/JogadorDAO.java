package br.com.gerenciaJogadores.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.gerenciaJogadores.model.Jogador;



@Repository
public class JogadorDAO {
	@PersistenceContext
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Jogador> listarJogadores(){
		return manager.createQuery("select j from Jogador j").getResultList();
	}
	
	
	public Jogador exibirJogador(int id){
		Jogador jogador = new Jogador();
		jogador.setSucess(false);
		jogador = manager.find(Jogador.class, id);
		if(jogador != null){
			jogador.setSucess(true);
		}
		
		return jogador;
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogador> listarJogadoresDisponiveis(){
		return manager.createQuery("select j from Jogador j where mercado = 'disponivel'").getResultList();
	}
	
	public Jogador comprarJogador(Jogador jogador){
		return  manager.merge(jogador);
	}
	
}
