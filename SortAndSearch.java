package org.sudoku.sftwring;
import java.util.ArrayList;
import java.util.Random;


public class SortAndSearch <T extends Comparable<T>>{

	public SortAndSearch(){
	}

	public  void quicksort(ArrayList<T> a){
		quicksort(a,0,a.size()-1);
	}

	private  void quicksort(ArrayList<T> a, int hasi, int bukatu) {
		if(bukatu-hasi>0){
			int indizeZatiketa=zatiketa(a,hasi,bukatu);
			quicksort(a,hasi,indizeZatiketa-1);
			quicksort(a,indizeZatiketa+1,bukatu);
		}
	}

	private int zatiketa(ArrayList<T> a,int i,int f){
		T lag=a.get(i);
		int ezker=i;
		int eskuin=f;
		while(ezker<eskuin){
			while(a.get(ezker).compareTo(lag)<=0 &&ezker<eskuin)ezker++;
			while(a.get(eskuin).compareTo(lag)>0 )
				eskuin--;	
			if(ezker<eskuin)
				aldatuPos(a,ezker,eskuin);
		}
		a.set(i, a.get(eskuin));
		a.set(eskuin, lag);
		return eskuin;
	}


	private void aldatuPos(ArrayList<T> a, int i, int j) {
		T aux;
		aux=a.get(i);
		a.set(i, a.get(j));
		a.set(j, aux);
	}
	public static int[] beteAusazArray(int nondik, int nora, int tamaina) {
		int[] zenbakienArray = new int[tamaina];
		Random rnd = new Random();
		int n;
		for (int g = 0; g < zenbakienArray.length; g++) {
			do {
				n = rnd.nextInt(nora - nondik + 1) + nondik;
			} while (egiaztauErrepikapena(zenbakienArray, g, n));
			zenbakienArray[g] = n;
		}
		return zenbakienArray;
	}


	public static boolean egiaztauErrepikapena(int[] zenbakienArray, int indizea, int momentukoBalorea) {

		for (int i = 0; i < indizea; i++) {
			if (zenbakienArray[i] == momentukoBalorea) {
				return true;
			}
		}
		return false;        

	}


	public T bilaketaDikotomikoa(ArrayList<T> a,String izen){

		int pos=bilatu(a,izen);
		if(pos>=0){
			return a.get(pos);
		}
		else{return null;}

	}

	private int bilatu(ArrayList<T> a,String izen){
		int i=0;
		int j=a.size();
		int erdia=0;
		int count=0;
		int aurreko=0;
		while(i<=j){
			erdia=(i+j)/2;
			if(count==2){
				count=0;
				if (aurreko==erdia) {
					return -1;}
			}else if(count==1){aurreko=erdia;
			count++;}
			else{count++;}
			int konparaketa=getIzena(a.get(erdia)).compareTo(izen);
			if(konparaketa<0){
				i=erdia++;
			}
			else if(konparaketa>0){
				j=erdia++;
			}
			else{return erdia;}
		}
		return -1;
	}

	private String getIzena(T obj) {
		if (obj instanceof Erabiltzaile) return ((Erabiltzaile) obj).getIzen();
		else {return null;}

	}

}


