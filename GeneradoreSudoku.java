package org.sudoku.sftwring;

import java.util.ArrayList;
import java.util.Random;

public class GeneradoreSudoku {

	private Kasila[][] sudoku;
	private int luzera=9;
	private int zabalera=9;
	private int zailtasuna;

	public GeneradoreSudoku(int zailtasun){
		sudoku = new Kasila [luzera][zabalera];
		this.zailtasuna=zailtasun;
		beteZeroz();
	}

	public void beteZeroz(){
		for (int z = 0; z < luzera; z++) {
			for (int i = 0; i < zabalera; i++) {
				sudoku[z][i] = new Kasila(0);
			}
		}
	}

	public void setZailtasuna(int maila){
		if (maila==0||maila==1||maila==2) {
			this.zailtasuna = maila;
		}
	}

	public int getZailtasuna(){
		return this.zailtasuna;
	}

	public Kasila[][] getSudoku(){
		return sudoku;
	}

	public Kasila getSudokuKasila(int i, int j) {
		return this.sudoku[i][j];
	}

	public void beteAusaz(){					//lehen adabegia sortzen da: ausazko zenbakia eta 0 sakonerarekin
		Random ausa = new Random();
		int zenb = ausa.nextInt(9)+1;
		Adabegia<Integer> lehena = new Adabegia<Integer>(zenb,0);
		hurrengoaJarri(0, zenb);				//zenbakia sudokuko dagokion posizioan jartzen da
		osotu(lehena);
		kasilakEzabatu(zailtasuna);
	}

	private boolean osotu(Adabegia<Integer> adabegi){		//Adabegi berria prestatzen da bere semeekin
		int sakonera = adabegi.sakonera+1;	
		if (sakonera==81) {return true;}					//amaierako kasua: sudoku bat lortu da eta balioak jarrita daude
		Integer [] posibleak = KalkulatuPosibleak(sakonera);
		shuffle(posibleak);
		boolean jarraituDaiteke = false;
		for (int j = 0; j < posibleak.length; j++) {
			if (posibleak[j]!=0) {
				jarraituDaiteke = true;
				break;
			}
		}
		if (jarraituDaiteke) {								//kasu errekurtsiboa: ez dira kasila guztiak bete eta kasila posibleak daude
			for (int j = 0; j < posibleak.length; j++) {	//adabegi guztak konprobatu behar ditu false(behean) itzuli aurretik
				if (posibleak[j]!=0) {
					Adabegia<Integer> unekoa = adabegi.gehituSemea(posibleak[j], sakonera);
					hurrengoaJarri(unekoa.sakonera, unekoa.content);
					if (osotu(unekoa)) {return true;}
					else {
						adabegi.ezabatuSemea(unekoa.content);
					}
				}
			}
			return false;
		}
		else {return false;}						//ez dago seme posiblerik, false erantzuten da gurasoak beste adabegi bat aukera dezan
	}

	public void kasilakEzabatu(int zailtasuna){		//kasilak ausaz ezabatuko ditu zailtasunaren arabera
		int kopurua=0;
		Random rg=new Random();
		int batu = rg.nextInt(4);
		switch(zailtasuna){							//zailtasunaren arabera erabakitako kentzeko zenbakiak
		case 0:kopurua = 44 + batu; break;
		case 1:kopurua = 48 + batu; break;
		case 2:kopurua = 52 + batu; break;
		}

		kopiatu();
		ezabatuAusaz(kopurua);

		for (int i = 0; i < sudoku.length; i++) {
			for (int z = 0; z < sudoku.length; z++) {
				if (!sudoku[i][z].getFinkoa()) {
					sudoku[i][z].aldatu(0);
				}
			}
		}
	}

