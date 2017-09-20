import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class UC7 {

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
		film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la "
				+ "Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		giornoP1 = now;
		oraP1 = now.plusHours(3);
	    p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	}

	//scenario principale: l'acquisto termina con successo(pagamento con carta)
	@Test
	public void testAcquistareBigliettiE1() {
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta);
		p1.acquistareBiglietti(3,"carta", c1);
		//verifico che ci siano 3 biglietti
		assertEquals(3,c1.getPrenotazioni().size());
	}
	
	//scenario principale: l'acquisto termina con successo(pagamento con abbonamento)
	@Test
	public void testAcquistareBigliettiE2(){
		Offerta o = new Offerta("standard", 10, 25.0);
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Abbonamento a = new Abbonamento(o);
		Cliente c2 = new Cliente("4","Mario","Rossi","rossi.m@hotmail.com",
				"M","333152497","rossimario","passw.","passw.","domanda segreta..",carta);
		c2.setAbbonamento(a);
		p1.acquistareBiglietti(3,"abbonamento", c2);
		//i biglietti vengono inseriti nella lista prenotazioni e quindi ne
		//modificano la size
		assertEquals(3,c2.getPrenotazioni().size());
	}
	
	//scenario alternativo: l'importo della carta non copre la spesa
	@Test
	public void testAcquistareBigliettiE3(){
		CartaDiCredito carta2 = new CartaDiCredito("2334549359434",2.8);
		Cliente cliente = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta2);
		int size = cliente.getPrenotazioni().size();
		p1.acquistareBiglietti(4,"carta", cliente);
		//la size non cambia poiche' non vengono inseriti i nuovi biglietti
		//(fallisce acquisto)
		assertEquals(size,cliente.getPrenotazioni().size());
	}

	//scenario alternativo: l'abbonamento non ha abbastanza biglietti 
	//rimasti per completare l'acquisto
	@Test
	public void testAcquistareBigliettiE4(){
		CartaDiCredito carta2 = new CartaDiCredito("2334549359434",3232.8);
		Cliente cliente2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta2);
		Offerta o = new Offerta("standard", 10, 25.0);
		Abbonamento a = new Abbonamento(o);
		cliente2.setAbbonamento(a);
		cliente2.getAbbonamento().setNumeroBiglietti(0);
		int size2 = cliente2.getPrenotazioni().size();
		p1.acquistareBiglietti(3,"abbonamento", cliente2);
		assertEquals(size2,cliente2.getPrenotazioni().size());
	}
	
	//scenario alternativo: non vi sono abbastanza posti liberi in sala
	//per soddisfare la richiesta di biglietti
	@Test
	public void testAcquistareBigliettiE5(){
		CartaDiCredito carta = new CartaDiCredito("2334549359434",23353.89);
		Cliente cliente3 = new Cliente("4","Mario","Rossi","rossi.m@hotmail.com",
				"M","333152497","rossimario","passw.","passw.","domanda segreta..",carta);
		p1.acquistareBiglietti(280,"carta", cliente3);
		//non andando a buon fine l'operazione, il cliente avra' 0 biglietti
		assertEquals(0,cliente3.getPrenotazioni().size());
	}
}
