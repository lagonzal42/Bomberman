package eredua;

import common.Mugimendu;

public class Etsaia {
	
	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	
	public Etsaia(int x, int y) {
		xPos = x;
		yPos = y;
		azkenMugi = Mugimendu.BEHERA;
	}
	
	public void mugitu() {
		int zenb = Dadoa.getNireDadoa().zenbakiaAukeratu(1, 5);
		if (zenb == 1) {
			mugituGora();
		} else if (zenb == 2) {
			mugituBehera();
		} else if (zenb == 3) {
			mugituEzkerra();
		} else {
			mugituEskuma();
		}
	}
	
	private void mugituGora() {
		this.setAzkenMugi(Mugimendu.GORA);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getGelaxka(yPos-1, xPos);
		//if (ibilbidea ahal den konprobatu) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getGelaxka(yPos -1, xPos).setEtsaia(this);
			this.yPos = this.yPos -1;
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		//}
	}
	
	private void mugituBehera() {
		this.setAzkenMugi(Mugimendu.BEHERA);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getGelaxka(yPos+1, xPos);
		//if (ibilbidea ahal den konprobatu) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getGelaxka(yPos +1, xPos).setEtsaia(this);
			this.yPos = this.yPos +1;
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		//}
	}
	
	private void mugituEzkerra() {
		this.setAzkenMugi(Mugimendu.EZKER);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getGelaxka(yPos, xPos -1);
		//if (ibilbidea ahal den konprobatu) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos -1).setEtsaia(this);
			this.xPos = this.xPos -1;
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		//}
	}
	
	private void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getGelaxka(yPos, xPos +1);
		//if (ibilbidea ahal den konprobatu) {
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).setEtsaia(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getGelaxka(yPos, xPos +1).setEtsaia(this);
			this.xPos = this.xPos +1;
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
		//}
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
}	
