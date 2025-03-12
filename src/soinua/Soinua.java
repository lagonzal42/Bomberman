package soinua;

import java.util.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import eredua.Matrizea;

public abstract class Soinua{
	
	protected Clip clip;
	
	protected Soinua(String pMusika) {
		try {
			String filePath = "/soinua/soinuak/" + pMusika + ".wav";
			clip = AudioSystem.getClip();
			
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
			
			clip.open(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setBolumena(float decibelios) {
        if (clip != null) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(decibelios);
        }
    }
	
	public abstract void hasi();
	public abstract void pausatu();

}
