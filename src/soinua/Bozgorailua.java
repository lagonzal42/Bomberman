package soinua;

import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import common.GelaxkaMota;
import eredua.Gelaxka;
import eredua.Matrizea;

public class Bozgorailua implements Observer{
	
	private Clip clip;
	private static Bozgorailua backMusic = null; 
	private static Bozgorailua bonbaMusic = null; 
	
	private Bozgorailua(String musika) {
		try {
			String filePath = "/soinua/soinuak/" + musika + ".wav";
			clip = AudioSystem.getClip();
			
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
			
			clip.open(inputStream);
			this.jarriListenerrak();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Bozgorailua getBackMusic() {
		if(backMusic==null) {
			backMusic = new Bozgorailua("backMusic");
		}
		return backMusic;
	}
	
	public void backMusicHasi()
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void backMusicPausatu() {
		clip.stop();
	}
	
	public static Bozgorailua getBonba() {
		if(bonbaMusic==null) {
			bonbaMusic = new Bozgorailua("bomba");
		}
		return bonbaMusic;
	}
	
	private void bonbaEgin() {
		if(clip.isRunning()) {
			clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		GelaxkaMota gelMota = (GelaxkaMota)arg;
		
		if(gelMota != null) {
			switch (gelMota)
			{
				case BIGUNA:
					break;
				case GOGORRA:
					break;
				case JOKALARIAGORA:
					break;
				case JOKALARIAEZKER:
					break;
				case JOKALARIAESKUIN:
					break;
				case BONBA:
					break;
				case JOKALARIBONBAREKIN:
					break;
				case BONBAESTANDA:
					this.getBonba().bonbaEgin();;
					break;
				case SUA:
					break;
				case JOKALARIASUAREKIN:
					break;
				default:
					break;
			}
		}
		
	}
	
	private void jarriListenerrak()
	{
		Matrizea m = Matrizea.getMatrizea();
		for (int y = 0; y < 11; y++)
		{
			for (int x = 0; x < 17; x++)
				m.getGelaxka(y, x).addObserver(this);
		}
		
	}
	
}
