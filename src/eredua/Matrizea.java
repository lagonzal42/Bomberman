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
			if (jok.getBonbaKop()>0) {	
				jok.bonbaKendu();
				jok.setBonba(new Bonba());
				gel.setBonba(jok.getBonba());
				gel.eguneratuGelaxka();
				System.out.println("Bonba jarri du ("+y+","+x+")");
			
				//timerra
				javax.swing.Timer errementa = new javax.swing.Timer(3000, e ->{
					System.out.println("Bonba apurtu da (" +y+","+x+")");
					gel.bonbaApurtu();
					blokeBigunakApurtu(y,x);
					//timerra2
					this.suaJarri(y, x);
					jok.setBonba(null);
					
				});
				errementa.setRepeats(false);
				errementa.start();
			}
			else {
				System.out.println("Ez daukazu bonbarik, itxaron 3 segundu");
				//bonba itxaroteko timerra
				javax.swing.Timer itxaron = new javax.swing.Timer(3000, e->{
					System.out.println("Bonba eskuragarri duzu");
					jok.bonbaGehitu();
				});
				itxaron.setRepeats(false);
				itxaron.start();
			}
		}

	}
	
	public void blokeBigunakApurtu(int x, int y) {
		apurtuBlokea(x,y+1);
		apurtuBlokea(x,y-1);
		apurtuBlokea(x+1,y);
		apurtuBlokea(x-1,y);
	}
	
	private void apurtuBlokea(int errenkada, int zutabea) {
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
		}
	}
	
	private void suaJarri(int errenkada, int zutabea) {
		Gelaxka gel = zerrenda[errenkada][zutabea];
		gel.setSua();
		gel.eguneratuGelaxka();
		javax.swing.Timer sua = new javax.swing.Timer(2000, o->{
			gel.deleteSua();
			if(blokeKop == 0) {
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
