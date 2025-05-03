package bista;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eredua.Biguna;
import eredua.Dadoa;
import eredua.Gelaxka;
import eredua.Gogorra;
import eredua.Jokalaria;
import eredua.JokoKudeatzailea;
import common.Mugimendu;

public class Mapa{
	
	private GelaxkaBista [][] mapa;
	private Image back;
	
	public Mapa(JPanel panel)
	{
		mapa = new GelaxkaBista[11][17];
		
		/*for (int i = 0; i < 11; i++)
		{
			for (int j = 0; j < 17; j++)
			{
				GelaxkaBista gel = new GelaxkaBista();
				gel.setOpaque(false);
				gel.setIcon(null);
				mapa[i][j] = gel;
				panel.add(gel);
			}
		}*/

		IntStream.range(0, 11).forEach(lerroa -> 
			IntStream.range(0, 17).forEach(gelaxka ->{
				GelaxkaBista gel = new GelaxkaBista();
				gel.setOpaque(false);
				gel.setIcon(null);
				mapa[lerroa][gelaxka] = gel;
				panel.add(gel);
		}));

		
	}
	
	public void jarriListenerrak()
	{
		JokoKudeatzailea m = JokoKudeatzailea.getJokoKudeatzaileaa();
		/*for (int y = 0; y < 11; y++)
		{
			for (int x = 0; x < 17; x++)
				m.getEreduMapa().getGelaxka(y, x).addObserver(mapa[y][x]);
		}*/
		IntStream.range(0, 11).forEach(lerroa -> 
			IntStream.range(0, 17).forEach(gelaxka -> 
				m.getEreduMapa().getGelaxka(lerroa, gelaxka).addObserver(mapa[lerroa][gelaxka])));
		
	}
	
	public JLabel get(int errenkada, int zutabea)
	{
		return (mapa[errenkada][zutabea]);
	}
	
	
	
}
