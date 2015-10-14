package org.sudoku.sftwring;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ErregistroLehioa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */

	private JPasswordField passwordField;
	private JTextField textFieldErabIzen;
	private JPasswordField passwordFieldErrepikatu;
	private JLabel lblErrorea;
	private JToggleButton tglbtnIkusi;
	private JButton btnErrejistratu;
	private JButton btnAtzera;

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (args.length!=2) frame = new ErregistroLehioa("","");
					else frame = new ErregistroLehioa(args[0],args[1]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErregistroLehioa(String pErabIzen, String pPasahitz) {
		setTitle("Erregistratu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel erregistroPanel = new JPanel();

		JLabel lblErregistratu = new JLabel("Erregistratu");
		lblErregistratu.setFont(new Font("EHUSerif", Font.BOLD, 18));

		btnAtzera = new JButton("<---");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Aurre: <-- botoia sakatzea
				//Post : errejistro lehioa izkutatu eta sarrera lehioa ikustarazi
				frame.setVisible(false);
				frame.remove(frame);
				SarrerakoLehioa.ikustarazi();


			}
		});
		btnAtzera.setFont(new Font("EHUSerif", Font.BOLD, 15));
		btnAtzera.setForeground(new Color(0, 0, 139));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(13)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(erregistroPanel, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblErregistratu)
										.addPreferredGap(ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
										.addComponent(btnAtzera, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
										.addGap(2))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblErregistratu)
								.addComponent(btnAtzera, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(erregistroPanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				);
		erregistroPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblErabiltzaileIzena = new JLabel("Erabiltzaile izena:");
		lblErabiltzaileIzena.setFont(new Font("EHUSerif", Font.BOLD, 14));
		erregistroPanel.add(lblErabiltzaileIzena, "2, 4, right, default");

		textFieldErabIzen = new JTextField(pErabIzen);
		textFieldErabIzen.setFont(new Font("EHUSerif", Font.PLAIN, 14));
		erregistroPanel.add(textFieldErabIzen, "4, 4, fill, default");
		textFieldErabIzen.setColumns(10);
		textFieldErabIzen.addKeyListener(new Kudeatzailea());

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setFont(new Font("EHUSerif", Font.BOLD, 14));
		erregistroPanel.add(lblPasahitza, "2, 6, right, default");

		passwordField = new JPasswordField(pPasahitz);
		passwordField.setFont(new Font("EHUSerif", Font.PLAIN, 14));
		erregistroPanel.add(passwordField, "4, 6, fill, default");
		passwordField.addKeyListener(new Kudeatzailea());

		tglbtnIkusi = new JToggleButton("Ikusi");
		tglbtnIkusi.addItemListener(new Kudeatzailea());
		tglbtnIkusi.setFont(new Font("EHUSerif", Font.BOLD, 14));
		erregistroPanel.add(tglbtnIkusi, "6, 6");

		JLabel lblErrepikatuPasahitza = new JLabel("Errepikatu pasahitza:");
		lblErrepikatuPasahitza.setFont(new Font("EHUSerif", Font.BOLD, 14));
		erregistroPanel.add(lblErrepikatuPasahitza, "2, 8");

		passwordFieldErrepikatu = new JPasswordField();
		passwordFieldErrepikatu.setFont(new Font("EHUSerif", Font.PLAIN, 14));
		erregistroPanel.add(passwordFieldErrepikatu, "4, 8, fill, default");
		passwordFieldErrepikatu.addKeyListener(new Kudeatzailea());

		lblErrorea = new JLabel("");
		lblErrorea.setFont(new Font("EHUSerif", Font.PLAIN, 12));
		lblErrorea.setForeground(new Color(255, 0, 0));
		erregistroPanel.add(lblErrorea, "4, 10, 7, 5");

		btnErrejistratu = new JButton("Errejistratu");
		btnErrejistratu.setFont(new Font("EHUSerif", Font.BOLD, 14));
		erregistroPanel.add(btnErrejistratu, "4, 16");
		btnErrejistratu.addActionListener(new Kudeatzailea());
		contentPane.setLayout(gl_contentPane);
	}

	private class Kudeatzailea extends WindowAdapter implements ActionListener, KeyListener, ItemListener {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//Aurre: objetuari lotutako akzioa egitea
			//Post : erregistratu() egingo du
			erregistratu();
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			//Aurre: botoren bat sakatzea
			//Post: ENTER sakatutakoan erregistratu() egingo du, besteren bat sakatuz gero ez du ezer egingo
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				erregistratu();
			}
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			//Aurre: atsitutako 'item'ak aldaketa bat jasaten du
			//Post: Lehenengo aldaketa SELECTED modoan badago goiko pasahitzeko karaktereak erakutziko dira eta berriz aldatuz gero berriz izkutatu
			if (arg0.getStateChange() == ItemEvent.SELECTED) {
				passwordField.setEchoChar((char)0);
			} else {
				passwordField.setEchoChar('\u2022'); // bullet edo puntu potoloa passworda ezkutatzeko
			}

		}

		private void erregistratu() {
			//Aurre:
			//Post: lehenengo textFieldErabIzen hutsik dagoen ikusiko du eta hutsik badago errore mezu bat bidali eta 12 karaktere baino gehiago baditu ere errore mezu bat itzuliko du
			//bestela erabiltzailea erabiltzaileListan jada exititzen den begiratuko du eta existitzen bada errore mezu bat bidali
			//bestela bi pasahitzetatik goikoan, sartutako pasahitzak bost karaktere baño gutxiago baditu errore mezu bat bidaliko du
			//bestela sartutako pasahitz biak desberdinak badira errore mezu bat bidaliko du eta beheko errepikapena ezabatu egingo du
			//azkenean beste guztia ondo badago erailtzailea gehituko du erabiltzaileListan

			if (textFieldErabIzen.getText().isEmpty() || textFieldErabIzen.getText().length() > 12) {
				if (textFieldErabIzen.getText().isEmpty())
					lblErrorea.setText("Erabiltzaile izena bete gabe dago");
				else
					lblErrorea.setText("Izenak gehienez 12 karaktere izan ditzake");
			} else {

				if (ErabiltzaileLista.getErabiltzaileLista().badago(textFieldErabIzen.getText())) {
					lblErrorea.setText("Erabiltzaile izen hau jada erregistratuta dago");
				} else {
					if (passwordField.getPassword().length < 5) {
						lblErrorea.setText("Pasahitzak gutxienez 5 karaktere behar ditu");
					} else {
						lblErrorea.setText("");
						String password = String.copyValueOf(passwordField.getPassword());
						String passwordErrep = String.copyValueOf(passwordFieldErrepikatu.getPassword());

						if (password.equals(passwordErrep)) {

							ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile(textFieldErabIzen.getText(), password);
							Erabiltzaile erab = ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile(textFieldErabIzen.getText(), String.copyValueOf(passwordField.getPassword()));

							if (erab==null) {
								lblErrorea.setText("Erabiltzaile izena edo pasahitza okerra");
							} else {
								ErabiltzaileLista.getErabiltzaileLista().gorde();
								lblErrorea.setText("");
								frame.setVisible(false);

								AukeratuLehioa.main(erab);
							}
						} else {
							lblErrorea.setText("Pasahitzak ez dira berdinak");
							passwordFieldErrepikatu.setText("");
						}
					}
				}
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

	}
}
