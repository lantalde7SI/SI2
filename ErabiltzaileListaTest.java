package org.sudoku.sftwring; 

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

public class ErabiltzaileListaTest extends TestCase{


	public ErabiltzaileListaTest(String izena) throws Throwable{
		super(izena);
	}

	protected void setUp() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();
	}
	protected void tearDown() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
	}

	@Test
	public void testGehituErabiltzaile() {
		//Erabiltzaileak bi pasahitzak berdinak direla interfazeak kontrolatzen du, beraz bi pasaitzak 
		//berdinak direla suposatuko da.
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		assertEquals(2,ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		assertEquals(2, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
	}

	@Test
	public void testEzabatuErabiltzaile() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		ErabiltzaileLista.getErabiltzaileLista().ezabatuErabiltzaile("Martin", "123456");
		assertEquals(0, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().ezabatuErabiltzaile("Martin", "123456");
		assertEquals(0, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().ezabatuErabiltzaile("Edgar", "123456");
		assertEquals(2, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().ezabatuErabiltzaile("Martin", "123456");
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().ezabatuErabiltzaile("Mikel", "156");
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());

	}

	@Test
	public void testErabiltzaileKop() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		assertEquals(0, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Edgar", "123456","123456");
		assertEquals(3, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
	}

	@Test
	public void testBilatuErabiltzaile() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		assertNull(ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Martin", "123456"));
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		assertNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Edgar", "123456"));
		assertNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Martin", "1234"));
		assertNotNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Martin", "123456"));
	}

	@Test
	public void testBadago() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		assertFalse(ErabiltzaileLista.getErabiltzaileLista().badago("Martin"));
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		assertFalse(ErabiltzaileLista.getErabiltzaileLista().badago("Edgar"));
		assertTrue(ErabiltzaileLista.getErabiltzaileLista().badago("Martin"));
	}



	@Test
	public void testGetErabiltzaile() {
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();		
		assertNull(ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(1));
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		assertNull(ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(3));
		assertNotNull(ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(1));	
	}

	@Test
	public void testKargatuGorde() throws IOException {
		//Erabiltzailerik ez badago ondo gorde eta kargatu egiten da.
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();
		assertEquals(0, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gorde();
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();
		ErabiltzaileLista.getErabiltzaileLista().kargatu();
		assertEquals(0, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		//Erabiltzaile bat gordeta
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Martin", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gorde();
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();
		ErabiltzaileLista.getErabiltzaileLista().kargatu();
		assertEquals(1, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		assertNotNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Martin", "123456"));
		//Erabiltzaile asko gordeta
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Mikel", "123456","123456");
		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("Edgar", "123456","123456");
		assertEquals(3, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		ErabiltzaileLista.getErabiltzaileLista().gorde();
		ErabiltzaileLista.getErabiltzaileLista().erreseteatuErabiltzaileLista();
		ErabiltzaileLista.getErabiltzaileLista().kargatu();
		assertEquals(3, ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop());
		assertNotNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Martin", "123456"));
		assertNotNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Mikel", "123456"));
		assertNotNull( ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("Edgar", "123456"));


	}


}
