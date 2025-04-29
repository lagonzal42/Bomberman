package eredua;

import java.util.ArrayList;

import common.Mugimendu;

public abstract class Jokalaria{
	
	private int xPos;
	private int yPos;
	private boolean hil;
	private Mugimendu azkenMugi;
	protected String color;
	private Puntuazioa puntuazioa;
	private ArrayList<Bonba> bonbaZer;
	private Bonba burbuila = new BonbaBurbuila();
	private boolean giltzaDu = false;
	private int kontBurb =1;
	
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
		this.mugitu(yPos-1, xPos);
	}
	
	public void mugituBehera(){
		this.setAzkenMugi(Mugimendu.BEHERA);
		this.mugitu(yPos+1, xPos);
	}
	
	public void mugituEzkerra(){
		this.setAzkenMugi(Mugimendu.EZKER);
		this.mugitu(yPos, xPos-1);
	}
	
	public void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		this.mugitu(yPos, xPos+1);
	}
	
	private void mugitu(int yPos1, int xPos1) {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos1, xPos1);
		//this.setIrudia("whiteright1.png");
		if (gel != null && gel.hutsikDago() && gel.getBonba()== null){
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos1, xPos1).setJokalaria(this);
			//Matrizea.getMatrizea().getEreduMapa().aldatuPos(xPos, yPos, xPos+1, yPos);
			this.xPos = xPos1;
			this.yPos = yPos1;
			if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getGiltza()) {
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setGiltza(false);
				this.giltzaDu = true;
			}
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
		else if(gel != null && gel.irteeraDa()) {
			if(this.giltzaDu == true) {
				JokoKudeatzailea.getJokoKudeatzaileaa().setIrabazi();
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setJokalaria(null);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos1, xPos1).setJokalaria(this);
			}
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
