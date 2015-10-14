package org.sudoku.sftwring;

import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;




public class SudokuLehioa{
	private Sudokua unekoSudoku;
	private static Erabiltzaile erabiltzailea;
	private JFrame frmSudokua;
	private JTextField[][] txtFMatrix;
	private JMenuBar menuBar;
	private JMenu mnOpzioak;
	private JMenuItem mntmGorde;
	private JMenuItem mntmZailtazunaAldatu;
	private JMenuItem mntmZuzendu;
	private int zenbatgarrena;
	private int tokatu;

	private JButton btnLaguntza;
	private JPanel panel_1;
	private int laguntzaKop;
	private JLabel lblZailtasuna;
	private JToggleButton btnSoinua;
	/**
	 * Launch the application.
	 */
	public static void main(final Erabiltzaile erab) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					erabiltzailea = erab;
					SudokuLehioa window = new SudokuLehioa(erab);
					window.frmSudokua.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SudokuLehioa(final Erabiltzaile erab) {
		laguntzaKop = 0;

		initialize(erab);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Erabiltzaile erab) {
		frmSudokua = new JFrame();
		frmSudokua.setTitle("SUDOKUA-"+erabiltzailea.getIzen());
		frmSudokua.setBounds(100, 100, 700, 619);
		frmSudokua.addWindowListener(new Kudeatzailea());

		menuBar = new JMenuBar();
		frmSudokua.setJMenuBar(menuBar);
		mnOpzioak = new JMenu("Opzioak");
		menuBar.add(mnOpzioak);

		mntmGorde = new JMenuItem("Gorde");
		mnOpzioak.add(mntmGorde);
		mntmGorde.addActionListener(new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//gorde
				Object[] opzioak={"Jolasten jarraitu","Sudokutik irten"};
				gorde();
				int baiEz = JOptionPane.showOptionDialog(
						frmSudokua, "Sudokua ondo gorde da!","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opzioak,null);

				if (JOptionPane.NO_OPTION == baiEz){
					//Sudokua itxi egingo da
					AukeratuLehioa.main(erabiltzailea);
					frmSudokua.dispose();
				} 
			}
		});


		mntmZailtazunaAldatu = new JMenuItem("Zailtazuna aldatu");
		mnOpzioak.add(mntmZailtazunaAldatu);
		mntmZailtazunaAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Zailtasuna aldatzeko aukera pantailaratu
				Object[] opzioak={"Bai","Ez"};
				int baiEz = JOptionPane.showOptionDialog(
						frmSudokua, "Zihur zailtasuna aldatu nahi duzula?\n(Zailtasuna aldatzen baduzu zailtasun handiagoko sudoku bat bakarrik aukeratu ahalko duzu)","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,opzioak,null);

				if (JOptionPane.OK_OPTION == baiEz){
					//Zailtasuna aukeratzeko ahukera
					int zailtasuna=unekoSudoku.getZailtasuna();
					int erantzun = -1;
					if(zailtasuna==2|| zailtasuna==1){
						Object[] opzioak2={"Zaila"};

						erantzun=JOptionPane.showOptionDialog(
								frmSudokua, "Autatu aukera:","Abisua", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,opzioak2,null);	
					}
					else if(zailtasuna==0){
						Object[] opzioak2={"Erdikoa","Zaila"};
						erantzun=JOptionPane.showOptionDialog(
								frmSudokua, "Autatu aukera:","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,opzioak2,null);

					}
					if (JOptionPane.YES_OPTION == erantzun){
						unekoSudoku=new SudokuAdapter();
						if (zailtasuna==0)unekoSudoku.ausazBete(1);
						else unekoSudoku.ausazBete(2);
						erabiltzailea.setSudoku(unekoSudoku);
					}else if(JOptionPane.NO_OPTION == erantzun){
						unekoSudoku=new SudokuAdapter();
						unekoSudoku.ausazBete(2);
						erabiltzailea.setSudoku(unekoSudoku);

					}
					frmSudokua.dispose();
					SudokuLehioa.main(erabiltzailea);
				}

			}
		});


		mntmZuzendu = new JMenuItem("Zuzendu");
		mnOpzioak.add(mntmZuzendu);
		mntmZuzendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Zihur zuzendu nahi duzula?Bai/Ez...
				Object[] opzioak={"Bai","Ez"};
				int baiEz = JOptionPane.showOptionDialog(
						frmSudokua, "Zihur zuzendu nahi duzula?\n(Zuzentzen baduzu ezingo duzu sudokua egiten jarraitu)","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,opzioak,null);

				if (JOptionPane.OK_OPTION == baiEz){
					//erabiltzailearen sudokua zuzendu
					zuzendu();
				}
			}
		});

		panel_1 = new JPanel();
		menuBar.add(panel_1);

		lblZailtasuna = new JLabel("");
		lblZailtasuna.setFont(new Font("EHUSerif", Font.BOLD, 18));
		panel_1.add(lblZailtasuna);

