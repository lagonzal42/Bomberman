package bista;

import javax.swing.JLabel;

public class GelaxkaBista extends JLabel{
	
	private String irudia = null;
	public GelaxkaBista() {
		super();
	}
	
	public void setIrudia(String pIrudia) {
		this.irudia = pIrudia;
	}
	
	public String getIrudia() {
		return this.irudia;
	}
}
