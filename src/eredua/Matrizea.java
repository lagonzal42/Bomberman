package eredua;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import common.Mugimendu;

public class Matrizea{
	
	private static Matrizea nMatrizea = null;
	private Gelaxka[][] zerrenda;
	private int lerroak = 11;
	private int zutabeak = 17;
	private Jokalaria jok;
	
	private Matrizea() {
		this.zerrenda = matrizeaSortu();
		this.jok = new Zuria();
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
					zerrenda[i][j] = new Hutsik();
					zerrenda[i][j].setJokalaria(true);
					
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
		if(i < 0 || j < 0 || i > 10 || j > 16) {
			return null;
		}
		return this.zerrenda[i][j];
	}
	
	public void ezabatu(int i, int j) {
		this.zerrenda[i][j] = new Hutsik();
	}
	
	public int[] getJokalariPos(){
		int[] pos = new int[2];
		pos[0] = jok.getY();
		pos[1] = jok.getX();
		return pos;
	}
	public Jokalaria getJokalaria() {
		return jok;
	}
	
	public void aldatuPos(int j1, int i1, int j2, int i2) {
		this.zerrenda[i2][j2] = this.zerrenda[i1][j1];
		this.ezabatu(i1, j1);
	}
	
	public void mugituJokalaria(Mugimendu mugimendu)
	{
		switch (mugimendu)
		{
			case GORA:
				jok.mugituGora();
				break;
			case BEHERA:
				jok.mugituBehera();
				break;
			case EZKER:
				jok.mugituEzkerra();
				break;
			case ESKUIN:
				jok.mugituEskuma();
				break;
		}
		jok.printPosizio();
	}
	
	public void bonbaJarri() {
		int [] pos=getJokalariPos();
		int x = pos[0];
		int y = pos[1];
		
		Gelaxka gel = zerrenda [x][y];
		
		if(!gel.getBonba()) {
			gel.setBonba(true);
			System.out.println("Bonba jarri du ("+x+","+y+")");
			
			//bonba apurtu + timerra
		}
	}
	
}
