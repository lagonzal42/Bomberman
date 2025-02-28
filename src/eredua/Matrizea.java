package eredua;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Matrizea extends Observable{
	
	private static Matrizea nMatrizea = null;
	private Gelaxka[][] zerrenda;
	private int lerroak = 11;
	private int zutabeak = 17;
	
	private Matrizea() {
		this.zerrenda = matrizeaSortu();
		setChanged();
		notifyObservers();
	}
	
	public static Matrizea getMatrizea() {
		if(nMatrizea == null) {
			nMatrizea = new Matrizea();
		}
		return nMatrizea;
	}
	
	//private izan behar du.
	private Gelaxka[][] matrizeaSortu() {
		Dadoa dado = Dadoa.getNireDadoa();
		Gelaxka[][] zerrenda = new Gelaxka[11][17];
		for(int i = 0; i < lerroak; i++) {
			for(int j = 0; j < zutabeak; j++) {
				if(j == 0 && i == 0) {
					//jokalaria
					zerrenda[i][j] = new Jokalaria();
				}
				else if((j == 0 && i == 1) || (j == 1 && i == 0)) {
					//hutsik
					zerrenda[i][j] = new Hutsik();
				}
				else if((j % 2 != 0 && i % 2 != 0)) {
					//bloke gogorra
					zerrenda[i][j] = new Gogorra();
				}
				else if(dado.gainditzenDu(0.4)){
					//bloke biguna
					zerrenda[i][j] = new Biguna();
				}
				else {
					//hutsik
					zerrenda[i][j] = new Hutsik();
				}
			}
		}
		return zerrenda;
	}
	
	public Gelaxka getGelaxka(int i, int j){
		return this.zerrenda[i][j];
	}
	
	public void ezabatu(int i, int j) {
		this.zerrenda[i][j] = new Hutsik();
	}
	
	
}
