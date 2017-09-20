import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Prenotazione.
 * 
 */
public class Prenotazione {
	
	/**  Attributes. */
	private int idPrenotazione;
	
	/** The costo. */
	private double costo;
	
	/** The fila posto. */
	private int filaPosto;
	
	/** The colonna posto. */
	private int colonnaPosto;
	
	/** The data spettacolo. */
	private LocalDateTime dataSpettacolo;
	
	/** The ora spettacolo. */
	private LocalDateTime oraSpettacolo; 
	
	/** The titolo film. */
	private String titoloFilm;
	
	/** The sala. */
	private int sala;
	
	
	/**
	 * Instantiates a new prenotazione.
	 *
	 * @param idPrenotazione the id prenotazione
	 * @param costo the costo
	 * @param filaPosto the fila posto
	 * @param colonnaPosto the colonna posto
	 * @param dataSpettacolo the data spettacolo
	 * @param oraSpettacolo the ora spettacolo
	 * @param titoloFilm the titolo film
	 * @param sala the sala
	 */
	public Prenotazione(int idPrenotazione,double costo, int filaPosto,
			int colonnaPosto, LocalDateTime dataSpettacolo,
			LocalDateTime oraSpettacolo, String titoloFilm, int sala){
		this.setIdPrenotazione(idPrenotazione);
		this.setCosto(costo);
		this.setFilaPosti(filaPosto);
		this.setColonnaPosti(colonnaPosto);
		this.setDataSpettacolo(dataSpettacolo);
		this.setOraSpettacolo(oraSpettacolo);
		this.setTitoloFilm(titoloFilm);
		this.setSala(sala);
	}

	/**
	 * Gets the id prenotazione.
	 *
	 * @return the id prenotazione
	 */
	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	/**
	 * Sets the id prenotazione.
	 *
	 * @param idPrenotazione the new id prenotazione
	 */
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
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
	 * Gets the fila posto.
	 *
	 * @return the fila posto
	 */
	public int getFilaPosto() {
		return filaPosto;
	}

	/**
	 * Sets the fila posti.
	 *
	 * @param filaPosto the new fila posti
	 */
	public void setFilaPosti(int filaPosto) {
		this.filaPosto = filaPosto;
	}

	/**
	 * Gets the colonna posto.
	 *
	 * @return the colonna posto
	 */
	public int getColonnaPosto() {
		return colonnaPosto;
	}

	/**
	 * Sets the colonna posti.
	 *
	 * @param colonnaPosto the new colonna posti
	 */
	public void setColonnaPosti(int colonnaPosto) {
		this.colonnaPosto = colonnaPosto;
	}
	
	/**
	 * Gets the data spettacolo.
	 *
	 * @return the data spettacolo
	 */
	public LocalDateTime getDataSpettacolo() {
		return dataSpettacolo;
	}

	/**
	 * Sets the data spettacolo.
	 *
	 * @param dataSpettacolo the new data spettacolo
	 */
	public void setDataSpettacolo(LocalDateTime dataSpettacolo) {
		this.dataSpettacolo = dataSpettacolo;
	}

	/**
	 * Gets the ora spettacolo.
	 *
	 * @return the ora spettacolo
	 */
	public LocalDateTime getOraSpettacolo() {
		return oraSpettacolo;
	}

	/**
	 * Sets the ora spettacolo.
	 *
	 * @param oraSpettacolo the new ora spettacolo
	 */
	public void setOraSpettacolo(LocalDateTime oraSpettacolo) {
		this.oraSpettacolo = oraSpettacolo;
	}
	
	/**
	 * Gets the titolo film.
	 *
	 * @return the titolo film
	 */
	public String getTitoloFilm() {
		return titoloFilm;
	}

	/**
	 * Sets the titolo film.
	 *
	 * @param titoloFilm the new titolo film
	 */
	public void setTitoloFilm(String titoloFilm) {
		this.titoloFilm = titoloFilm;
	}
	
	/**
	 * Gets the sala.
	 *
	 * @return the sala
	 */
	public int getSala() {
		return sala;
	}

	/**
	 * Sets the sala.
	 *
	 * @param sala the new sala
	 */
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		
		if(!(that instanceof Prenotazione)) return false;
		
		Prenotazione p = (Prenotazione)that;
		
		return this.idPrenotazione == p.idPrenotazione;
		
	}
	
	/**
	 * Verifica cancellazione.
	 * e' possibile eliminare una prenotazione fino a un ora prima dell'inizio 
	 * della proiezione del film.
	 * @return true, if successful
	 */
	public boolean verificaCancellazione(){
		//prendi data attuale e confronti se è passata più di un ora per cancellare la prenotazione
		//controllo che l'ora attuale sia almeno un'ora prima dell'inizio del 
		//film. In caso affermativo posso cancellare la prenotazione altrimenti
		//non posso eliminare la prenotazione.
		LocalDateTime oraDataAttuale = LocalDateTime.now();
		//se anno giorno e mese sono uguali controllo l'ora
		if(dataSpettacolo.getYear() == oraDataAttuale.getYear() 
				&& dataSpettacolo.getMonthValue() == oraDataAttuale.getMonthValue()
				&& dataSpettacolo.getDayOfMonth() == oraDataAttuale.getDayOfMonth()){
			//se sono almeno un ora prima dello spettacolo posso cancellare
			//la prenotazione
			if(oraDataAttuale.getHour() < (this.oraSpettacolo.getHour()-1)) 
				return true;
			//se la prenotazione è ormai scaduta(spettacolo gia' avvenuto)
			//posso cancellarla
			else if(oraDataAttuale.getHour() > (this.oraSpettacolo.getHour()))
				return true;
			else
				return false;
		//caso in cui si cancella la prenotazione nei giorni prima
		//dello spettacolo
		}else if(dataSpettacolo.getYear() == oraDataAttuale.getYear() 
				&& dataSpettacolo.getMonthValue() < oraDataAttuale.getMonthValue()){
			return true; 
		}
		return true;
	}
}
