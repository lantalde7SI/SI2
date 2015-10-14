package org.sudoku.sftwring;

import java.util.ArrayList;
import java.util.Iterator;

public class Klasifikazioa {
	private ArrayList<Integer> ranking;

	public Klasifikazioa(){
		this.ranking = new ArrayList<Integer>();
	}

	private void add(Erabiltzaile erab){
		//	aurre:
		//	post: erabiltzailea zerrendan ez badago gehitu egingo du segituan ordenatzeko
		if (this.emanErabHonenPos(erab)==-1){
			ranking.add(erab.getID());
		}
	}

	public void eguneratu(){
		//	aurre:
		//	post: rankingeko erabiltzaileak beheranzko ordenean ordenatuko ditu puntuazioan oinarrituz
		for (int i = 0; i < ErabiltzaileLista.getErabiltzaileLista().erabiltzaileKop(); i++) {
			this.add(ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(i));
		}

		quickSort(ranking, 0, ranking.size()-1);

	}

	private Iterator<Integer> getIteradorea(){
		return ranking.iterator();
	}

	public int emanErabHonenPos(Erabiltzaile erab){
		//	aurre: erab!=null
		//	post: erabiltzailearen posizioa itzuliko du eta -1 erabiltzailea ez bada zerrendan aurkitzen
		int kont = 0;
		for (Integer id : ranking) {
			if (id == erab.getID()) return kont;
			kont++;
		}
		return -1;
	}

	public void erreseteatu(){
		this.ranking = new ArrayList<Integer>();
	}

	public ArrayList<Erabiltzaile> erabiltzaileenListaKlasifikatorian() {
		//Aurre:
		//Post: Erabiltzaileen zerrenda bat bueltatuko du klasifikazioan ordenatuta dauden bezala.
		ArrayList<Erabiltzaile> erabKlasf = new ArrayList<Erabiltzaile>();

		for (int j = 0; j < ranking.size(); j++) {
			erabKlasf.add(ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(ranking.get(j)));
		}
		return erabKlasf;
	}

	public void inprimatuKlasifikazioa(){
		//aurre: 
		//post: Erabiltzaileen izena eta puntuazioa itzuliko du, beherazko ordenean
		Iterator<Integer> itr = this.getIteradorea();
		while(itr.hasNext()){
			int erabID=(int)itr.next();
			Erabiltzaile unekoa = ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(erabID);
			unekoa.inprimatuDatuakSudokuGabe();
		}
	}

	private void quickSort(ArrayList<Integer> taula, int hasiera,int bukaera) {
		//Aurre:
		//Post: IDak erabiltzailearen puntuen arabera ordenatuko ditu

		if (bukaera-hasiera>0) {
			int indizeaZatiketa = zatiketa(taula,hasiera,bukaera);
			quickSort(taula, hasiera, indizeaZatiketa-1);
			quickSort(taula, indizeaZatiketa+1, bukaera);
		}

	}
	public int tamaina(){
		return this.ranking.size();
	}

	private int zatiketa(ArrayList<Integer> taula, int l, int r) {

		Integer lag = taula.get(l);
		int ezker=l;
		int eskuin=r;

		while (ezker<eskuin) {
			while(((Integer)ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile((taula.get(ezker))).getPuntuazioa()).compareTo((Integer)ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(lag).getPuntuazioa()) >= 0 && ezker<eskuin) {
				ezker ++;

			}

			while(((Integer)ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile((taula.get(eskuin))).getPuntuazioa()).compareTo((Integer)ErabiltzaileLista.getErabiltzaileLista().getErabiltzaile(lag).getPuntuazioa()) < 0)
				eskuin--;
			if(ezker<eskuin)
				swap(taula,ezker,eskuin);
		}
		taula.set(l, taula.get(eskuin));
		taula.set(eskuin, lag);
		return eskuin;

	}

	private void swap(ArrayList<Integer> taula, int ezker, int eskuin) {

		Integer aux = taula.get(ezker);
		taula.set(ezker, taula.get(eskuin));
		taula.set(eskuin, aux);

	}

}