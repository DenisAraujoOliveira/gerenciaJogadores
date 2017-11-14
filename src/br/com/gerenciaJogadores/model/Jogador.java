package br.com.gerenciaJogadores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
	
	@Size(min=1)
	private int valor;
	
	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int ataque;

	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int defesa;
	
	 
	@DecimalMin(value="1")
	private double altura;
	
	
	@DecimalMin(value="1")
	private double peso;
	
	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int cond_fisica;
	
	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int forca;
	
	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int drible;
	
	@DecimalMax(value="99") 
	@DecimalMin(value="1")
	private int desarme;
	
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCond_fisica() {
		return cond_fisica;
	}

	public void setCond_fisica(int cond_fisica) {
		this.cond_fisica = cond_fisica;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getDrible() {
		return drible;
	}

	public void setDrible(int drible) {
		this.drible = drible;
	}

	public int getDesarme() {
		return desarme;
	}

	public void setDesarme(int desarme) {
		this.desarme = desarme;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", posicao=" + posicao + ", mercado=" + mercado + ", valor="
				+ valor + ", ataque=" + ataque + ", defesa=" + defesa + ", altura=" + altura + ", peso=" + peso
				+ ", cond_fisica=" + cond_fisica + ", forca=" + forca + ", drible=" + drible + ", desarme=" + desarme
				+ "]";
	}


	
}
