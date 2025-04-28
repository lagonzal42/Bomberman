package eredua;

import common.Mugimendu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.Timer;

public abstract class Etsaia {
	
	protected int xPos;
	protected int yPos;
	protected Mugimendu azkenMugi;
	protected Timer denbora;
	
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
	
	protected abstract void mugitu();
	
	protected void mugituGora() {
		this.mugitu(yPos-1, xPos);
	}
	
	protected void mugituBehera() {
		this.mugitu(yPos+1, xPos);
	}
	
	protected void mugituEzkerra() {
		this.setAzkenMugi(Mugimendu.EZKER);
		this.mugitu(yPos, xPos-1);
	}
	
	protected void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		this.mugitu(yPos, xPos + 1);
	}
	
	protected void mugitu(int yPos1, int xPos1) {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos1, xPos1).setEtsaia(this);
		this.xPos = xPos1;
		this.yPos = yPos1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		
	}
	
	protected void setAzkenMugi(Mugimendu m) {
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
	protected boolean mugituAhal(int y, int x) {
		boolean ema = false;
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x);
		if (!(y < 0 || x< 0 || y > 10 || x > 16) && gel != null && gel.hutsikDago() && gel.getBonba()==null && gel.getSua()==false && gel.getEtsaia()==null) {
			ema = true;
		}
		return ema;
	}
}	
