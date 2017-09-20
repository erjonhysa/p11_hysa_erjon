import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class UC6 {

	Film film;
	LocalDateTime now ;
	LocalDateTime dInizio1;
	LocalDateTime dFine1;
	CartaDiCredito cartaC1;
	Cliente c1;
	
	@Before
	public void setUp() throws Exception {
		now = LocalDateTime.now();
		dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film = new Film(2,"Matrix","fanascienza","Thomas lavora presso"
				+ " la Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		cartaC1 = new CartaDiCredito("1239949549593",1333.39);
		c1 = new Cliente("18","Jack","Dawson","Jack@hotmail.com","M","345845649",
				"Jack.Dws","Platone","Platone","phamous philosopher",cartaC1);

	}

	//scenario principale: la recensione viene inserita correttamente
	@Test
	public void testScrivereRecensioniE1() {
		int size = film.getRecensioni().size();
		film.inserisciRecensione("interessante..", 3, c1);
		assertTrue(film.getRecensioni().get(0).getUsername().equals(c1.getUsername()));
		assertEquals(size+1,film.getRecensioni().size());
	}

	//scenario alternativo: l'utente non inserisce un commento
	@Test
	public void testScrivereRecensioniE2() {
		int size2 = film.getRecensioni().size();
		film.inserisciRecensione(null, 3, c1);
		assertEquals(size2,film.getRecensioni().size());
	}
}
