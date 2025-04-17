package bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
	private JButton b3;

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
		b1 = this.botoiaSortu("Klasikoa");
		b2 = this.botoiaSortu("POP");
		b3 = this.botoiaSortu("HEAVY");
		JLabel e1 = new JLabel("");
		JLabel e2 = new JLabel("");
		JLabel e3 = new JLabel("");
		JLabel e4 = new JLabel("");
		JLabel e5 = new JLabel("");
		JLabel e6 = new JLabel("");
		JLabel e7 = new JLabel("");
		
		erdikoPanela.add(e1);
		erdikoPanela.add(e2);
		erdikoPanela.add(e3);
		erdikoPanela.add(b1);
		erdikoPanela.add(b2);
		erdikoPanela.add(b3);
		erdikoPanela.add(e5);
		erdikoPanela.add(e6);
		erdikoPanela.add(e7);
		add(erdikoPanela, BorderLayout.CENTER);
		JLabel atera = new JLabel("pantailatik ateratzeko spc sakatu.");
		atera.setHorizontalAlignment(SwingConstants.CENTER);
		add(atera,BorderLayout.SOUTH);
		
	}
	
	private JButton botoiaSortu(String pBotoia) {
		JButton botoia = new JButton();
		botoia.addActionListener(getControler());
		botoia.setOpaque(false);
		botoia.setText(pBotoia);
		botoia.setHorizontalTextPosition(SwingConstants.CENTER);
		botoia.setVerticalTextPosition(SwingConstants.BOTTOM);
		botoia.setContentAreaFilled(false);
		botoia.setBorderPainted(false);
		ImageIcon icon = new ImageIcon(getClass().getResource("/bista/Sprites/"+pBotoia +".png"));
		Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		botoia.setIcon(resizedIcon);
		botoia.setFocusPainted(false);
		botoia.setFocusable(false);
		return botoia;
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
			else if(e.getSource().equals(b3)) {
				Bozgorailua.getBozgorailua().musikaAldatu("heavy");
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
