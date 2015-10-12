package org.sudoku.sftwring;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudokuaTest extends TestCase{
	//Atributua
	private Sudokua s;
	
	public SudokuaTest(String izena){
		super(izena);
	}
	@Before
	protected void setUp() throws Exception {
		s = new Sudokua();
	}

	@After
	protected void tearDown() throws Exception {
		s.erreseteatuSudoku();
	}



	@Test
	public void testGorde() {

		//Zeroz betetako sudokua
		s.kargatu("0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");

		assertEquals(s.gorde(), "0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");

		//Sudokua beteta egonda
		s.kargatu("4-4-true-%2-0-false-%9-0-false-%6-6-true-%3"
				+ "-0-false-%1-0-false-%7-0-false-%5-0-false-%8-0-"
				+ "false-%/3-3-true-%6-0-false-%8-0-false-%5-0-false-%7-7-true-%2-0-false-%9-"
				+ "9-true-%4-0-false-%1-0-false-%/1-1-true-%7-0-false-%5-0-false-%8-0-false-%9"
				+ "-0-false-%4-0-false-%6-6-true-%2-0-false-%3-0-false-%/9-0-false-%4-4-true-%2"
				+ "-2-true-%1-1-true-%7-0-false-%6-6-true-%3-0-false-%8-0-false-%5-5-true-%/6-0"
				+ "-false-%8-0-false-%5-0-false-%4-0-false-%9-0-false-%3-0-false-%1-0-false-%2-"
				+ "2-true-%7-0-false-%/3-3-true-%1-0-false-%7-7-true-%2-2-true-%5-0-false-%8-0-"
				+ "false-%9-0-false-%4-0-false-%6-6-true-%/2-0-false-%9-0-false-%4-0-false-%8-8"
				+ "-true-%1-0-false-%7-7-true-%5-0-false-%6-0-false-%3-3-true-%/8-8-true-%5-0-false-"
				+ "%6-6-true-%2-0-false-%3-3-true-%4-0-false-%7-7-true-%1-0-false-%9-0-false-%/7-0-"
				+ "false-%3-0-false-%1-0-false-%5-0-false-%6-0-false-%9-9-true-%4-4-true-%8-8-true-"
				+ "%2-2-true-%/");
		assertEquals("4-4-true-%2-0-false-%9-0-false-%6-6-true-%3"
				+ "-0-false-%1-0-false-%7-0-false-%5-0-false-%8-0-"
				+ "false-%/3-3-true-%6-0-false-%8-0-false-%5-0-false-%7-7-true-%2-0-false-%9-"
				+ "9-true-%4-0-false-%1-0-false-%/1-1-true-%7-0-false-%5-0-false-%8-0-false-%9"
				+ "-0-false-%4-0-false-%6-6-true-%2-0-false-%3-0-false-%/9-0-false-%4-4-true-%2"
				+ "-2-true-%1-1-true-%7-0-false-%6-6-true-%3-0-false-%8-0-false-%5-5-true-%/6-0"
				+ "-false-%8-0-false-%5-0-false-%4-0-false-%9-0-false-%3-0-false-%1-0-false-%2-"
				+ "2-true-%7-0-false-%/3-3-true-%1-0-false-%7-7-true-%2-2-true-%5-0-false-%8-0-"
				+ "false-%9-0-false-%4-0-false-%6-6-true-%/2-0-false-%9-0-false-%4-0-false-%8-8"
				+ "-true-%1-0-false-%7-7-true-%5-0-false-%6-0-false-%3-3-true-%/8-8-true-%5-0-false-"
				+ "%6-6-true-%2-0-false-%3-3-true-%4-0-false-%7-7-true-%1-0-false-%9-0-false-%/7-0-"
				+ "false-%3-0-false-%1-0-false-%5-0-false-%6-0-false-%9-9-true-%4-4-true-%8-8-true-"
				+ "%2-2-true-%/", s.gorde());

	}

	@Test
	public void testKargatu() {

		//Sudokua zeroz kargatu
		s.kargatu("0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");

		assertEquals(s.gorde(), "0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");


		//Sudokua balio zehatzekin kargatu
		s.kargatu("4-4-true-%2-0-false-%9-0-false-%6-6-true-%3"
				+ "-0-false-%1-0-false-%7-0-false-%5-0-false-%8-0-"
				+ "false-%/3-3-true-%6-0-false-%8-0-false-%5-0-false-%7-7-true-%2-0-false-%9-"
				+ "9-true-%4-0-false-%1-0-false-%/1-1-true-%7-0-false-%5-0-false-%8-0-false-%9"
				+ "-0-false-%4-0-false-%6-6-true-%2-0-false-%3-0-false-%/9-0-false-%4-4-true-%2"
				+ "-2-true-%1-1-true-%7-0-false-%6-6-true-%3-0-false-%8-0-false-%5-5-true-%/6-0"
				+ "-false-%8-0-false-%5-0-false-%4-0-false-%9-0-false-%3-0-false-%1-0-false-%2-"
				+ "2-true-%7-0-false-%/3-3-true-%1-0-false-%7-7-true-%2-2-true-%5-0-false-%8-0-"
				+ "false-%9-0-false-%4-0-false-%6-6-true-%/2-0-false-%9-0-false-%4-0-false-%8-8"
				+ "-true-%1-0-false-%7-7-true-%5-0-false-%6-0-false-%3-3-true-%/8-8-true-%5-0-false-"
				+ "%6-6-true-%2-0-false-%3-3-true-%4-0-false-%7-7-true-%1-0-false-%9-0-false-%/7-0-"
				+ "false-%3-0-false-%1-0-false-%5-0-false-%6-0-false-%9-9-true-%4-4-true-%8-8-true-"
				+ "%2-2-true-%/");

		assertEquals(s.gorde(), "4-4-true-%2-0-false-%9-0-false-%6-6-true-%3"
				+ "-0-false-%1-0-false-%7-0-false-%5-0-false-%8-0-"
				+ "false-%/3-3-true-%6-0-false-%8-0-false-%5-0-false-%7-7-true-%2-0-false-%9-"
				+ "9-true-%4-0-false-%1-0-false-%/1-1-true-%7-0-false-%5-0-false-%8-0-false-%9"
				+ "-0-false-%4-0-false-%6-6-true-%2-0-false-%3-0-false-%/9-0-false-%4-4-true-%2"
				+ "-2-true-%1-1-true-%7-0-false-%6-6-true-%3-0-false-%8-0-false-%5-5-true-%/6-0"
				+ "-false-%8-0-false-%5-0-false-%4-0-false-%9-0-false-%3-0-false-%1-0-false-%2-"
				+ "2-true-%7-0-false-%/3-3-true-%1-0-false-%7-7-true-%2-2-true-%5-0-false-%8-0-"
				+ "false-%9-0-false-%4-0-false-%6-6-true-%/2-0-false-%9-0-false-%4-0-false-%8-8"
				+ "-true-%1-0-false-%7-7-true-%5-0-false-%6-0-false-%3-3-true-%/8-8-true-%5-0-false-"
				+ "%6-6-true-%2-0-false-%3-3-true-%4-0-false-%7-7-true-%1-0-false-%9-0-false-%/7-0-"
				+ "false-%3-0-false-%1-0-false-%5-0-false-%6-0-false-%9-9-true-%4-4-true-%8-8-true-"
				+ "%2-2-true-%/");

	}

	@Test
	public void testBeteZeroz() {
		//Sudokua jada zeroz beteta badago
		s.beteZeroz();
		assertEquals(s.gorde(), "0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");

		//Sudokua beteta egonda
		s.kargatu("4-4-true-%2-0-false-%9-0-false-%6-6-true-%3"
				+ "-0-false-%1-0-false-%7-0-false-%5-0-false-%8-0-"
				+ "false-%/3-3-true-%6-0-false-%8-0-false-%5-0-false-%7-7-true-%2-0-false-%9-"
				+ "9-true-%4-0-false-%1-0-false-%/1-1-true-%7-0-false-%5-0-false-%8-0-false-%9"
				+ "-0-false-%4-0-false-%6-6-true-%2-0-false-%3-0-false-%/9-0-false-%4-4-true-%2"
				+ "-2-true-%1-1-true-%7-0-false-%6-6-true-%3-0-false-%8-0-false-%5-5-true-%/6-0"
				+ "-false-%8-0-false-%5-0-false-%4-0-false-%9-0-false-%3-0-false-%1-0-false-%2-"
				+ "2-true-%7-0-false-%/3-3-true-%1-0-false-%7-7-true-%2-2-true-%5-0-false-%8-0-"
				+ "false-%9-0-false-%4-0-false-%6-6-true-%/2-0-false-%9-0-false-%4-0-false-%8-8"
				+ "-true-%1-0-false-%7-7-true-%5-0-false-%6-0-false-%3-3-true-%/8-8-true-%5-0-false-"
				+ "%6-6-true-%2-0-false-%3-3-true-%4-0-false-%7-7-true-%1-0-false-%9-0-false-%/7-0-"
				+ "false-%3-0-false-%1-0-false-%5-0-false-%6-0-false-%9-9-true-%4-4-true-%8-8-true-"
				+ "%2-2-true-%/");
		s.beteZeroz();
		assertEquals(s.gorde(), "0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false"
				+ "-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%/0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-"
				+ "%0-0-false-%/0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-false-%0-0-"
				+ "false-%0-0-false-%0-0-false-%0-0-false-%/");

	}

	@Test
	public void testZuzendu() {

		//Sudokua ondo beteta egonda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		boolean[][] lag;

		lag = s.zuzendu();

		for (int i = 0; i < lag.length; i++) {
			for (int j = 0; j < lag.length; j++) {
				assertTrue(lag[i][j]);
			}

		}

		//Sudokua ondo beteta ez badago
		s.kargatu("5-0-false-%1-3-false-%6-3-false-%2-0-false-%3-2-false-%4-1-false"
				+ "-%9-4-false-%8-0-false-%7-0-false-%/8-0-false-%3-5-false-%7-5-"
				+ "false-%6-0-false-%9-0-false-%5-4-false-%2-6-false-%1-0-false-%4-3-"
				+ "false-%/4-5-false-%2-0-false-%9-0-false-%1-0-false-%7-0-false-%8-0-"
				+ "false-%5-0-false-%6-0-false-%3-0-false-%/6-0-false-%9-0-false-%1-0-"
				+ "false-%3-0-false-%2-0-false-%8-0-false-%7-0-false-%4-0-"
				+ "false-%5-0-false-%/4-0-false-%5-0-false-%8-0-false-%9-0-"
				+ "false-%7-0-false-%1-0-false-%3-0-false-%2-0-false-%6-0-false"
				+ "-%/2-0-false-%3-0-false-%7-0-false-%6-0-false-%4-0-false-%5-0-"
				+ "false-%8-0-false-%9-0-false-%1-0-false-%/4-0-false-%7-0-false"
				+ "%2-0-false-%1-0-false-%5-0-false-%3-0-false-%8-0-false-%6-0-false"
				+ "-%9-0-false-%/5-0-false-%8-0-false-%9-0-false-%7-0-false-%6-0-"
				+ "false-%2-0-false-%1-0-false-%4-0-false-%3-0-false-%/3-0-false-"
				+ "%1-0-false-%6-0-false-%9-0-false-%8-0-false-%4-0-false-%7-0-"
				+ "false-%5-0-false-%2-0-false-%/");

		lag = s.zuzendu();

		for (int i = 0; i < lag.length; i++) {
			for (int j = 0; j < lag.length; j++) {
				assertFalse(lag[i][j]);
			}
		}	

		//Sudokua erdi beteta egonda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-9-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-4-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		lag = s.zuzendu();

		assertFalse(lag[3][1]);
		assertFalse(lag[7][0]);


	}

	@Test
	public void testLaguntzaIlarak() {
		//Sudoku osoa ondo eginda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		assertEquals(-1, s.laguntzaIlarak());

		//Sudokua ilara oker batekin
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-9-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		assertEquals(3, s.laguntzaIlarak());
	}

	@Test
	public void testLaguntzaZutabe() {
		//Sudoku osoa ondo eginda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		assertEquals(-1, s.laguntzaZutabe());	

		//Zutabe bat txarto egonda

		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-9-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");
		
		assertEquals(1, s.laguntzaZutabe());


	}

	@Test
	public void testLaguntzaBloke() {

		//Bloke guztiak ondo egonda

		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		assertEquals(-1,s.laguntzaBloke());


		//Blokeren bat txarto egonda
		s.kargatu("6-3-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");	

		assertEquals(0, s.laguntzaBloke());
	}





	@Test
	public void testArtuZutabe() {
		//Sudokua beteta egonda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		Kasila[] lag = s.artuZutabe(0,0);
		int[] laguntzaile3 = new int[9];
		for (int i = 0; i < lag.length; i++){
			laguntzaile3[i] = lag[i].getBalioZuzena();
		}
		int[] laguntzaile2 = {6,4,7,8,9,2,1,5,3};
		assertArrayEquals(laguntzaile3, laguntzaile2);
		

	}

	@Test
	public void testArtuIlara() {

		//Sudokua beteta egonda
		s.kargatu("6-6-false-%1-1-false-%8-8-false-%4-4-false-%9-9-false-%2-2-"
				+ "false-%7-7-false-%3-3-false-%5-5-false-%/4-4-false-%2-2-"
				+ "false-%5-5-false-%7-7-false-%6-6-false-%3-3-false-%1-1-false-"
				+ "%8-8-false-%9-9-false-%/3-3-false-%7-7-false-%9-9-false-%5-5-"
				+ "false-%8-8-false-%1-1-false-%6-6-false-%2-2-false-%4-4-false-"
				+ "%/8-8-false-%5-5-false-%6-6-false-%9-9-false-%7-7-false-%1-1-"
				+ "false-%2-2-false-%4-4-false-%3-3-false-%/3-3-false-%1-1-false"
				+ "-%7-7-false-%2-2-false-%4-4-false-%6-6-false-%5-5-false-%9-9-"
				+ "false-%8-8-false-%/4-4-false-%9-9-false-%2-2-false-%8-8-false"
				+ "-%5-5-false-%3-3-false-%7-7-false-%1-1-false-%6-6-false-%/1-1-"
				+ "false-%2-2-false-%7-7-false-%5-5-false-%8-8-false-%4-4-false"
				+ "-%3-3-false-%6-6-false-%9-9-false-%/6-6-false-%5-5-false-%4-4-"
				+ "false-%9-9-false-%3-3-false-%1-1-false-%8-8-false-%7-7-false-"
				+ "%2-2-false-%/9-9-false-%3-3-false-%8-8-false-%2-2-false-%6-6-"
				+ "false-%7-7-false-%1-1-false-%4-4-false-%5-5-false-%/");

		Kasila[] lag = s.artuIlara(0, 0);
		int[] lag3 = new int[9];
		for (int i = 0; i < lag.length; i++) {
			lag3[i] = lag[i].getBalioZuzena();
		}
		int[] lag2 = {6,1,8,4,2,5,3,7,9};
		assertArrayEquals(lag3, lag2);

	}



}//end class
