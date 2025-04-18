package bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import eredua.JokoKudeatzailea;

public class PanelAmaiera extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAmaiera() {
		setLayout(new BorderLayout());
	}
	
	public void itxi(boolean pGaldu) {
		this.removeAll();
		JPanel guztia = new JPanel(new BorderLayout());
		guztia.setOpaque(false);
		JLabel label = new JLabel();
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel puntuazioa = new JLabel("Puntuazioa: " + JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().getPuntuak());
		puntuazioa.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		puntuazioa.setHorizontalAlignment(SwingConstants.CENTER);
		puntuazioa.setOpaque(false);
		guztia.add(label, BorderLayout.NORTH);
		guztia.add(puntuazioa, BorderLayout.SOUTH);
		if(pGaldu) {
			label.setText("BESTE BATEAN IZANGO DA.");
			ImageIcon iconTxarra = new ImageIcon(getClass().getResource("/bista/Sprites/amaieraitsusia.png"));
			JLabel irudiaTxarra = new JLabel(iconTxarra);
			irudiaTxarra.setHorizontalAlignment(SwingConstants.CENTER);
			guztia.add(irudiaTxarra, BorderLayout.CENTER);
			irudiaTxarra.setOpaque(false);
		}
		else {
			label.setText("ZORIONAK!!!");
			ImageIcon iconOna = new ImageIcon(getClass().getResource("/bista/Sprites/amaierapolita.png"));
			JLabel irudiaOna = new JLabel(iconOna);
			irudiaOna.setHorizontalAlignment(SwingConstants.CENTER);
			guztia.add(irudiaOna, BorderLayout.CENTER);
			irudiaOna.setOpaque(false);
		}
		add(guztia, BorderLayout.CENTER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image backAmaiera = new ImageIcon(getClass().getResource("/bista/Sprites/back2.png")).getImage();
		g.drawImage(backAmaiera, 0, 0, getWidth(), getHeight(), this);
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
