package bista;

import common.Mugimendu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
	private JPanel panel;
	private Mapa mapa;
	private Controler controler = null;
	private static JokoBista jb = null;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	private JokoBista() {
		setTitle("BOMBERMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		setVisible(true);
		
		this.mapa.jarriListenerrak();
		this.addKeyListener(getControler());
	}
	
	public static JokoBista getJokoBista()
	{
		if (jb == null)
			jb = new JokoBista();
		return (jb);
	}
	
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel() {
				private Image back = new ImageIcon(this.getClass().getResource("/bista/Sprites/stageBack1.png")).getImage();
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panel.setLayout(new GridLayout(11, 17, 0, 0));
			mapa = new Mapa(panel);
		}
		return panel;
	}
	
	public Mapa getMapa()
	{
		return (mapa);
	}
	
	//Kontroladorea
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	public void itxi()
	{
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	private class Controler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			//int[] pos = Matrizea.getMatrizea().getJokalariPos();
			Matrizea mat = Matrizea.getMatrizea();
			
			if(!mat.getJokalaria().getHilda()) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					mat.mugituJokalaria(Mugimendu.GORA);
					//jok.mugituGora();
					//jokalaria.mugituGora()
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					mat.mugituJokalaria(Mugimendu.BEHERA);
					//jok.mugituBehera();
					//jokalaria.mugituBehera()
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					mat.mugituJokalaria(Mugimendu.EZKER);
					//jok.mugituEzkerra();
					//jokalaria.mugituEzkerra()
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					mat.mugituJokalaria(Mugimendu.ESKUIN);
					//jok.mugituEskuma();
					//jokalaria.mugituEskuma()
				}
				if(e.getKeyCode() == KeyEvent.VK_B) {
					//bonba ipini
					mat.bonbaJarri();	
				}
				
			}
			
		}
		

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}
