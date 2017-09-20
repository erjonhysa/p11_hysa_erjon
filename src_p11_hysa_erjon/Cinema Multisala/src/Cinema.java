import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Cinema.
 */
public class Cinema {
	
	/**  Attributes. */
	private int idCinema;
	
	/** The nome. */
	private String nome;
	
	/** The indirizzo. */
	private String indirizzo;
	
	/** The citta. */
	private String citta;
	
	
	/**  Associations. */
	private ArrayList<Sala> sale;
	
	/** The film programmati. */
	private ArrayList<Programmazione> filmProgrammati;
	
	/** The clienti. */
	private ArrayList<Cliente> clienti;
	
	/**
	 * Instantiates a new cinema.
	 *
	 * @param idCinema the id cinema
	 * @param nome the nome
	 * @param indirizzo the indirizzo
	 * @param citta the citta
	 */
	public Cinema(int idCinema, String nome, String indirizzo, String citta){
		this.setIdCinema(idCinema);
		this.setNome(nome);
		this.setIndirizzo(indirizzo);
		this.setCitta(citta);
		this.sale = new ArrayList<Sala>();
		this.filmProgrammati = new ArrayList<Programmazione>();
		this.clienti = new ArrayList<Cliente>();
	}

	/**
	 * Gets the id cinema.
	 *
	 * @return the id cinema
	 */
	public int getIdCinema() {
		return idCinema;
	}

	/**
	 * Sets the id cinema.
	 *
	 * @param idCinema the new id cinema
	 */
	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the indirizzo.
	 *
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Sets the indirizzo.
	 *
	 * @param indirizzo the new indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Gets the citta.
	 *
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * Sets the citta.
	 *
	 * @param citta the new citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * Gets the sale.
	 *
	 * @return the sale
	 */
	public ArrayList<Sala> getSale() {
		return sale;
	}

	/**
	 * Sets the sale.
	 *
	 * @param sale the new sale
	 */
	public void setSale(ArrayList<Sala> sale) {
		this.sale = sale;
	}

	/**
	 * Gets the film programmati.
	 *
	 * @return the film programmati
	 */
	public ArrayList<Programmazione> getFilmProgrammati() {
		return filmProgrammati; 
	}

	/**
	 * Sets the film programmati.
	 *	
	 * @param filmProgrammati the new film programmati(sono tutte le 
	 * proiezioni schedulate in questo cinema )
	 */
	public void setFilmProgrammati(ArrayList<Programmazione> filmProgrammati) {
		this.filmProgrammati = filmProgrammati;
	}
	
	/**
	 * Gets the clienti.
	 *
	 * @return the clienti 
	 */
	public ArrayList<Cliente> getClienti() {
		return clienti;
	}

	/**
	 * Sets the clienti.
	 *
	 * @param clienti the new clienti
	 */
	public void setClienti(ArrayList<Cliente> clienti) {
		this.clienti = clienti;
	}
	
	/**
	 * Aggiungi sala.
	 *
	 * @param s the s
	 */
	public void aggiungiSala(Sala s) {
		if(this.sale.contains(s))
		{
			System.err.println("La sala è già presente");
		}else{
			this.sale.add(s);
		}
	}
	
	/**
	 * Rimuovi sala.
	 *
	 * @param s the s
	 * @return true, if successful
	 */
	public boolean rimuoviSala(Sala s){
		 if(!this.sale.contains(s))
		 {
			 System.err.println("La sala selezionata non esiste");
			 return false;
		 }else{
			 int index = this.sale.indexOf(s);
			 this.sale.remove(index);
			 return true;
		 }
	 }
	 
	 /**
 	 * Aggiungi programmazione.
 	 * aggiunge una nuova programmazione al cinema
 	 * @param p the p
 	 */
 	public void aggiungiProgrammazione(Programmazione p) {
		 if(this.filmProgrammati.contains(p))
		 {
			 System.err.println("La programmazione è già inserita");
		 }else{
			 this.filmProgrammati.add(p);
		 }
	 }
	 
	 /**
 	 * Rimuovi programmazione.
 	 *
 	 * @param p the p
 	 * @return true, if successful
 	 */
 	public boolean rimuoviProgrammazione(Programmazione p){
		 if(!this.filmProgrammati.contains(p))
		 {
			 System.err.println("La programmazione selezionata non esiste");
			 return false;
		 }else{
			 int index = this.filmProgrammati.indexOf(p);
			 this.filmProgrammati.remove(index);
			 return true;
		 }
	 }

	 /**
 	 * Registra cliente.
 	 *
 	 * @param c the c
 	 * @return true, if successful
 	 */
 	public boolean registraCliente(Cliente c){
		 if(c.getPassword().equals(c.getPassword2()))
		 {
			 if(!this.clienti.contains(c)){
				 this.clienti.add(c);
				 return true;
			 }
			 else{
				 System.err.println("cliente gia' registrato");
				 return false;
			 }
		 }else{
			 System.err.println("le password non coincidono");
			 return false;
		 }
	 }
	 
	 /**
 	 * Elimina cliente.
 	 *
 	 * @param cliente the cliente
 	 */
 	public void eliminaCliente(Cliente cliente) {
		 if(!this.clienti.contains(cliente))
		 {
			 System.err.println("Questo cliente non esiste");
		 }else{
			 int index = this.clienti.indexOf(cliente);
			 this.clienti.remove(index);
		 }
	 }
	 
	 /**
 	 * Login.
 	 * un cliente effettua il login
 	 * @param username the username
 	 * @param password the password
 	 */
 	public void login(String username, String password) {
		 for(Cliente c : this.clienti)
		 {
			 if(c.getUsername().equals(username) && c.getPassword().equals(password))
			 {
				 c.setLoggato(true);
			 }else if(c.getUsername().equals(username) && !c.getPassword().equals(password)){	 
				 System.err.println("Password errata. Frase segreta: "+c.getFraseSegreta());
			 }else if(!c.getUsername().equals(username) && !c.getPassword().equals(password)){
				 System.err.println("Dati inseriti non corretti");	
			 }else if(!c.getUsername().equals(username) && c.getPassword().equals(password)){
				 System.err.println("Username non corretto");	
			 }
		 } 
	 }
	 
	 /**
 	 * Logout.
 	 * un cliente effettua il logout dal sistema
 	 * @param username the username
 	 */
 	public void logout(String username){
		 for(Cliente c : this.clienti)
		 {
			 if(c.getUsername().equals(username))
			 {
				 c.setLoggato(false);
			 }
		 }
	 }
}
