package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eredua.SemaforoKudeatzailea;
import eredua.Biguna;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Jokalari;
import eredua.Matrizea;

public class JokoBista extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel panel;

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
		getPanel().setLayout(new GridLayout(11, 17, 0, 0));
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(6, 0, 0, 0));
		}
		return panel;
	}
	
	private void initialize() {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 17; j ++) {
				panel.add(new JPanel());
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 17; j++) {
				Gelaxka gel = Matrizea.getMatrizea().getGelaxka(i, j);
				if(gel instanceof Jokalari) {
					//TODO
				}
				else if(gel instanceof Gogorra) {
					//TODO
				}
				else if(gel instanceof Biguna) {
					//TODO
				}
				else {
					//TODO
				}
			}
		}
		
	}
}
