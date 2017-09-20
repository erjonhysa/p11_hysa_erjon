import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtenteTest {

	Utente u;
	
	@Before
	public void setUp() throws Exception {
		u = new Utente("2","Luca", "Bianchi", "l.b@hotmail.com",
				"M", "laMiaPassword","laMiaPassword");
	}
	
	@Test
	public void testCostruttore() {
		assertNotNull(u);
		assertEquals("2",u.getIdUtente());
		assertEquals("Luca",u.getNome());
		assertEquals("Bianchi",u.getCognome());
		assertEquals("l.b@hotmail.com",u.getEmail());
		assertEquals("M",u.getSesso());
		assertEquals("laMiaPassword",u.getPassword());
		assertEquals("laMiaPassword",u.getPassword2());
	}
	
	

}
