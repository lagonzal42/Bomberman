package bista;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eredua.Biguna;
import eredua.Dadoa;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Jokalaria;
import eredua.Matrizea;
import common.Mugimendu;

public class Mapa{
	
	private GelaxkaBista [][] mapa;
	private Image back;
	
	public Mapa(JPanel panel)
	{
		mapa = new GelaxkaBista[11][17];
		
		for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				GelaxkaBista gel = new GelaxkaBista();
				gel.setOpaque(false);
				gel.setIcon(null);
				mapa[i][j] = gel;
				panel.add(gel);
			}
		}
		
	}
	
	public void eguneratu()
	{
		String		path;
		Matrizea	m = Matrizea.getMatrizea();
		for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				Gelaxka g = m.getGelaxka(i, j);
				GelaxkaBista gel = (GelaxkaBista) mapa[i][j];
				
				if(g.getJokalaria())
				{
					switch (m.getJokalaria().getAzkenMugi())
					{
						case GORA:
							gel.setIrudia("/bista/Sprites/whiteup1.png");
							//path = "/bista/Sprites/whiteup1.png";
							break;
						case EZKER:
							gel.setIrudia("/bista/Sprites/whiteleft1.png");
							//path = "/bista/Sprites/whiteleft1.png";
							break;
						case ESKUIN:
							gel.setIrudia("/bista/Sprites/whiteright1.png");
							//path = "/bista/Sprites/whiteright1.png";
							break;
						default:
							gel.setIrudia("/bista/Sprites/whitedown1.png");
							//path = "/bista/Sprites/whitedown1.png";
							break;
					}
					gel.setIcon(new ImageIcon(this.getClass().getResource(gel.getIrudia())));
				}
				else if(g instanceof Gogorra) {
					//TODO
					if(gel.getIrudia() == null) {
						gel.setIrudia("/bista/Sprites/hard1.png");
					}
					//path = "/bista/Sprites/hard1.png";
					gel.setSize(gel.getWidth(), gel.getHeight());
					gel.setIcon(new ImageIcon(this.getClass().getResource(gel.getIrudia())));
				}
				else if(g instanceof Biguna) {
					//TODO
					if(gel.getIrudia() == null) {
						gel.setIrudia("/bista/Sprites/soft4" + Dadoa.getNireDadoa().zenbakiaAukeratu(1, 6) + ".png");
					}
					//path = "/bista/Sprites/soft1.png";
					gel.setIcon(new ImageIcon(this.getClass().getResource(gel.getIrudia())));
				}
				else {
					//TODO
					gel.setIcon(null);
				}
			}
		}	
		
	}
	
	public JLabel get(int errenkada, int zutabea)
	{
		return (mapa[errenkada][zutabea]);
	}
	
	
	
}
