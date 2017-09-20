import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UC9 {

	CartaDiCredito carta;
	Cliente c1;
	Offerta o;
	
	@Before
	public void setUp() throws Exception {
		o = new Offerta("standard", 10, 25.0);
		carta = new CartaDiCredito("2334549359434",2333.89);
		c1 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","Logan92","loganlogan","il tuo nome",carta);

	}

	//scenario principale: acquisto di un pagamento con successo
	@Test
	public void testAcquistareAbbonamentiE1() {
		assertNull(c1.getAbbonamento());
		c1.acquistaAbbonamento(o);
		assertNotNull(c1.getAbbonamento());
		assertEquals(c1.getAbbonamento().getTipoAbbonamento(),o.getTipo());
		assertEquals(c1.getAbbonamento().getNumeroBiglietti(),o.getNumBiglietti());
	}

	//scenario alternativo: la transizione non va a buon fine
	@Test
	public void testAcquistareAbbonamentiE2(){
		CartaDiCredito carta2 = new CartaDiCredito("2334549359434",1.89);
		Cliente c2 = new Cliente("3","Logan","Peck","logan@hotmail.com",
				"M","333152497","Logan92","loganlogan","loganlogan","il tuo nome",carta2);
		c2.acquistaAbbonamento(o);
		assertNull(c2.getAbbonamento());
	}
}
