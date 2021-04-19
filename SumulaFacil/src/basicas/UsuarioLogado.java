package basicas;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsuarioLogado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cod;

	@Column(nullable = false)
	private Usuario usuario;
	
	@Column(name = "Login")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date entradaCalendar;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Logout")	
	private Date saida;

	public UsuarioLogado() {
	}
	
	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public Usuario getIdUuario() {
		return getIdUuario();
	}

	public Date getEntradaCalendar() {
		return entradaCalendar;
	}

	public void setEntradaCalendar(Date entradaCalendar) {
		this.entradaCalendar = entradaCalendar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
