package bista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import eredua.Biguna;
import eredua.Dadoa;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Matrizea;
import common.GelaxkaMota;

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
	public void eguneratu(GelaxkaMota gelMota)
	{
		switch (gelMota)
		{
		case BIGUNA:
			this.setIrudia("/bista/Sprites/soft1.png");
			//path = "/bista/Sprites/whiteup1.png";
			break;
		case GOGORRA:
			this.setIrudia("/bista/Sprites/hard1.png");
			//path = "/bista/Sprites/whiteleft1.png";
			break;
		case JOKALARIA:
			this.setIrudia("/bista/Sprites/whitedown1.png");
			//path = "/bista/Sprites/whiteright1.png";
			break;
		case BONBA:
			this.setIrudia("/bista/Sprites/bomb1.png");
			//path = "/bista/Sprites/whiteright1.png";
			break;
		case JOKALARIBONBAREKIN:
			this.setIrudia("/bista/Sprites/whitewithbomb1.png");
			//path = "/bista/Sprites/whiteright1.png";
		case SUA:
			this.setIrudia("/bista/Sprites/blast.png");
			//path = "/bista/Sprites/whiteright1.png";
			break;
		default:
			this.setIrudia("/bista/Sprites/whitedown1.png");
			//path = "/bista/Sprites/whitedown1.png";
			break;
		}
	}
}
