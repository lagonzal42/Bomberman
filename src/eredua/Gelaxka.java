package eredua;

import java.util.Observable;

import common.GelaxkaMota;
import common.Mugimendu;

public class Gelaxka extends Observable{
	
	private Jokalaria	jok;
	private Bonba		bonba;
	private boolean 	sua;
	private Bloke		blokea;
	private Etsaia		etsaia;
	
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
		this.eguneratuGelaxka();
	}
	
	public Bonba getBonba()
	{
		return (bonba);
	}
	
	public void bonbaApurtu(){
		if (bonba!=null) {
			this.bonba=null;
			if(this.jok!=null) {
				jok.setBonba(null);
				jok.setAzkenMugi(Mugimendu.HILDA);
				jok.setHilda();
			}
			this.eguneratuGelaxka();
		}
	}
	
	public void setSua() {
		this.sua=true;
		if(this.jok!=null) {
			jok.setAzkenMugi(Mugimendu.HILDA);
			jok.setHilda();
			Matrizea.getEreduMapa().etsaiakGelditu();
		}
		if(this.etsaia!=null) {
			this.etsaia.geldituEtsaia();
	        this.etsaia = null;
	        Matrizea.getEreduMapa().etsaiakMurriztu();
	        Matrizea.getEreduMapa().etsaiakGelditu();
		}
		this.eguneratuGelaxka();
	}
	
	public boolean getSua() {
		return this.sua;
	}
	
	public void deleteSua() {
		this.sua=false;
		this.eguneratuGelaxka();
	}
	
	public void eguneratuGelaxka()
	{
		GelaxkaMota gM = null;
		if (jok != null){
			if(bonba != null) {
				if (sua == true)
					gM = GelaxkaMota.JOKALARIASUAREKIN;
				else
					gM = GelaxkaMota.JOKALARIBONBAREKIN;
			}
			else{
				switch (jok.getAzkenMugi())
				{
				case HILDA:
					if (this.sua == true) {
						gM = GelaxkaMota.JOKALARIASUAREKIN;
					}
					else {
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
			if(etsaia!= null) {
				if (etsaia.getAzkenMugi() == Mugimendu.ESKUIN) {
					gM = GelaxkaMota.ETSAIAESKUMA;
				} else {
					gM = GelaxkaMota.ETSAIAEZKERRA;
				}
			}
			else {
				gM = null;
			}
		}
		else if (this.blokea instanceof Biguna)
		{
			gM = GelaxkaMota.BIGUNA;
		}
		else if (this.blokea instanceof Gogorra)
		{
			gM = GelaxkaMota.GOGORRA;
		}
		if(Matrizea.getEreduMapa().partidaBukatu()) {
			gM = GelaxkaMota.IRABAZI;
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
	
	public void setEtsaia(Etsaia pEtsaia) {
		this.etsaia = pEtsaia;
	}
	
	public Etsaia getEtsaia() {
		return this.etsaia;
	}
}
