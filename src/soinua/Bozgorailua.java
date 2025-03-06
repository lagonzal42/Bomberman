package soinua;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Bozgorailua {
	
	private Clip clip;
	private static Bozgorailua backMusic = null; 
	private static Bozgorailua bonbaMusic = null; 
	
	private Bozgorailua(String musika) {
		try {
			String filePath = "/soinua/soinuak/" + musika + ".wav";
			clip = AudioSystem.getClip();
			
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
			
			clip.open(inputStream);
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
	
	public void bonbaEgin() {
		if(clip.isRunning()) {
			clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}
	
}
