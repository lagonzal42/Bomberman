
package bista;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import eredua.Biguna;
import eredua.Dadoa;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.JokoKudeatzailea;
import common.GelaxkaMota;

public class GelaxkaBista extends JLabel implements Observer{
	
	private String irudia = null;
	public GelaxkaBista() {
		super();
	}
	
	public void setIrudia(String pIrudia) {
		this.irudia = pIrudia;
		if (pIrudia != null) {
			if (pIrudia.toLowerCase().endsWith(".gif")) {
				this.setIcon(new ImageIcon(this.getClass().getResource(pIrudia)));
			}else {
				ImageIcon icon = new ImageIcon(this.getClass().getResource(pIrudia));
				Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
				this.setIcon(new ImageIcon(img));
			}
			
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
		Timer animazioa;
		
		System.out.println("gelaxka orain " + arg);
		String color = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getColor();
		
		if (gelMota == null)
			this.setIrudia(null);
			
		else
		{
			Dadoa dadoa = Dadoa.getNireDadoa();
			switch (gelMota)
			{
				case BIGUNA:
					this.setIrudia("/bista/Sprites/soft4" + dadoa.zenbakiaAukeratu(1, 4) +"Berria.png");
					//path = "/bista/Sprites/whiteup1.png";
					break;
				case GOGORRA:
					this.setIrudia("/bista/Sprites/hard1.png");
					//path = "/bista/Sprites/whiteleft1.png";
					break;
				case IRTEERA:
					this.setIrudia("/bista/Sprites/irteera.png");
					break;
				case JOKALARIAGORA:
					this.setIrudia("/bista/Sprites/"+color+"up1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIAEZKER:
					this.setIrudia("/bista/Sprites/"+color+"left1.png");
					break;
				case JOKALARIAESKUIN:
					this.setIrudia("/bista/Sprites/"+color+"right1.png");
					break;
				case BONBA:
					this.setIrudia("/bista/Sprites/bomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIBONBAREKIN:
					this.setIrudia("/bista/Sprites/"+color+"withbomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case JOKALARIAULTRABONBAREKIN:
					this.setIrudia("/bista/Sprites/"+ color +"withbomb2.png");
					break;
				case BONBAESTANDA:
					this.setIrudia("/bista/Sprites/kabomb1.png");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case SUA:
				//	this.setIrudia("/bista/Sprites/kaBomb5.png");
					this.setIrudia("/bista/Sprites/miniBlast1.gif");
					//path = "/bista/Sprites/whiteright1.png";
					break;
				case GILTZA:
					this.setIrudia("/bista/Sprites/giltza.png");
					break;
				case SUBERDEA:
					this.setIrudia("/bista/Sprites/miniBlast2.gif");
					break;
				case SUMOREA:
					this.setIrudia("/bista/Sprites/miniBlast3.gif");
					break;
				case JOKALARIASUAREKIN:
					this.setIrudia("/bista/Sprites/onFire2.png");
					animazioa = new Timer(2000, e -> {
						((Timer) e.getSource()).stop();
						JokoBista.getJokoBista().itxi(true);
			        });
			        animazioa.start();
					break;
				case JOKALARIAHARRAPATUTA:
					this.setIrudia("/bista/Sprites/harrapatuta.png");
					animazioa = new Timer(2000, e -> {
						((Timer) e.getSource()).stop();
						JokoBista.getJokoBista().itxi(true);
					});
					animazioa.start();
					break;
				case ETSAIAESKUMA:
					this.setIrudia("/bista/Sprites/baloon1.png");
					//path = "/bista/Sprites/baloon1.png";
					break;
				case ETSAIAEZKERRA:
					this.setIrudia("/bista/Sprites/baloon2.png");
					break;
					//path = "/bista/Sprites/baloon2.png";
				case IRABAZI:
					//this.setIrudia("/bista/Sprites/miniBlast1.gif");
					animazioa = new Timer(2000, e -> {
						((Timer) e.getSource()).stop();
						JokoBista.getJokoBista().itxi(false);
			        });
			        animazioa.start();
			        break;
				case ULTRABONBA:
					this.setIrudia("/bista/Sprites/bomb2.png");
					break;
				default:
					this.setIrudia("/bista/Sprites/"+color+"down1.png");
					//path = "/bista/Sprites/whitedown1.png";
					break;
			}
		}
		
	}
}
