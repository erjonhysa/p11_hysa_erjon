import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UC4 {

	Cliente c1;
	CartaDiCredito carta;
	LocalDateTime now;
	ArrayList<Programmazione> listP;
	Film film1;
	Film film2;
	
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
		film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso"
				+ " la Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
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
	}

	//scenario principale: effettuare ricerche in base alla data
	@Test
	public void testEffettuareRicercheE1() {
		LocalDateTime giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		assertEquals(1,c1.searchByDate(listP,giornoP1).size());
		LocalDateTime giornoP2 = now.withDayOfMonth(11).withMonth(4).withYear(2018); 
		assertEquals(3,c1.searchByDate(listP,giornoP2).size());
		//controllo che tutti abbiano la data che ho inserito
		for(Programmazione prog : c1.searchByDate(listP,giornoP2))
		{
			assertEquals(giornoP2,prog.getGiorno());
		}
	}
	
	//scenario principale: effettuare ricerche in base al film
	@Test
	public void testEffettuareRicercheE2() {
		assertEquals(2,c1.searchByFilm(listP, "Matrix").size());
		//controllo che tutti abbiano il film che ho inserito
		for(Programmazione prog : c1.searchByFilm(listP,"Matrix"))
		{
			assertEquals("Matrix",prog.getFilm().getTitolo());
		}
	}
	
	//scenario alternativo: ritorna una lista vuota(film non proiettato)
	@Test
	public void testEffettuareRicercheE3(){
		assertEquals(0,c1.searchByFilm(listP, "Giovanna D'Arco").size());
	}
	
	//scenario alternativo: ritorna una lista vuota(giorno senza proiezioni)
	@Test
	public void testEffettuareRicercheE4(){
		assertEquals(0,c1.searchByDate(listP, now.plusYears(43)).size());
	}	
	
	
}
