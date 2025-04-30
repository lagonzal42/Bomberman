package bista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanelInstrukzioak extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInstrukzioak() {
		setLayout(new BorderLayout());
		JPanel panelIns = new JPanel();
		panelIns.setLayout(new BoxLayout(panelIns, BoxLayout.Y_AXIS));
		
		// TEKLAK
		JLabel teklakLabel = new JLabel("<html><b>TEKLAK:</b><br>"
		        + "B: bonba edo ultrabonda jarri.<br>"
		        + "P: bonba berezia jarri.<br>"
		        + "Geziak: mugitzeko.</html>");
		teklakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
		//PERTSONAIAK
		JLabel pertsonaiakLabel = new JLabel("<html><b>PERTSONAIAK:</b><br>"
		        + "Zuria: bonba normalak ditu eta berezi bat.<br>"
		        + "Beltza: ultrabonba du eta berezi bat.<br>"
		        + "Urdina: bietako bonba bat ager daiteke eta bonaba berezi bat du.</html>");
		pertsonaiakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// BONBAK
		JLabel bonbakLabel = new JLabel("<html><b>BONBAK:</b><br>"
		        + "Bonba normala: bere alboetan estanda egiten du.<br>"
		        + "Ultrabonba: dagoen fila osoan estanda egiten du.<br>"
		        + "Bonba berezia: alboan eta diagonaletan estanda egiten du, ez zaitu hiltzen eta bloke gogorrak <br> apurtzen ditu.</html>");
		bonbakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// MAPAK
		JLabel mapakLabel = new JLabel("<html><b>MAPAK:</b><br>"
		        + "Classic: Bloke gogorrak eta bigunak dituen mapa.<br>"
		        + "Soft: Bloke bigunak dituen mapa.<br>"
		        + "Empty: Blokerik gabeko mapa.</html>");
		mapakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// MAPAK
		JLabel etsaiakLabel = new JLabel("<html><b>ETSAIAK:</b><br>"
		        + "Larrosa: Etsai normalak, errazago hiltzeko.<br>"
		        + "Urdina: Etsai adimentsuak, jokalaria jarraitzen dute.</html>");
		etsaiakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		//JLabel panelean sartu
		panelIns.add(teklakLabel);
		panelIns.add(Box.createVerticalStrut(10));
		panelIns.add(pertsonaiakLabel);
		panelIns.add(Box.createVerticalStrut(10));
		panelIns.add(bonbakLabel);
		panelIns.add(Box.createVerticalStrut(10));
		panelIns.add(mapakLabel);
		panelIns.add(Box.createVerticalStrut(10));
		panelIns.add(etsaiakLabel);
		panelIns.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		add(panelIns, BorderLayout.WEST);
        
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
