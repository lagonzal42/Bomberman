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
	
	public void setBonba(Bonba pBonba)
	{
		bonba = pBonba;
		setChanged();
		notifyObservers();
	}
	
	public Bonba getBonba()
	{
		return (bonba);
	}
	
	public void bonbaApurtu(){
		this.bonba=null;
		setChanged();
		notifyObservers();
	}
	
	public Jokalaria getJokalaria()
	{
		return (jok);
	}
	
	public void setSua() {
		this.sua=true;
	}
	
	public boolean getSua() {
		return this.sua;
	}
	
	public void eguneratuGelaxka()
	{
		GelaxkaMota gM = null;
		if (jok != null)
		{	
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
					gM = GelaxkaMota.JOKALARIASUAREKIN;
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
