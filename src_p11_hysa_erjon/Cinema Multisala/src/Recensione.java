import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Recensione.
 */
public class Recensione {

	/** The commento. */
	private String commento;
	
	/** The voto. */
	private int voto;
	
	/** The username. */
	private String username;
	
	/**
	 * Instantiates a new recensione.
	 *
	 * @param commento the commento
	 * @param voto the voto
	 * @param username the username
	 */
	public Recensione(String commento, int voto, String username) {
		this.commento = commento;
		this.voto = voto;
		this.username = username;
	}

	/**
	 * Gets the commento.
	 *
	 * @return the commento
	 */
	public String getCommento() {
		return commento;
	}

	/**
	 * Sets the commento.
	 *
	 * @param commento the new commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}

	/**
	 * Gets the voto.
	 *
	 * @return the voto
	 */
	public int getVoto() {
		return voto;
	}

	/**
	 * Sets the voto.
	 *
	 * @param voto the new voto
	 */
	public void setVoto(int voto) {
		this.voto = voto;
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
	 * Gets the info recensione.
	 *
	 * @return the info recensione
	 */
	public ArrayList<Object> getInfoRecensione(){
		ArrayList<Object> temp = new ArrayList<Object>();
		temp.add(commento);
		temp.add(voto);
		temp.add(username);
		return temp;
	}
	
}
