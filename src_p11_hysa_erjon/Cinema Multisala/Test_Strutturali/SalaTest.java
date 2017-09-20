import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class SalaTest {

	Sala s;
	Sala s2;
	
	@Before
	public void setUp() throws Exception {
		s = new Sala(1,9,10);
		s2 = new Sala(2,10,10);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(s);
		assertEquals(1,s.getIdSala());
		assertEquals(9,s.getNumeroFile());
		assertEquals(10,s.getNumeroPosti());
	}
	
	@Test
	public void testsetGetIdSala(){
		s2.setIdSala(2);
		assertEquals(2,s2.getIdSala());
	}

	@Test
	public void testSetGetNumPostiTotali(){
		s2.setNumPostiTotali(100);
		assertEquals(100,s2.getNumPostiTotali());
	}
	
	@Test
	public void testSetGetNumeroFile(){
		s2.setNumeroFile(4);
		assertEquals(4,s2.getNumeroFile());
	}
	
	@Test
	public void testSetGetNumeroPosti(){
		s2.setNumeroPosti(120);
		assertEquals(120,s2.getNumeroPosti());
	}
	
	@Test
	public void testSetGetPostiPrenotati(){
		s2.setPostiPrenotati(3);
		assertEquals(3,s2.getPostiPrenotati());
	}
	
	@Test
	public void testIsBooked(){
		//se non è prenotato
		assertFalse(s.isBooked(1, 1));
		//effettuo prenotazione e controllo 
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		Film film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la"
				+ " Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		LocalDateTime giornoP1 = now;
		LocalDateTime oraP1 = now.plusHours(3);
	    Programmazione p1 = new Programmazione(1,giornoP1,oraP1,s,film1);
	    CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
	    Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
	    		"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
	    p1.acquistareBiglietti(3, "carta", c1);
	    assertTrue(s.isBooked(0,0));
	}
	
	@Test
	public void testEquals(){
		assertTrue(s.equals(s));
		assertFalse(s.equals(s2));
		assertFalse(s.equals("aabb"));
		Sala s3 = new Sala(1,5,6);
		assertTrue(s.equals(s3));
	}
	
	@Test
	public void TestPrenotaPosti(){
		Sala s4 = new Sala(1,10,10);
		int postiIniziali = s4.getNumPostiTotali();
		//caso in cui non ci sono abbastanza posti 
		assertNull(s4.prenotaPosti(300));
		//prenotazione va a buon fine
		int posti = 3;
		assertNotNull(s4.prenotaPosti(posti));
		int postPrenotazione = s4.getNumPostiTotali();
		assertEquals(postiIniziali,postPrenotazione + posti);
		//caso in cui continuo a prenotare e ci sono ancora posti
		s4.prenotaPosti(4);
	}
	
	@Test
	public void liberaPostazione(){
		//eseguo 3 prenotazioni e poi le cancello e verifico che i posti siano liberati
		Sala s5 = new Sala(8,10,10);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		Film film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso "
				+ "la Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		LocalDateTime giornoP1 = now;
		LocalDateTime oraP1 = now.plusHours(3);
	    Programmazione p1 = new Programmazione(1,giornoP1,oraP1,s5,film1);
	    CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
	    Cliente cliente = new Cliente("3","Logan","Peck","logan@hotmail.com",
	    		"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
	    p1.acquistareBiglietti(3, "carta", cliente);
	    assertEquals(3,p1.getSala().getPostiPrenotati());
	    for(Prenotazione p: cliente.getPrenotazioni())
	    {
	    	s5.liberaPostazione(p);
	    }
	    assertEquals(100,s5.getNumPostiTotali());
	    
	}
}
