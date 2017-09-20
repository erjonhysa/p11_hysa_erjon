import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
//
@RunWith(Parameterized.class)
public class CinemaTest {
	Cinema cinema;
	
	
	@Parameter(0) public String usernameP;
	@Parameter(1) public String passwordP;
	@Parameter(2) public boolean expectedval;
	
	@Before
	public void setUp() throws Exception {
	    cinema = new Cinema(1, "Universal", "Via 20 Settembre", "Genova");
	}
	
		@Parameters
		public static Collection<Object[]> data(){
			return Arrays.asList(new Object[][] {
				{"Luca93", "Lucaaa",true},
				{"Luca93", "passwordSbagliata",false}, 
				{"usernameSbagliato", "Lucaaa",false},
				{"usernameSbagliato", "passwordSbagliata",false}

			});
		}

	@Test
	public void testCostruttore() {
		assertNotNull(cinema);
		assertEquals(1,cinema.getIdCinema());
		assertEquals("Universal",cinema.getNome());
		assertEquals("Via 20 Settembre",cinema.getIndirizzo());
		assertEquals("Genova",cinema.getCitta());
	}

	@Test
	public void testSetGetSale(){
		Sala s1 = new Sala(1,13,130);
		Sala s2 = new Sala(2,10,100);
		ArrayList<Sala> sale = new ArrayList<Sala>();
		sale.add(s1);
		sale.add(s2);
		cinema.setSale(sale);
		assertTrue(cinema.getSale().contains(s1));
		assertTrue(cinema.getSale().contains(s2));
	}

	@Test 
	public void testAggiungiSala(){
		Sala s1 = new Sala(1,13,130);
		Sala s2 = new Sala(2,10,100);
		ArrayList<Sala> sale = new ArrayList<Sala>();
		sale.add(s1);
		sale.add(s2);
		cinema.setSale(sale);
		Sala s3 = new Sala(1,13,130);
		Sala s4 = new Sala(3,11,120);
		int size = sale.size();
		cinema.aggiungiSala(s3);
		assertEquals(size,cinema.getSale().size());
		cinema.aggiungiSala(s4);
		assertEquals(size+1,cinema.getSale().size());	
	}
	
	@Test
	public void testRimuiviSala(){
		Sala s1 = new Sala(1,13,130);
		Sala s2 = new Sala(2,10,100);
		ArrayList<Sala> sale = new ArrayList<Sala>();
		sale.add(s1);
		sale.add(s2);
		cinema.setSale(sale);
		Sala s3 = new Sala(3,12,180);
		assertEquals(false, cinema.rimuoviSala(s3));
		assertEquals(true,cinema.rimuoviSala(s2));
	}
	
	@Test
	public void testAggiungiProgrammazione(){
		Sala s1 = new Sala(1,13,130);
		Sala s2 = new Sala(2,10,100);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		Film film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la "
				+ "Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		LocalDateTime giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		LocalDateTime oraP1 = now.withHour(21).withMinute(35);
	    Programmazione p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	    LocalDateTime dInizio2 = now.withDayOfMonth(1).withMonth(9).withYear(2017);
	    LocalDateTime dFine2 = now.withDayOfMonth(1).withMonth(9).withYear(2018);
		Film film2 = new Film(2,"Drive","thriller","Un pilota d'auto, oltre a "
				+ "lavorare come meccanico..",6.00,1,35,dInizio2,dFine2);
		LocalDateTime giornoP2 = now.withDayOfMonth(11).withMonth(4).withYear(2018); 
		LocalDateTime oraP2 = now.withHour(21).withMinute(35);
	    Programmazione p2 = new Programmazione(3,giornoP2,oraP2,s2,film2);
	    ArrayList<Programmazione> listP = new ArrayList<Programmazione>();
	    listP.add(p1);
	    cinema.setFilmProgrammati(listP);
	    int size = cinema.getFilmProgrammati().size();
	    cinema.aggiungiProgrammazione(p1);
	    assertEquals(size,cinema.getFilmProgrammati().size());
	    cinema.aggiungiProgrammazione(p2);
	    assertEquals(size +1, cinema.getFilmProgrammati().size());    
	}
	 
