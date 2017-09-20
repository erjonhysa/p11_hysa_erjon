import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OffertaTest {

	Offerta o;
	@Before
	public void setUp() throws Exception {
		o = new Offerta("standard", 15, 25.0);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(o);
		assertEquals("standard",o.getTipo());
		assertEquals(15,o.getNumBiglietti());
		assertEquals(25.0,o.getPrezzo(),1);
	}
	
	@Test
	public void testSetGetTipo(){
		o.setTipo("premium");
		assertEquals("premium",o.getTipo());
	}
	
	@Test
	public void testSetGetNumBiglietti(){
		o.setNumBiglietti(15);
		assertEquals(15,o.getNumBiglietti());
	}
	
	@Test
	public void testSetGetPrezzo(){
		o.setPrezzo(33);
		assertEquals(33,o.getPrezzo(),1);
	}
	
	@Test
	public void testEquals(){
		Offerta o2 = new Offerta("standard", 15, 25.0);
		Offerta o3 = new Offerta("premium", 20, 30.0);
		assertTrue(o.equals(o2));
		assertFalse(o.equals(o3));
		assertTrue(o.equals(o));
		assertFalse(o.equals("Prova"));
	}

	@Test
	public void testGetInfoOfferta(){
		ArrayList<Object> listaInfo = new ArrayList<Object>();
		listaInfo = o.getInfoOfferta();
		assertTrue(listaInfo.get(0).equals(o.getTipo()));
		assertTrue(listaInfo.get(1).equals(o.getNumBiglietti()));
		assertTrue(listaInfo.get(2).equals(o.getPrezzo()));
		assertTrue(listaInfo.get(3).equals(o.getScadenza()));
		
	}
}
