import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;



public class ClienteTest {

	Cliente c1;
	CartaDiCredito carta;
	LocalDateTime now;
	ArrayList<Programmazione> listP;
	Film film1;
	Film film2;
	Offerta o;
	
	@Before
	public void setUp() throws Exception {
		carta = new CartaDiCredito("2334549359434",2333.89);
		c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","Logan92","loganlogan","il tuo nome",carta);
		Sala s1 = new Sala(1,13,130);
		Sala s2 = new Sala(2,10,100);
		now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la "
				+ "Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		LocalDateTime giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		LocalDateTime oraP1 = now.withHour(21).withMinute(35);
	    Programmazione p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	    LocalDateTime dInizio2 = now.withDayOfMonth(1).withMonth(9).withYear(2017);
	    LocalDateTime dFine2 = now.withDayOfMonth(1).withMonth(9).withYear(2018);
		film2 = new Film(2,"Drive","thriller","Un pilota d'auto, oltre a "
				+ "lavorare come meccanico..",6.00,1,35,dInizio2,dFine2);
		LocalDateTime giornoP2 = now.withDayOfMonth(11).withMonth(4).withYear(2018); 
		LocalDateTime oraP2 = now.withHour(21).withMinute(35);
	    Programmazione p2 = new Programmazione(3,giornoP2,oraP2,s2,film2);
	    Programmazione p3 = new Programmazione(4,giornoP2,oraP2.plusHours(3),s2,film2);
	    Programmazione p4 = new Programmazione(5,giornoP2,oraP2.minusHours(3),s2,film1);
	    listP = new ArrayList<Programmazione>();
	    listP.add(p1); 
	    listP.add(p2);
	    listP.add(p3);
	    listP.add(p4);
		o = new Offerta("standard", 10, 25.0);
	}

	
	@Test
	public void testCostruttore() {
		assertNotNull(c1); 
		assertEquals("3",c1.getIdUtente());
		assertEquals("Logan",c1.getNome());
		assertEquals("Peck",c1.getCognome());
		assertEquals("logan@hotmail.com",c1.getEmail());
		assertEquals("333152497",c1.getNumeroTelefono());
		assertEquals("Logan92",c1.getUsername());
		assertEquals("il tuo nome",c1.getFraseSegreta());
		assertEquals(carta,c1.getCartaDiCredito());
	}
	
	@Test
	public void setGetIdDocumento(){
		c1.setIdDocumento("abc123de23");
		assertEquals("abc123de23",c1.getIdDocumento());
	}
	
	@Test
	public void testIsLoggato(){
		c1.setLoggato(false);
		assertFalse(c1.isLoggato());
		c1.setLoggato(true);
		assertTrue(c1.isLoggato());
	}
	
	@Test
	public void testSetGetPrenotazioni(){
		Cliente cliente2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		ArrayList<Prenotazione> listPrenotazioni = new ArrayList<Prenotazione>();
		Prenotazione prenotazione = new Prenotazione(2, 18.0,9,9, now, now,
				"Gladiatore", 2);
		listPrenotazioni.add(prenotazione);
		cliente2.setPrenotazioni(listPrenotazioni);
		assertEquals(listPrenotazioni,cliente2.getPrenotazioni());
		
	}

	@Test
	public void testSearchByDate(){
		LocalDateTime giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		assertEquals(1,c1.searchByDate(listP,giornoP1).size());
		LocalDateTime giornoP2 = now.withDayOfMonth(11).withMonth(4).withYear(2018); 
		assertEquals(3,c1.searchByDate(listP,giornoP2).size());
	}
	
	@Test
	public void testSearchByFilm(){
		assertEquals(2,c1.searchByFilm(listP, "Matrix").size());
		assertEquals(2,c1.searchByFilm(listP, "Drive").size());
	}
	
	@Test
	public void testAcquistaAbbonamento(){
		assertNull(c1.getAbbonamento());
		c1.acquistaAbbonamento(o);
		assertNotNull(c1.getAbbonamento());
		assertEquals(c1.getAbbonamento().getTipoAbbonamento(),o.getTipo());
		assertEquals(c1.getAbbonamento().getNumeroBiglietti(),o.getNumBiglietti());
		//se uno non ha soldi
		CartaDiCredito carta2 = new CartaDiCredito("2334549359434",1.89);
		Cliente c2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan",
				"il tuo nome",carta2);
		c2.acquistaAbbonamento(o);
		assertNull(c2.getAbbonamento());
		//possiedi gia un abbonamento, l'abbonamento rimae quello che hai 
		//non viene messo un altro abbonamento e anche la size degli abbonamenti posseduti è 1
		Offerta o2 = new Offerta("premium", 15, 30.0);
		c1.acquistaAbbonamento(o2);
		assertFalse(c1.getAbbonamento().getTipoAbbonamento().equals(o2.getTipo()));		
	}
	
	@Test
	public void TestEquals(){
		Cliente c2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		Cliente c3 = new Cliente("4","Nick","Parker","free@hotmail.com",
				"M","34846157","nicki","mypass","mypass","la solita password",carta);
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertTrue(c2.equals(c2));
		assertFalse(c2.equals(11));
	}
}
