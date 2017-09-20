import java.time.LocalDateTime;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 * Il manager puo modificare le programmazioni e inserire o cancellare 
 * un offerta
 */
public class Manager extends Utente{
	
	/**  Attributes. */
	private int numeroDipendenti;
	
	/** The stipendio. */
	private double stipendio;
	
	/** The data assunzione. */
	private LocalDateTime dataAssunzione;
	
	/**  Associations. */ 
	private ArrayList<Offerta> offerte;
	
	/**
	 * Instantiates a new manager.
	 *
	 * @param idUtente the id utente
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param email the email
	 * @param sesso the sesso
	 * @param password the password
	 * @param password2 the password 2
	 */
	public Manager(String idUtente, String nome, String cognome, String email, String sesso, String password, String password2){
		super(idUtente, nome, cognome, email, sesso, password, password2);
		this.setNumeroDipendenti(0);
		this.setStipendio(0.0);
		this.dataAssunzione = null;	
		this.offerte = new ArrayList<Offerta>();
	}
	
	/**
	 * Gets the numero dipendenti.
	 *
	 * @return the numero dipendenti
	 */
	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}
	
	/**
	 * Sets the numero dipendenti.
	 *
	 * @param numeroDipendenti the new numero dipendenti
	 */
	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}
	
	/**
	 * Gets the stipendio.
	 *
	 * @return the stipendio
	 */
	public double getStipendio() {
		return stipendio;
	}
	
	/**
	 * Sets the stipendio.
	 *
	 * @param stipendio the new stipendio
	 */
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public LocalDateTime getData() {
		return dataAssunzione;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(LocalDateTime data) {
		this.dataAssunzione = data;
	}
	
	/**
	 * Gets the offerte.
	 *
	 * @return the offerte
	 */
	public ArrayList<Offerta> getOfferte() {
		return offerte;
	}

	/**
	 * Sets the offerte.
	 *
	 * @param offerte the new offerte
	 */
	public void setOfferte(ArrayList<Offerta> offerte) {
		this.offerte = offerte;
	}
	
	/**
	 * Modifica programmazione.
	 * modifica di una programmazione, bisogna verificare che non si 
	 * sovvrapponga a un altra programmazione gia schedulata
	 * @param idSala the id sala
	 * @param inizioFilm the inizio film
	 * @param dataFilm the data film
	 * @param p the p
	 * @param programmazioni the programmazioni
	 * @return true, if successful
	 */
	public boolean modificaProgrammazione(int idSala, LocalDateTime inizioFilm,
			LocalDateTime dataFilm, Programmazione p, ArrayList<Programmazione>
			programmazioni){
		//se in quella sala quel giorno c'e gia un film
		for(Programmazione programmazione : programmazioni) 
		{
			//se la sala e' la stessa e il giorno e' lo stesso bisogna controllare 
			//l'orario, la modifica va a buon fine solo se il nuovo orario
			// è prima del film gia schedulato quel giorno o dopo che esso sia finito
			if(programmazione.getSala().getIdSala() == idSala && 
					programmazione.getGiorno().isEqual(dataFilm))
			{
				LocalDateTime fine;
				fine = programmazione.getOra().plusHours(programmazione.getFilm()
						.getDurataOre()).plusMinutes(programmazione.getFilm()
						.getDurataMin());
				if(inizioFilm.isEqual(programmazione.getOra()) || 
						inizioFilm.isBefore(fine) && inizioFilm.
						isAfter(programmazione.getOra())) 
				{
					System.err.println("La programmazione si sovrappone a una "
							+ "gia esistente");
					return false;
				}
			} 
		}
		return true;
	}

	/**
	 * Aggiungi offerta.
	 * Il manager inserisce una nuova tipologia di offerta
	 * @param offerta the offerta
	 */
	public void aggiungiOfferta(Offerta offerta) {
		if(this.offerte.contains(offerta))
		{
			System.err.println("L'offerta è gia stata inserita");
		}else{
			this.offerte.add(offerta);
		}
	}
	
   /**
    * Rimuovi offerta.
    *
    * @param offerta the offerta
    * @return true, if successful
    */
   public boolean rimuoviOfferta(Offerta offerta) {
	   if(!this.offerte.contains(offerta)) 
	   {
		   System.err.println("L'offerta selezionata non esiste");
		   return false;
	   }else{ 
		   int index = this.offerte.indexOf(offerta);
		   this.offerte.remove(index);
		   return true;
	   }
   }
}