	@Test 
	public void testRimuoviProgrammazione(){
		Sala s1 = new Sala(1,13,130);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dInizio1 = now.withDayOfMonth(10).withMonth(4).withYear(2017);
		LocalDateTime dFine1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		Film film1 = new Film(2,"Matrix","fanascienza","Thomas lavora presso la"
				+ " Metacortex come programmatore..",6.00,2,20,dInizio1,dFine1);
		LocalDateTime giornoP1 = now.withDayOfMonth(10).withMonth(4).withYear(2018);
		LocalDateTime oraP1 = now.withHour(21).withMinute(35);
	    Programmazione p1 = new Programmazione(1,giornoP1,oraP1,s1,film1);
	    ArrayList<Programmazione> listP = new ArrayList<Programmazione>();
	    listP.add(p1);
	    cinema.setFilmProgrammati(listP);
	    Programmazione p2 = new Programmazione(3,giornoP1,oraP1,s1,film1);
	    assertEquals(false, cinema.rimuoviProgrammazione(p2));
		assertEquals(true,cinema.rimuoviProgrammazione(p1));
	}
	
	@Test
	public void testRegistraCliente(){
		//registrazione con successo
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com","M",
				"333152497","Logan92","loganlogan","loganlogan","il tuo nome..",cartaC1);
		assertEquals(true,cinema.registraCliente(c1));
		//cliente gia' registrato
		assertEquals(false,cinema.registraCliente(c1));
		//le due password non sono corrette
		Cliente client2 = new Cliente("3","Logan","Peck","logan@hotmail.com","M","333152497","Logan92","loganlogan","sbagliata","il tuo nome..",cartaC1);
		assertFalse(cinema.registraCliente(client2));
	}
	
	@Test
	public void testEliminaCliente(){
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		CartaDiCredito cartaC2 = new CartaDiCredito("1239949549593",1333.39);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com","M",
				"333152497","Logan92","loganlogan","loganlogan","il tuo nome",cartaC1);
		Cliente c3 = new Cliente("18","Jack","Dawson","Jack@hotmail.com","M",
				"345845649","Jack.Dws","Platone","Platone","phamous philosopher",cartaC2);
		ArrayList<Cliente> listC = new ArrayList<Cliente>();
		listC.add(c1);
		cinema.setClienti(listC);
		int size = cinema.getClienti().size();
		cinema.eliminaCliente(c1);
		assertEquals(size-1,cinema.getClienti().size());
		cinema.eliminaCliente(c3);
		assertEquals(size-1,cinema.getClienti().size());
	}
	
	@Test
	public void testLogin(){
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Luca","Rossi","luca@hotmail.com","M","333152497","Luca93","Lucaaa","Lucaaa","il tuo nome",cartaC1);
		cinema.registraCliente(c1);
		cinema.login(usernameP, passwordP);
		assertEquals(expectedval,c1.isLoggato());
	}
	
	@Test
	public void testLogout(){
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Luca","Rossi","luca@hotmail.com","M",
				"333152497","Luca93","Lucaaa","Lucaaa","il tuo nome",cartaC1);
		cinema.registraCliente(c1);
		cinema.login(c1.getUsername(), c1.getPassword());
		cinema.logout(c1.getUsername());
		assertFalse(cinema.getClienti().get(0).isLoggato());
		//un utente non del sistema non può effettuare logout
		Cliente c2 = new Cliente("3","Luca","Rossi","luca@hotmail.com",
				"M","333152497","insesistente","Lucaaa","Lucaaa","il tuo nome",cartaC1);
		cinema.logout(c2.getUsername());
		assertFalse(cinema.getClienti().contains(c2));
	}
}
