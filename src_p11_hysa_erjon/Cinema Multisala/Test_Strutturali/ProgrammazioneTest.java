import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ProgrammazioneTest {

	Programmazione p1;
	Sala s1;
	LocalDateTime now;
	LocalDateTime dInizio1; 
	LocalDateTime dFine1;
	Film film1;
	LocalDateTime giornoP1;
	LocalDateTime oraP1;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Sala(1,13,18);
		now = LocalDateTime.now();
		dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso"
				+ " la Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		giornoP1 = now;
		oraP1 = now.plusHours(3);
	    p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(p1);
		assertEquals(1,p1.getIdProgrammazione());
		assertEquals(giornoP1,p1.getGiorno());
		assertEquals(oraP1,p1.getOra());
		assertEquals(s1,p1.getSala());
		assertEquals(film1,p1.getFilm());
	}
	
	@Test
	public void testSetGetPostiDisponibili(){
		Programmazione p2 = new Programmazione(1,giornoP1,oraP1,s1,film1);
		p2.setPostiDisponibili(240);
		assertEquals(240,p2.getPostiDisponibili());
	}
	
	@Test
	public void testSetGetPrenotazioni(){
		Prenotazione prenotazione = new Prenotazione(1,18.0,9,9,now,now,"Matrix",1);
		ArrayList<Prenotazione> lista = new ArrayList<Prenotazione>();
		lista.add(prenotazione);
		Programmazione prog = new Programmazione(1,giornoP1,oraP1,s1,film1);
		prog.setPrenotazioni(lista);
		assertEquals(lista,prog.getPrenotazioni()); 
	}
	
	@Test 
	public void testEquals(){
		Programmazione p2 = new Programmazione(1,giornoP1,oraP1,s1,film1);
		assertTrue(p1.equals(p2));
		assertTrue(p1.equals((p1)));
		Programmazione p3 = new Programmazione(5,giornoP1,oraP1.plusHours(4),s1,film1);
		assertFalse(p1.equals(p3));
		assertFalse(p1.equals(3));
	}
	
	@Test
	public void testAggiungiPrenotazione(){
		Prenotazione prenotazione1 = new Prenotazione(1,18.0,9,9,p1.getGiorno(),
				p1.getOra(),p1.getFilm().getTitolo(),p1.getSala().getIdSala());
		p1.aggiungiPrenotazione(prenotazione1);
		assertTrue(p1.getPrenotazioni().contains(prenotazione1));
		int size = p1.getPrenotazioni().size();
		p1.aggiungiPrenotazione(prenotazione1);
		assertEquals(size,p1.getPrenotazioni().size());
	}
	 
	@Test
	public void testAcquistareBiglietti(){
		//acquisto con carta di credito, con credito sufficiente
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com","M",
				"333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		p1.acquistareBiglietti(3,"carta", c1);
		//verifico che ci siano 3 biglietti
		assertEquals(3,c1.getPrenotazioni().size());
		//caso in cui non bastano i soldi della carta
		CartaDiCredito carta2 = new CartaDiCredito("2334549359434",2.8);
		c1.setCartaDiCredito(carta2);
		int size = c1.getPrenotazioni().size();
		p1.acquistareBiglietti(4,"carta", c1);
		assertEquals(size,c1.getPrenotazioni().size());
		//pagamento con abbonamento da parte di cliente che non ne possiede uno
		p1.acquistareBiglietti(2, "abbonamento", c1);
		assertEquals(size,c1.getPrenotazioni().size());
		//pagamento con abbonamento andato a buon fine
		Offerta o = new Offerta("standard", 10, 25.0);
		Abbonamento a = new Abbonamento(o);
		Cliente c2 = new Cliente("4","Mario","Rossi","rossi.m@hotmail.com",
				"M","333152497","rossimario","passw.","passw.","domanda segreta..",carta);
		c2.setAbbonamento(a);
		p1.acquistareBiglietti(3,"abbonamento", c2);
		assertEquals(3,c2.getPrenotazioni().size());
		//pagamento con abbonamento NON andato a buon fine
		c2.getAbbonamento().setNumeroBiglietti(0);
		int size2 = c2.getPrenotazioni().size();
		p1.acquistareBiglietti(3,"abbonamento", c2);
		assertEquals(size2,c2.getPrenotazioni().size());
		//i posti disponibili in sala non sono sufficienti
		c2.setCartaDiCredito(carta);
		p1.acquistareBiglietti(401,"carta", c2);
		assertEquals(size2,c2.getPrenotazioni().size());
		//pagamento indicato sbagliato
		p1.acquistareBiglietti(1, "metodosbagliato",c2);
	}
	
	@Test
	public void testCancellaPrenotazione(){
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Cliente cc1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		p1.acquistareBiglietti(3,"carta", cc1);
		//caso in cui la prenotazione puo essere cancellata
		int size = cc1.getPrenotazioni().size();
		p1.cancellaPrenotazione(cc1.getPrenotazioni().get(1).getIdPrenotazione(),cc1);
		assertEquals(size-1, cc1.getPrenotazioni().size());
		//caso in cui la prenotazione non puo essere cancellata
		//poiche cambia l'ora della programmazione creo un nuovo p2
		Cliente cc2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		LocalDateTime oraP2 = now.plusMinutes(30);
		Programmazione p2 = new Programmazione(1,giornoP1,oraP2,s1,film1);
		p2.acquistareBiglietti(3, "carta", cc2);
		int size2 = cc2.getPrenotazioni().size();
		p2.cancellaPrenotazione(cc2.getPrenotazioni().get(0).getIdPrenotazione(), cc2);
		//la size non deve essere cambiata poiche non e possibile cancellarlo
		assertEquals(size2, cc2.getPrenotazioni().size());
	}
}
