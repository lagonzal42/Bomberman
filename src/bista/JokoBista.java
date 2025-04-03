package bista;

import common.Mugimendu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eredua.Biguna;
import eredua.Dadoa;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Jokalaria;
import eredua.Matrizea;
import soinua.Bozgorailua;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class JokoBista extends JFrame{
	//orokorra
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private Controler controler = null;
	private static JokoBista jb = null;
	private Mapa mapa;
	private int unekoPanela = -1;
	
	//Jokoa
	private PanelJokoa panelJokoa = new PanelJokoa();
	private Image backJokoa;
	private boolean musikaOn = false;
	
	//hasiera
	private PanelHasiera panelHasiera = new PanelHasiera();
	private int aukeratutakoPertsonaia = 1;
	
	//amaiera
	private PanelAmaiera panelAmaiera = new PanelAmaiera();

	/**
	 * Create the frame.
	 */
	private JokoBista() {
		setTitle("BOMBERMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
//		irudiakKargatu();
//		
//		panelHasiera = getPanelHasiera();
//		panelJokoa = getPanelJokoa();
		
		mainPanel.add(panelHasiera, "Hasiera");
		mainPanel.add(panelJokoa, "Jokoa");
		mainPanel.add(panelAmaiera, "Amaiera");
		
		getContentPane().add(mainPanel);
		setVisible(true);
		
		panelJokoa.getMapa().jarriListenerrak();
		this.addKeyListener(getControler());
		cardLayout.show(mainPanel, "Hasiera");
		unekoPanela = 0;//hasierako panela
	}
	

	public static JokoBista getJokoBista()
	{
		if (jb == null)
			jb = new JokoBista();
		return (jb);
	}
	
	
//	private JPanel getPanelJokoa() {
//		if (panelJokoa == null) {
//			panelJokoa = new JPanel() {
//				private Image back = new ImageIcon(this.getClass().getResource("/bista/Sprites/stageBack1.png")).getImage();
//				protected void paintComponent(Graphics g) {
//					super.paintComponent(g);
//					g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
//				}
//			};
//			panelJokoa.setLayout(new GridLayout(11, 17, 0, 0));
//			mapa = new Mapa(panelJokoa);
//		}
//		return panelJokoa;
//	}
	
	public Mapa getMapa()
	{
		return (mapa);
	}
	
	//TODO:Aldatu cardLayout-ekin
	public void itxi(boolean pGaldu)
	{
		panelAmaiera.itxi(pGaldu);
		cardLayout.show(mainPanel, "Amaiera");
		unekoPanela = 2;
	}
	//Kontroladorea
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(unekoPanela == 0) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						//TODO: aukeratu hurrengo pertsonaia
						if(aukeratutakoPertsonaia -1 == 1) {
							aukeratutakoPertsonaia --;
							panelHasiera.setAukeratutakoPertsonaia(aukeratutakoPertsonaia);
						}
						break;
					case KeyEvent.VK_RIGHT:
						if(aukeratutakoPertsonaia + 1 == 2) {
							aukeratutakoPertsonaia ++;
							panelHasiera.setAukeratutakoPertsonaia(aukeratutakoPertsonaia);
						}
						break;
					case KeyEvent.VK_M:
						Bozgorailua musika = Bozgorailua.getBozgorailua();
						if (musikaOn) {
							musika.getMusika().pausatu();
							musikaOn = false;
						}
						else {
							musika.getMusika().hasi();
							musikaOn = true;
						}
						break;
					case KeyEvent.VK_O:
						//TODO:jokoa erabakitzeko
						break;
					case KeyEvent.VK_ESCAPE:
						System.exit(0);;
						break;
					case KeyEvent.VK_SPACE:
						int aukeratutakoMapa = panelHasiera.getAukeratutakoMapa();
						System.out.println(aukeratutakoMapa + " "+ aukeratutakoPertsonaia);
						cardLayout.show(mainPanel, "Jokoa");
						unekoPanela = 1;
						break;
				}
			}
			else if(unekoPanela == 1) {
				//int[] pos = Matrizea.getMatrizea().getJokalariPos();
				Matrizea mat = Matrizea.getMatrizea();
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
					mat.mugituJokalaria(Mugimendu.GORA);
					break;
				case KeyEvent.VK_DOWN:
					mat.mugituJokalaria(Mugimendu.BEHERA);
					break;
				case KeyEvent.VK_LEFT:
					mat.mugituJokalaria(Mugimendu.EZKER);
					break;
				case KeyEvent.VK_RIGHT:
					mat.mugituJokalaria(Mugimendu.ESKUIN);
					break;
				case KeyEvent.VK_B:
					mat.bonbaJarri();	
					break;	
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				}
			}
			
		}
		

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}