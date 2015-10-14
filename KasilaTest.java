package org.sudoku.sftwring;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

public class KasilaTest extends TestCase{
	
	public KasilaTest(String izena){
		super(izena);
	}
	
	protected void setUp() throws Exception {
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test
	public void testKasila() {
		//KASILA BERRIA BALIO EGOKIEKIN
		Kasila probetarakoKasila1=new Kasila(0);
		assertEquals(0,probetarakoKasila1.getBalioZuzena());
		assertEquals(0,probetarakoKasila1.getErabiltzaileBal());
		assertEquals(false,probetarakoKasila1.getFinkoa());
		assertEquals(false,probetarakoKasila1.getPantailaratuta());
		//KASILA BERRIA BALIO DESEGOKIEKIN (konpondu behar)
		Kasila probetarakoKasila2=new Kasila(-1);
		assertEquals(-1,probetarakoKasila2.getBalioZuzena());
		assertEquals(0,probetarakoKasila2.getErabiltzaileBal());
		assertEquals(false,probetarakoKasila2.getFinkoa());
		assertEquals(false,probetarakoKasila2.getPantailaratuta());
		
		
	}
	@Test
	public void testAldatu() {
		//KASILA HUTSA BALIO EGOKIEKIN ALDATUTA
		Kasila probetarakoKasila1=new Kasila(0);
		probetarakoKasila1.aldatu(1);
		assertEquals(0,probetarakoKasila1.getBalioZuzena());
		assertEquals(1,probetarakoKasila1.getErabiltzaileBal());
		assertEquals(false,probetarakoKasila1.getFinkoa());
		assertEquals(false,probetarakoKasila1.getPantailaratuta());
		//KASILA HUTSA BALIO EGOKIEKIN ALDATUTA(KONPONDU BEHAR)
		Kasila probetarakoKasila2=new Kasila(0);
		probetarakoKasila2.aldatu(-1);
		assertEquals(0,probetarakoKasila2.getBalioZuzena());
		assertEquals(-1,probetarakoKasila2.getErabiltzaileBal());
		assertEquals(false,probetarakoKasila2.getFinkoa());
		assertEquals(false,probetarakoKasila2.getPantailaratuta());
	}

	@Test
	public void testGorde() {
		
		//Kasila1 berria gorde
		Kasila probetarakoKasila1=new Kasila(0);
		assertEquals("0-0-false-",probetarakoKasila1.gorde());
		//Kasila2 berria balio desegokiarekin
		Kasila probetarakoKasila2=new Kasila(-1);
		assertEquals("-1-0-false-",probetarakoKasila2.gorde());
		//Kasila2  gorde balore bat aldatuta
		probetarakoKasila2.setFinkoa(true);
		assertEquals("-1-0-true-",probetarakoKasila2.gorde());
	
	}

	@Test
	public void testKargatu() {
		//Kasila1 berria kargatu
		//balio egokiak
				Kasila probetarakoKasila1=new Kasila(1);
				assertEquals("1-0-false-",probetarakoKasila1.gorde());
				probetarakoKasila1.kargatu("0-0-false-");
				assertEquals("0-0-false-",probetarakoKasila1.gorde());
		//datuak era desegokian kargatu
				Kasila probetarakoKasila2=new Kasila(0);
				probetarakoKasila2.kargatu("0--0-false-");
				assertEquals("",probetarakoKasila1.gorde());
				probetarakoKasila2.kargatu("-0-0-false-");
				assertEquals("",probetarakoKasila1.gorde());
				probetarakoKasila2.kargatu("0--0-false-");
				assertEquals("",probetarakoKasila1.gorde());
				probetarakoKasila2.kargatu("0-0--false-");
				assertEquals("",probetarakoKasila1.gorde());
				probetarakoKasila2.kargatu("0-0-false--");
				assertEquals("",probetarakoKasila1.gorde());
				//Kasila2 formatua desegokia denean kontrolatu behar da
			
	}

	@Test
	public void testKasilaErreseteatu() {
		Kasila probetarakoKasila1=new Kasila(1);
		probetarakoKasila1.kasilaErreseteatu();
		assertEquals("0-0-false-",probetarakoKasila1.kasilaErreseteatu().gorde());

		
		assertEquals("0-0-false-",probetarakoKasila1.kasilaErreseteatu().gorde());
		
	}

	@Test
	public void testSetPantailaratuta() {
		Kasila probetarakoKasila1=new Kasila(0);
		assertEquals(false, probetarakoKasila1.getPantailaratuta());
		probetarakoKasila1.setPantailaratuta(true);
		assertEquals(true, probetarakoKasila1.getPantailaratuta());
	}

		
	@Test
	public void testSetFinkoa() {
		Kasila probetarakoKasila1=new Kasila(0);
		assertEquals(false, probetarakoKasila1.getFinkoa());
		probetarakoKasila1.setFinkoa(true);
		assertEquals(true, probetarakoKasila1.getFinkoa());
	}


	@Test
	public void testSetBalioZuzena() {
		Kasila probetarakoKasila1=new Kasila(0);
		assertEquals(0, probetarakoKasila1.getBalioZuzena());
		probetarakoKasila1.setBalioZuzena(1);
		assertEquals(1, probetarakoKasila1.getBalioZuzena());
	}

	@Test
	public void testSetPosibleak() {
		Kasila probetarakoKasila1=new Kasila(0);
		ArrayList <Integer> balioak=new ArrayList<Integer>(9);
		balioak.add(1);
		balioak.add(2);
		balioak.add(3);
		balioak.add(4);
		balioak.add(5);
		balioak.add(6);
		balioak.add(7);
		balioak.add(8);
		balioak.add(9);
		probetarakoKasila1.setPosibleak(balioak);
		assertTrue(compare(balioak,probetarakoKasila1.getPosibleak()));		
		
	}

	private Boolean compare(ArrayList<Integer> balioak,ArrayList<Integer> posibleak) {
		Boolean ok=false;
		if (balioak.size()==posibleak.size()) {
			for (int i = 0; i < balioak.size(); i++) {
				if (balioak.get(i)==posibleak.get(i)) {
					ok= true;
				} else {
					ok= false;
				}
			}	
		}
		return ok;
		
		
	}
	@Test
	public void testKenduPosibleak() {
		Kasila probetarakoKasila1=new Kasila(0);
		ArrayList <Integer> balioak=new ArrayList<Integer>(9);
		balioak.add(1);
		balioak.add(2);
		balioak.add(3);
		balioak.add(4);
		balioak.add(5);
		balioak.add(6);
		balioak.add(7);
		balioak.add(8);
		balioak.add(9);
		probetarakoKasila1.setPosibleak(balioak);
		assertEquals(9,probetarakoKasila1.getPosibleak().size());
		probetarakoKasila1.kenduPosibleak(1);
		
		assertEquals(8,probetarakoKasila1.getPosibleak().size());
	}

}
