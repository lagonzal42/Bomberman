package eredua;

public abstract class Gelaxka {
	
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
	}
	
	public boolean getBonba()
	{
		return (bonba);
	}
	
	public boolean getJokalaria()
	{
		return (jok);
	}
}
