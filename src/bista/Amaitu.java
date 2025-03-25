package bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Amaitu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private static Amaitu amaitu= null;

	/**
	 * Create the frame.
	 */
	private Amaitu(String pMezua) {
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().add(getLblNewLabel(pMezua), BorderLayout.CENTER);

	}
	public static Amaitu getIrabazi() {
		if(amaitu == null) {
			amaitu = new Amaitu("ZORIONAK!!");
		}
		return amaitu;
	}
	public static Amaitu getGaldu() {
		if(amaitu == null) {
			amaitu = new Amaitu("Beste batean izango da");
		}
		return amaitu;
	}

	private JLabel getLblNewLabel(String pMezua) {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(pMezua);
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
}