//		btnSoinua = new JToggleButton("Soinua");
//		menuBar.add(btnSoinua);
//		btnSoinua.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				try {
//					Clip sonido = AudioSystem.getClip();
//					try{
//					sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("sudoku_tema_bukley_160kbps.mp3")));
//					}catch(Exception e4){
//						System.err.println("Ezin izan da fitxeroa irakurri!");
//					}
//					if (e.getStateChange() == ItemEvent.SELECTED) {
//						try {
//							sonido.start();
//							Thread.sleep(108000);
//							itemStateChanged(e);
//						}
//						catch (Exception e1){
//
//						}
//					}else{
//						sonido.stop();
//					}
//				} catch (LineUnavailableException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
//			}
//		});





		btnLaguntza = new JButton("Laguntza");
		btnLaguntza.setBackground(menuBar.getBackground());
		menuBar.add(btnLaguntza);

		JPanel panel=new Panel("icon2.png");
		btnLaguntza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] opzioak={"Laguntza","Ez dut behar laguntzarik"};
				int baiEz = JOptionPane.showOptionDialog(
						frmSudokua,"Zihur Laguntza behar duzula?\n(Laguntza eskatzeak puntuak kentzen ditu)","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,opzioak,null);

				if (JOptionPane.OK_OPTION== baiEz){		
					try {
						markatuGorriz();

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		frmSudokua.setContentPane(panel);

		frmSudokua.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));

		txtFMatrix = new JTextField[9][9];

		int zutabe = 1;
		int lerro = 1;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				txtFMatrix[i][j] = new JTextField();
				txtFMatrix[i][j].setFont(new Font("EHUSerif", Font.BOLD, 40));
				txtFMatrix[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				txtFMatrix[i][j].addKeyListener(new Kudeatzailea(txtFMatrix[i][j]));
				txtFMatrix[i][j].setColumns(1);
				frmSudokua.getContentPane().add(txtFMatrix[i][j], (""+zutabe+", "+lerro+", fill, fill"));
				if (zutabe!=13) {
					if (zutabe==3||zutabe==8) zutabe = zutabe + 3;
					else zutabe++;
				} else zutabe = 1;
				txtFMatrix[i][j].setOpaque(false);
			}
			if (lerro!=13) {
				if (lerro==3||lerro==8) lerro = lerro + 3;
				else lerro++;
			} else lerro = 1;
		}


		unekoSudoku = erabiltzailea.getSudoku();
		if (unekoSudoku.getZailtasuna()==0) {
			lblZailtasuna.setText("Erraza");
			lblZailtasuna.setForeground(new Color(0, 128, 0));
		} else if (unekoSudoku.getZailtasuna()==1) {
			lblZailtasuna.setText("Erdikoa");
			lblZailtasuna.setForeground(new Color(255, 215, 0));
		} else {
			lblZailtasuna.setText("Zaila");
			lblZailtasuna.setForeground(new Color(255, 0, 0));
		}

		this.kargatu();

	}


	private class Kudeatzailea extends WindowAdapter implements ActionListener,KeyListener {

		JTextField txt;
		public Kudeatzailea(JTextField pTxt){
			txt=pTxt;
		}
		public Kudeatzailea(){
			super();
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if(!(e.getKeyChar()<'1' || e.getKeyChar()>'9')) e.consume();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			char caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if(((caracter < '1') ||(caracter > '9')) &&(caracter != '\b' /*corresponde a BACK_SPACE*/))
			{
				e.consume();  // ignorar el evento de teclado
			}
			if(txt.getText().length()==1 && txt.isEditable()){txt.setText("");}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			frmSudokua.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			Object[] opzioak={"Bai","Ez", "Ezeztatu"};
			int baiEz = JOptionPane.showOptionDialog(
					frmSudokua, "Irten aurretik sudokua gorde nahi duzu?","Abisua", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opzioak,null);

			if (JOptionPane.OK_OPTION == baiEz){
				//erabiltzaileak sudokua gorde
				gorde();

			}else if(JOptionPane.CANCEL_OPTION==baiEz){
				frmSudokua.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			}
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
		}

	}

	private void kargatu(){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Kasila kas = unekoSudoku.getKasila(i, j);
				if (kas.getBalioZuzena()!=0 && kas.getFinkoa()) {
					txtFMatrix[i][j].setText(""+kas.getBalioZuzena());
					txtFMatrix[i][j].setForeground(Color.BLUE);
					txtFMatrix[i][j].setEditable(false);
				}
				if (kas.getErabiltzaileBal()!=0) txtFMatrix[i][j].setText(""+kas.getErabiltzaileBal());
			}
		}
	}

	private void gorde() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (txtFMatrix[i][j].isEditable()) {
					if (!txtFMatrix[i][j].getText().equals(""))
						unekoSudoku.getKasila(i, j).aldatu(new Integer(txtFMatrix[i][j].getText()));
					else unekoSudoku.getKasila(i, j).aldatu(0);
				}
			}
		}
		erabiltzailea.setSudoku(unekoSudoku);
		ErabiltzaileLista.getErabiltzaileLista().gorde();
	}

	private void zuzendu() {
		gorde();
		boolean[][] zuzenketa = unekoSudoku.zuzendu();
		int puntu = erabiltzailea.puntuatu(laguntzaKop,zuzenketa);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!zuzenketa[i][j]) {
					txtFMatrix[i][j].setForeground(Color.RED);
					txtFMatrix[i][j].setText(""+unekoSudoku.getKasila(i, j).getBalioZuzena());
				}
				txtFMatrix[i][j].setEditable(false);
			}
		}

		unekoSudoku = new Sudokua();
		gorde();

		Object[] opzioak={"Menu Nagusia","Klasifikazioa"};
		int baiEz = JOptionPane.showOptionDialog(
				frmSudokua, puntu+" puntu lortu dituzu\nNora joan nahi duzu?","Abisua", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opzioak,null);

		if (JOptionPane.YES_OPTION == baiEz){
			//erabiltzaileak sudokua gorde
			frmSudokua.dispose();
			AukeratuLehioa.main(erabiltzailea);
			frmSudokua.remove(frmSudokua);

		}else if(JOptionPane.NO_OPTION==baiEz || JOptionPane.CLOSED_OPTION == baiEz){
			frmSudokua.dispose();
			KlasifikazioLehioa.main(erabiltzailea);
			frmSudokua.remove(frmSudokua);
		}
	}

	public void markatuGorriz() throws InterruptedException {
		laguntzaKop++;
		boolean bukatu=false;
		Random rand=new Random();
		int count=0;
		tokatu=rand.nextInt(3);
		zenbatgarrena=0;
		this.gorde();
		int i=-1;
		while (count<3 && !bukatu) {
			if(tokatu==0){
				i=erabiltzailea.getSudoku().laguntzaBloke();
				if(i!=-1){bukatu=true;zenbatgarrena=i;}
				else tokatu++;
				count++;
			}else if(tokatu==1){
				i=erabiltzailea.getSudoku().laguntzaZutabe();
				if(i!=-1){bukatu=true;zenbatgarrena=i;}
				else tokatu++;
				count++;
			}else{
				i=erabiltzailea.getSudoku().laguntzaIlarak();
				if(i!=-1){bukatu=true;zenbatgarrena=i;}
				else tokatu=0;
				count++;
			}
		}
		if(!bukatu){
			Object[] opzioak={"OK"};
			JOptionPane.showOptionDialog(frmSudokua, "Dena ondo!!!", "Ondo", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, opzioak, null);
		}
		else{
			TimerTask timerTask = new TimerTask()
			{	int count=0;
			public void run() {
				if(count==0 ){
					count++;
					if(tokatu==0){
						int o=0;
						if(zenbatgarrena<3)o=0;
						else if(zenbatgarrena<6)o=3;
						else o=6;
						int k=0;
						if(zenbatgarrena%3==0)k=0;
						else if(zenbatgarrena==1 ||zenbatgarrena==4 ||zenbatgarrena==7)k=3;
						else k=6;

						for (int i =o ; i <o+3; i++) {
							for (int j = k; j <k+3; j++) {
								txtFMatrix[i][j].setOpaque(true);
								txtFMatrix[i][j].setBackground(Color.red);					
							}
						}
					}else if(tokatu==1){
						for (int i = 0; i <9; i++) {
							txtFMatrix[i][zenbatgarrena].setOpaque(true);
							txtFMatrix[i][zenbatgarrena].setBackground(Color.red);
						}
					}else{
						for (int i = 0; i <9; i++) {
							txtFMatrix[zenbatgarrena][i].setOpaque(true);
							txtFMatrix[zenbatgarrena][i].setBackground(Color.red);	
						}
					}
				}else {
					tokatu=0;
					count++;
					for (int j = 0; j < 9; j++) {
						for (int k = 0; k < 9; k++) {
							txtFMatrix[j][k].setBackground(Color.white); 
							txtFMatrix[j][k].setOpaque(false);
						}
					}
					this.cancel();
				}
			}

			};
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(timerTask, 0, 2000);

		}

	}	
}	
