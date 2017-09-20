import java.time.LocalDateTime;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 * La classe cliente estende Utente
 */
public class Cliente extends Utente{

	/** The numero telefono. */
	private String numeroTelefono;
	
	/** The username. */
	private String username;
	
	/** The id documento. */
	private String idDocumento;
	
	/** The frase segreta. */
	private String fraseSegreta;
	
	/** The prenotazioni. */
	private ArrayList<Prenotazione> prenotazioni;
	
	/** The abbonamento. */
	private Abbonamento abbonamento;
	
	/** The carta di credito. */
	private CartaDiCredito cartaDiCredito;
	
	/**
	 * Instantiates a new cliente.
	 *
	 * @param idUtente the id utente
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param email the email
	 * @param sesso the sesso
	 * @param numTelefono the num telefono
	 * @param username the username
	 * @param password the password
	 * @param password2 the password 2
	 * @param fraseSegreta the frase segreta
	 * @param cartaDiCredito the carta di credito
	 */
	public Cliente(String idUtente, String nome, String cognome, String email, String sesso, String numTelefono, String username, String password, String password2,String fraseSegreta, CartaDiCredito cartaDiCredito){
		super(idUtente, nome, cognome, email, sesso, password, password2);
		this.setNumeroTelefono(numTelefono);
		this.setUsername(username);
		this.setPrenotazioni(new ArrayList<Prenotazione>());
		this.setAbbonamento(null);
		this.setFraseSegreta(fraseSegreta);
		this.setCartaDiCredito(cartaDiCredito);
		
	}

	/**
	 * Gets the numero telefono.
	 *
	 * @return the numero telefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	/**
	 * Sets the numero telefono.
	 *
	 * @param numeroTelefono the new numero telefono
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the id documento.
	 *
	 * @return the id documento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * Sets the id documento.
	 *
	 * @param idDocumento the new id documento
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	/**
	 * Gets the prenotazioni.
	 *
	 * @return the prenotazioni
	 */
	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	/**
	 * Sets the prenotazioni.
	 *
	 * @param prenotazioni the new prenotazioni
	 */
	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	/**
	 * Gets the abbonamento.
	 *
	 * @return the abbonamento
	 */
	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	/**
	 * Sets the abbonamento.
	 *
	 * @param abbonamento the new abbonamento
	 */
	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

	/**
	 * Gets the carta di credito.
	 *
	 * @return the carta di credito
	 */
	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}

	/**
	 * Sets the carta di credito.
	 *
	 * @param cartaDiCredito the new carta di credito
	 */
	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	
	/**
	 * Gets the frase segreta.
	 *
	 * @return the frase segreta
	 */
	public String getFraseSegreta() {
		return fraseSegreta;
	}

	/**
	 * Sets the frase segreta.
	 *
	 * @param fraseSegreta the new frase segreta
	 */
	public void setFraseSegreta(String fraseSegreta) {
		this.fraseSegreta = fraseSegreta;
	}
	
	
	/**
	 * Search by date.
	 * Il cliente inserisce la data e riceve tutte le programmazioni previste
	 * in quella giornata
	 * @param listp the listp
	 * @param data the data
	 * @return the array list
	 */
	//ricerca tutte le programmazioni in quel giorno
	public ArrayList<Programmazione> searchByDate(ArrayList<Programmazione> listp, LocalDateTime data){
		ArrayList<Programmazione> tempList = new ArrayList<Programmazione>();
		for(Programmazione p : listp)
		{
			if(p.getGiorno().equals(data)) // test: crei la lista di programmazioni di cui sai gia tutto e poi fai il test in cui cerchi una certa data e controlli che magari hai messo puoi farla con i parametri mettendo {data,numerodiprogrammazioniin quella data}
			{
				tempList.add(p);
			}
		}
		return tempList;
	}
	
	/**
	 * Search by film.
	 * Il cliente inserisce il film e vede tutte le programmazioni di quel film
	 * quindi puo vedere i giorni e le ore in cui viene proiettato il film
	 * @param listp the listp
	 * @param titolo the titolo
	 * @return the array list
	 */
	//ricerca per film, ritorna tt le programmazioni dove c'e quel film
	public ArrayList<Programmazione> searchByFilm(ArrayList<Programmazione> listp, String titolo){
		ArrayList<Programmazione> tempList = new ArrayList<Programmazione>();
		for(Programmazione p : listp)
		{
			if(p.getFilm().getTitolo() == titolo) //idem a quello sopra 
			{
				tempList.add(p);
			}
		}
		return tempList;
	}
	
	/**
	 * Acquista abbonamento.
	 * Un utente può avere solo un abbonamento, ne può acquistare uno nuovo
	 * una volta terminati i biglietti dell'abbonamento che possiede.
	 * @param offerta the offerta
	 */
	public void acquistaAbbonamento(Offerta offerta){ 
		if(this.abbonamento != null)
		{
			System.err.println("Possiedi già un abbonamento!");
		}
		else if(this.abbonamento == null)
		{
			Abbonamento abb = new Abbonamento(offerta);
			if(this.cartaDiCredito.pagamento(offerta.getPrezzo())) 
			{
				this.abbonamento = abb;
			}else{
				System.err.println("Abbonamento non acquistato");
			}
		}
	}
	 
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		if(!(that instanceof Cliente)) return false;
		Cliente c = (Cliente) that;
		return this.username.equals(c.getUsername());
	}
}