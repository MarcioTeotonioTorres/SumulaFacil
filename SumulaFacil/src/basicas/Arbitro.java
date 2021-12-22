package basicas;

public class Arbitro extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean primeiroArbitro;
	private boolean segundoArbitro;
	private boolean anotador;
	private boolean representante;
	private boolean cronometrista;
	
	public Arbitro() {}
	
	public boolean isPrimeiroArbitro() {
		return primeiroArbitro;
	}
	public void setPrimeiroArbitro(boolean primeiroArbitro) {
		this.primeiroArbitro = primeiroArbitro;
	}
	public boolean isSegundoArbitro() {
		return segundoArbitro;
	}
	public void setSegundoArbitro(boolean segundoArbitro) {
		this.segundoArbitro = segundoArbitro;
	}
	public boolean isAnotador() {
		return anotador;
	}
	public void setAnotador(boolean anotador) {
		this.anotador = anotador;
	}
	public boolean isRepresentante() {
		return representante;
	}
	public void setRepresentante(boolean representante) {
		this.representante = representante;
	}

	public boolean isCronometrista() {
		return cronometrista;
	}

	public void setCronometrista(boolean cronometrista) {
		this.cronometrista = cronometrista;
	}
	
	
	
}
