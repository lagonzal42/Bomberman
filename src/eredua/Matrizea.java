package eredua;

import bista.JokoBista;
import common.Mugimendu;

public class Matrizea{
	
	private static Matrizea nMatrizea = null;
	private Gelaxka[][] zerrenda;
	private int lerroak = 11;
	private int zutabeak = 17;
	private Jokalaria jok;
	private int blokeKop;
	private int etsaiKop;
	private boolean amaitu = false;
	
	private Matrizea() {
		blokeKop = 0;
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
				zerrenda[i][j] = new Gelaxka();
				if(j == 0 && i == 0) {
					//jokalaria
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setJokalaria(new Zuria());
					
				}
				else if((j == 0 && i == 1) || (j == 1 && i == 0)) {
					//hutsik
					zerrenda[i][j].setBlokea(new Hutsik()); 
				}
				else if((j % 2 != 0 && i % 2 != 0)) {
					//bloke gogorra
					zerrenda[i][j].setBlokea(new Gogorra()); 
				}
				else if(dado.gainditzenDu(0.4)){
					//bloke biguna
					zerrenda[i][j].setBlokea(new Biguna());
					blokeKop++;
				}
				//proba kutre
				else if(dado.gainditzenDu(0.9) && etsaiKop < 7) {
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setEtsaia(new Etsaia(j,i));
					etsaiKop ++;
				}
				else {
					//hutsik
					zerrenda[i][j].setBlokea(new Hutsik());
				}
			}
		}
		return zerrenda;
	}
	
	public void hasieratuBista()
	{
		JokoBista.getJokoBista();
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
	
	public Jokalaria getJokalaria() {
		return jok;
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
		int y = jok.getY();
		int x = jok.getX();
		
		if (zerrenda[y][x].hutsikDago()) {
			Gelaxka gel = zerrenda [y][x];
			//bonba jarri
			Bonba bon = jok.getBonba();
			if (bon != null) {
				gel.setBonba(bon);
				gel.eguneratuGelaxka();
				System.out.println("Bonba jarri du ("+y+","+x+")");
			
				//timerra
				javax.swing.Timer errementa = new javax.swing.Timer(3000, e ->{
					System.out.println("Bonba apurtu da (" +y+","+x+")");
					gel.bonbaApurtu();
					blokeBigunakApurtu(y,x);
					//timerra2
					this.suaJarri(y, x);
					//jok.setBonba(null);
					
				});
				errementa.setRepeats(false);
				errementa.start();
			}
		}

	}
	
	public void blokeBigunakApurtu(int x, int y) {
		int estaldura = jok.bonbaEstaldura;
		//eskuma
		for (int kont=0; kont<=10; kont ++) {
			if (!apurtuBlokea(x,y+kont)) break;
		}
		//ezkerreta
		for (int kont=0; kont<=10; kont ++) {
			if (!apurtuBlokea(x,y-kont)) break;
		}
		//gora
		for (int kont=0; kont<=10; kont ++) {
			if (!apurtuBlokea(x+kont,y)) break;
		}
		//behera
		for (int kont=0; kont<=10; kont ++) {
			if(!apurtuBlokea(x-kont,y)) break;
		}
	}
	
	private boolean apurtuBlokea(int errenkada, int zutabea) {
		if (errenkada >= 0 && errenkada < 11 && zutabea >= 0 && zutabea < 17) {
			Gelaxka gel = zerrenda[errenkada][zutabea];
			if (gel.getBlokea() instanceof Biguna) {
				gel.setBlokea(new Hutsik());
				this.suaJarri(errenkada, zutabea);
				System.out.println("blokea apurtu da:"+ errenkada +","+ zutabea);
				blokeKop--;
			}
			else if (gel.hutsikDago()) {
				this.suaJarri(errenkada, zutabea);
			}
			if (gel.getBlokea() instanceof Gogorra) {
				return false;
			}
		}
		return true;
	}
	
	private void suaJarri(int errenkada, int zutabea) {
		Gelaxka gel = zerrenda[errenkada][zutabea];
		gel.setSua();
		gel.eguneratuGelaxka();
		javax.swing.Timer sua = new javax.swing.Timer(2000, o->{
			gel.deleteSua();
			if(etsaiKop == 0) {
				amaitu = true;
			}
			gel.eguneratuGelaxka();
		});
		sua.setRepeats(false);
		sua.start();
		
	}
	
	public boolean partidaBukatu()
	{
		return amaitu;
	}
	
}
