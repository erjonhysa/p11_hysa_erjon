
// TODO: Auto-generated Javadoc
/**
 * The Class Sala.
 */
public class Sala {
	
	/**  Attributes. */
	private int idSala;
	
	/** The num posti totali. */
	private int numPostiTotali;
	
	/** The posti prenotati. */
	private int postiPrenotati;
	
	/** The numero file. */
	private int numeroFile;
	
	/** The numero posti. */
	private int numeroPosti; //posti per fila
	
	/** The posti sala. */
	private boolean[][] postiSala; 
	
	/**
	 * Instantiates a new sala.
	 *
	 * @param idSala the id sala
	 * @param numeroFile the numero file
	 * @param numeroPosti the numero posti
	 */
	public Sala(int idSala, int numeroFile, int numeroPosti) { 
		this.idSala = idSala;
		this.numeroFile = numeroFile;
		this.numeroPosti = numeroPosti;
		this.numPostiTotali = numeroFile * numeroPosti;
		this.postiSala = new boolean[numeroFile][numeroPosti];
		this.setPostiPrenotati(0);
		for(int i = 0; i < numeroFile; i++)
		{
			for(int j = 0; j < numeroPosti ; j++)
			{
				postiSala[i][j] = false;
			}
		}
	}
	
	/**
	 * Gets the id sala.
	 *
	 * @return the id sala
	 */
	public int getIdSala() {
		return idSala;
	}
	
	/**
	 * Sets the id sala.
	 *
	 * @param idSala the new id sala
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	/**
	 * Gets the num posti totali.
	 *
	 * @return the num posti totali
	 */
	public int getNumPostiTotali() {
		return numPostiTotali;
	}
	
	/**
	 * Sets the num posti totali.
	 *
	 * @param numPostiTotali the new num posti totali
	 */
	public void setNumPostiTotali(int numPostiTotali) {
		this.numPostiTotali = numPostiTotali;
	}
	
	/**
	 * Gets the numero file.
	 *
	 * @return the numero file
	 */
	public int getNumeroFile() {
		return numeroFile;
	}

	/**
	 * Sets the numero file.
	 *
	 * @param numeroFile the new numero file
	 */
	public void setNumeroFile(int numeroFile) {
		this.numeroFile = numeroFile;
	}

	/**
	 * Gets the numero posti.
	 *
	 * @return the numero posti
	 */
	public int getNumeroPosti() {
		return numeroPosti;
	}

	/**
	 * Sets the numero posti.
	 *
	 * @param numeroPosti the new numero posti
	 */
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	
	/**
	 * Gets the posti prenotati.
	 *
	 * @return the posti prenotati
	 */
	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	/**
	 * Sets the posti prenotati.
	 *
	 * @param postiPrenotati the new posti prenotati
	 */
	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
	
	/**
	 * Checks if is booked.
	 *
	 * @param fila the fila
	 * @param posto the posto
	 * @return the boolean
	 */
	public Boolean isBooked(int fila, int posto){
		if(postiSala[fila][posto] == true)
			return true;
		else 
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if(this == that) return true;
		if(!(that instanceof Sala)) return false;
		Sala s = (Sala) that;
		return this.idSala == s.idSala;
	}

	/**
	 * Prenota posti.
	 * I posti della sala vengono aggiornati quando viene fatta una nuova
	 * prenotazione o quando viene cancellata una prenotazione.
	 * Quando si acquista si controlla anche che il numero di posti disponibili
	 * sia sufficiente al numero di biglietti richiesti.
	 * @param numPrenotazioni the num prenotazioni
	 * @return the int[]
	 */
	public int[] prenotaPosti(int numPrenotazioni) {
		int count = 0;
		
		if(numPrenotazioni <= this.numPostiTotali)
		{
			this.postiPrenotati = this.postiPrenotati + numPrenotazioni;
			for(int i = 0; i<this.numeroFile ; i++)
			{
				for(int j = 0; count < numPrenotazioni && j < this.numeroPosti ; j++)
				{
					if(postiSala[i][j] != true)
					{
						postiSala[i][j] = true;
						count = count + 1;
						this.numPostiTotali = this.numPostiTotali - numPrenotazioni;
						return new int[] {i, j}; 
					}
				}
			}
		}else{
			System.err.println("non vi sono abbastanza posti disponibili in sala");
		}
		return null;
	}
	
	
	/**
	 * Libera postazione.
	 *
	 * @param p the p
	 */
	public void liberaPostazione(Prenotazione p) {
		this.postiSala[p.getFilaPosto()][p.getColonnaPosto()] = false;
		//incremento di un posto perche ho liberato un biglietto
		this.numPostiTotali = this.numPostiTotali + 1;
	}
}
