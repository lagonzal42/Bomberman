package eredua;

import java.util.Observable;

import common.GelaxkaMota;
import common.Mugimendu;

public class Gelaxka extends Observable{
	
	private Jokalaria	jok;
	private Bonba bonba;
	private javax.swing.Timer suaTimerra = null;
	private boolean sua;
	private String suaKolorea;
	private Bloke blokea;
	private Etsaia etsaia;
	private boolean giltza;
	
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
	//		this.bonba=null;
			if(this.jok!=null) {
				jok.setBonba(null);
				jok.setAzkenMugi(Mugimendu.HILDAS);
				JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
				jok.setHilda();
			}
			this.eguneratuGelaxka();
		}
	}
	
	public void setSua() {
		//sua badago aurreko kontagailura gehitu
		if (suaTimerra !=null) {
			suaTimerra.stop();
		}
		if(this.jok!=null) {
			jok.setAzkenMugi(Mugimendu.HILDAS);
			jok.setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
		}
		if(this.etsaia!=null) {
			this.etsaia.geldituEtsaia();
	        this.etsaia = null;
	        JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakMurriztu();
	        JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().etsaiaHil(etsaia);
		}
		
		if (bonba!=null) {
			if (bonba.getEztandaPortaera() instanceof EztandaBat) {
				suaKolorea="horia";
			}else {
				suaKolorea="morea";
			}
		}
		
		this.sua=true;
		this.eguneratuGelaxka();
		
		
		//sua errementa
		suaTimerra =new javax.swing.Timer(2000, o-> {
			deleteSua();
			this.eguneratuGelaxka();
			
		});
		suaTimerra.setRepeats(false);
		suaTimerra.start();
	}
	
	public boolean getSua() {
		return this.sua;
	}
	
	public void deleteSua() {
		this.sua=false;
		this.eguneratuGelaxka();
	}
	
	public void setSuaKolorea(String pKolorea) {
		this.suaKolorea=pKolorea;
	}
	
	public void eguneratuGelaxka()
	{
		GelaxkaMota gM = null;
		if (jok != null){
			if(bonba != null) {
				if (sua == true) {
					gM = GelaxkaMota.JOKALARIASUAREKIN;
				}else {
					if (bonba instanceof BonbaNormala) {
						gM = GelaxkaMota.JOKALARIBONBAREKIN;
					}else if (bonba instanceof UltraBonba){
						gM = GelaxkaMota.JOKALARIAULTRABONBAREKIN;
					}else {
						gM = GelaxkaMota.JOKALARIABURBUILA;
					}
				}	
			}
			else{
				switch (jok.getAzkenMugi())
				{
				case HILDAE:
					gM = GelaxkaMota.JOKALARIAHARRAPATUTA;
					break;
				case HILDAS:
					gM = GelaxkaMota.JOKALARIASUAREKIN;
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
			if (bonba instanceof BonbaNormala) {
				gM =GelaxkaMota.BONBA;
			}else if (bonba instanceof UltraBonba){
				gM = GelaxkaMota.ULTRABONBA;
			}else {
				gM= GelaxkaMota.JOKALARIABURBUILA;
			}
			
		} 
		else if (sua==true) {
			if (suaKolorea=="horia") {
				gM =GelaxkaMota.SUA;
			}else if (suaKolorea=="morea"){
				gM = GelaxkaMota.SUMOREA;
			}else {
				gM=GelaxkaMota.BURBUILASUA;
			}
		}
		else if(giltza == true) {
			gM = GelaxkaMota.GILTZA;
		}
		else if (this.blokea instanceof Hutsik)
		{
			if(etsaia!= null) {
				if(etsaia instanceof EtsaiNormala) {
					if (etsaia.getAzkenMugi() == Mugimendu.ESKUIN) {
						gM = GelaxkaMota.ETSAIAESKUMA;
					} else {
						gM = GelaxkaMota.ETSAIAEZKERRA;
					}
				}
				else {
					if (etsaia.getAzkenMugi() == Mugimendu.ESKUIN) {
						gM = GelaxkaMota.ETSAIAIESKUMA;
					} else {
						gM = GelaxkaMota.ETSAIAIEZKERRA;
					}
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
		else if (this.blokea instanceof Irteera) {
			gM = GelaxkaMota.IRTEERA;
		}
		if(JokoKudeatzailea.getJokoKudeatzaileaa().getIrabazi()) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().irabazi();
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

	public boolean irteeraDa() {
		return this.blokea instanceof Irteera;
	}

	public void setGiltza(boolean b) {
		giltza = b;
		this.eguneratuGelaxka();
	}

	public boolean getGiltza() {
		return this.giltza;
	}
}
