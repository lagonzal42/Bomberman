package bista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.Mugimendu;
import eredua.Matrizea;

public class PanelJokoa extends JPanel implements PanelEgoera{

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

	@Override
	public void teklaSakatuta(KeyEvent e) {
		Matrizea mat = Matrizea.getMatrizea();
		
		if(!mat.getEreduMapa().partidaBukatu() && !mat.getEreduMapa().getJokalaria().getHilda()) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				mat.getEreduMapa().mugituJokalaria(Mugimendu.GORA);
				break;
			case KeyEvent.VK_DOWN:
				mat.getEreduMapa().mugituJokalaria(Mugimendu.BEHERA);
				break;
			case KeyEvent.VK_LEFT:
				mat.getEreduMapa().mugituJokalaria(Mugimendu.EZKER);
				break;
			case KeyEvent.VK_RIGHT:
				mat.getEreduMapa().mugituJokalaria(Mugimendu.ESKUIN);
				break;
			case KeyEvent.VK_B:
				mat.getEreduMapa().bonbaJarri();	
				break;	
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
			}
		}
		
		
	}

}
