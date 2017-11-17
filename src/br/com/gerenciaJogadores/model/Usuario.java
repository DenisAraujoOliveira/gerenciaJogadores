package br.com.gerenciaJogadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdUsuario")
	private Long id;
	
	@Column(length=30, unique = true )
	@Size(max=30,min=4,message="O username deve conter no maximo 30 caracteres")
	private String username;
	
	@Column(length=32, nullable=false)
	@Size(max=32,min=5,message="A senha deve conter no maximo 32 caracteres")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", senha=" + senha + "]";
	}
	
	
	
	
}
