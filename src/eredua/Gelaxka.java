package eredua;

import java.util.Observable;

public abstract class Gelaxka extends Observable{
	
	private boolean jok;
	private boolean bonba;
	
	//private String irudia;
	
	public Gelaxka() {
		jok = false;
		bonba = false;
		//this.irudia = "/bista/Sprites/" + pIrudia;
	}
	
	//public String getIrudia() {
	//	return this.irudia;
	//}
	
	//public void setIrudia(String pIrudia) {
	//	this.irudia = "/bista/Sprites/" + pIrudia;
	//}
	
	public void setJokalaria(boolean dago)
	{
		jok = dago;
	}
	
	public void setBonba(boolean pDago)
	{
		bonba = pDago;
		setChanged();
		notifyObservers();
	}
	
	public boolean getBonba()
	{
		return (bonba);
	}
	
	public void bonbaApurtu(){
		this.bonba=false;
		setChanged();
		notifyObservers();
	}
	
	public boolean getJokalaria()
	{
		return (jok);
	}
}
