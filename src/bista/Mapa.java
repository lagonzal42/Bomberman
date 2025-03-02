package bista;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eredua.Biguna;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Jokalaria;
import eredua.Matrizea;
import common.Mugimendu;

public class Mapa{
	
	private JLabel [][] mapa;
	private Image back;
	
	public Mapa(JPanel panel)
	{
		mapa = new JLabel[11][17];
		
		for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				JLabel jl = new JLabel();
				jl.setOpaque(false);
				jl.setIcon(null);
				mapa[i][j] = jl;
				panel.add(jl);
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
				JLabel lbl = (JLabel) mapa[i][j];
				
				if(g.getJokalaria())
				{
					switch (m.getJokalaria().getAzkenMugi())
					{
						case GORA:
							path = "/bista/Sprites/whiteup1.png";
							break;
						case EZKER:
							path = "/bista/Sprites/whiteleft1.png";
							break;
						case ESKUIN:
							path = "/bista/Sprites/whiteright1.png";
							break;
						default:
							path = "/bista/Sprites/whitedown1.png";
							break;
					}
					lbl.setIcon(new ImageIcon(this.getClass().getResource(path)));
				}
				else if(g instanceof Gogorra) {
					//TODO
					path = "/bista/Sprites/hard1.png";
					lbl.setIcon(new ImageIcon(this.getClass().getResource(path)));
				}
				else if(g instanceof Biguna) {
					//TODO
					path = "/bista/Sprites/soft1.png";
					lbl.setIcon(new ImageIcon(this.getClass().getResource(path)));
				}
				else {
					//TODO
					lbl.setIcon(null);
				}
			}
		}	
		
	}
	
	public JLabel get(int errenkada, int zutabea)
	{
		return (mapa[errenkada][zutabea]);
	}
	
	
	
}
