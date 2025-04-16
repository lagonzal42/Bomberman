package bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import soinua.Bozgorailua;

public class PanelOptions extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;
	private Controler controler;
	private JButton b1;
	private JButton b2;

	/**
	 * Create the panel.
	 */
	public PanelOptions() {
		setLayout(new BorderLayout());
		setOpaque(false);
		gehituOsagaiak();
	}

	private void gehituOsagaiak() {
		JLabel titleLabel = new JLabel("Musika");
		titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel erdikoPanela = new JPanel();
		erdikoPanela.setLayout(new GridLayout(3,3));
		JLabel e1 = new JLabel("");
		b1 = new JButton("Klasikoa");
		JLabel e2 = new JLabel("");
		JLabel e3 = new JLabel("");
		b2 = new JButton("Pop");
		JLabel e4 = new JLabel("");
		JLabel e5 = new JLabel("");
		JLabel e6 = new JLabel("");
		JLabel e7 = new JLabel("");
		
		b1.addActionListener(getControler());
		b1.setFocusPainted(false);
		b1.setFocusable(false);
		b1.setBorderPainted(true);
		
		b2.addActionListener(getControler());
		b2.setFocusPainted(false);
		b2.setFocusable(false);
		b2.setBorderPainted(true);
		
		erdikoPanela.add(e1);
		erdikoPanela.add(b1);
		erdikoPanela.add(e2);
		erdikoPanela.add(e5);
		erdikoPanela.add(e6);
		erdikoPanela.add(e7);
		erdikoPanela.add(e3);
		erdikoPanela.add(b2);
		erdikoPanela.add(e4);
		add(erdikoPanela, BorderLayout.CENTER);
		JLabel atera = new JLabel("pantailatik ateratzeko spc sakatu.");
		atera.setHorizontalAlignment(SwingConstants.CENTER);
		add(atera,BorderLayout.SOUTH);
		
	}

	private ActionListener getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(b1)) {
				Bozgorailua.getBozgorailua().musikaAldatu("classic");
			}
			else if (e.getSource().equals(b2)){
				Bozgorailua.getBozgorailua().musikaAldatu("pop");				
			}
			
		}
		
	}
	@Override
	public void teklaSakatuta(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			JokoBista.getJokoBista().aldatuPanela("Hasiera");
			break;
		}
	}

}
