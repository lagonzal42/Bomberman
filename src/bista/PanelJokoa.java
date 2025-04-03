package bista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJokoa extends JPanel {

	private static final long serialVersionUID = 1L;
	private Mapa mapa;

	/**
	 * Create the panel.
	 */
	public PanelJokoa() {
		setLayout(new GridLayout(11,17,0,0));
		setOpaque(false);
		mapa = new Mapa(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image back = new ImageIcon(this.getClass().getResource("/bista/Sprites/stageBack1.png")).getImage();
        g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
    }
	
	public Mapa getMapa() {
		return mapa;
	}

}
