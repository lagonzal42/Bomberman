package eredua;

import bista.JokoBista;
import common.Mugimendu;

public abstract class EreduMapa {
	Gelaxka[][] gelaxkak;
	protected int lerroak = 11;
	protected int zutabeak = 17;
	protected int blokeKop;
	protected int etsaiKop;
	protected Jokalaria jok;

	
	public Jokalaria getJokalaria()
	{
		return (jok);
	}
	
	public void hasieratuBista()
	{
		for(int i = 0; i < lerroak; i++)
		{
			for(int j = 0; j < zutabeak; j++)
				gelaxkak[i][j].eguneratuGelaxka();
		}
	}
	
	public Gelaxka getGelaxka(int i, int j){
		if(i < 0 || j < 0 || i > 10 || j > 16) {
			return null;
		}
		return this.gelaxkak[i][j];
	}
	
	public void bonbaJarri()
	{
		int y = jok.getY();
		int x = jok.getX();
		
		if (gelaxkak[y][x].hutsikDago()) {
			Gelaxka gel = gelaxkak [y][x];
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
		//eskumata
		for (int kont=0; kont<=estaldura; kont ++) {
			if (!apurtuBlokea(x,y+kont)) break;
		}
		//ezkerreta
		for (int kont=0; kont<=estaldura; kont ++) {
			if (!apurtuBlokea(x,y-kont)) break;
		}
		//gora
		for (int kont=0; kont<=estaldura; kont ++) {
			if (!apurtuBlokea(x+kont,y)) break;
		}
		//behera
		for (int kont=0; kont<=estaldura; kont ++) {
			if(!apurtuBlokea(x-kont,y)) break;
		}
	}
	
	private boolean apurtuBlokea(int errenkada, int zutabea) {
		if (errenkada >= 0 && errenkada < 11 && zutabea >= 0 && zutabea < 17) {
			Gelaxka gel = gelaxkak[errenkada][zutabea];
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
		Gelaxka gel = gelaxkak[errenkada][zutabea];
		gel.setSua();
		gel.eguneratuGelaxka();
		javax.swing.Timer sua = new javax.swing.Timer(2000, o->{
			gel.deleteSua();
			gel.eguneratuGelaxka();
		});
		sua.setRepeats(false);
		sua.start();
		
	}
	
	public void etsaiakMurriztu() {
		etsaiKop --;
	}
	
	public void etsaiakGelditu() {
		for(int i = 0; i < lerroak; i++)
		{
			for(int j = 0; j < zutabeak; j++)
				if(gelaxkak[i][j].getEtsaia() != null)
					gelaxkak[i][j].getEtsaia().geldituEtsaia();
		}
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
}
