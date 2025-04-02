package eredua;

import common.Mugimendu;
import javax.swing.Timer;

public class Etsaia {
	
	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	
	public Etsaia(int x, int y) {
		xPos = x;
		yPos = y;
		azkenMugi = Mugimendu.BEHERA;
	}
	
	public void hasieratuEtsaia() {
		Timer denbora = new Timer(1000, e ->{
			mugitu();
		});
		denbora.setRepeats(true);
		denbora.start();
	}
	
	private void mugitu() {
		boolean ahal = false;
		while (ahal == false) {
			int zenb = Dadoa.getNireDadoa().zenbakiaAukeratu(1, 4);
			if (zenb == 1) {
				ahal = mugituAhal(this.yPos-1,this.xPos);
				if (ahal == true) {
					mugituGora();
				}
			} else if (zenb == 2) {
				ahal = mugituAhal(this.yPos+1,this.xPos);
				if (ahal == true) {
					mugituBehera();
				}
			} else if (zenb == 3) {
				ahal = mugituAhal(this.yPos,this.xPos-1);
				if (ahal == true) {
					mugituEzkerra();	
				}
			} else {
				ahal = mugituAhal(this.yPos,this.yPos+1);
				if (ahal == true) {
					mugituEskuma();
				}
			}
		}
	}
	
	private void mugituGora() {
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Matrizea.getMatrizea().getGelaxka(yPos -1, xPos).setEtsaia(this);
		this.yPos = this.yPos -1;
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria() != null) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDA);
		}
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituBehera() {
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Matrizea.getMatrizea().getGelaxka(yPos +1, xPos).setEtsaia(this);
		this.yPos = this.yPos +1;
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria() != null) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDA);
		}
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEzkerra() {
		this.setAzkenMugi(Mugimendu.EZKER);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Matrizea.getMatrizea().getGelaxka(yPos, xPos -1).setEtsaia(this);
		this.xPos = this.xPos -1;
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria() != null) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDA);
		}
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Matrizea.getMatrizea().getGelaxka(yPos, xPos +1).setEtsaia(this);
		this.xPos = this.xPos +1;
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria() != null) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDA);
		}
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
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
	
	private boolean mugituAhal(int y, int x) {
		boolean ema = false;
		Gelaxka gel = Matrizea.getMatrizea().getGelaxka(y, x);
		if (gel != null && gel.hutsikDago() && gel.getBonba()==null && gel.getSua()==false) {
			ema = true;
		}
		return ema;
	}
}	
