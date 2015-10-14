package org.sudoku.sftwring;

import java.util.ArrayList;

public class Kasila{
	private Integer zuzena;
	private Integer erabiltzaileBal;
	private boolean finkoa;
	private ArrayList<Integer> posibleak;
	private boolean pantailaratuta;

	public Kasila(Integer Balioa){
		zuzena=Balioa;
		this.erabiltzaileBal=0;
		this.finkoa=false;
		this.pantailaratuta=false;
		posibleak = new ArrayList<Integer>();

	}

	public void aldatu(Integer balioBerri){
		if(!this.finkoa)
			this.erabiltzaileBal=balioBerri;
		else{
			System.out.println("Ezin izan da balioa aldatu, finkoa da");
		}
	}

	public String gorde(){
		String emaitza="";
		emaitza=emaitza+zuzena;
		emaitza=emaitza+"-";
		emaitza=emaitza+this.erabiltzaileBal;
		emaitza=emaitza+"-";
		emaitza=emaitza+this.finkoa;
		emaitza=emaitza+"-";
		return emaitza;
	}
	public void kargatu(String pKasila){
		String[] pKas=pKasila.split("-");
		zuzena=Integer.parseInt(pKas[0]);
		this.erabiltzaileBal=new Integer(pKas[1]);
		if(pKas[2].equals("true"))
			this.finkoa=true;
		else this.finkoa=false;

	}
	public void inprimatuKasila(){
		System.out.println("Erabiltzaile Balioa: "+this.erabiltzaileBal);
		System.out.println("Balio Zuzena: "+zuzena);
		if(this.finkoa==false)System.out.println("Ez da finkoa.");
		else{System.out.println("Finkoa da.");}
	}

	public Kasila kasilaErreseteatu(){
		return new Kasila(0);
	}

	public void setPantailaratuta(boolean bai) {
		this.pantailaratuta=bai;
	}

	public boolean getPantailaratuta() {
		return this.pantailaratuta;
	}

	public int getErabiltzaileBal() {
		return erabiltzaileBal;
	}

	public void inprimatuZuzena() {
		System.out.print(zuzena);
	}

	public void setFinkoa(boolean e) {
		this.finkoa = e;

	}
	public boolean getFinkoa(){
		return finkoa;
	}
	public int getBalioZuzena(){
		return zuzena;
	}

	public String toString() {
		if (finkoa) {
			if (zuzena == 0) return "";
			else return ""+zuzena;
		} else return "";
	}

	public void setBalioZuzena(int zenb){
		zuzena=zenb;
	}

	public ArrayList<Integer> getPosibleak(){
		return posibleak;
	}

	public void setPosibleak(ArrayList<Integer> balioak){
		this.posibleak = balioak;
	}

	public void kenduPosibleak(int balioa){
		if (this.posibleak.contains(balioa)) {
			this.posibleak.remove((Integer)balioa);
		}
	}

}

