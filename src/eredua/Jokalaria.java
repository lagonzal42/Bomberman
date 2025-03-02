package eredua;

import common.Mugimendu;

public abstract class Jokalaria extends Gelaxka{
	
	public Jokalaria(String pIrudia) {
		super(pIrudia);
		// TODO Auto-generated constructor stub
	}

	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	
	
	public void mugituGora(){
		this.setIrudia("whiteup1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos-1, xPos) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos-1);
			this.yPos = this.yPos -1;
		}
	}
	
	public void mugituBehera(){
		this.setIrudia("whitedown1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos+1, xPos) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos, yPos+1);
			this.yPos = this.yPos +1;
		}
	}
	
	public void mugituEzkerra(){
		this.setIrudia("whiteleft1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos-1) instanceof Hutsik){
			Matrizea.getMatrizea().aldatuPos(xPos, yPos, xPos-1, yPos);
			this.xPos = this.xPos -1;
		}
	}
	
	public void mugituEskuma() {
		this.setIrudia("whiteright1.png");
		if (Matrizea.getMatrizea().getGelaxka(yPos, xPos+1) instanceof Hutsik){
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
