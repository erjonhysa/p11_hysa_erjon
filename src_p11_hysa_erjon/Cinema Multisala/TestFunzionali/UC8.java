import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class UC8 {

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

	//scenario principale: la cancellazione avviene con successo
	@Test
	public void testCancellarePrenotazioniE1() {
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Cliente cc1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		p1.acquistareBiglietti(3,"carta", cc1);
		int size = cc1.getPrenotazioni().size();
		p1.cancellaPrenotazione(cc1.getPrenotazioni().get(1).getIdPrenotazione(),cc1);
		assertEquals(size-1, cc1.getPrenotazioni().size());
	}
	
	//scenario alternativo: la cancellazione non può essere eseguita
	@Test
	public void testCancellarePrenotazioniE2(){
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
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
