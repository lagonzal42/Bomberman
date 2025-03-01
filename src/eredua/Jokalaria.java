package eredua;

import common.Mugimendu;

public abstract class Jokalaria extends Gelaxka{
	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	
	
	public void mugituGora(){
		if (Matrizea.getMatrizea().getGelaxka(xPos, yPos-1) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos-1);
			this.yPos = this.yPos -1;
		}
	}
	
	public void mugituBehera(){
		if (Matrizea.getMatrizea().getGelaxka(xPos, yPos+1) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos+1);
			this.yPos = this.yPos +1;
		}
	}
	
	public void mugituEzkerra(){
		if (Matrizea.getMatrizea().getGelaxka(xPos-1, yPos) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos-1, yPos);
			this.xPos = this.xPos -1;
		}
	}
	
	public void mugituEskuma() {
		if (Matrizea.getMatrizea().getGelaxka(xPos+1, yPos) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos+1, yPos);
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
}
