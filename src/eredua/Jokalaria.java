package eredua;

import common.Mugimendu;

public abstract class Jokalaria{
	
	public Jokalaria() {
		//super(pIrudia);
		// TODO Auto-generated constructor stub
		xPos = 0;
		yPos = 0;
		azkenMugi = Mugimendu.BEHERA;
	}

	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	
	
	public void mugituGora(){
		this.setAzkenMugi(Mugimendu.GORA);
		//this.setIrudia("whiteup1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos-1, xPos) instanceof Hutsik){
			//Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos-1);
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos)).setJokalaria(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos - 1, xPos)).setJokalaria(this);
			Matrizea.getMatrizea().getGelaxka(yPos - 1, xPos).eguneratuGelaxka();
			this.yPos = this.yPos -1;
		}
	}
	
	public void mugituBehera(){
		this.setAzkenMugi(Mugimendu.BEHERA);
		//this.setIrudia("whitedown1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos+1, xPos) instanceof Hutsik){
			//Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos+1);
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos)).setJokalaria(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos + 1, xPos)).setJokalaria(this);
			Matrizea.getMatrizea().getGelaxka(yPos + 1, xPos).eguneratuGelaxka();
			this.yPos = this.yPos +1;
		}
	}
	
	public void mugituEzkerra(){
		this.setAzkenMugi(Mugimendu.EZKER);
		//this.setIrudia("whiteleft1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos-1) instanceof Hutsik){
			//Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos-1, yPos);
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos)).setJokalaria(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos - 1)).setJokalaria(this);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos - 1).eguneratuGelaxka();
			this.xPos = this.xPos -1;
		}
	}
	
	public void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		//this.setIrudia("whiteright1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos+1) instanceof Hutsik){
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos)).setJokalaria(null);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos).eguneratuGelaxka();
			((Hutsik)Matrizea.getMatrizea().getGelaxka(yPos, xPos + 1)).setJokalaria(this);
			Matrizea.getMatrizea().getGelaxka(yPos, xPos + 1).eguneratuGelaxka();
			//Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos+1, yPos);
			this.xPos = this.xPos +1;
		}
	}
	
	public Mugimendu getAzkenMugi()
	{
		return (this.azkenMugi);
	}
	
	public void setAzkenMugi(Mugimendu m)
	{
		this.azkenMugi = m;
	}
	
	public int getX()
	{
		return(xPos);
	}
	
	public int getY()
	{
		return (yPos);
	}
	
	public void printPosizio()
	{
		System.out.println("Errenkada: " + yPos + " Zutabe: " + xPos);
	}
}
