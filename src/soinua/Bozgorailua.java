package soinua;

import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import common.GelaxkaMota;
import eredua.Gelaxka;
import eredua.JokoKudeatzailea;

public class Bozgorailua implements Observer{
	
	private static Bozgorailua boz=null;
	
	private Bozgorailua() {
		//this.jarriListenerrak();
	}
	
	public static Bozgorailua getBozgorailua() {
		if(boz==null) {
			boz=new Bozgorailua();
		}
		return boz;
	}
	
	public AtzekoMusika getMusika() {
		return (AtzekoMusika) BozgorailuFactory.getBF().getMusika();
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
					break;
				case SUA:
					BozgorailuFactory.getBF().getBonba().hasi();;
					break;
				case JOKALARIASUAREKIN:
					BozgorailuFactory.getBF().getMusika().pausatu();
					BozgorailuFactory.getBF().getGaldu().hasi();
					break;
				case JOKALARIAHARRAPATUTA:
					BozgorailuFactory.getBF().getMusika().pausatu();
					BozgorailuFactory.getBF().getGaldu().hasi();
					break;
				case IRABAZI:
					BozgorailuFactory.getBF().getMusika().pausatu();
					BozgorailuFactory.getBF().getIrabazi().hasi();
					break;
				default:
					break;
			}
		}
		
	}
	
	public void jarriListenerrak()
	{
		JokoKudeatzailea m = JokoKudeatzailea.getJokoKudeatzaileaa();
		for (int y = 0; y < 11; y++)
		{
			for (int x = 0; x < 17; x++)
				m.getEreduMapa().getGelaxka(y, x).addObserver(this);
		}
		
	}
	
}
