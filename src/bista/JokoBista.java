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
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
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
import eredua.JokoKudeatzailea;
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
	private PanelEgoera panelEgoera;
	
	//Jokoa
	private PanelJokoa panelJokoa = new PanelJokoa();
	
	//hasiera
	private PanelHasiera panelHasiera = new PanelHasiera();
	
	//amaiera
	private PanelAmaiera panelAmaiera = new PanelAmaiera();
	
	//opzioen panela
	private PanelOptions panelOptions = new PanelOptions();
	
	private PanelRecords panelRecords = new PanelRecords();
	private PanelInstrukzioak panelIns = new PanelInstrukzioak();

	/**
	 * Create the frame.
	 */
	private JokoBista() {
		setTitle("BOMBERMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		panelEgoera = panelHasiera;
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
//		irudiakKargatu();
//		
//		panelHasiera = getPanelHasiera();
//		panelJokoa = getPanelJokoa();
		
		mainPanel.add(panelHasiera, "Hasiera");
		mainPanel.add(panelJokoa, "Jokoa");
		mainPanel.add(panelAmaiera, "Amaiera");
		mainPanel.add(panelOptions, "Options");
		mainPanel.add(panelRecords, "Records");
		mainPanel.add(panelIns, "Instrukzioak");
		
		getContentPane().add(mainPanel);
		setVisible(true);
		
		//panelJokoa.getMapa().jarriListenerrak();
		this.addKeyListener(getControler());
		cardLayout.show(mainPanel, "Hasiera");
	}
	

	public static JokoBista getJokoBista()
	{
		if (jb == null)
			jb = new JokoBista();
		return (jb);
	}
	
	public Mapa getMapa()
	{
		return (mapa);
	}
	
	public void setPanelJokoaFondoa(int pFondoa) {
		this.panelJokoa.fondoaAldatu(pFondoa);
	}
	
	//TODO:Aldatu cardLayout-ekin
	public void itxi(boolean pGaldu)
	{
		panelAmaiera.itxi(pGaldu);
		this.aldatuPanela("Amaiera");
	}
	
	public void aldatuPanela(String panela) {
		cardLayout.show(mainPanel, panela);
		switch(panela) {
		case("Hasiera"):
			JokoKudeatzailea.getJokoKudeatzaileaa().mapaErreseteatu();
			Bozgorailua.getBozgorailua().musikaReset();
			panelEgoera = panelHasiera;
			break;
		case("Options"):
			panelEgoera = panelOptions;
			break;
		case("Records"):
			try {
				panelRecords.hasieratu();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			panelEgoera = panelRecords;
			break;
		case("Instrukzioak"):
			panelEgoera = panelIns;
			break;
		case("Jokoa"):
			panelEgoera = panelJokoa;
			panelJokoa.getMapa().jarriListenerrak();
			Bozgorailua.getBozgorailua().jarriListenerrak();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().hasieratuBista();
			break;
		case("Amaiera"):
			panelEgoera = panelAmaiera;
			break;
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
		public void keyReleased(KeyEvent e) {
			
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			panelEgoera.teklaSakatuta(e);
		}

	}
	
}
