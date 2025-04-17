package eredua;

import common.Mugimendu;

import java.util.ArrayList;

import javax.swing.Timer;

public class Etsaia {
	
	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	private Timer denbora;
	
	public Etsaia(int x, int y) {
		xPos = x;
		yPos = y;
		azkenMugi = Mugimendu.ESKUIN;
	}
	
	public void hasieratuEtsaia() {
		denbora = new Timer(1000, e ->{
			mugitu();
		});
		denbora.setRepeats(true);
		denbora.start();
	}
	
	private void mugitu() {
		
		ArrayList<Integer> mugimenduPosibleak = new ArrayList();
		if (mugituAhal(this.yPos-1,this.xPos)) {
			mugimenduPosibleak.add(1);
		} 
		if (mugituAhal(this.yPos+1,this.xPos)) {
			mugimenduPosibleak.add(2);
		}
		if (mugituAhal(this.yPos,this.xPos-1)) {
			mugimenduPosibleak.add(3);
		} 
		if (mugituAhal(this.yPos,this.xPos+1)) {
			mugimenduPosibleak.add(4);
		}
		mugimenduPosibleak.add(5);
		int zenbRandom = Dadoa.getNireDadoa().zenbakiaAukeratu(1,mugimenduPosibleak.size()+1);
		int zenb = mugimenduPosibleak.get(zenbRandom-1);
		if (zenb == 1) {
			mugituGora();
		} else if (zenb == 2) {
			mugituBehera();
		} else if (zenb == 3) {
			mugituEzkerra();
		} else if (zenb == 4) {
			mugituEskuma();
		}
		
//		while (ahal == false) {
//		}
	}
	
	private void mugituGora() {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos -1, xPos).setEtsaia(this);
		this.yPos = this.yPos -1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituBehera() {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos +1, xPos).setEtsaia(this);
		this.yPos = this.yPos +1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEzkerra() {
		this.setAzkenMugi(Mugimendu.EZKER);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos -1).setEtsaia(this);
		this.xPos = this.xPos -1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos +1).setEtsaia(this);
		this.xPos = this.xPos +1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void setAzkenMugi(Mugimendu m) {
		this.azkenMugi = m;
	}
	
	public Mugimendu getAzkenMugi() {
		return this.azkenMugi;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public void geldituEtsaia() {
		if(denbora != null && denbora.isRunning()) {
			denbora.stop();
		}
		
	}
	private boolean mugituAhal(int y, int x) {
		boolean ema = false;
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x);
		if (!(y < 0 || x< 0 || y > 10 || x > 16) && gel != null && gel.hutsikDago() && gel.getBonba()==null && gel.getSua()==false && gel.getEtsaia()==null) {
			ema = true;
		}
		return ema;
	}
}	
