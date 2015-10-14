package org.sudoku.sftwring;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon irudia;
	String izena;

	public Panel(String pIzena){
		this.izena=pIzena;
	}
	public void paint(Graphics g){
		Dimension tamaina=getSize();
		irudia=new ImageIcon(getClass().getResource(izena));
		g.drawImage(irudia.getImage(),0,0, tamaina.width,tamaina.height,null);
		setOpaque(false);
		super.paint(g);
	}

}
