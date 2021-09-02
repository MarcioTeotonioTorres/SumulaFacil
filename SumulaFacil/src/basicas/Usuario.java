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
public class Usuario extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="matricula")
	private Pessoa pessoa;
	
	@Column(nullable = false, unique = true,length = 100)
	private String nomeUsuario;
	
	@Column(length = 8,nullable = false)
	private String senha;
	

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	public Usuario() {
		
	}

	public Usuario(Pessoa pessoa, String nomeUsuario, String senha, TipoUsuario tipoUsuario) {
		super();
		this.pessoa = pessoa;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}
 
	public void setNomeUsuario(String usuario) {
		this.nomeUsuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
