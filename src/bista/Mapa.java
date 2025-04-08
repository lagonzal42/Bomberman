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
	
	public void jarriListenerrak()
	{
		Matrizea m = Matrizea.getMatrizea();
		for (int y = 0; y < 11; y++)
		{
			for (int x = 0; x < 17; x++)
				m.getEreduMapa().getGelaxka(y, x).addObserver(mapa[y][x]);
		}
		
	}
	
	public JLabel get(int errenkada, int zutabea)
	{
		return (mapa[errenkada][zutabea]);
	}
	
	
	
}
