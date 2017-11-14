package br.com.gerenciaJogadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Jogador")
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idJogador")
	private int id;
	
	@NotNull
	@Size(max=100)
	private String nome;
	
	@NotNull
	@Size(max=30)
	private String posicao;
	
	@Enumerated(EnumType.STRING)
	private Mercado mercado;
	
	@Size(max=100)
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", posicao=" + posicao + ", mercado=" + mercado + ", time="
				+ time + "]";
	}

	
	
	
	
	
}
