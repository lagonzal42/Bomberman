package eredua;

import java.util.Observable;

import common.GelaxkaMota;

public class Gelaxka extends Observable{
	
	private Jokalaria	jok;
	private Bonba		bonba;
	private boolean 	sua;
	private Bloke		blokea;
	
	public Gelaxka() {
		
	}
	
	public boolean hutsikDago()
	{
		return (blokea instanceof Hutsik);
	}
	
	public void setJokalaria(Jokalaria pJok)
	{
		jok = pJok;
	}
	
	public Jokalaria getJokalaria()
	{
		return (jok);
	}
	
	public void setBonba(Bonba pBonba)
	{
		bonba = pBonba;
//		setChanged();
//		notifyObservers(GelaxkaMota.BONBA);
	}
	
	public Bonba getBonba()
	{
		return (bonba);
	}
	
	public void bonbaApurtu(){
		if (bonba!=null) {
			this.bonba=null;
//			setChanged();
//			notifyObservers(GelaxkaMota.BONBAESTANDA);	
		}
	}
	
	public void setSua() {
		this.sua=true;
		setChanged();
		notifyObservers(GelaxkaMota.SUA);
	}
	
	public boolean getSua() {
		return this.sua;
	}
	
	public void deleteSua() {
		this.sua=false;
//		setChanged();
//		notifyObservers();
	}
	
	public void eguneratuGelaxka()
	{
		GelaxkaMota gM = null;
		if (jok != null){
			if(bonba != null) {
				gM = GelaxkaMota.JOKALARIBONBAREKIN;
			}
			else{
				switch (jok.getAzkenMugi())
				{
				case HILDA:
					if (this.sua == true) {
						gM = GelaxkaMota.JOKALARIASUAREKIN;
					}
					break;
				case GORA:
					gM = GelaxkaMota.JOKALARIAGORA;
					break;
				case BEHERA:
					gM = GelaxkaMota.JOKALARIABEHERA;
					break;
				case EZKER:
					gM = GelaxkaMota.JOKALARIAEZKER;
					break;
				case ESKUIN:
					gM = GelaxkaMota.JOKALARIAESKUIN;
					break;
				default:
					gM = GelaxkaMota.JOKALARIABEHERA;
					break;
				}
			}
		}
		else if (bonba !=null) {
			gM =GelaxkaMota.BONBA;
		} 
		else if (sua==true) {
			gM=GelaxkaMota.SUA;				
		}	
		else if (this.blokea instanceof Hutsik)
		{
			gM = null;
		}
		else if (this.blokea instanceof Biguna)
		{
			gM = GelaxkaMota.BIGUNA;
		}
		else if (this.blokea instanceof Gogorra)
		{
			gM = GelaxkaMota.GOGORRA;
		}
		
		this.setChanged();
		this.notifyObservers(gM);
	}
	
	public Bloke getBlokea()
	{
		return (blokea);
	}
	
	public void setBlokea(Bloke pBloke)
	{
		this.blokea = pBloke;
	}
}
