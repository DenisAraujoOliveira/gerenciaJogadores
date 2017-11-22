package br.com.gerenciaJogadores.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gerenciaJogadores.model.Usuario;


@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public Usuario fazerLogin(Usuario usuario) {
		
		String jpql = "select u from Usuario u where u.username = :user and u.senha = :senha";
		Query query = manager.createQuery(jpql);
		query.setParameter("user", usuario.getUsername());
		query.setParameter("senha", usuario.getSenha());
		@SuppressWarnings("unchecked")
		List<Usuario> result = query.getResultList();
		if(result != null && result.size() == 1){
			usuario.setId(result.get(0).getId());
			usuario.setUsername(result.get(0).getUsername());
			return usuario;
		}
		else{
			usuario = null;
			return usuario;
		}
	}
	
	

}
