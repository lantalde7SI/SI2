package org.sudoku.sftwring;

import java.util.LinkedList;

public class Adabegia<T> {

	protected T content;
	protected int sakonera;
	protected Adabegia<T> gurasoa;
	protected LinkedList<Adabegia<T>> semea;

	public Adabegia(T elem, int zenb){
		this.content = elem;
		this.sakonera = zenb;
		this.semea = new LinkedList<Adabegia<T>>();
	}

	public Adabegia<T> gehituSemea(T elem,int zenb){
		Adabegia<T> semeAdabegi = new Adabegia<T>(elem,zenb);
		this.semea.addLast(semeAdabegi);
		return semeAdabegi;
	}

	public Adabegia<T> ezabatuSemea (T elem){
		for (int i = 0; i < this.semea.size(); i++) {
			Adabegia<T>unekoa = this.semea.removeFirst();
			if (!unekoa.content.equals(elem)) {
				this.gehituSemea(unekoa.content, unekoa.sakonera);
			}
			else{return unekoa;}
		}
		return null;
	}

}
