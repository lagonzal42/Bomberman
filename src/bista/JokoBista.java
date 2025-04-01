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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class JokoBista extends JFrame{

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private JPanel panelJokoa;
	private JPanel panelHasiera;
	private JPanel mainPanel;
	private Mapa mapa;
	private Controler controler = null;
	private static JokoBista jb = null;
	private Image titulua;
	private Image backHasiera;
	private Image[] pertsonaiak;
	private Image backJokoa;
	private int unekoPanela = -1;

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
		
		irudiakKargatu();
		
		panelHasiera = getPanelHasiera();
		panelJokoa = getPanelJokoa();
		
		mainPanel.add(panelHasiera, "Hasiera");
		mainPanel.add(panelJokoa, "Jokoa");
		
		getContentPane().add(mainPanel);
		setVisible(true);
		
		this.mapa.jarriListenerrak();
		this.addKeyListener(getControler());
		cardLayout.show(mainPanel, "Hasiera");
		unekoPanela = 0;//hasierako panela
	}
	

	private void irudiakKargatu() {
		backHasiera = new ImageIcon(getClass().getResource("/bista/Sprites/back.png")).getImage();
		titulua = new ImageIcon(getClass().getResource("/bista/Sprites/title.png")).getImage();
		pertsonaiak = new Image[3];
		for (int i = 1; i < pertsonaiak.length; i++) {
			pertsonaiak[i] = new ImageIcon(getClass().getResource("/bista/Sprites/bomber"+i+".png")).getImage();
		}
	}


	public static JokoBista getJokoBista()
	{
		if (jb == null)
			jb = new JokoBista();
		return (jb);
	}
	
	private JPanel getPanelHasiera() {
		if (panelHasiera == null) {
			panelHasiera = new JPanel() {
				private Image back = backHasiera;
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panelHasiera.setLayout(new BorderLayout());
			
			//hasierako panelaren goikaldean tituluaren irudia jartzen du(zentroan)
			JLabel titleLabel = new JLabel(new ImageIcon(titulua));
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			panelHasiera.add(titleLabel, BorderLayout.NORTH);
			
			//erdian elementu bat baino gehiago egon ahal izateko panel bat sortu
			JPanel erdikoPanela = new JPanel();
			erdikoPanela.setLayout(new GridLayout(2,1,0,0));
			erdikoPanela.setOpaque(false);
			
			//jokalaria erabakitzeko textua
			JLabel erabaki = new JLabel("<Jokalaria erabaki -><- geziekin>");
			erabaki.setFont(new Font("Arial",Font.PLAIN,24));
			erabaki.setForeground(Color.BLACK);
			erabaki.setHorizontalAlignment(SwingConstants.CENTER);
			erabaki.setVerticalAlignment(SwingConstants.NORTH);
			erdikoPanela.add(erabaki);
			
			//Jokalarien irudiak erakutzi
			JPanel pertsonaienPanela = new JPanel(new GridLayout(1,2,0,0));
			pertsonaienPanela.setOpaque(false);
			for(int i = 1; i < pertsonaiak.length; i++) {
				ImageIcon icon = new ImageIcon(pertsonaiak[i]);
				JLabel perLabel = new JLabel(icon);
				perLabel.setVerticalAlignment(SwingConstants.NORTH);
				pertsonaienPanela.add(perLabel);
			}
			erdikoPanela.add(pertsonaienPanela);
			
			panelHasiera.add(erdikoPanela, BorderLayout.CENTER);
			
			//Mezua jarri
			JLabel mezua = new JLabel("<space> to start, <m>usic, <o>ptions && <esc> to exit");
			mezua.setFont(new Font("Arial", Font.PLAIN, 18));
            mezua.setForeground(Color.BLACK);
            mezua.setHorizontalAlignment(SwingConstants.CENTER);
            panelHasiera.add(mezua, BorderLayout.SOUTH);
			
		}
		return panelHasiera;
	}
	
	private JPanel getPanelJokoa() {
		if (panelJokoa == null) {
			panelJokoa = new JPanel() {
				private Image back = new ImageIcon(this.getClass().getResource("/bista/Sprites/stageBack1.png")).getImage();
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panelJokoa.setLayout(new GridLayout(11, 17, 0, 0));
			mapa = new Mapa(panelJokoa);
		}
		return panelJokoa;
	}
	
	public Mapa getMapa()
	{
		return (mapa);
	}
	
	//TODO:Aldatu cardLayout-ekin
	public void itxi(boolean pGaldu)
	{
		//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		this.dispose();
		if(pGaldu) {
			Amaitu galdu = Amaitu.getGaldu();			
		}
		else {
			Amaitu irabazi = Amaitu.getIrabazi();	
		}
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
						break;
					case KeyEvent.VK_SPACE:
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
				}
			}
			
		}
		

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}
