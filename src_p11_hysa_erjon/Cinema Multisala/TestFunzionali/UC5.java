import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UC5 {

	Film film;
	LocalDateTime now ;
	LocalDateTime dInizio1;
	LocalDateTime dFine1;
	Cliente c1;
	CartaDiCredito cartaC1;
	
	@Before
	public void setUp() throws Exception {
		now = LocalDateTime.now();
		dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		film = new Film(2,"Matrix","fanascienza","Thomas lavora presso la "
				+ "Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		cartaC1 = new CartaDiCredito("1239949549593",1333.39);
		c1 = new Cliente("18","Jack","Dawson","Jack@hotmail.com","M",
				"345845649","Jack.Dws","Platone","Platone","phamous philosopher",cartaC1);
	}

	//scenario principale: ottengo le informazioni della scheda film
	//ad esempio un film con una recensione 
	@Test
	public void testConsultareSchedaFilmE1() {
		// controlliamo che ritorni i valori corretti  
			ArrayList<Object> listaInfo = new ArrayList<Object>();
			Film film2 = new Film(2,"Matrix","fanascienza","Thomas lavora "
					+ "presso la Metacortex come programmatore..",6.00,0,20,dInizio1,
					dFine1);
			String commento = "interessante..";
			int voto = 4;
			double medioAtteso = 4.0;
			film2.inserisciRecensione(commento , voto, c1);
			listaInfo = film2.getInformation();
			assertTrue(listaInfo.get(0).equals(film2.getTitolo()));
			assertTrue(listaInfo.get(1).equals(film2.getTrama()));
			assertTrue(listaInfo.get(2).equals(film2.getCategoria()));
			assertEquals(listaInfo.get(3),medioAtteso);
			assertTrue(listaInfo.get(4).equals(film2.getPrezzo()));
			assertTrue(listaInfo.get(5).equals(film2.getDataInizioProgrammazione()));
			assertTrue(listaInfo.get(6).equals(film2.getDataFineProgrammazione()));
			assertTrue(listaInfo.get(7).equals(commento));
			assertEquals((int)listaInfo.get(8),voto);	}

}
