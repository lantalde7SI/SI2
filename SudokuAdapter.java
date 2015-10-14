package org.sudoku.sftwring;

public class SudokuAdapter extends Sudokua {

	public SudokuAdapter() {
		super();
	}

	public void ausazBete(int zailtasun) {
		setZailtasuna(zailtasun);
		GeneradoreSudoku genSudo = new GeneradoreSudoku(zailtasun);
		genSudo.beteAusaz();
		pasatu(genSudo);
	}

	public void pasatu(GeneradoreSudoku pGenSudo){

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.setKasila(i, j, pGenSudo.getSudokuKasila(i, j));
			}
		}
	}
}
