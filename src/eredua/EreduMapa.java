package eredua;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import bista.JokoBista;
import common.Mugimendu;

public abstract class EreduMapa {
	protected Gelaxka[][] gelaxkak;
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
		Arrays.stream(gelaxkak).forEach(lerroa -> Arrays.stream(lerroa).forEach(gelaxka -> gelaxka.eguneratuGelaxka()));
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
				jok.bonbaKendu();
				System.out.println("Bonba jarri du ("+y+","+x+")");
			
				//timerra
				javax.swing.Timer errementa = new javax.swing.Timer(3000, e ->{
					System.out.println("Bonba apurtu da (" +y+","+x+")");
					bon.bonbaApurtu(y,x);
				});
				errementa.setRepeats(false);
				errementa.start();
			}
		}
	}

	
	public boolean apurtuBlokea(int errenkada, int zutabea, String kolorea) {
		if (errenkada >= 0 && errenkada < 11 && zutabea >= 0 && zutabea < 17) {
			Gelaxka gel = gelaxkak[errenkada][zutabea];
			if (gel.getBlokea() instanceof Biguna) {
				gel.setBlokea(new Hutsik());
				this.suaJarri(errenkada, zutabea, kolorea);
				System.out.println("blokea apurtu da:"+ errenkada +","+ zutabea);
				jok.getPuntuazioa().blokeaApurtu();
				blokeKop--;
			}
			else if (gel.hutsikDago() || gel.getSua()) {
				this.suaJarri(errenkada, zutabea, kolorea);
			}
			else if (gel.getBlokea() instanceof Gogorra) {
				return false;
			}
		}
		return true;
	}
	
	public void bonbaBabestu()
	{
		int y = jok.getY();
		int x = jok.getX();
		
		if (gelaxkak[y][x].hutsikDago()) {
			Gelaxka gel = gelaxkak [y][x];
			//bonba jarri
			Bonba bon = jok.getProtect();
			if (bon != null) {
				gel.setBonba(bon);
				System.out.println("Protect jarri du ("+y+","+x+")");
				bon.bonbaApurtu(x, y);
				jok.burbuilaBlokAktibatu();
				//bertan gelaxkan pertsonaira bueltatu
				javax.swing.Timer bueltatu = new javax.swing.Timer(2000, e -> {
	                gel.setBonba(null); 
	                jok.burbuilaBlokDesaktibatu();
	                gel.eguneratuGelaxka(); 
	            });
	            bueltatu.setRepeats(false);
	            bueltatu.start();
			}
		}
	}
	
	public void babestuBlokea(int errenkada, int zutabea, String kolorea) {
		if (errenkada >= 0 && errenkada < 11 && zutabea >= 0 && zutabea < 17) {
			Gelaxka gel = gelaxkak[errenkada][zutabea];
			if (gel.getBlokea() instanceof Biguna ) {
				blokeKop--;
			}
			gel.setBlokea(new Hutsik());
			this.suaJarri(errenkada, zutabea, kolorea);
			System.out.println("blokea hutsik jarri da:"+ errenkada +","+ zutabea);
			jok.getPuntuazioa().blokeaApurtu();
		}
	}
	
	private void suaJarri(int errenkada, int zutabea, String kolorea) {
		Gelaxka gel = gelaxkak[errenkada][zutabea];
		gel.setSuaKolorea(kolorea);
		gel.setSua();
		gel.setBonba(null);
	}
	
	public void etsaiakMurriztu() {
		etsaiKop --;
		if(etsaiKop == 0) {
			this.giltzaJarri();
		}
	}
	
	private void giltzaJarri() {
		ArrayList<Point> hutsik = new ArrayList<>();
		
		for(int i = 0; i < lerroak; i++) {
			for(int j = 0; j < zutabeak; j++) {
				Gelaxka gel = gelaxkak[i][j];
				if(gel.hutsikDago()) {
					hutsik.add(new Point(i,j));
				}
			}
		}
		
		if(!hutsik.isEmpty()) {
			Dadoa dado = Dadoa.getNireDadoa();
			Point pos = hutsik.get(dado.zenbakiaAukeratu(0, hutsik.size()));
			
			gelaxkak[pos.x][pos.y].setGiltza(true);
		}
		
	}

	public void etsaiakGelditu() {
		
		Arrays.stream(gelaxkak).forEach(lerroa -> Arrays.stream(lerroa).forEach(gelaxka -> {
			if(gelaxka.getEtsaia() != null) {
				gelaxka.getEtsaia().geldituEtsaia();
				gelaxka.setEtsaia(null);
			}
		}));
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
