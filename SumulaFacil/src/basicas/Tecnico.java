package basicas;

public class Tecnico extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean primeiroTecnico;
	private boolean assistenteTecnico;
	private boolean coordenadorTecnico;
	private boolean preparadorFisico;
	private boolean medicoMassagista;
	private Equipe equipe;
	
	public Tecnico() {}
	
	
	
	public boolean isPreparadorFisico() {
		return preparadorFisico;
	}

	public void setPreparadorFisico(boolean preparadorFisico) {
		this.preparadorFisico = preparadorFisico;
	}


	public boolean isMedicoMassagista() {
		return medicoMassagista;
	}


	public void setMedicoMassagista(boolean medicoMassagista) {
		this.medicoMassagista = medicoMassagista;
	}
		
	public boolean isAssistenteTecnico() {
		return assistenteTecnico;
	}
	public void setAssistenteTecnico(boolean assistenteTecnico) {
		this.assistenteTecnico = assistenteTecnico;
	}
	public boolean isPrimeiroTecnico() {
		return primeiroTecnico;
	}
	public void setPrimeiroTecnico(boolean primeiroTecnico) {
		this.primeiroTecnico = primeiroTecnico;
	}
	public boolean isCoordenadorTecnico() {
		return coordenadorTecnico;
	}
	public void setCoordenadorTecnico(boolean coordenadorTecnico) {
		this.coordenadorTecnico = coordenadorTecnico;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
