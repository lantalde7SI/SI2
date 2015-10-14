package org.sudoku.sftwring;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AukeratuLehioa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static AukeratuLehioa frame;
	private ButtonGroup zailtasunak;
	private JRadioButton rdbtnErraza;
	private JRadioButton rdbtnErdikoa;
	private JRadioButton rdbtnZaila;
	private JLabel lblZailtasuna;
	private JPanel jokatuPanel;
	private JLabel lblSudokuGordeta;
	private JButton btnSudokuBerria;
	private JButton btnJokatu;
	private Erabiltzaile erabiltzaile;
	private JLabel lblErabizen;
	private JPanel infoPanel;
	private JLabel lblPuntuazioa;
	private JLabel lblError;
	private JPanel sudopanel;
	private JTextField[][] txtFMatrix;


	public static void main(final Erabiltzaile erab) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AukeratuLehioa(erab);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AukeratuLehioa(Erabiltzaile erab) {
		setTitle("Menua");
		erabiltzaile = erab;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel zailtasunakPanel = new JPanel();

		jokatuPanel = new JPanel();

		infoPanel = new JPanel();
		
		JButton btnKlask = new JButton("Klasifikazioa");
		btnKlask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				KlasifikazioLehioa.main(erabiltzaile);
			}
		});
		btnKlask.setFont(new Font("EHUSerif", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(jokatuPanel, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(30)
								.addComponent(zailtasunakPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnKlask)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnKlask)
					.addGap(29)
					.addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(zailtasunakPanel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jokatuPanel, GroupLayout.PREFERRED_SIZE, 476, Short.MAX_VALUE)
					.addContainerGap())
		);
		infoPanel.setLayout(new MigLayout("", "[85px][][][][][][]", "[19px][]"));

		lblErabizen = new JLabel(erabiltzaile.getIzen());
		infoPanel.add(lblErabizen, "cell 6 0,alignx right,aligny top");
		lblErabizen.setForeground(new Color(128, 0, 128));
		lblErabizen.setFont(new Font("EHUSerif", Font.BOLD, 28));

		lblPuntuazioa = new JLabel(erabiltzaile.getPuntuazioa()+" puntu");
		lblPuntuazioa.setFont(new Font("EHUSerif", Font.BOLD, 18));
		lblPuntuazioa.setForeground(new Color(128, 0, 128));
		infoPanel.add(lblPuntuazioa, "cell 6 1");

		lblSudokuGordeta = new JLabel("");
		lblSudokuGordeta.setForeground(new Color(139, 0, 139));
		lblSudokuGordeta.setFont(new Font("EHUSerif", Font.BOLD, 20));

		btnJokatu = new JButton("Jokatu");
		btnJokatu.setFont(new Font("EHUSerif", Font.BOLD, 26));
		btnJokatu.addActionListener(new Kudeatzailea(false));

		String icon = "icon2.png";
		boolean baduSudokurik = begiratuSudokurikBadu();
		if (!baduSudokurik) icon ="icon3.png";

		sudopanel = new Panel(icon);
		GroupLayout gl_jokatuPanel = new GroupLayout(jokatuPanel);
		gl_jokatuPanel.setHorizontalGroup(
				gl_jokatuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jokatuPanel.createSequentialGroup()
						.addGroup(gl_jokatuPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_jokatuPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(sudopanel, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING, gl_jokatuPanel.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblSudokuGordeta, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, gl_jokatuPanel.createSequentialGroup()
														.addGap(93)
														.addComponent(btnJokatu)))
														.addContainerGap())
				);
		gl_jokatuPanel.setVerticalGroup(
				gl_jokatuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jokatuPanel.createSequentialGroup()
						.addContainerGap(25, Short.MAX_VALUE)
						.addComponent(lblSudokuGordeta, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(sudopanel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnJokatu)
						.addGap(40))
				);

		kargatu(baduSudokurik);

		jokatuPanel.setLayout(gl_jokatuPanel);
		contentPane.setLayout(gl_contentPane);




		zailtasunak = new ButtonGroup();


		lblZailtasuna = new JLabel("Zailtasuna:");
		lblZailtasuna.setFont(new Font("EHUSerif", Font.BOLD, 22));

		rdbtnErraza = new JRadioButton("Erraza");
		rdbtnErraza.setFont(new Font("EHUSerif", Font.BOLD, 19));
		rdbtnErraza.setForeground(new Color(0, 128, 0));
		zailtasunak.add(rdbtnErraza);


		rdbtnErdikoa = new JRadioButton("Erdikoa");
		rdbtnErdikoa.setForeground(new Color(255, 215, 0));
		rdbtnErdikoa.setFont(new Font("EHUSerif", Font.BOLD, 20));
		zailtasunak.add(rdbtnErdikoa);

		rdbtnZaila = new JRadioButton("Zaila");
		rdbtnZaila.setFont(new Font("EHUSerif", Font.BOLD, 20));
		rdbtnZaila.setForeground(new Color(255, 0, 0));
		zailtasunak.add(rdbtnZaila);


		btnSudokuBerria = new JButton("Sudoku Berria");
		btnSudokuBerria.setFont(new Font("EHUSerif", Font.BOLD, 20));
		btnSudokuBerria.addActionListener(new Kudeatzailea(true));

		lblError = new JLabel("");
		lblError.setFont(new Font("EHUSerif", Font.BOLD, 16));
		lblError.setForeground(Color.RED);
		GroupLayout gl_zailtasunakPanel = new GroupLayout(zailtasunakPanel);
		gl_zailtasunakPanel.setHorizontalGroup(
				gl_zailtasunakPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_zailtasunakPanel.createSequentialGroup()
						.addContainerGap(53, Short.MAX_VALUE)
						.addComponent(btnSudokuBerria)
						.addGap(41))
						.addGroup(Alignment.LEADING, gl_zailtasunakPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblError, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
								.addContainerGap())
								.addGroup(Alignment.LEADING, gl_zailtasunakPanel.createSequentialGroup()
										.addGap(118)
										.addGroup(gl_zailtasunakPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(rdbtnZaila, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtnErraza, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
												.addComponent(rdbtnErdikoa))
												.addContainerGap(39, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, gl_zailtasunakPanel.createSequentialGroup()
														.addGap(48)
														.addComponent(lblZailtasuna)
														.addContainerGap(105, Short.MAX_VALUE))
				);
		gl_zailtasunakPanel.setVerticalGroup(
				gl_zailtasunakPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_zailtasunakPanel.createSequentialGroup()
						.addContainerGap(29, Short.MAX_VALUE)
						.addComponent(lblZailtasuna)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(rdbtnErraza)
						.addGap(7)
						.addComponent(rdbtnErdikoa)
						.addGap(7)
						.addComponent(rdbtnZaila)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSudokuBerria)
						.addGap(24))
				);
		zailtasunakPanel.setLayout(gl_zailtasunakPanel);
		begiratuSudokurikBadu();
	}
	private class Kudeatzailea extends WindowAdapter implements ActionListener {

		private boolean sudokuBerria;

		public Kudeatzailea(boolean pSudokuBerria) {
			sudokuBerria = pSudokuBerria;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Sudokua pSudo=new SudokuAdapter();
			if (sudokuBerria) {
				if (rdbtnErraza.isSelected()||rdbtnErdikoa.isSelected()||rdbtnZaila.isSelected()) {
					if(rdbtnErraza.isSelected()){
						pSudo.ausazBete(0);
					}else if(rdbtnErdikoa.isSelected()){
						pSudo.ausazBete(1);
					}else if(rdbtnZaila.isSelected()){
						pSudo.ausazBete(2);	
					}
					erabiltzaile.setSudoku(pSudo);
					SudokuLehioa.main(erabiltzaile);
					frame.setVisible(false);
				}else {
					lblError.setText("Zailtasuna aukeratu barik");
				}

			} else {
				if (erabiltzaile.getSudoku().getKasila(0, 0).getBalioZuzena()!=0) {
					SudokuLehioa.main(erabiltzaile);
					frame.dispose();
				} else 
					lblSudokuGordeta.setForeground(Color.RED);
			}

		}

	}
	private boolean begiratuSudokurikBadu() {
		//konprobatu ea baduen eta izaten badu jarri beztela ez duela jarri
		if (erabiltzaile.getSudoku().getKasila(0, 0).getBalioZuzena()==0){
			lblSudokuGordeta.setText("Ez duzu sudokurik gordeta");
			return false;
		} else {
			lblSudokuGordeta.setText("Sudoku hau duzu amaitzeko");
			return true;
		}
	}

	public static void ikustarazi() {
		//Aurre:
		//Post: Sarrerako lehioa berriz ikustaraziko du.
		frame.setVisible(true);
	}

	private void kargatu(boolean sudoBadu){
		sudopanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				FormFactory.DEFAULT_ROWSPEC,
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
				txtFMatrix[i][j].setFont(new Font("EHUSerif", Font.BOLD, 25));
				txtFMatrix[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				txtFMatrix[i][j].setColumns(1);
				sudopanel.add(txtFMatrix[i][j], (""+zutabe+", "+lerro+", fill, fill"));
				if (zutabe!=13) {
					if (zutabe==3||zutabe==8) zutabe = zutabe + 3;
					else zutabe++;
				} else zutabe = 1;
				txtFMatrix[i][j].setOpaque(false);
				txtFMatrix[i][j].setEditable(false);
			}
			if (lerro!=13) {
				if (lerro==3||lerro==8) lerro = lerro + 3;
				else lerro++;
			} else lerro = 1;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Kasila kas = erabiltzaile.getSudoku().getKasila(i, j);
				if (kas.getBalioZuzena()!=0 && kas.getFinkoa()) {
					txtFMatrix[i][j].setText(""+kas.getBalioZuzena());
					txtFMatrix[i][j].setForeground(Color.BLUE);
				}
				if (kas.getErabiltzaileBal()!=0) txtFMatrix[i][j].setText(""+kas.getErabiltzaileBal());
			}
		}
	}
}