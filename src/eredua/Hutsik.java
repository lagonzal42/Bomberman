package eredua;
import common.*;


public class Hutsik extends Gelaxka{

	private Jokalaria jok;
	private Bonba bonba;
	private boolean sua;
	
	public Hutsik() {
		super();
		jok = null;
		bonba = null;
		sua = false;
		// TODO Auto-generated constructor stub
	}

	public void setJokalaria(Jokalaria pJok)
	{
		jok = pJok;
		setChanged();
		notifyObservers();
	}
	
	public Jokalaria getJokalaria()
	{
		return (jok);
	}
	
	public void setBonba(Bonba pBonba)
	{
		bonba = pBonba;
		setChanged();
		notifyObservers(GelaxkaMota.BONBA);
	}
	
	public Bonba getBonba()
	{
		return (bonba);
	}
	
	public void bonbaApurtu(){
		if (bonba!=null) {
			this.bonba=null;
			setChanged();
			notifyObservers(GelaxkaMota.BONBAESTANDA);	
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
		setChanged();
		notifyObservers();
	}
	
	public void eguneratuGelaxka()
	{
		GelaxkaMota gM = null;
		if (bonba !=null) {
			gM =GelaxkaMota.BONBA;
			
		} else if (sua) {
			gM=GelaxkaMota.SUA;
			
		} else if (jok != null){	
			switch (jok.getAzkenMugi())
			{
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
				case HILDA:
					if (this.sua == true) {
					gM = GelaxkaMota.JOKALARIASUAREKIN;
					}
					break;
				default:
					gM = GelaxkaMota.JOKALARIABEHERA;
					break;
			}
		}
		this.setChanged();
		this.notifyObservers(gM);
	}
}
