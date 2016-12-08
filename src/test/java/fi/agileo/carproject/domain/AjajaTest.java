package fi.agileo.carproject.domain;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fi.agileo.carproject.domain.Ajaja.Ajotapa;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AjajaTest {

	@Mock
	Auto mockAuto;
	
	@Before
	public void setUp(){
		when(mockAuto.laskeNopeus1()).thenReturn(100.0);
	}
	
	
	@Test
	public void testAjaAggressivinen() {
		Ajaja testattava= new Ajaja(mockAuto, "spded Pasanen", Ajotapa.AGGRESSIIVINEN);
		
		assertEquals(0.01, testattava.aja1(0.0001), 0.001);
		assertEquals(50, testattava.aja1(0.5), 0.0001);
		assertEquals(100, testattava.aja1(1.0), 0.0001);
//	assertEquals(0, testattava.aja(-1.0), 0.0001);
		assertEquals(-100, testattava.aja1(-1.0), 0.0001);
		
		
		
	}

	
	@Test
	public void testAja() {
		Ajaja testattava= new Ajaja(mockAuto, "spded Pasanen", Ajotapa.TAVALLINEN);
		
		assertEquals(0.007, testattava.aja1(0.0001), 0.001);
		assertEquals(35, testattava.aja1(0.5), 0.0001);
		assertEquals(70, testattava.aja1(1.0), 0.0001);
		//assertEquals(0, testattava.aja(-1.0), 0.0001);
	
}
}
