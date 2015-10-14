package org.sudoku.sftwring;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ErabiltzaileLista {

	private static ErabiltzaileLista nErabiltzaileLista=null;
	private ArrayList<Erabiltzaile> erabiltzaileLista;
	private Klasifikazioa klasifikazioa;
	private ErabiltzaileLista(){
		this.erabiltzaileLista=new ArrayList<Erabiltzaile>();
		this.klasifikazioa = new Klasifikazioa();
	}

	public static ErabiltzaileLista getErabiltzaileLista(){
		if (nErabiltzaileLista==null)
			nErabiltzaileLista= new ErabiltzaileLista();
		return nErabiltzaileLista;
	}

	public void gehituErabiltzaile(String pIzena,String pPasahitza, String pZifraPasahitz){
		if(!badago(pIzena))
			erabiltzaileLista.add(new Erabiltzaile(pIzena,this.erabiltzaileLista.size(),pPasahitza));

		else {System.out.println("Erabiltzaile izen hori hartuta dago, mesedez aukeratu beste bat");}
	}

	public void gehituErabiltzaile(String pIzena,String pPasahitza){
		if(!badago(pIzena))
			erabiltzaileLista.add(new Erabiltzaile(pIzena,this.erabiltzaileLista.size(),pPasahitza));

		else {System.out.println("Erabiltzaile izen hori hartuta dago, mesedez aukeratu beste bat");}
	}

	public void ezabatuErabiltzaile(String pIzena,String pPasahitza){
		Erabiltzaile pErabiltzaile=ErabiltzaileLista.nErabiltzaileLista.bilatuErabiltzaile(pIzena, pPasahitza);
		if(pErabiltzaile!=null){
			ErabiltzaileLista.nErabiltzaileLista.erabiltzaileLista.remove(pErabiltzaile);
		}
	}

	public int erabiltzaileKop() {
		return erabiltzaileLista.size();
	}

	public Erabiltzaile bilatuErabiltzaile(String pIzen,String pPasaHitza){
		Iterator<Erabiltzaile> itr=this.getIteradorea();
		boolean aurk=false;
		Erabiltzaile unekoErabiltzaile = null;
		while(itr.hasNext()&&!aurk){
			unekoErabiltzaile=itr.next();
			if (unekoErabiltzaile.getIzen().equals(pIzen)&&unekoErabiltzaile.nirePasahitzaDa(pPasaHitza)){
				aurk=true;
			}
		}
		if(!aurk){return null;}
		else{ return unekoErabiltzaile;}
	}


	private Iterator<Erabiltzaile> getIteradorea(){
		return ErabiltzaileLista.nErabiltzaileLista.erabiltzaileLista.iterator();
	}

	public void inprimatu(){
		Iterator<Erabiltzaile> itr=this.getIteradorea();
		while(itr.hasNext()){
			itr.next().inprimatuDatuak();
			System.out.println("----------");
		}
	}

	public boolean badago(String pIzen){

		Iterator<Erabiltzaile> itr=this.getIteradorea();
		while(itr.hasNext()){
			Erabiltzaile unekoErabiltzaile=itr.next();
			if (unekoErabiltzaile.getIzen().equals(pIzen)){
				return true;
			}
		}
		return false;
	}

	public void kargatu() throws IOException{
		try{
			Scanner sarrera = new Scanner(new FileReader("usr.log"));
			while(sarrera.hasNext()){
				String lerroa=sarrera.next();
				Erabiltzaile pErab = new Erabiltzaile("",0,"","");
				pErab.kargatu(lerroa);
				ErabiltzaileLista.nErabiltzaileLista.erabiltzaileLista.add(pErab);
			}
			sarrera.close();
		}catch(IOException e) {e.printStackTrace();}

	}   

	public Erabiltzaile getErabiltzaile(int pId) {
		if(pId>erabiltzaileKop()){
			return null;
		}else{
		return erabiltzaileLista.get(pId);}
	}

	public void gorde(){
		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter("usr.log"));
			Iterator<Erabiltzaile> it=this.getIteradorea();
			while(it.hasNext()){
				String pErab=it.next().gorde();
				pw.println(pErab);
			}
			pw.close();
			System.out.println("Fitxagian gorde da erabiltzaile lista");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Klasifikazioa getKlasifikazioa() {
		return klasifikazioa;
	}

	public void erreseteatuErabiltzaileLista(){
		ErabiltzaileLista.nErabiltzaileLista=null;
		System.out.println("Erabiltzaile lista berrabiarazi da");
	}
}