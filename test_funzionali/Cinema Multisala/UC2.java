import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UC2 {

	Cinema cinema;
	
	@Before
	public void setUp() throws Exception {
		cinema = new Cinema(1, "Universal", "Via 20 Settembre", "Genova");
	}

	//scenario principale: logout corretto
	@Test
	public void testLogoutE1() {
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Luca","Rossi","luca@hotmail.com","M","333152497","Luca93","Lucaaa","Lucaaa","il tuo nome",cartaC1);
		cinema.registraCliente(c1);
		cinema.login(c1.getUsername(), c1.getPassword());
		cinema.logout(c1.getUsername());
		assertFalse(cinema.getClienti().get(0).isLoggato());
	}
}
