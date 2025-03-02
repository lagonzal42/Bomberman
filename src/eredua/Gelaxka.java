package eredua;

public abstract class Gelaxka {
	private String irudia;
	
	public Gelaxka(String pIrudia) {
		this.irudia = "/bista/Sprites/" + pIrudia;
	}
	
	public String getIrudia() {
		return this.irudia;
	}
	
	public void setIrudia(String pIrudia) {
		this.irudia = "/bista/Sprites/" + pIrudia;
	}
}
