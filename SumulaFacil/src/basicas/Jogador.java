package basicas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Jogador extends Pessoa implements Serializable{



	@Override
	public String toString() {
		return "Jogador [pessoa=" + pessoa + ", equipe=" + equipe + ", numeroCamisa=" + numeroCamisa + ", apelido="
				+ apelido + ", capitao=" + capitao + ", goleiro=" + goleiro + "]";
	}

	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricula")
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 2)
	private Equipe equipe;
	private String numeroCamisa;
	private String apelido;
	private boolean capitao;
	private boolean goleiro;
	
	public Jogador() {}	
	
	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public String getNumeroCamisa() {
		return numeroCamisa;
	}


	public void setNumeroCamisa(String numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public Boolean getCapitao() {
		return capitao;
	}


	public void setCapitao(Boolean capitao) {
		this.capitao = capitao;
	}

	public boolean isGoleiro() {
		return goleiro;
	}

	public void setGoleiro(boolean goleiro) {
		this.goleiro = goleiro;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	

	

}
