import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RecensioneTest {

	Recensione r;
	
	@Before
	public void setUp() throws Exception {
		 r = new Recensione("bello..", 3, "Mark");
	}

	@Test
	public void testCostruttore() {
		assertNotNull(r);
		assertEquals("bello..",r.getCommento());
		assertEquals(3,r.getVoto());
		assertEquals("Mark",r.getUsername());
	}

	@Test
	public void testSetGetVoto(){
		r.setVoto(2);
		assertEquals(2,r.getVoto());
	}
	
	@Test
	public void testSetGetCommento(){
		r.setCommento("mi e' piaciuto");
		assertEquals("mi e' piaciuto",r.getCommento());
	}
	
	@Test
	public void testSetGetUsername(){
		r.setUsername("Erik");
		assertEquals("Erik",r.getUsername());
	}
	
	@Test
	public void testGetInfoRecensione(){
		ArrayList<Object> listaInfo = new ArrayList<Object>();
		listaInfo = r.getInfoRecensione();
		assertTrue(listaInfo.get(0).equals(r.getCommento()));
		assertTrue(listaInfo.get(1).equals(r.getVoto()));
		assertTrue(listaInfo.get(2).equals(r.getUsername()));
	}
}
