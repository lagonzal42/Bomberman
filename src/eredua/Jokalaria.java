package eredua;

import common.Mugimendu;

public abstract class Jokalaria{
	
	private int xPos;
	private int yPos;
	private boolean hil;
	private Mugimendu azkenMugi;
//	private Bonba bonba;
	protected int bonbaKop;
	protected String color;
	protected BonbaPortaera bonPortaera;
		
	public Jokalaria() {
		//super(pIrudia);
		// TODO Auto-generated constructor stub
		xPos = 0;
		yPos = 0;
		hil = false;
		azkenMugi = Mugimendu.BEHERA;
		//this.bonPortaera = new BonbaNormala();
	}
	
	public void mugituGora(){
		this.setAzkenMugi(Mugimendu.GORA);
		Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos-1, xPos);
		//this.setIrudia("whiteup1.png");
		if (gel!=null && gel.hutsikDago()&& gel.getBonba()== null){
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos, yPos-1);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos - 1, xPos).setJokalaria(this);
			this.yPos = this.yPos -1;
			if (Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true || 
					Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDA);
				Matrizea.getMatrizea().getEreduMapa().etsaiakGelditu();
			}
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituBehera(){
		this.setAzkenMugi(Mugimendu.BEHERA);
		Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos+1, xPos);
		if (gel!=null && gel.hutsikDago() && gel.getBonba()== null){
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos + 1, xPos).setJokalaria(this);
			this.yPos = this.yPos +1;
			if (Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true || 
					Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDA);
				Matrizea.getMatrizea().getEreduMapa().etsaiakGelditu();
			}
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituEzkerra(){
		this.setAzkenMugi(Mugimendu.EZKER);
		Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos-1);
		//this.setIrudia("whiteleft1.png");
		if (gel!= null && gel.hutsikDago() && gel.getBonba()== null){
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos-1, yPos);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos - 1).setJokalaria(this);
			this.xPos = this.xPos -1;
			if (Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true || 
					Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDA);
				Matrizea.getMatrizea().getEreduMapa().etsaiakGelditu();
			}
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos+1);
		//this.setIrudia("whiteright1.png");
		if (gel != null && gel.hutsikDago() && gel.getBonba()== null){
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos + 1).setJokalaria(this);
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos+1, yPos);
			this.xPos = this.xPos +1;
			if (Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true || 
					Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDA);
				Matrizea.getMatrizea().getEreduMapa().etsaiakGelditu();
			}
			Matrizea.getMatrizea().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
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
	
	public boolean getHilda() {
		return hil;
	}
	
	public void setHilda() {
		this.hil = true;
	}
	
	public int getBonbaKop() {
		return (this.bonbaKop);
	}
	
	public void bonbaKendu() {
		this.bonbaKop= this.bonbaKop-1;
		if (this.bonbaKop == 0) {
			bonbaBarik();
		}
	}
	
	public void bonbaGehitu() {
		this.bonbaKop ++;
	}
	
	public BonbaPortaera getBonba() { 
		BonbaPortaera berria = null;
		if (this.getBonbaKop()>0) {
			System.out.println(this.bonbaKop + " garren bonba jarri duzu");
			berria = this.bonPortaera;
		}
		return berria;
	}	
	
	public void setBonba(BonbaPortaera pBonba)
	{
		bonPortaera = pBonba;
	}
	
	public void bonbaBarik() {
		System.out.println("Ez daukazu bonbarik, itxaron 3 segundo");
		//bonba itxaron timerra
		javax.swing.Timer itxaron = new javax.swing.Timer(3000, e->{
			this.bonbaGehitu();
			System.out.println("Bonba bakarra daukazu eskuragarri");
		});
		itxaron.setRepeats(false);
		itxaron.start();
	}
	
	public String getColor() {
		return color;
	}

}
