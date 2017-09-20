
// TODO: Auto-generated Javadoc
/**
 * The Class Abbonamento.
 * Ogni utente puo' acquistare un abbonamento.
 * Il prezzo,tipo,numero dei biglietti vengono settati
 * in base al tipo di offerta che l'utente desidera acquistare
 */
public class Abbonamento {

	/** The tipo abbonamento. */
	private String tipoAbbonamento;
	
	/** The numero biglietti. */
	private int numeroBiglietti;
	
	/** The costo. */
	private double costo;
	
	/**
	 * Instantiates a new abbonamento.
	 *
	 * @param offerta the offerta
	 */
	public Abbonamento(Offerta offerta){
		this.setTipoAbbonamento(offerta.getTipo());
		this.setNumeroBiglietti(offerta.getNumBiglietti());
		this.setCosto(offerta.getPrezzo());
	}

	/**
	 * Gets the tipo abbonamento.
	 *
	 * @return the tipo abbonamento
	 */
	public String getTipoAbbonamento() {
		return tipoAbbonamento;
	}

	/**
	 * Sets the tipo abbonamento.
	 *
	 * @param tipoAbbonamento the new tipo abbonamento
	 */
	public void setTipoAbbonamento(String tipoAbbonamento) {
		this.tipoAbbonamento = tipoAbbonamento;
	}

	/**
	 * Gets the numero biglietti.
	 *
	 * @return the numero biglietti
	 */
	public int getNumeroBiglietti() {
		return numeroBiglietti;
	}

	/**
	 * Sets the numero biglietti.
	 *
	 * @param numBiglietti the new numero biglietti
	 */
	public void setNumeroBiglietti(int numBiglietti) {
		this.numeroBiglietti = numBiglietti;
	}
	

	/**
	 * Gets the costo.
	 *
	 * @return the costo
	 */
	public double getCosto() {
		return costo;
	}

	/**
	 * Sets the costo.
	 *
	 * @param costo the new costo
	 */
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	/**
	 * Scala biglietti.
	 * quando un utente acquista e paga con abbonamento
	 * vengono scalati i biglietti
	 * @param nBiglietti the n biglietti
	 * @return true, if successful
	 */
	public boolean scalaBiglietti(int nBiglietti) {
		if(this.numeroBiglietti >= nBiglietti) 
		{
			this.numeroBiglietti = this.numeroBiglietti - nBiglietti;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Rimborso biglietti.
	 * quando viene cancellata una prenotazione pagata con abbonamento
	 * vengono rimborsati i biglietti 
	 * @param nBiglietti the n biglietti
	 */
	public void rimborsoBiglietti(int nBiglietti){
		this.numeroBiglietti = this.getNumeroBiglietti() + nBiglietti;
	}
}
