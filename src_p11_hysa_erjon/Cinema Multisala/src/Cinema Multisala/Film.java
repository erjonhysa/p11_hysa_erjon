import java.time.LocalDateTime;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Film.
 * 
 */
public class Film {

	/** The id film. */
	private int idFilm;
	
	/** The titolo. */
	private String titolo;
	
	/** The categoria. */
	private String categoria;
	
	/** The trama. */
	private String trama;
	
	/** The voto medio. */
	private double votoMedio;
	
	/** The prezzo. */
	private double prezzo;
	
	/** The durata ore. */
	private int durataOre;
	
	/** The durata min. */
	private int durataMin;
	
	/** The data inizio programmazione. */
	private LocalDateTime dataInizioProgrammazione;
	
	/** The data fine programmazione. */
	private LocalDateTime dataFineProgrammazione;
	
	/** The recensioni. */
	private ArrayList<Recensione> recensioni;
	
	/**
	 * Instantiates a new film.
	 *
	 * @param idFilm the id film
	 * @param titolo the titolo
	 * @param categoria the categoria
	 * @param trama the trama
	 * @param prezzo the prezzo
	 * @param durataOre the durata ore
	 * @param durataMin the durata min
	 * @param dInizio the d inizio
	 * @param dFine the d fine
	 */
	public Film(int idFilm, String titolo, String categoria, String trama, double prezzo, int durataOre, int durataMin, LocalDateTime dInizio, LocalDateTime dFine){
		this.setIdFilm(idFilm);
		this.setTitolo(titolo);
		this.setCategoria(categoria);
		this.setTrama(trama);
		this.setVotoMedio(0.0);
		this.setPrezzo(prezzo);
		this.setDurataOre(durataOre);
		this.setDurataMin(durataMin);
		this.setDataInizioProgrammazione(dInizio);
		this.setDataFineProgrammazione(dFine);
		this.recensioni = new ArrayList<Recensione>();
	}

	/**
	 * Gets the id film.
	 *
	 * @return the id film
	 */
	public int getIdFilm() {
		return idFilm;
	}

	/**
	 * Sets the id film.
	 *
	 * @param idFilm the new id film
	 */
	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	/**
	 * Gets the titolo.
	 *
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Sets the titolo.
	 *
	 * @param titolo the new titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Gets the trama.
	 *
	 * @return the trama
	 */
	public String getTrama() {
		return trama;
	}

	/**
	 * Sets the trama.
	 *
	 * @param trama the new trama
	 */
	public void setTrama(String trama) {
		this.trama = trama;
	}

	/**
	 * Gets the voto medio.
	 *
	 * @return the voto medio
	 */
	public double getVotoMedio() {
		return votoMedio;
	}

	/**
	 * Sets the voto medio.
	 *
	 * @param votoMedio the new voto medio
	 */
	public void setVotoMedio(double votoMedio) {
		this.votoMedio = votoMedio;
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
	
	/**
	 * Gets the durata ore.
	 *
	 * @return the durata ore
	 */
	public int getDurataOre() {
		return durataOre;
	}

	/**
	 * Sets the durata ore.
	 *
	 * @param durataOre the new durata ore
	 */
	public void setDurataOre(int durataOre) {
		this.durataOre = durataOre;
	}

	/**
	 * Gets the durata min.
	 *
	 * @return the durata min
	 */
	public int getDurataMin() {
		return durataMin;
	}

	/**
	 * Sets the durata min.
	 *
	 * @param durataMin the new durata min
	 */
	public void setDurataMin(int durataMin) {
		this.durataMin = durataMin;
	}

	/**
	 * Gets the data inizio programmazione.
	 *
	 * @return the data inizio programmazione
	 */
	public LocalDateTime getDataInizioProgrammazione() {
		return dataInizioProgrammazione;
	}

	/**
	 * Sets the data inizio programmazione.
	 *
	 * @param dataInizioProgrammazione the new data inizio programmazione
	 */
	public void setDataInizioProgrammazione(LocalDateTime dataInizioProgrammazione) {
		this.dataInizioProgrammazione = dataInizioProgrammazione;
	}

	/**
	 * Gets the data fine programmazione.
	 *
	 * @return the data fine programmazione
	 */
	public LocalDateTime getDataFineProgrammazione() {
		return dataFineProgrammazione;
	}

	/**
	 * Sets the data fine programmazione.
	 *
	 * @param dataFineProgrammazione the new data fine programmazione
	 */
	public void setDataFineProgrammazione(LocalDateTime dataFineProgrammazione) {
		this.dataFineProgrammazione = dataFineProgrammazione;
	}
	
	/**
	 * Gets the recensioni.
	 *
	 * @return the recensioni
	 */
	public ArrayList<Recensione> getRecensioni() {
		return recensioni;
	}

	/**
	 * Sets the recensioni.
	 *
	 * @param recensioni the new recensioni
	 */
	public void setRecensioni(ArrayList<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	/**
	 * Inserisci recensione.
	 * Un utente puo' inserire una sola recensione per film
	 * @param commento the commento
	 * @param voto the voto
	 * @param cliente the cliente
	 */
	public void inserisciRecensione(String commento, int voto, Cliente cliente) {
		boolean check = false;
		for(Recensione r : this.recensioni)
		{
			if(r.getUsername() == cliente.getUsername())
			{
				check = true; 
			} 
		}
		if(check)
		{
			System.err.println("Hai gia inserito una recensione per questo film");
			
		}else if(commento != null){
			Recensione r = new Recensione(commento, voto, cliente.getUsername());
			this.votoMedio = (this.votoMedio + r.getVoto()) / (this.recensioni.size()+1);
			this.recensioni.add(r);
		}else{
			System.err.println("inserisci il commento");
		}
	}
	
	/**
	 * Gets the information.
	 * Un utente puo visualizzare la scheda di un film, quindi vede tutte le
	 * sue informazioni(giorno proiezione, trama ecc)
	 * @return the information
	 */
	public ArrayList<Object> getInformation() {
		ArrayList<Object> listaInfo = new ArrayList<Object>();
		listaInfo.add(titolo);
		listaInfo.add(trama);
		listaInfo.add(categoria);
		listaInfo.add(votoMedio);
		listaInfo.add(prezzo);
		listaInfo.add(dataInizioProgrammazione);
		listaInfo.add(dataFineProgrammazione);
		for(Recensione r : recensioni)//fai test in cui non ci sono recensioni dentro
		{
			listaInfo.add(r.getCommento());
			listaInfo.add(r.getVoto());
		}
		return listaInfo;
	}
	
	/**
	 * Prints the.
	 */
	public void print(){
		System.out.println("Titolo: "+this.titolo +"\n"+ "Trama: "+this.trama +"\n"+
							"In proiezione dal: "+dataInizioProgrammazione.getDayOfMonth()+"/"+dataInizioProgrammazione.getMonth()+"/"+dataInizioProgrammazione.getYear()+
							"Fino al: "+dataFineProgrammazione.getDayOfMonth()+"/"+dataFineProgrammazione.getMonth()+"/"+dataFineProgrammazione.getYear());
		
	}

	
	/**
	 * Rimuovi recensione.
	 * @param recensione the recensione
	 * @return true, if successful
	 */
	public boolean rimuoviRecensione(Recensione recensione) {
		if(!this.recensioni.contains(recensione))
		{
			System.err.println("La recensione selezionata non esiste");
			return false;
		}else{
			int index = this.recensioni.indexOf(recensione);
			this.recensioni.remove(index);
			return true;
		}
	}
}
