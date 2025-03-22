
package bista;

import java.awt.Graphics;
import java.awt.Image;
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
		if (pIrudia != null) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource(pIrudia));
			Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			this.setIcon(new ImageIcon(img));
		}
		else
			this.setIcon(null);
	}
	
	public String getIrudia() {
		return this.irudia;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		GelaxkaMota gelMota = (GelaxkaMota)arg;
		
		System.out.println("gelaxka orain " + arg);
		
		if (gelMota == null)
			this.setIrudia(null);
			
		else
		{
			Dadoa dadoa = Dadoa.getNireDadoa();
			switch (gelMota)
			{
				case BIGUNA:
					this.setIrudia("/bista/Sprites/soft4" + dadoa.zenbakiaAukeratu(1, 4) +".png");
					//path = "/bista/Sprites/whiteup1.png";
					break;
				case GOGORRA:
					this.setIrudia("/bista/Sprites/hard1.png");
					//path = "/bista/Sprites/whiteleft1.png";
					break;
				case JOKALARIAGORA:
					this.setIrudia("/bista/Sprites/whiteup1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIAEZKER:
					this.setIrudia("/bista/Sprites/whiteleft1.png");
					break;
				case JOKALARIAESKUIN:
					this.setIrudia("/bista/Sprites/whiteright1.png");
					break;
				case BONBA:
					this.setIrudia("/bista/Sprites/bomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIBONBAREKIN:
					this.setIrudia("/bista/Sprites/whitewithbomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case BONBAESTANDA:
					this.setIrudia("/bista/Sprites/kabomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case SUA:
					this.setIrudia("/bista/Sprites/kaBomb5.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIASUAREKIN:
					this.setIrudia("/bista/Sprites/onFire2.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				default:
					this.setIrudia("/bista/Sprites/whitedown1.png");
					//path = "/bista/Sprites/whitedown1.png";
					break;
			}
		}
		
	}
}
