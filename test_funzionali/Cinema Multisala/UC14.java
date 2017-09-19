import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UC14 {

	Manager m; 
	LocalDateTime now;
	ArrayList<Programmazione> listP;
	Film film1;
	Film film2;
	LocalDateTime giornoP1;
	LocalDateTime oraP1;
	LocalDateTime giornoP2;
	LocalDateTime oraP2;
	Sala s1;
	Sala s2;
	Programmazione p1;
	Programmazione p2;
	
	@Before
	public void setUp() throws Exception {
		m = new Manager("1","Patrick","Neville","p.nev@hotmail.com","M","aabbcc",
				"aabbcc");
		m = new Manager("1","Patrick","Neville","p.nev@hotmail.com","M","aabbcc",
				"aabbcc");
		s1 = new Sala(1,13,130);
		s2 = new Sala(2,10,100);
		now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la "
				+ "Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		oraP1 = now.withHour(21).withMinute(35);
	    p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	    LocalDateTime dInizio2 = now.withDayOfMonth(1).withMonth(9).withYear(2017);
	    LocalDateTime dFine2 = now.withDayOfMonth(1).withMonth(9).withYear(2018);
		film2 = new Film(2,"Drive","thriller","Un pilota d'auto, oltre a"
				+ " lavorare come meccanico..",6.00,1,35,dInizio2,dFine2);
		giornoP2 = now.withDayOfMonth(11).withMonth(4).withYear(2018); 
		oraP2 = now.withHour(21).withMinute(35);
	    p2 = new Programmazione(3,giornoP2,oraP2,s2,film2);
	    Programmazione p3 = new Programmazione(4,giornoP2,oraP2.plusHours(3),s2,film2);
	    listP = new ArrayList<Programmazione>();
	    listP.add(p1);
	    listP.add(p2);
	    listP.add(p3);
	}

	//scenario principale: la modifica della programmazione va a buon fine
	@Test
	public void testModificareProgrammazioneE1() {
		//creo una programmazione "prova" e la modifico(cambio orario o sala e 
		//verifico sovrapposizione)
		Programmazione p4 = new Programmazione(5,giornoP2,oraP2.minusHours(3),s2,film1);
	    //caso modifica va a buon fine(stesso giorno stessa sala ma dopo che il 
		//film proiettato è finito)
		assertTrue(m.modificaProgrammazione(s1.getIdSala(), oraP1.plusHours(3),
				giornoP1, p4, listP));	
	}

	//scenario alternativo: la modifica della programmazione non va a buon fine
	//esiste sovvrapposizione
	@Test
	public void testModificareProgrammazioneE2(){
		Programmazione p4 = new Programmazione(5,giornoP2,oraP2.minusHours(3),s2,film1);
		//caso in cui abbiamo gia' un film in quella ora (stesso identico orario)
		assertFalse(m.modificaProgrammazione(s1.getIdSala(), oraP1, giornoP1, p4, listP));
	}
}
