package org.sudoku.sftwring;

import javax.crypto.BadPaddingException;


public class Erabiltzaile implements Comparable<Erabiltzaile> {

	private String izena;
	private String pasahitza;
	private String zifraPasahitz;
	private int ID;
	private int puntuazioa;
	private Sudokua azkenengoSudokua;

	public Erabiltzaile(String pIzena, int pID,String pPasahitza, String pZifraPasahitz){

		this.izena=pIzena;
		this.ID=pID;
		this.azkenengoSudokua = new SudokuAdapter();
		if (!pZifraPasahitz.equals("")) {
			this.pasahitza=pPasahitza;
			Zifra z0 = new Zifra(pasahitza);
			this.zifraPasahitz = pZifraPasahitz;
			Zifra z1 = new Zifra(zifraPasahitz);
			try {
				this.pasahitza = z1.encrypt(pasahitza);
				zifraPasahitz = z0.encrypt(zifraPasahitz);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.puntuazioa=0;
		}
	}

	public Erabiltzaile(String pIzena, int pID,String pPasahitza){
		this.izena=pIzena;
		this.ID=pID;
		this.azkenengoSudokua = new Sudokua();
		this.pasahitza=pPasahitza;
		Zifra z0 = new Zifra(pasahitza);
		this.zifraPasahitz = z0.generateKey();
		Zifra z1 = new Zifra(zifraPasahitz);
		try {
			this.pasahitza = z1.encrypt(pasahitza);
			zifraPasahitz = z0.encrypt(zifraPasahitz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.puntuazioa=0;
	}

	public String getIzen() {
		//Aurre:
		//Post: erabiltzailearen izena bueltatuko du
		return this.izena;
	}

	public int getID(){
		return this.ID;
	}
	public String getPasahitza() {
		return this.pasahitza;
	}
	public Sudokua getSudoku(){
		return this.azkenengoSudokua;
	}
	public String getSudokuZifratuta(){
		return this.azkenengoSudokua.gorde();
	}
	public boolean nirePasahitzaDa(String pPasahitza) {
		//Aurre: pasahitzarekin konparatu nahi dugun stringa sartuko dugu !=null
		//Post: pasahitza berdina bada true bueltatuko du beztela false
		Zifra zifrPas = new Zifra(pPasahitza);

		try {
			String z = zifrPas.decrypt(zifraPasahitz);
			Zifra pas = new Zifra(z);
			String e = pas.decrypt(pasahitza);
			return pPasahitza.equals(e);
		} catch (Exception e) {
			if (e instanceof BadPaddingException) {
				System.err.println("--------------------Okerreko pasahitza sartu da------------------");
			}
			e.printStackTrace();
		}

		return false;
	}

	public int compareTo(Erabiltzaile arg0) {
		//Aurre: arg0!=null
		//Post: zenbaki bat bueltatuko du, negatiboa sartutako erabiltzailearen izena honena baino aurretik badago alfabetikoki
		//positiboa bueltatuko du sartutako erabiltzailearen izena honena baino atzerago badago alfabetikoki
		//eta zero bien izenak berdinak direnean
		return this.izena.compareTo(arg0.getIzen());
	}

	public void gehituPuntuak(int pPuntuak) {
		puntuazioa = puntuazioa + pPuntuak;
		ErabiltzaileLista.getErabiltzaileLista().getKlasifikazioa().eguneratu();
	}

	public int getPuntuazioa() {
		return puntuazioa;
	}

	public String gorde(){
		String emaitza="";
		emaitza=emaitza+this.izena;
		emaitza=emaitza+",";
		emaitza=emaitza+this.ID;
		emaitza=emaitza+",";
		emaitza=emaitza+this.zifraPasahitz;
		emaitza=emaitza+",";
		emaitza=emaitza+this.pasahitza;
		emaitza=emaitza+",";
		emaitza=emaitza+this.azkenengoSudokua.gorde();
		emaitza=emaitza+",";
		emaitza=emaitza+this.puntuazioa;
		emaitza=emaitza+",";
		return emaitza;
	}
	public void kargatu(String pErab){
		String[] pEr=pErab.split(",");
		this.izena=pEr[0];
		this.ID=new Integer(pEr[1]);
		this.zifraPasahitz = (pEr[2]);
		this.pasahitza=pEr[3];
		this.azkenengoSudokua.kargatu(pEr[4]);
		this.puntuazioa=new Integer(pEr[5]);
	}

	public void inprimatuDatuak() {
		//Aurre:
		//Post: Erabiltzailearen datuak inprimatuko ditu
		System.out.println("Izena: "+this.izena);
		System.out.println("ID: "+this.ID);
		System.out.println("Puntuazioa: "+this.puntuazioa);
		System.out.println("Erabiltzailearen azken sudokua: ");
		this.azkenengoSudokua.inprimatuSudoku();
	}
	public void inprimatuDatuakSudokuGabe() {
		//Aurre:
		//Post: Erabiltzailearen datuak inprimatuko ditu
		System.out.println("Izena: "+this.izena);
		System.out.println("ID: "+this.ID);
		System.out.println("Puntuazioa: "+this.puntuazioa);
		//System.out.println("Erabiltzailearen azken sudokua: ");
		//this.azkenengoSudokua.inprimatuSudoku();
	}
	public void setSudoku(Sudokua pSudo){
		this.azkenengoSudokua=pSudo;
	}

	public int puntuatu(int laguntzaKop , boolean[][] zuzenketa) {
		boolean[][] sudo = zuzenketa;
		boolean zuzena = true;
		for (int i = 0; i < sudo.length; i++) {
			for (int j = 0; j < sudo.length; j++) {
				zuzena = sudo[i][j];
				if (!zuzena) break;
			}
			if (!zuzena) break;
		}
		
		int puntu = ((azkenengoSudokua.getZailtasuna()+1)*100)-(7*(azkenengoSudokua.getZailtasuna()+1)*laguntzaKop);
		System.out.println(puntu);
		if (zuzena&&puntu>0) {
			gehituPuntuak(puntu);
			return puntu;
		} else return 0;

	}

}
