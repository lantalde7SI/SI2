package org.sudoku.sftwring;

public class Bloke {

	private Kasila [][] bloke;
	private int luzera = 3;
	private int zabalera = 3;

	public Bloke() {
		bloke = new Kasila[luzera][zabalera];
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++) {
				bloke[i][j]=new Kasila(0);
				bloke[i][j].setFinkoa(false);
			}
		}
	}

	public int getLuzera() {
		return luzera;
	}

	public int getZabalera() {
		return zabalera;
	}
	public Kasila[][] getBloke(){
		return this.bloke;}

	public void inprimatuBloke(){
		for (int i = 0; i < luzera; i++) {
			for (int j = 0; j < zabalera; j++) {
				if ((i==2&&j==2)||(i==0&&j==2)||(i==1&&j==2))System.out.print(" "+bloke[i][j].getErabiltzaileBal()+"\n");else{
					System.out.print(" "+bloke[i][j].getErabiltzaileBal());}
			}
		}

	}

	public void inprimatuBlokeZuzen(){
		for (int i = 0; i < luzera; i++) {
			for (int j = 0; j < zabalera; j++) {
				if ((i==2&&j==2)||(i==0&&j==2)||(i==1&&j==2)){
					System.out.print(" ");
					bloke[i][j].inprimatuZuzena();
					System.out.println("\n");
				}
				else{
					System.out.print(" ");
					bloke[i][j].inprimatuZuzena();
				}
			}
		}

	}

	public String gorde(){
		//Aurre
		//Post:String bat bueltatiko du zeinek blokeko kasiletako datuak bananduta edokiko dituen.
		String emaitza="";
		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				emaitza=emaitza+bloke[j][k].gorde();
				emaitza=emaitza+"%";
			}
		}
		return emaitza;
	}

	public void kargatu(String pKasila){
		//Aurre:Bloke bat betetzeko bezain beste zenbaki daramatzan string bat sartuko da "-" banandurik
		//Post:Blokeko kasilak dagokien zenbakiekin beteko ditu.
		String[] arrayKasila=pKasila.split("%");
		int cont=0;
		for(int j=0;j<3;j++){
			for(int k=0;k<3;k++){
				bloke[j][k].kargatu(arrayKasila[cont]);
				cont++;
			}

		}
	}
	public Kasila getKasila(int i , int j){
		return bloke[i][j];
	}

	public void setKasila(int i , int j, Kasila pKasila){

		bloke[i][j]= pKasila;

	}

	public boolean laguntza(){
		boolean[] ilara=new boolean[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!this.bloke[i][j].getFinkoa() && this.bloke[i][j].getErabiltzaileBal()!=0){
					if(ilara[this.bloke[i][j].getErabiltzaileBal()]) {
						return true;
					}
					else{
						ilara[this.bloke[i][j].getErabiltzaileBal()]=true;
					}
				}
				else if(this.bloke[i][j].getFinkoa()) {
					if(ilara[this.bloke[i][j].getBalioZuzena()]){
						return true;
					}
					else{
						ilara[this.bloke[i][j].getBalioZuzena()]=true;
					}
				}			
			}
		}
		return false;
	}

	public Kasila[] getZutabe(int k) {
		Kasila[] emaitza = new Kasila[3];
		for (int i = 0; i < 3; i++) {
			emaitza[i]=this.bloke[i][k];
		}
		return emaitza;
	}

	public Kasila[] getIlara(int k) {
		Kasila[] emaitza = new Kasila[3];
		for (int i = 0; i < 3; i++) {
			emaitza[i]=this.bloke[k][i];
		}
		return emaitza;
	}

}
