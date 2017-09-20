import java.time.LocalDateTime;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Offerta.
 */
public class Offerta {

	/** The tipo. */
	private String tipo;
	
	/** The num biglietti. */
	private int numBiglietti;
	
	/** The prezzo. */
	private double prezzo;
	
	/** The scadenza. */
	private LocalDateTime scadenza;
	
	/**
	 * Instantiates a new offerta.
	 *
	 * @param tipo the tipo
	 * @param numBiglietti the num biglietti
	 * @param prezzo the prezzo
	 */
	public Offerta(String tipo, int numBiglietti, double prezzo){
		this.tipo = tipo;
		this.numBiglietti = numBiglietti;
		this.prezzo = prezzo;
		this.setScadenza(LocalDateTime.now().plusDays(30));
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the num biglietti.
	 *
	 * @return the num biglietti
	 */
	public int getNumBiglietti() {
		return numBiglietti;
	}

	/**
	 * Sets the num biglietti.
	 *
	 * @param numBiglietti the new num biglietti
	 */
	public void setNumBiglietti(int numBiglietti) {
		this.numBiglietti = numBiglietti;
	}

	/**
	 * Gets the prezzo.
	 *
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Sets the prezzo.
	 *
	 * @param prezzo the new prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		if(!(that instanceof Offerta)) return false;
		Offerta o = (Offerta) that;
		return this.tipo.equals(o.tipo);
	}

	/**
	 * Gets the scadenza.
	 *
	 * @return the scadenza
	 */
	public LocalDateTime getScadenza() {
		return scadenza;
	}

	/**
	 * Sets the scadenza.
	 *
	 * @param scadenza the new scadenza
	 */
	public void setScadenza(LocalDateTime scadenza) {
		this.scadenza = scadenza;
	}
	
	/**
	 * Gets the info offerta.
	 *
	 * @return the info offerta
	 */
	public ArrayList<Object> getInfoOfferta(){
		ArrayList<Object> temp = new ArrayList<Object>();
		temp.add(tipo);
		temp.add(numBiglietti);
		temp.add(prezzo);
		temp.add(scadenza);
		return temp;
	}
}
