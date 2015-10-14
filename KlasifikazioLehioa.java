package org.sudoku.sftwring;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.AbstractListModel;

public class KlasifikazioLehioa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static KlasifikazioLehioa frame;
	private static Erabiltzaile erabiltzailea;

	public static void main(final Erabiltzaile erab) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new KlasifikazioLehioa(erab);
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
	private JList<String> KlasifikazioaList;
	private JButton btnHasiera;

	public KlasifikazioLehioa(Erabiltzaile erab) {
		ErabiltzaileLista.getErabiltzaileLista().getKlasifikazioa().eguneratu();
		erabiltzailea = erab;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel KlasifikazioPanel = new JPanel();

		JLabel Klasifikazioalabel = new JLabel("Klasifikazioa");
		Klasifikazioalabel.setForeground(new Color(0, 100, 0));
		Klasifikazioalabel.setFont(new Font("EHUSerif", Font.BOLD, 22));

		JScrollPane klasifikazioaScrollPane = new JScrollPane();
		GroupLayout gl_KlasifikazioPanel = new GroupLayout(KlasifikazioPanel);
		gl_KlasifikazioPanel.setHorizontalGroup(
				gl_KlasifikazioPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_KlasifikazioPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_KlasifikazioPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(Klasifikazioalabel)
								.addComponent(klasifikazioaScrollPane, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
								.addContainerGap())
				);
		gl_KlasifikazioPanel.setVerticalGroup(
				gl_KlasifikazioPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_KlasifikazioPanel.createSequentialGroup()
						.addGap(6)
						.addComponent(Klasifikazioalabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(klasifikazioaScrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addContainerGap())
				);

		AbstractListModel<String> model = lortuKlasifikazioarenModeloa(ErabiltzaileLista.getErabiltzaileLista().getKlasifikazioa());
		KlasifikazioaList = new JList<String>(model);
		KlasifikazioaList.setCellRenderer(new ListaRenderizatzailea(erabiltzailea, ErabiltzaileLista.getErabiltzaileLista().getKlasifikazioa()));

		klasifikazioaScrollPane.setViewportView(KlasifikazioaList);
		KlasifikazioPanel.setLayout(gl_KlasifikazioPanel);

		btnHasiera = new JButton("Hasierako Menua");
		btnHasiera.setFont(new Font("EHUSerif", Font.BOLD, 20));
		btnHasiera.addActionListener(new Kudeatzailea());

		JLabel lblErabInfo = new JLabel(erabiltzailea.getIzen()+" - "+erabiltzailea.getPuntuazioa()+" puntu");
		lblErabInfo.setForeground(new Color(128, 0, 128));
		lblErabInfo.setFont(new Font("EHUSerif", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(lblErabInfo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(KlasifikazioPanel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(btnHasiera)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblErabInfo)
					.addGap(5)
					.addComponent(KlasifikazioPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHasiera)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private DefaultListModel<String> lortuKlasifikazioarenModeloa(Klasifikazioa klasf) {
		//Aurre: klasf!=null
		//Post: sarrerako klasifikazioak dituen erabiltzaile guztiak hartu eta pantailaratzeko eran jarriko ditu:
		//int(zenbatgarrena). erabiltzaile_izena - puntuazioa p.
		DefaultListModel<String> model = new DefaultListModel<String>();
		ArrayList<Erabiltzaile> erabKlsf = klasf.erabiltzaileenListaKlasifikatorian();

		int index = 1;
		for (Erabiltzaile erab : erabKlsf) {
			String iespazioak = "   ";
			String eespazioak = "   ";
			String despazioak = "   ";

			for (int i = 0; i < 6-((int)Math.log10(index)+1); i++) {
				iespazioak = iespazioak + "   ";
			}
			for (int i = 0; i < 6-(erab.getIzen().length()); i++) {
				eespazioak = eespazioak + "   ";
			}
			double punt = erab.getPuntuazioa();
			if (punt == 0) punt++;

			for (int i = 0; i < 6-((int)Math.log10(punt)+1); i++) {
				eespazioak = eespazioak + "   ";
			}
			model.addElement(index+"."+iespazioak+erab.getIzen()+eespazioak+erab.getPuntuazioa()+despazioak+"puntu");
			index++;
		}
		return model;
	}

	private class Kudeatzailea extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Aurre: objetuari lotutako akzioa egitea
			//Post : AukeratuLehioa zabalduko du eta hau zarratu
			frame.dispose();
			AukeratuLehioa.main(erabiltzailea);
			frame.remove(frame);
		}

	}

	private class ListaRenderizatzailea extends DefaultListCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Erabiltzaile erabiltzaile;
		private Klasifikazioa klsf;

		public ListaRenderizatzailea(Erabiltzaile erab, Klasifikazioa pKlsf) {
			setOpaque(true);
			erabiltzaile = erab;
			klsf = pKlsf;
		}

		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			//Aurre:
			//Post: JListaren barruko klasifikazioari formatua emango dio eta sartutako erabiltzailea gorriz
			setText(value.toString());
			setFont(new Font("EHUSerif", Font.BOLD, 18));
			if (index == klsf.emanErabHonenPos(erabiltzaile)){
				setForeground(new Color(128, 0, 128));

			} else setForeground(new Color(105, 105, 105));

			return this;
		}

	}
}
