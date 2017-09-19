import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilmTest {
	
	ArrayList<Recensione> recensioni;
	Cliente c1;
	CartaDiCredito cartaC1;
	Film film;
	LocalDateTime now ;
	LocalDateTime dInizio1;
	LocalDateTime dFine1;
	
	@Before
	public void setUp() throws Exception {
		now = LocalDateTime.now();
		dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film = new Film(2,"Matrix","fanascienza","Thomas lavora presso"
				+ " la Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		cartaC1 = new CartaDiCredito("1239949549593",1333.39);
		c1 = new Cliente("18","Jack","Dawson","Jack@hotmail.com",
				"M","345845649","Jack.Dws","Platone","Platone",
				"phamous philosopher",cartaC1);
	}

	@Test
	public void testCostruttore(){
		assertNotNull(film);
		assertEquals(film.getIdFilm(),2);
		assertEquals(film.getTitolo(),"Matrix");
		assertEquals(film.getCategoria(),"fanascienza");
		assertEquals(film.getTrama(),"Thomas lavora presso la Metacortex come "
				+ "programmatore..");
		assertEquals(film.getPrezzo(),6.00,1);
		assertEquals(film.getDurataOre(),2);
		assertEquals(film.getDurataMin(),20);
		assertEquals(film.getDataInizioProgrammazione(),dInizio1);
		assertEquals(film.getDataFineProgrammazione(),dFine1);
	}
	
	@Test
	public void testInserisciRecensione() {
		//inserisco la recensione e controllo che sia quella che ho inserito
		//quindi che la recensione inserita sia quella che ha scritto l'utente
		//e controllo anche che la size sia aumentata di 1
		int size = film.getRecensioni().size();
		film.inserisciRecensione("interessante..", 3, c1);
		assertTrue(film.getRecensioni().get(0).getUsername().equals(c1.getUsername()));
		assertEquals(size+1,film.getRecensioni().size());
		//caso errore(lo stesso utente inserisce un altra recension,solo una recensione
		//per utente è concessa)
		film.inserisciRecensione("bello ma..", 3, c1);
		assertEquals(film.getRecensioni().size(),1);
		//caso in cui un altro cliente diverso da quelli presenti inserisce una recensione 
		//controllo se è andata a buon fine(aumenta la size + controllo che la 
		//recensione sia quella inserita)
		Cliente cliente2 = new Cliente("18","Jack","Dawson","Jack@hotmail.com",
				"M","345845649","JackJack","pass","pass","luogo di nascita?",cartaC1);
		int size2 =  film.getRecensioni().size();
		film.inserisciRecensione("molto bello..", 5, cliente2);
		assertTrue(film.getRecensioni().get(1).getUsername().
				equals(cliente2.getUsername()));
		assertEquals(size2+1,film.getRecensioni().size());
		//caso in cui si inserisce una recensione con commento null
		Cliente cliente3 = new Cliente("42","Jack","Dawson","Jack@hotmail.com",
				"M","345845649","aa","pass","pass","luogo di nascita?",cartaC1);	
		film.inserisciRecensione( null, 5, cliente3);
	}
	
	@Test
	public void testgetInformation() {
		// controlliamo che ritorni i valori corretti  
		ArrayList<Object> listaInfo = new ArrayList<Object>();
		Film film2 = new Film(2,"Matrix","fanascienza",
				"Thomas lavora presso la Metacortex "
				+ "come programmatore..",6.00,0,20,dInizio1,dFine1);
		String commento = "interessante..";
		int voto = 4;
		double medioAtteso = 4.0;
		film2.inserisciRecensione(commento , voto, c1);
		System.out.println(film2.getRecensioni().size());
		listaInfo = film2.getInformation();
		assertTrue(listaInfo.get(0).equals(film2.getTitolo()));
		assertTrue(listaInfo.get(1).equals(film2.getTrama()));
		assertTrue(listaInfo.get(2).equals(film2.getCategoria()));
		assertEquals(listaInfo.get(3),medioAtteso);
		assertTrue(listaInfo.get(4).equals(film2.getPrezzo()));
		assertTrue(listaInfo.get(5).equals(film2.getDataInizioProgrammazione()));
		assertTrue(listaInfo.get(6).equals(film2.getDataFineProgrammazione()));
		assertTrue(listaInfo.get(7).equals(commento));
		assertTrue((int)listaInfo.get(8) == voto);
	}

	@Test
	public void testPrint(){
		film.print();
	}
	
	@Test
	public void testRimuoviRecensione(){
		ArrayList<Recensione> list = new ArrayList<Recensione>();
		Recensione r = new Recensione("interessante",3,c1.getUsername());
		list.add(r);
		film.setRecensioni(list);
		assertTrue(film.getRecensioni().contains(r));
		film.rimuoviRecensione(r);
		assertFalse(film.getRecensioni().contains(r));
		//recensione non esiste
		Recensione r2 = new Recensione("non mi piace",1,c1.getUsername());
		assertFalse(film.rimuoviRecensione(r2));

	}
}
