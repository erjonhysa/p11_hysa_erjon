import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UC1 {
	Cinema cinema;
	CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
	Cliente c1;
	
	
	@Before
	public void setUp() throws Exception {
		cinema = new Cinema(1, "Universal", "Via 20 Settembre", "Genova");
		cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		c1 = new Cliente("3","Logan","Peck","logan@hotmail.com","M",
				"333152497","Logan92","loganlogan","loganlogan",
				"il tuo nome",cartaC1);
		cinema.registraCliente(c1);
	}

	//scenario principale: autenticazione con successo
	@Test 
	public void testLoginE1() {
		cinema.login(c1.getUsername(),c1.getPassword());
		assertTrue(c1.isLoggato());
	}
	
	//scenario alternativo: autenticazione fallita(4A)
	@Test
	public void testLoginE2() {
		c1.setLoggato(false);
		cinema.login(c1.getUsername(), "sbagliata");
		assertFalse(c1.isLoggato()); 
	}

	//scenario alternativo: 4B 
	@Test
	public void testLoginE3(){
		c1.setLoggato(false);
		cinema.login("usernameSbagliato",c1.getPassword());
		assertFalse(c1.isLoggato()); 
	}
}
