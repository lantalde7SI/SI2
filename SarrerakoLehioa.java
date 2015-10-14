package org.sudoku.sftwring;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

public class SarrerakoLehioa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static SarrerakoLehioa frame = new SarrerakoLehioa();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	JLabel lblOngietorria;
	final JLabel lblErrorea;
	final JButton btnSartu;
	JPanel loginPanel;
	JLabel lblErregistratu;
	JLabel lblIcon;

	public SarrerakoLehioa() {
		setTitle("Sarrera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblOngietorria = new JLabel("Ongi etorri Sagarra taldearen Sudokura");
		lblOngietorria.setFont(new Font("EHUSerif", Font.BOLD, 19));
		lblOngietorria.setForeground(new Color(0, 128, 0));



		lblErrorea = new JLabel();
		lblErrorea.setForeground(Color.RED);
		lblErrorea.setFont(new Font("EHUSerif", Font.PLAIN, 12));

		btnSartu = new JButton("Sartu");

		btnSartu.setFont(new Font("EHUSerif", Font.BOLD, 14));

		loginPanel = new JPanel();

		lblErregistratu = new JLabel("Erregistratu");
		lblErregistratu.addMouseListener(new Kudeatzailea() {

		});
		lblErregistratu.setFont(new Font("EHUSerif", Font.ITALIC, 14));
		lblErregistratu.setForeground(Color.BLUE);

		lblIcon = new JLabel("icon");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(16)
										.addComponent(lblOngietorria, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(28)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblErregistratu)
																		.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGap(168)
																				.addComponent(btnSartu)))
																				.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
																				.addGroup(gl_contentPane.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(lblErrorea, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(ComponentPlacement.RELATED)))
																						.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
																						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(11)
						.addComponent(lblOngietorria, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(30)
										.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblErrorea, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addGap(24)
												.addComponent(btnSartu)
												.addGap(24)
												.addComponent(lblErregistratu)
												.addGap(16))
				);

		lblIcon.setText("");
		lblIcon.setIcon(sortuImageIcon("icon1.png", "icon1.png"));

		loginPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblErabIzena = new JLabel("Erabiltzaile izena:");
		loginPanel.add(lblErabIzena, "2, 2");
		lblErabIzena.setFont(new Font("EHUSerif", Font.BOLD, 14));

		textField = new JTextField();
		loginPanel.add(textField, "4, 2");
		textField.setFont(new Font("EHUSerif", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.addKeyListener(new Kudeatzailea());

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		loginPanel.add(lblPasahitza, "2, 4");
		lblPasahitza.setFont(new Font("EHUSerif", Font.BOLD, 14));

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new Kudeatzailea());
		loginPanel.add(passwordField, "4, 4");
		passwordField.setFont(new Font("EHUSerif", Font.PLAIN, 14));
		contentPane.setLayout(gl_contentPane);

		btnSartu.addActionListener(new Kudeatzailea());

		try {
			ErabiltzaileLista.getErabiltzaileLista().kargatu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ImageIcon sortuImageIcon(String path, String deskribapena) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, deskribapena);
		} else {
			lblIcon.setText("Ezin izan da fitxategi hau aurkitu: " + path);
			return null;
		}
	}

	private class Kudeatzailea extends WindowAdapter implements ActionListener, KeyListener, MouseListener {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//Aurre: objetuari lotutako akzioa egitea
			//Post : login() egingo du
			login();
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			//Aurre: botoren bat sakatzea
			//Post: ENTER sakatutakoan login() egingo du, besteren bat sakatuz gero ez du ezer egingo
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				login();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) { //Errejistroa egiteko linka
			//Aurre: click egitea
			//Post: Momentu horretan textField eta passwordField barruan sartuta dagoena emango zaio 
			//erregistroko lehioari sorreran eta hau zabaldu egingo da sarrerako lehioa izkutatu ondoren
			frame.dispose();
			String[] args = new String[2];
			args[0] = textField.getText();
			args[1] = String.copyValueOf(passwordField.getPassword());
			ErregistroLehioa.main(args);
		}

		private void login() {
			//Aurre:
			//Post:Izena eta pasahitza ondo dauden begiratu, txarto egon ezkero
			//errore mezua emango du. 

			Erabiltzaile erab = ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile(textField.getText(), String.copyValueOf(passwordField.getPassword()));

			if (erab==null) {
				lblErrorea.setText("Erabiltzaile izena edo pasahitza okerra");
			} else {
				lblErrorea.setText("");
				frame.dispose();

				AukeratuLehioa.main(erab);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public static void ikustarazi() {
		//Aurre:
		//Post: Sarrerako lehioa berriz ikustaraziko du.
		frame.setVisible(true);
	}
}

