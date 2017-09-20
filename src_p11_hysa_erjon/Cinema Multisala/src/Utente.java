
// TODO: Auto-generated Javadoc
/**
 * The Class Utente.
 */
public class Utente {

	/**  Attributes. */
	private String idUtente;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The email. */
	private String email;
	
	/** The sesso. */
	private String sesso;
	
	/** The password. */
	private String password;
	
	/** The password 2. */
	private String password2;
	
	/** The loggato. */
	private boolean loggato;
	
	/**
	 * Instantiates a new utente.
	 *
	 * @param idUtente the id utente
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param email the email
	 * @param sesso the sesso
	 * @param password the password
	 * @param password2 the password 2
	 */
	public Utente(String idUtente, String nome, String cognome, String email, String sesso, String password, String password2) {
		this.setIdUtente(idUtente);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setSesso(sesso);
		this.setPassword(password);
		this.setPassword2(password2);
		this.setLoggato(false);
	}
	
	/**
	 * Gets the id utente.
	 *
	 * @return the id utente
	 */
	public String getIdUtente() {
		return idUtente;
	}
	
	/**
	 * Sets the id utente.
	 *
	 * @param idUtente the new id utente
	 */
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
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
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the sesso.
	 *
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * Sets the sesso.
	 *
	 * @param sesso the new sesso
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the password 2.
	 *
	 * @return the password 2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * Sets the password 2.
	 *
	 * @param password2 the new password 2
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	/**
	 * Sets the loggato.
	 *
	 * @param loggato the new loggato
	 */
	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}
	
	/**
	 * Checks if is loggato.
	 *
	 * @return true, if is loggato
	 */
	public boolean isLoggato() {
		return loggato;
	}
	
}
