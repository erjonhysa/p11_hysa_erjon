import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UC3 {

	Cinema cinema;
	@Before
	public void setUp() throws Exception {
		cinema = new Cinema(1, "Universal", "Via 20 Settembre", "Genova");
	}
	
	//scenario principale: registrazione con successo
	@Test
	public void testRegistrazioneE1() {
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan",
				"il tuo nome..",cartaC1);
		assertEquals(true,cinema.registraCliente(c1));
	}
	
	//scenario alternativo: username gia' in uso
	@Test
	public void testRegistrazioneE2() {
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan",
				"il tuo nome..",cartaC1);
		assertEquals(true,cinema.registraCliente(c1));
		assertEquals(false,cinema.registraCliente(c1));
	}
	
	//scenario alternativo: le due password non sono corrette
	@Test
	public void testRegistrazioneE3() {
		CartaDiCredito cartaC1 = new CartaDiCredito("2334549359434",2333.89);
		Cliente c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","abb",
				"il tuo nome..",cartaC1);
		assertEquals(false,cinema.registraCliente(c1));
	}
	
}
