import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartaDiCreditoTest {

	CartaDiCredito c;
	@Before
	public void setUp() throws Exception {
		c = new CartaDiCredito("123456677",3200.4);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(c); 
		assertEquals("123456677",c.getNumeroCarta());
		assertEquals(3200.4,c.getSaldo(),1);		
	}

	@Test
	public void testPagamento(){
		c.setSaldo(24.5);
		assertTrue(c.pagamento(12.40));
        assertFalse(c.pagamento(212));
	}
	
	@Test
	public void testRimborso() {
		c.setSaldo(21);
		c.rimborso(16.80);
		assertEquals(37.80,c.getSaldo(),1);
	}
}
