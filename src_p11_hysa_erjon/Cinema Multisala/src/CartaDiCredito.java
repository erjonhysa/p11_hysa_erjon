
// TODO: Auto-generated Javadoc
/**
 * The Class CartaDiCredito.
 * Un utente che si registra deve essere in possesso di una carta di credito
 */
public class CartaDiCredito {

	/** The numero carta. */
	private String numeroCarta;
	
	/** The saldo. */
	private double saldo;
	
	/**
	 * Instantiates a new carta di credito.
	 *
	 * @param numeroCarta the numero carta
	 * @param saldo the saldo
	 */
	public CartaDiCredito(String numeroCarta, double saldo){
		this.setNumeroCarta(numeroCarta);
		this.setSaldo(saldo); 
	}
	
	/**
	 * Gets the numero carta.
	 *
	 * @return the numero carta
	 */
	public String getNumeroCarta() {
		return numeroCarta;
	}
	
	/**
	 * Sets the numero carta.
	 *
	 * @param numeroCarta the new numero carta
	 */
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	/**
	 * Gets the saldo.
	 *
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Sets the saldo.
	 *
	 * @param saldo the new saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * Pagamento.
	 * funzione che controlla se il saldo disponiblie copre la spesa che si
	 * vuole effettuare.
	 * @param importo the importo
	 * @return true, if successful
	 * 
	 */
	public boolean pagamento(double importo) {
		if(this.saldo >= importo)
		{
			return true;
		}else{
			System.err.println("Credito non sufficiente per completare l'operazione");
			return false;
		}
	}
	
	/**
	 * Effettua pagamento.
	 * funzione che effettua il pagamento e quindi scala il saldo.
	 * @param importo the importo
	 */
	public void effettuaPagamento(double importo){
		this.setSaldo(this.getSaldo() - importo);
	}
	
	/**
	 * Rimborso.
	 * Dopo aver cancellato una prenotazione pagata con carta di credito
	 * viene effettuato il rimborso.
	 * @param importo the importo
	 */
	public void rimborso(double importo) {
		this.setSaldo(this.getSaldo() + importo);
	}
}