	private void kopiatu(){
		ArrayList<Integer> balioGuztiak = new ArrayList<Integer>();
		balioGuztiak.add(1);
		balioGuztiak.add(2);
		balioGuztiak.add(3);
		balioGuztiak.add(4);
		balioGuztiak.add(5);
		balioGuztiak.add(6);
		balioGuztiak.add(7);
		balioGuztiak.add(8);
		balioGuztiak.add(9);
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				sudoku[i][j].setFinkoa(false);							//sudokua soluziorik duen ikusteko bigarren saiakera denean beharrezkoa da
				sudoku[i][j].aldatu(sudoku[i][j].getBalioZuzena());		//balio zuzen denak jartzen dira gero atzintzen joateko
				sudoku[i][j].setPosibleak(balioGuztiak);				//kasila guztien zenbaki posibleak denak dira hasieran 
			}
		}
	}

	private void ezabatuAusaz(int kopurua) {
		Random r = new Random();
		int i = r.nextInt(9);
		int z = r.nextInt(9);
		while (kopurua>0) {
			if (sudoku[i][z].getErabiltzaileBal()!=0) {
				sudoku[i][z].aldatu(0);
				if (soluzioBakarra()) {
					kopurua--;
				} else {
					try{
					} catch (Exception e){}
					sudoku[i][z].aldatu(sudoku[i][z].getBalioZuzena());
				}
			}

			i = r.nextInt(9);
			z = r.nextInt(9);
		}
		for (int j = 0; j < sudoku.length; j++) {
			for (int k = 0; k < sudoku[0].length; k++) {
				if (sudoku[j][k].getErabiltzaileBal()!=0) {
					sudoku[j][k].setFinkoa(true);
				}
			}
		}
	}

	public boolean soluzioBakarra()  {

		int [][] model = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				model[i][j]=sudoku[i][j].getErabiltzaileBal();
			}
		}
		SudokuSolver solver = new SudokuSolver(model);
		int emaitzKop = solver.solve();
		boolean emaitza= emaitzKop==1;
		return emaitza;
	}

	public void inprimatuZuzena(){
		for (int z = 0; z < luzera; z++) {
			for (int i = 0; i < zabalera; i++) {
				if (i==8) {
					System.out.print(" "+sudoku[z][i].getBalioZuzena()+"\n");
				}
				else {System.out.print(" "+sudoku[z][i].getBalioZuzena());}
			}
		}
		System.out.print("\n");
	}

	public void inprimatuErabiltzaile(){
		for (int z = 0; z < luzera; z++) {
			for (int i = 0; i < zabalera; i++) {
				if (i==8) {
					System.out.print(" "+sudoku[z][i].getErabiltzaileBal()+"\n");
				}
				else {System.out.print(" "+sudoku[z][i].getErabiltzaileBal());}
			}
		}
		System.out.print("\n");
	}

	public void hurrengoaJarri(int pos, int zenb){
		switch(pos){
		case 0:sudoku[0][0].setBalioZuzena(zenb);
		case 1:sudoku[0][1].setBalioZuzena(zenb);
		case 2:sudoku[0][2].setBalioZuzena(zenb);
		case 3:sudoku[0][3].setBalioZuzena(zenb);
		case 4:sudoku[0][4].setBalioZuzena(zenb);
		case 5:sudoku[0][5].setBalioZuzena(zenb);
		case 6:sudoku[0][6].setBalioZuzena(zenb);
		case 7:sudoku[0][7].setBalioZuzena(zenb);
		case 8:sudoku[0][8].setBalioZuzena(zenb);
		case 9:sudoku[1][0].setBalioZuzena(zenb);
		case 10:sudoku[1][1].setBalioZuzena(zenb);
		case 11:sudoku[1][2].setBalioZuzena(zenb);
		case 12:sudoku[1][3].setBalioZuzena(zenb);
		case 13:sudoku[1][4].setBalioZuzena(zenb);
		case 14:sudoku[1][5].setBalioZuzena(zenb);
		case 15:sudoku[1][6].setBalioZuzena(zenb);
		case 16:sudoku[1][7].setBalioZuzena(zenb);
		case 17:sudoku[1][8].setBalioZuzena(zenb);
		case 18:sudoku[2][0].setBalioZuzena(zenb);
		case 19:sudoku[2][1].setBalioZuzena(zenb);
		case 20:sudoku[2][2].setBalioZuzena(zenb);
		case 21:sudoku[2][3].setBalioZuzena(zenb);
		case 22:sudoku[2][4].setBalioZuzena(zenb);
		case 23:sudoku[2][5].setBalioZuzena(zenb);
		case 24:sudoku[2][6].setBalioZuzena(zenb);
		case 25:sudoku[2][7].setBalioZuzena(zenb);
		case 26:sudoku[2][8].setBalioZuzena(zenb);
		case 27:sudoku[3][0].setBalioZuzena(zenb);
		case 28:sudoku[3][1].setBalioZuzena(zenb);
		case 29:sudoku[3][2].setBalioZuzena(zenb);
		case 30:sudoku[3][3].setBalioZuzena(zenb);
		case 31:sudoku[3][4].setBalioZuzena(zenb);
		case 32:sudoku[3][5].setBalioZuzena(zenb);
		case 33:sudoku[3][6].setBalioZuzena(zenb);
		case 34:sudoku[3][7].setBalioZuzena(zenb);
		case 35:sudoku[3][8].setBalioZuzena(zenb);
		case 36:sudoku[4][0].setBalioZuzena(zenb);
		case 37:sudoku[4][1].setBalioZuzena(zenb);
		case 38:sudoku[4][2].setBalioZuzena(zenb);
		case 39:sudoku[4][3].setBalioZuzena(zenb);
		case 40:sudoku[4][4].setBalioZuzena(zenb);
		case 41:sudoku[4][5].setBalioZuzena(zenb);
		case 42:sudoku[4][6].setBalioZuzena(zenb);
		case 43:sudoku[4][7].setBalioZuzena(zenb);
		case 44:sudoku[4][8].setBalioZuzena(zenb);
		case 45:sudoku[5][0].setBalioZuzena(zenb);
		case 46:sudoku[5][1].setBalioZuzena(zenb);
		case 47:sudoku[5][2].setBalioZuzena(zenb);
		case 48:sudoku[5][3].setBalioZuzena(zenb);
		case 49:sudoku[5][4].setBalioZuzena(zenb);
		case 50:sudoku[5][5].setBalioZuzena(zenb);
		case 51:sudoku[5][6].setBalioZuzena(zenb);
		case 52:sudoku[5][7].setBalioZuzena(zenb);
		case 53:sudoku[5][8].setBalioZuzena(zenb);
		case 54:sudoku[6][0].setBalioZuzena(zenb);
		case 55:sudoku[6][1].setBalioZuzena(zenb);
		case 56:sudoku[6][2].setBalioZuzena(zenb);
		case 57:sudoku[6][3].setBalioZuzena(zenb);
		case 58:sudoku[6][4].setBalioZuzena(zenb);
		case 59:sudoku[6][5].setBalioZuzena(zenb);
		case 60:sudoku[6][6].setBalioZuzena(zenb);
		case 61:sudoku[6][7].setBalioZuzena(zenb);
		case 62:sudoku[6][8].setBalioZuzena(zenb);
		case 63:sudoku[7][0].setBalioZuzena(zenb);
		case 64:sudoku[7][1].setBalioZuzena(zenb);
		case 65:sudoku[7][2].setBalioZuzena(zenb);
		case 66:sudoku[7][3].setBalioZuzena(zenb);
		case 67:sudoku[7][4].setBalioZuzena(zenb);
		case 68:sudoku[7][5].setBalioZuzena(zenb);
		case 69:sudoku[7][6].setBalioZuzena(zenb);
		case 70:sudoku[7][7].setBalioZuzena(zenb);
		case 71:sudoku[7][8].setBalioZuzena(zenb);
		case 72:sudoku[8][0].setBalioZuzena(zenb);
		case 73:sudoku[8][1].setBalioZuzena(zenb);
		case 74:sudoku[8][2].setBalioZuzena(zenb);
		case 75:sudoku[8][3].setBalioZuzena(zenb);
		case 76:sudoku[8][4].setBalioZuzena(zenb);
		case 77:sudoku[8][5].setBalioZuzena(zenb);
		case 78:sudoku[8][6].setBalioZuzena(zenb);
		case 79:sudoku[8][7].setBalioZuzena(zenb);
		case 80:sudoku[8][8].setBalioZuzena(zenb);
		}
	}

	public Integer[] KalkulatuPosibleak(int pos){		//kasilan posible diren zenbakiak kalkulatzen ditu
		Integer[] emaitza = null;
		switch(pos){
		case 0:return emaitza = KalkulatuPosibleak(0, 0);
		case 1:return emaitza = KalkulatuPosibleak(0, 1);
		case 2:return emaitza = KalkulatuPosibleak(0, 2);
		case 3:return emaitza = KalkulatuPosibleak(0, 3);
		case 4:return emaitza = KalkulatuPosibleak(0, 4);
		case 5:return emaitza = KalkulatuPosibleak(0, 5);
		case 6:return emaitza = KalkulatuPosibleak(0, 6);
		case 7:return emaitza = KalkulatuPosibleak(0, 7);
		case 8:return emaitza = KalkulatuPosibleak(0, 8);
		case 9:return emaitza = KalkulatuPosibleak(1, 0);
		case 10:return emaitza = KalkulatuPosibleak(1, 1);
		case 11:return emaitza = KalkulatuPosibleak(1, 2);
		case 12:return emaitza = KalkulatuPosibleak(1, 3);
		case 13:return emaitza = KalkulatuPosibleak(1, 4);
		case 14:return emaitza = KalkulatuPosibleak(1, 5);
		case 15:return emaitza = KalkulatuPosibleak(1, 6);
		case 16:return emaitza = KalkulatuPosibleak(1, 7);
		case 17:return emaitza = KalkulatuPosibleak(1, 8);
		case 18:return emaitza = KalkulatuPosibleak(2, 0);
		case 19:return emaitza = KalkulatuPosibleak(2, 1);
		case 20:return emaitza = KalkulatuPosibleak(2, 2);
		case 21:return emaitza = KalkulatuPosibleak(2, 3);
		case 22:return emaitza = KalkulatuPosibleak(2, 4);
		case 23:return emaitza = KalkulatuPosibleak(2, 5);
		case 24:return emaitza = KalkulatuPosibleak(2, 6);
		case 25:return emaitza = KalkulatuPosibleak(2, 7);
		case 26:return emaitza = KalkulatuPosibleak(2, 8);
		case 27:return emaitza = KalkulatuPosibleak(3, 0);
		case 28:return emaitza = KalkulatuPosibleak(3, 1);
		case 29:return emaitza = KalkulatuPosibleak(3, 2);
		case 30:return emaitza = KalkulatuPosibleak(3, 3);
		case 31:return emaitza = KalkulatuPosibleak(3, 4);
		case 32:return emaitza = KalkulatuPosibleak(3, 5);
		case 33:return emaitza = KalkulatuPosibleak(3, 6);
		case 34:return emaitza = KalkulatuPosibleak(3, 7);
		case 35:return emaitza = KalkulatuPosibleak(3, 8);
		case 36:return emaitza = KalkulatuPosibleak(4, 0);
		case 37:return emaitza = KalkulatuPosibleak(4, 1);
		case 38:return emaitza = KalkulatuPosibleak(4, 2);
		case 39:return emaitza = KalkulatuPosibleak(4, 3);
		case 40:return emaitza = KalkulatuPosibleak(4, 4);
		case 41:return emaitza = KalkulatuPosibleak(4, 5);
		case 42:return emaitza = KalkulatuPosibleak(4, 6);
		case 43:return emaitza = KalkulatuPosibleak(4, 7);
		case 44:return emaitza = KalkulatuPosibleak(4, 8);
		case 45:return emaitza = KalkulatuPosibleak(5, 0);
		case 46:return emaitza = KalkulatuPosibleak(5, 1);
		case 47:return emaitza = KalkulatuPosibleak(5, 2);
		case 48:return emaitza = KalkulatuPosibleak(5, 3);
		case 49:return emaitza = KalkulatuPosibleak(5, 4);
		case 50:return emaitza = KalkulatuPosibleak(5, 5);
		case 51:return emaitza = KalkulatuPosibleak(5, 6);
		case 52:return emaitza = KalkulatuPosibleak(5, 7);
		case 53:return emaitza = KalkulatuPosibleak(5, 8);
		case 54:return emaitza = KalkulatuPosibleak(6, 0);
		case 55:return emaitza = KalkulatuPosibleak(6, 1);
		case 56:return emaitza = KalkulatuPosibleak(6, 2);
		case 57:return emaitza = KalkulatuPosibleak(6, 3);
		case 58:return emaitza = KalkulatuPosibleak(6, 4);
		case 59:return emaitza = KalkulatuPosibleak(6, 5);
		case 60:return emaitza = KalkulatuPosibleak(6, 6);
		case 61:return emaitza = KalkulatuPosibleak(6, 7);
		case 62:return emaitza = KalkulatuPosibleak(6, 8);
		case 63:return emaitza = KalkulatuPosibleak(7, 0);
		case 64:return emaitza = KalkulatuPosibleak(7, 1);
		case 65:return emaitza = KalkulatuPosibleak(7, 2);
		case 66:return emaitza = KalkulatuPosibleak(7, 3);
		case 67:return emaitza = KalkulatuPosibleak(7, 4);
		case 68:return emaitza = KalkulatuPosibleak(7, 5);
		case 69:return emaitza = KalkulatuPosibleak(7, 6);
		case 70:return emaitza = KalkulatuPosibleak(7, 7);
		case 71:return emaitza = KalkulatuPosibleak(7, 8);
		case 72:return emaitza = KalkulatuPosibleak(8, 0);
		case 73:return emaitza = KalkulatuPosibleak(8, 1);
		case 74:return emaitza = KalkulatuPosibleak(8, 2);
		case 75:return emaitza = KalkulatuPosibleak(8, 3);
		case 76:return emaitza = KalkulatuPosibleak(8, 4);
		case 77:return emaitza = KalkulatuPosibleak(8, 5);
		case 78:return emaitza = KalkulatuPosibleak(8, 6);
		case 79:return emaitza = KalkulatuPosibleak(8, 7);
		case 80:return emaitza = KalkulatuPosibleak(8, 8);
		}
		return emaitza;
	}

	private Integer[] KalkulatuPosibleak(int z, int i){		//kasilan posible diren zenbakiak kalkulatzen ditu
		Integer[] posibleak = {1,2,3,4,5,6,7,8,9};
		for(int j=0; j<luzera; j++){   //ilara konprobatu
			if(sudoku[j][i].getBalioZuzena()!=0){posibleak[sudoku[j][i].getBalioZuzena()-1]=0;}
		}
		for(int j=0; j<luzera; j++){   //zutabea konprobatu
			if(sudoku[z][j].getBalioZuzena()!=0){posibleak[sudoku[z][j].getBalioZuzena()-1]=0;}
		}
		if(z<3 && i<3){   //blokeak konprobatu
			for (z = 0; z < 3; z++) {
				for (i = 0; i < 3; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z<3 && i>2 && i<6){
			for (z = 0; z < 3; z++) {
				for (i = 3; i < 6; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z<3 && i>5 && i<9){
			for (z = 0; z < 3; z++) {
				for (i = 6; i < 9; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>2 && z<6 && i<3){
			for (z = 3; z < 6; z++) {
				for (i = 0; i < 3; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>2 && z<6 && i>2 && i<6){
			for (z = 3; z < 6; z++) {
				for (i = 3; i < 6; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>2 && z<6 && i>5 && i<9){
			for (z = 3; z < 6; z++) {
				for (i = 6; i < 9; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>5 && z<9 && i<3){
			for (z = 6; z < 9; z++) {
				for (i = 0; i < 3; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>5 && z<9 && i>2 && i<6){
			for (z = 6; z < 9; z++) {
				for (i = 3; i < 6; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		else if(z>5 && z<9 && i>5 && i<9){
			for (z = 6; z < 9; z++) {
				for (i = 6; i < 9; i++) {
					if(sudoku[z][i].getBalioZuzena()!=0){posibleak[sudoku[z][i].getBalioZuzena()-1]=0;}
				}
			}
		}
		return posibleak;
	}

	private void shuffle(Integer[] zerrenda){	//Integer[] motako zerrenda nahasten du 
		Random ausa = new Random();
		for (int i = zerrenda.length-1; i > 0; i--) {
			int indize = ausa.nextInt(i+1);
			if (indize!=i) {
				int balioa = zerrenda[indize];
				zerrenda[indize] = zerrenda [i];
				zerrenda[i] = balioa;
			}
		}
	}

}
