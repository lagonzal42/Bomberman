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
		
		// JOLASA
		JLabel jolasaLabel = new JLabel("<html><b>NOLA IRABAZI?:</b><br>"
		        + "Bonbekin blokeak kendu eta etsai guztiak hil ondoren, giltza lortu eta mapatik atera irabazteko.<br>"
		        + "Etsai bat edo bonbaren sua jokalaria harrapetzen badu, galduko du.</html>");
		jolasaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// TEKLAK
		JLabel teklakLabel = new JLabel("<html><b>TEKLAK:</b><br>"
		        + "B: bonba edo ultrabonda jarri.<br>"
		        + "P: bonba berezia jarri.<br>"
		        + "Geziak: mugitzeko.</html>");
		teklakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
		// PERTSONAIAK
		JLabel pertsonaiakLabel = new JLabel("<html><b>PERTSONAIAK:</b><br>"
		        + "Zuria: bonba normalak ditu eta berezi bat.<br>"
		        + "Beltza: ultrabonba du eta berezi bat.<br>"
		        + "Urdina: bietako bonba bat ager daiteke eta bonaba berezi bat du.</html>");
		pertsonaiakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// BONBAK
		JLabel bonbakLabel = new JLabel("<html><b>BONBAK:</b><br>"
		        + "Bonba normala: bere alboetan eztanda egiten du.<br>"
		        + "Ultrabonba: dagoen fila osoan eztanda egiten du.<br>"
		        + "Bonba berezia: alboan eta diagonaletan eztanda egiten du, ez zaitu hiltzen eta bloke gogorrak <br> apurtzen ditu.</html>");
		bonbakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// MAPAK
		JLabel mapakLabel = new JLabel("<html><b>MAPAK:</b><br>"
		        + "Classic: Bloke gogorrak eta bigunak dituen mapa.<br>"
		        + "Soft: Bloke bigunak dituen mapa.<br>"
		        + "Empty: Blokerik gabeko mapa.</html>");
		mapakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// ETSAIAK
		JLabel etsaiakLabel = new JLabel("<html><b>ETSAIAK:</b><br>"
		        + "Larrosa: Etsai normalak, errazago hiltzeko.<br>"
		        + "Urdina: Etsai adimentsuak, jokalaria jarraitzen dute.</html>");
		etsaiakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// JLabel panelean sartu
		panelIns.add(jolasaLabel);
		panelIns.add(Box.createVerticalStrut(10));
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
		
		// PANTAILATU
		JScrollPane scrollPane = new JScrollPane(panelIns);
		add(scrollPane, BorderLayout.WEST);
        
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
