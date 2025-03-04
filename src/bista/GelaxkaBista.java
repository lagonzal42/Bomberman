package bista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GelaxkaBista extends JLabel implements Observer{
	
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
