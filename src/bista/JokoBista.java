package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class JokoBista extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel[][] mapa;
	private Controler controler = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokoBista frame = new JokoBista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JokoBista() {
		setTitle("BOMBERMAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		setVisible(true);
		Matrizea mat = Matrizea.getMatrizea();
		mat.addObserver(this);
		update(mat, null);
		
		this.addKeyListener(getControler());
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
			initialice();
		}
		return panel;
	}
	private void initialice() {
		mapa = new JPanel[11][17];
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 17; j++) {
				mapa[i][j] = new JPanel();
				mapa[i][j].setOpaque(false);
				mapa[i][j].setLayout(new BorderLayout()); // Para centrar la imagen
	            JLabel label = new JLabel();
	            label.setOpaque(false);
	            mapa[i][j].add(label);
	            panel.add(mapa[i][j]);
			}
		}
	}
	

	@Override
	public void update(Observable o, Object arg) {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 17; j++) {
				Gelaxka gel = Matrizea.getMatrizea().getGelaxka(i, j);
				JLabel lbl = (JLabel) mapa[i][j].getComponent(0);
				
				if(gel instanceof Jokalaria) {
					lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/whitedown1.png")));
				}
				else if(gel instanceof Gogorra) {
					//TODO
					lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/hard5.png")));
				}
				else if(gel instanceof Biguna) {
					//TODO
					lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/soft4" + Dadoa.getNireDadoa().zenbakiaAukeratu(1, 6) +".png")));
				}
				else {
					//TODO
					lbl.setIcon(null);
				}
			}
		}
	}
	
	private boolean bigunaDa(int errenkada, int zutabea) {
		return Matrizea.getMatrizea().getGelaxka(errenkada, zutabea) instanceof Biguna;
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
			int[] pos = Matrizea.getMatrizea().getJokalariPos();
			Jokalaria jok = Matrizea.getMatrizea().getJokalaria();
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				JLabel lbl = (JLabel) mapa[pos[0]][pos[1]].getComponent(0);
				lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/whiteup1.png")));
				jok.mugituGora();
				//jokalaria.mugituGora()
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				JLabel lbl = (JLabel) mapa[pos[0]][pos[1]].getComponent(0);
				lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/whitedown1.png")));
				jok.mugituBehera();
				//jokalaria.mugituBehera()
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				JLabel lbl = (JLabel) mapa[pos[0]][pos[1]].getComponent(0);
				lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/whiteleft1.png")));
				jok.mugituEzkerra();
				//jokalaria.mugituEzkerra()
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				JLabel lbl = (JLabel) mapa[pos[0]][pos[1]].getComponent(0);
				lbl.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/whiteright1.png")));
				jok.mugituEskuma();
				//jokalaria.mugituEskuma()
			}
			if(e.getKeyCode() == KeyEvent.VK_B) {
				//bonba ipini
				JLabel lbl = (JLabel) mapa[pos[0]][pos[1]].getComponent(0);
				JLabel bonbaLabel = new JLabel(new ImageIcon(this.getClass().getResource("/bista/Sprites/bomb1.png")));
				mapa[pos[0]][pos[1]].add(bonbaLabel);
				//timerra hasi
				bonbaLabel.setIcon(new ImageIcon(this.getClass().getResource("/bista/Sprites/kaBomb0.png")));
				//timerra amaitu
				blokeBigunakApurtu(pos[0],pos[1]);
				mapa[pos[0]][pos[1]].remove(bonbaLabel);	
			}
		}
		
		public void blokeBigunakApurtu(int errenkada, int zutabea) {
			if (bigunaDa(errenkada,zutabea+1)){
				blokeaEzabatu(errenkada,zutabea+1);
			}
			if (bigunaDa(errenkada,zutabea-1)){
				blokeaEzabatu(errenkada,zutabea-1);
			}
			if (bigunaDa(errenkada+1,zutabea)){
				blokeaEzabatu(errenkada+1,zutabea);
			}
			if (bigunaDa(errenkada-1,zutabea)){
				blokeaEzabatu(errenkada-1,zutabea);
			}
		}
		
		public void blokeaEzabatu(int errenkada, int zutabea) {
			Matrizea.getMatrizea().ezabatu(errenkada, zutabea);
			JLabel lbl= (JLabel) mapa[errenkada][zutabea].getComponent(0);
			lbl.setIcon(null);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
}
