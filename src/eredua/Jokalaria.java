package eredua;

import java.util.ArrayList;

import common.Mugimendu;

public abstract class Jokalaria{
	
	private int xPos;
	private int yPos;
	private boolean hil;
	private Mugimendu azkenMugi;
//	protected Bonba bonba;
//	protected int bonbaKop;
	protected String color;
	private Puntuazioa puntuazioa;
	private ArrayList<Bonba> bonbaZer;
	
	public Jokalaria() {
		//super(pIrudia);
		// TODO Auto-generated constructor stub
		xPos = 0;
		yPos = 0;
		hil = false;
		azkenMugi = Mugimendu.BEHERA;
		puntuazioa = new Puntuazioa();
		bonbaZer = new ArrayList<Bonba>();
	}
	
	public void mugituGora(){
		this.setAzkenMugi(Mugimendu.GORA);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos-1, xPos);
		//this.setIrudia("whiteup1.png");
		if (gel!=null && gel.hutsikDago()&& gel.getBonba()== null){
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos, yPos-1);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos - 1, xPos).setJokalaria(this);
			this.yPos = this.yPos -1;
			if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAS);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();				
				this.puntuazioa.galdu();
			}
			else if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAE);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
				this.puntuazioa.galdu();
			}
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituBehera(){
		this.setAzkenMugi(Mugimendu.BEHERA);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos+1, xPos);
		if (gel!=null && gel.hutsikDago() && gel.getBonba()== null){
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos + 1, xPos).setJokalaria(this);
			this.yPos = this.yPos +1;
			if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAS);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();				
				this.puntuazioa.galdu();
			}
			else if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAE);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
				this.puntuazioa.galdu();
			}
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituEzkerra(){
		this.setAzkenMugi(Mugimendu.EZKER);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos-1);
		//this.setIrudia("whiteleft1.png");
		if (gel!= null && gel.hutsikDago() && gel.getBonba()== null){
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos-1, yPos);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos - 1).setJokalaria(this);
			this.xPos = this.xPos -1;
			if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAS);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();				
				this.puntuazioa.galdu();
			}
			else if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAE);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
				this.puntuazioa.galdu();
			}
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		}
	}
	
	public void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos+1);
		//this.setIrudia("whiteright1.png");
		if (gel != null && gel.hutsikDago() && gel.getBonba()== null){
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos + 1).setJokalaria(this);
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos+1, yPos);
			this.xPos = this.xPos +1;
			if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getSua() == true) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAS);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
				this.puntuazioa.galdu();
			}
			else if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos,xPos).getEtsaia() != null) {
				this.hil = true;
				this.setAzkenMugi(Mugimendu.HILDAE);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
				this.puntuazioa.galdu();
			}
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
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
		return (this.bonbaZer.size());
	}
	
	public void bonbaKendu() {
		this.bonbaZer.remove(bonbaZer.size()-1);
		if (this.bonbaZer.isEmpty()) {
			bonbaBarik();
		}
	}
	
	public void bonbaGehitu(Bonba pBonba) {
		this.bonbaZer.add(pBonba);
	}
	
	public Bonba getBonba() { 
		if (!bonbaZer.isEmpty()) {
			System.out.println(this.bonbaZer.size()-1 + " bonba geratzen zaizkizu");
			return this.bonbaZer.get(bonbaZer.size()-1);
		}
		return null;
	}	
	
	public void setBonba(Bonba pBonba)
	{
		this.bonbaZer.add(pBonba);
	}
	
	public void bonbaBarik() {
		System.out.println("Ez daukazu bonbarik, itxaron 3 segundo");
		//bonba itxaron timerra
		javax.swing.Timer itxaron = new javax.swing.Timer(3000, e->{
			bonbaGehitu(this.batGehitu());
			System.out.println("Bonba bakarra daukazu eskuragarri");
		});
		itxaron.setRepeats(false);
		itxaron.start();
	}
	
	protected abstract Bonba batGehitu();
	
	public String getColor() {
		return color;
	}
	
	public Puntuazioa getPuntuazioa() {
		return this.puntuazioa;
	}

}
