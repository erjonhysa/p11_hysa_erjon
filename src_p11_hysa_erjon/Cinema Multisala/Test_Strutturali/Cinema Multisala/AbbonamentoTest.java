import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AbbonamentoTest {

	Offerta o;
	Abbonamento a;

	@Parameter(0) public int par1; 
	@Parameter(1) public boolean expectedval;

	@Before
	public void setUp() throws Exception {
		o = new Offerta("standard", 10, 25.0);
		a = new Abbonamento(o);
	}


	@Parameters
	public static Collection<Object[]> data(){ 
		return Arrays.asList(new Object[][] {
			{3,true},
			{20,false}, 
			{1,true}
		});
	}

	@Test
	public void testCostruttore() {
		assertNotNull(a); 
		assertEquals("standard",a.getTipoAbbonamento());
		assertEquals(10,a.getNumeroBiglietti());
		assertEquals(25.0,a.getCosto(),1);
	}

	@Test
	public void testSetGetTipoAbb(){
		a.setTipoAbbonamento("premium");
		assertEquals("premium",a.getTipoAbbonamento());
	}

	//quello con parametri
	@Test
	public void testScalaBiglietti(){
		assertEquals(expectedval,a.scalaBiglietti(par1));
	}

	@Test
	public void testRimborsoBiglietti(){
		a.setNumeroBiglietti(3);
		a.rimborsoBiglietti(3);
		assertEquals(6,a.getNumeroBiglietti());
	}
}
