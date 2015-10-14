package org.sudoku.sftwring;

import java.util.Random;

public class Sudokua {
	private Bloke [][] sudoku;
	private int luzera = 3;
	private int zabalera = 3;
	private int zailtasuna;

	public Sudokua() {
		sudoku = new Bloke[luzera][zabalera];
		beteZeroz();
	}

	public void inprimatuSudoku(){

		for (int i = 0; i < luzera; i++) {
			for (int j = 0; j < zabalera; j++) {
				sudoku[i][j].inprimatuBloke();;
			}
		}
	}

	public void inprimatuSudokuZuzena(){

		for (int i = 0; i < luzera; i++) {
			for (int j = 0; j < zabalera; j++) {
				sudoku[i][j].inprimatuBlokeZuzen();
			}
		}
	}

	public Sudokua erreseteatuSudoku(){
		//Aurre:
		//Post:Sudokua hasieratuko du
		Sudokua sudokuBerria= new Sudokua();
		return  sudokuBerria;	
	}

	public Bloke getBloke(int i){
		Bloke pBloke=null;
		switch(i){
		case 0:pBloke=sudoku[0][0];break;
		case 1:pBloke=sudoku[0][1];break;
		case 2:pBloke=sudoku[0][2];break;
		case 3:pBloke=sudoku[1][0];break;
		case 4:pBloke=sudoku[1][1];break;
		case 5:pBloke=sudoku[1][2];break;
		case 6:pBloke=sudoku[2][0];break;
		case 7:pBloke=sudoku[2][1];break;
		case 8:pBloke=sudoku[2][2];break;
		}


		return pBloke;
	}
	public Kasila getKasila(int i, int j) {
		int blokeI = i/3;
		int blokeJ = j/3;
		int kasilaI = i - (blokeI*3);
		int kasilaJ = j - (blokeJ*3);
		return sudoku[blokeI][blokeJ].getKasila(kasilaI,kasilaJ);
	}
	public void setKasila(int i, int j, Kasila pKasila) {
		int blokeI = i/3;
		int blokeJ = j/3;
		int kasilaI = i - (blokeI*3);
		int kasilaJ = j - (blokeJ*3);
		sudoku[blokeI][blokeJ].setKasila(kasilaI,kasilaJ,pKasila);
	}
	public String gorde(){
		//Aurre:
		//Post:Sudokua String batetara pasako da.
		String emaitza="";
		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				emaitza=emaitza+sudoku[j][k].gorde();
				emaitza=emaitza+"/";
			}
		}
		return emaitza;
	}

	public void kargatu(String pSudoku){
		//Aurre: pSudoku String-a sudoku bat betetzeko behar beste zenbakiz egongo da beteta.
		//Post: Sudokua zenbakiz beteko da.
		if(!pSudoku.equals("")){
			String[] arrayString=pSudoku.split("/");
			int cont=0;
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					sudoku[j][k].kargatu(arrayString[cont]);
					cont++;
				}
			}
		}else beteZeroz();
	}

	public void beteZeroz(){
		//Aurre:
		//Post:Sudokua 0roz beteko du.
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++) {
				sudoku[i][j]=new Bloke();	 
			}
		}
	}


	public void setZailtasuna(int i){
		this.zailtasuna=i;
	}
	public int getZailtasuna(){
		return this.zailtasuna;
	}

	public boolean[][] zuzendu()  {
		boolean[][] zuzen = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Kasila kas = this.getKasila(i, j);
				if (!kas.getFinkoa()) zuzen[i][j] = kas.getBalioZuzena()==kas.getErabiltzaileBal();
				else zuzen[i][j] = true;
			}
		}
		return zuzen;
	}

	public void ausazBete(int zailtasuna) {/*Ausaz betetzeko metodoa bere semeetan definituko da Adib.: Adapterrean*/}

	public int laguntzaIlarak(){
		Random rand=new Random();
		int i=-1;
		i=rand.nextInt(3);
		if(i==0)i=0;
		else if(i==1)i=3;
		else i=6;
		boolean[] ilara=new boolean[10];
		int bukatu=0;
		Kasila[] ilar=new Kasila[9];
		int k=rand.nextInt(3);
		while(bukatu<9){
			ilar=this.artuIlara(k, i);
			for (int j = 0; j < ilar.length; j++) {
				if(ilar[j].getErabiltzaileBal()!=0){
					if(ilara[ilar[j].getErabiltzaileBal()]){
						System.out.println("Erabiltzaile bal: "+ilar[j].getErabiltzaileBal());

						return i+k;
					}else {
						ilara[ilar[j].getErabiltzaileBal()]=true;
					}
				}
				else if(ilar[j].getFinkoa()){
					if( ilara[ilar[j].getBalioZuzena()]){
						System.out.println("Balio zuzen: "+ilar[j].getBalioZuzena());
						return i+k;
					}
					else{
						ilara[ilar[j].getBalioZuzena()]=true;
					}
				}
			}
			bukatu++;
			ilara=new boolean[10];
			if(k==2){ k=0;
			if(i==6)i=0;
			else i=i+3;}
			else {k++;}
		}
		return -1;
	}

	public int laguntzaZutabe(){
		Random rand=new Random();
		int i=rand.nextInt(3);
		boolean[] ilara=new boolean[10];
		int bukatu=0;
		Kasila[] zutab=new Kasila[9];;
		int k=rand.nextInt(3);
		while(bukatu<9){
			zutab=this.artuZutabe(k,i);
			for (int j = 0; j < zutab.length; j++) {
				if(zutab[j].getErabiltzaileBal()!=0){
					if(ilara[zutab[j].getErabiltzaileBal()]){
						return i*3+k;
					}else {
						ilara[zutab[j].getErabiltzaileBal()]=true;
					}
				}
				else if(zutab[j].getFinkoa()){
					if( ilara[zutab[j].getBalioZuzena()]){

						return i*3+k;
					}
					else{
						ilara[zutab[j].getBalioZuzena()]=true;
					}
				}
			}
			bukatu++;
			ilara=new boolean[10];
			if(k==2){ k=0;
			if(i==2)i=0;
			else i++;

			}
			else {k++;}
		}
		return -1;
	}

	public int laguntzaBloke(){
		Random rand=new Random();
		int i=rand.nextInt(9);
		for (int j = 0; j < 9; j++) {
			if(this.getBloke(i).laguntza()){
				return i;
			}
			if(i==8)i=0;
			else i++;

		}
		return -1;
	}
	public Kasila[] artuZutabe(int k, int blok){
		Kasila[] kas=new Kasila[9];
		Kasila[] kas3=new Kasila[3];
		int count=0;
		for (int i = blok; i <9; i=i+3) {
			kas3=this.getBloke(i).getZutabe(k);
			for (int j = 0; j < kas3.length; j++) {
				kas[count]=kas3[j];
				count++;
			}
		}
		return kas;
	}
	public Kasila[] artuIlara(int k, int ilar){
		Kasila[] kas=new Kasila[9];
		Kasila[] kas3=new Kasila[3];
		int count=0;
		for (int i = 0; i <3; i++) {
			kas3=this.getBloke(ilar++).getIlara(k);
			for (int j = 0; j < kas3.length; j++) {
				kas[count]=kas3[j];
				count++;
			}
		}
		return kas;
	}
}




