package eredua;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import bista.JokoBista;
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
		Gelaxka[][] zerrenda = new Gelaxka[lerroak][zutabeak];
		for(int i = 0; i < lerroak; i++) {
			for(int j = 0; j < zutabeak; j++) {
				if(j == 0 && i == 0) {
					//jokalaria
					zerrenda[i][j] = new Hutsik();
					((Hutsik)zerrenda[i][j]).setJokalaria(new Zuria());
					
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
	
	public void hasieratuBista()
	{
		for(int i = 0; i < lerroak; i++)
		{
			for(int j = 0; j < zutabeak; j++)
				zerrenda[i][j].eguneratuGelaxka();
		}
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
		int y = pos[0];
		int x = pos[1];
		
		if (zerrenda[y][x] instanceof Hutsik) {
			Hutsik gel = ((Hutsik)zerrenda [y][x]);
			//bonba jarri
			if(gel.getBonba() == null) {
				gel.setBonba(new Bonba());
				System.out.println("Bonba jarri du ("+y+","+x+")");
			}
			//timerra
			javax.swing.Timer errementa = new javax.swing.Timer(3000, e ->{
				System.out.println("Bonba apurtu da (" +y+","+x+")");
				gel.bonbaApurtu();
				blokeBigunakApurtu(y,x);
		
				javax.swing.Timer sua = new javax.swing.Timer(2000, o->{
					gel.deleteSua();
				});
				sua.setRepeats(false);
				sua.start();
				
			});
			errementa.setRepeats(false);
			errementa.start();
		}
	}
	
	public void blokeBigunakApurtu(int x, int y) {
		apurtuBlokea(x,y+1);
		apurtuBlokea(x,y-1);
		apurtuBlokea(x+1,y);
		apurtuBlokea(x-1,y);
	}
	
	private void apurtuBlokea(int errenkada, int zutabea) {
		if (errenkada >= 0 && errenkada <= 11 && zutabea >= 0 && zutabea <= 17) {
			if (zerrenda [errenkada][zutabea] instanceof Biguna) {
				zerrenda[errenkada][zutabea]=new Hutsik();
				zerrenda [errenkada][zutabea].eguneratuGelaxka();
				
			}
		}
	}
	
}
