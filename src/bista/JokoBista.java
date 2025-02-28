package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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
	
}
