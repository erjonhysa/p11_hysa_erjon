import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Programmazione.
 * La programmazione contiene il film che viene proiettato 
 * e giorno e data in cui viene proiettato
 */
public class Programmazione {
	
	/**  Attributes. */
	private int idProgrammazione;
	
	/** The giorno. */
	private LocalDateTime giorno;
	
	/** The ora. */
	private LocalDateTime ora; 
	
	/** The posti disponibili. */
	private int postiDisponibili;
	
	/**  Associations. */
	private ArrayList<Prenotazione> prenotazioni;
	
	/** The sala. */
	private Sala sala;
	
	/** The film. */
	private Film film;

	/**
	 * Instantiates a new programmazione.
	 *
	 * @param idProgrammazione the id programmazione
	 * @param giorno the giorno
	 * @param ora the ora
	 * @param sala the sala
	 * @param film the film
	 */
	public Programmazione(int idProgrammazione, LocalDateTime giorno,
			LocalDateTime ora, Sala sala, Film film){
		this.setIdProgrammazione(idProgrammazione);
		this.setGiorno(giorno);
		this.setOra(ora);
		this.setPostiDisponibili(sala.getNumPostiTotali());
		this.setSala(sala);
		this.setFilm(film);
		this.prenotazioni = new ArrayList<Prenotazione>();
	}
	
	/**
	 * Gets the id programmazione.
	 *
	 * @return the id programmazione
	 */
	public int getIdProgrammazione() {
		return idProgrammazione;
	}

	/**
	 * Sets the id programmazione.
	 *
	 * @param idProgrammazione the new id programmazione
	 */
	public void setIdProgrammazione(int idProgrammazione) {
		this.idProgrammazione = idProgrammazione;
	}

	/**
	 * Gets the giorno.
	 *
	 * @return the giorno
	 */
	public LocalDateTime getGiorno() {
		return giorno;
	}

	/**
	 * Sets the giorno.
	 *
	 * @param giorno the new giorno
	 */
	public void setGiorno(LocalDateTime giorno) {
		this.giorno = giorno;
	}

	/**
	 * Gets the ora.
	 *
	 * @return the ora
	 */
	public LocalDateTime getOra() {
		return ora;
	}

	/**
	 * Sets the ora.
	 *
	 * @param ora the new ora
	 */
	public void setOra(LocalDateTime ora) {
		this.ora = ora;
	}

	/**
	 * Gets the posti disponibili.
	 *
	 * @return the posti disponibili
	 */
	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	/**
	 * Sets the posti disponibili.
	 *
	 * @param postiDisponibili the new posti disponibili
	 */
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	/**
	 * Gets the sala.
	 *
	 * @return the sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * Sets the sala.
	 *
	 * @param sala the new sala
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
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
	 * Sets the film.
	 *
	 * @param film the new film
	 */
	public void setFilm(Film film){
		this.film = film;
	}
	
	/**
	 * Gets the film.
	 *
	 * @return the film
	 */
	public Film getFilm(){
		return film;
	}
	 
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		if(!(that instanceof Programmazione)) return false;
		Programmazione p = (Programmazione) that;
		return this.idProgrammazione == p.idProgrammazione;
	}
	 
	/**
	 * Aggiungi prenotazione.
	 *
	 * @param p the p
	 */
	public void aggiungiPrenotazione(Prenotazione p){
		if(prenotazioni.contains(p)) 
			System.err.println("Prenotazione già inserita");
		else 
			prenotazioni.add(p);
	}
	
	/*public void updatePostiDisponibili(int postiRichiesti){
		this.
	}*/
	/**
	 * Acquistare biglietti.
	 * L' acquisto dei biglietti puo' essere pagato con abbonamento
	 * o con carta di credito. In base alla scelta viene controllato se 
	 * vi sono abbastanza soldi o il numero di biglietti disponibili
	 * nell'abbonamento è sufficiente.
	 * E' possibile acquistare piu' di un biglietto per film.
	 * 
	 * @param numBiglietti the num biglietti
	 * @param metodoPagamento the metodo pagamento
	 * @param cliente the cliente
	 *
	 */
	public void acquistareBiglietti(int numBiglietti, String metodoPagamento, Cliente cliente ) {
		if(numBiglietti <= this.sala.getNumPostiTotali())
		{
			if(metodoPagamento == "carta")
			{
				//se i soldi nella carta non bastano non fa il pagamaento
				//e la prenotazione non va a buon fine
				if(!cliente.getCartaDiCredito().pagamento(film.getPrezzo()))
				{
					System.err.println("Pagamento non effettuato!");
				}else {
					//altrimenti se i soldi nella carta bastano e 
					//quindi posso creare i biglietti
					//un biglietto per ogni persona
					for(int i = 0; i<numBiglietti; i++)
					{
						int[] postazione = this.sala.prenotaPosti(1); 
						Random rand = new Random(System.nanoTime() % 100000);
						int id = rand.nextInt();
						Prenotazione p = new Prenotazione(id, film.getPrezzo(),
						postazione[0], postazione[1], this.giorno, this.ora,
						this.film.getTitolo(),this.sala.getIdSala());
						aggiungiPrenotazione(p); 
						cliente.getPrenotazioni().add(p); 
						cliente.getCartaDiCredito().effettuaPagamento(film.getPrezzo());
					}
				}
			}else if(metodoPagamento == "abbonamento") {
				//se il cliente non possiede un abbonamento o il numero di
				//biglietti che sono rimasti nell'abbonamento non bastano 
				//allora esci altrimenti fa il for come sopra e crea le prenotazioni
				if(cliente.getAbbonamento() == null || 
						!cliente.getAbbonamento().scalaBiglietti(numBiglietti))
				{
					System.err.println("Pagamento non effettuato");
				}else {
					for(int i = 0; i<numBiglietti; i++)
					{
						int[] postazione = this.sala.prenotaPosti(1);
						Random rand = new Random(System.nanoTime() % 100000);
						int id = rand.nextInt();
						Prenotazione p = new Prenotazione(id, film.getPrezzo(),
								postazione[0], postazione[1], this.giorno,
								this.ora, this.film.getTitolo(),
								this.sala.getIdSala());
						aggiungiPrenotazione(p);
						cliente.getPrenotazioni().add(p);
					}
				}
			}else{
				System.err.println("metodo di pagamento non corretto");
			}
		}else{
			System.err.println("Il numero di posti richiesti non è disponibile");
		}
	}
	
	/**
	 * Cancella prenotazione.
	 * viene passaato l'id della prentoazione e il cliente dal quale si 
	 * vuole che la prenotazione sia tolta 
	 * @param id the id
	 * @param cliente the cliente
	 */
	public void cancellaPrenotazione(int id,Cliente cliente){ 
		for(Prenotazione p : this.prenotazioni)
		{
			if(p.getIdPrenotazione() == id)
			{
				int index = prenotazioni.indexOf(p);
				if(p.verificaCancellazione())
				{
					//cancellazione la prenotazione dalle prenotazioni
					//contenute in programmazione
					this.prenotazioni.remove(index);
					int index2 = cliente.getPrenotazioni().indexOf(p);
					//liberazione dell posto della sala occupato 
					//da quella prenotazione
					this.sala.liberaPostazione(cliente.getPrenotazioni().get(index2));
					//cancello la prenotazione da quelle contenute nelle prenotazioni del cliente
					cliente.getPrenotazioni().remove(index2);
				}else{
					System.err.println("non è piu possibile rimuovere questa prenotazione!");
				}
			}
		}
	}
}
