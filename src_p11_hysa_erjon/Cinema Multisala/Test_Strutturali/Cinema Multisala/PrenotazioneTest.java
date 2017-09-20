import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class PrenotazioneTest {

	Prenotazione p;
	LocalDateTime dataSpettacolo;
	LocalDateTime now;
	LocalDateTime oraSpettacolo;
	
	@Before
	public void setUp() throws Exception {
		now = LocalDateTime.now();
		dataSpettacolo = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		oraSpettacolo = now.withHour(21).withMinute(35);
		p = new Prenotazione(1,18.0,9,9,dataSpettacolo,oraSpettacolo,"Matrix",1);

	}

	@Test
	public void testCostruttore() {
		assertNotNull(p);
		assertEquals(1,p.getIdPrenotazione());
		assertEquals(18.0,p.getCosto(),1);
		assertEquals(9,p.getFilaPosto());
		assertEquals(9,p.getColonnaPosto());
		assertEquals(dataSpettacolo,p.getDataSpettacolo());
		assertEquals(oraSpettacolo,p.getOraSpettacolo());
		assertEquals("Matrix",p.getTitoloFilm());
	}

	@Test
	public void testSetGetSala(){
		p.setSala(2);
		assertEquals(2,p.getSala());
	}
	
	@Test
	public void testEquals(){
		Prenotazione p2 = new Prenotazione(1,18.0,9,9,dataSpettacolo,
				oraSpettacolo,"Matrix",1);
		assertTrue(p.equals(p2));
		Prenotazione p3 = new Prenotazione(4,18.0,9,9,dataSpettacolo,
				oraSpettacolo,"Matrix",1);
		assertFalse(p.equals(p3));
		assertTrue(p.equals(p));
		assertFalse(p.equals(2));
	}
	
	@Test
	public void testVerificaCancellazione(){
		//caso cancellazione prenotazione un giorno prima dello spettacolo
		Prenotazione  pp1= new Prenotazione(1,18.0,9,9,LocalDateTime.now().
				plusDays(1),LocalDateTime.now(),"Matrix",1);
		assertTrue(pp1.verificaCancellazione());
		//cancellazione di una prenotazione un ora prima dello spettacolo
		Prenotazione  pp2= new Prenotazione(1,18.0,9,9,LocalDateTime.now(),
				LocalDateTime.now().plusHours(1),"Matrix",1);
		assertFalse(pp2.verificaCancellazione());
		//cancellazione di una prenotazione a distanza minore di un 
		//ora(quindi non cancellabile)
		Prenotazione  pp3= new Prenotazione(1,18.0,9,9,LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(30),"Matrix",1);
		assertFalse(pp3.verificaCancellazione());
		//un anno prima
		Prenotazione  pp4= new Prenotazione(1,18.0,9,9,LocalDateTime.now().
				plusYears(1),LocalDateTime.now(),"Matrix",1);
		assertTrue(pp4.verificaCancellazione());
		//un mese prima
		Prenotazione  pp5= new Prenotazione(1,18.0,9,9,LocalDateTime.now().
				plusMonths(1),LocalDateTime.now(),"Matrix",1);
		assertTrue(pp5.verificaCancellazione());
		//tempo dopo(mese dopo)
		Prenotazione  pp6= new Prenotazione(1,18.0,9,9,LocalDateTime.now().
				minusMonths(1),LocalDateTime.now(),"Matrix",1);
		assertTrue(pp6.verificaCancellazione());
		//cancellazione di una prenotazione un ora dopo dello spettacolo
		Prenotazione  pp7= new Prenotazione(1,18.0,9,9,LocalDateTime.now(),
				LocalDateTime.now().minusHours(1),"Matrix",1);
		assertTrue(pp7.verificaCancellazione());
		//cancellazione di una prenotazione che è esattamente un ora prima 
		//della cancellazione
		Prenotazione  pp8= new Prenotazione(1,18.0,9,9,LocalDateTime.now(),
				LocalDateTime.now().plusHours(2),"Matrix",1);
		assertTrue(pp8.verificaCancellazione());		
	}
}
