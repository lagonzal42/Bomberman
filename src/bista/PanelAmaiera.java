package bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAmaiera extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAmaiera() {
		setLayout(new BorderLayout());
	}
	
	public void itxi(boolean pGaldu) {
		if(pGaldu) {
			JLabel label = new JLabel("BESTE BATEAN IZANGO DA.");
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label, BorderLayout.CENTER);
		}
		else {
			JLabel label = new JLabel("ZORIONAK!!!");
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label, BorderLayout.CENTER);		
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image backAmaiera = new ImageIcon(getClass().getResource("/bista/Sprites/back2.png")).getImage();
		g.drawImage(backAmaiera, 0, 0, getWidth(), getHeight(), this);
	}

}
