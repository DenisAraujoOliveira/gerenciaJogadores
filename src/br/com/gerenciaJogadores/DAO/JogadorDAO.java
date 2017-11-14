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
		return manager.find(Jogador.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogador> listarJogadoresDisponiveis(){
		return manager.createQuery("select j from Jogador j where mercado = 'disponivel'").getResultList();
	}
	
	public void comprarJogador(Jogador jogador){
		manager.merge(jogador);
	}
	
}
