package org.sudoku.sftwring;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSudokuOsoa {
	static Test suite;
	
	public static Test suite() throws Throwable{
		TestSuite suite = new TestSuite();
		suite.addTestSuite(SudokuaTest.class);
		suite.addTestSuite(ErabiltzaileListaTest.class);
		suite.addTestSuite(KasilaTest.class);		
		return suite;
	}

}
