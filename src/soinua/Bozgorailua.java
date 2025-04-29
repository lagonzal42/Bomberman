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
	private AtzekoMusika musika;
	private GalduSoinua galdu;
	private IrabaziSoinua irabazi;
	private BonbaSoinua bonba;
	private boolean musikaOn = false;
	
	private Bozgorailua() {
		musika = new AtzekoMusika("backMusic");
		galdu = new GalduSoinua("galdu");
		irabazi = new IrabaziSoinua("irabazi");
		bonba = new BonbaSoinua("bomba");
	}
	
	public static Bozgorailua getBozgorailua() {
		if(boz==null) {
			boz=new Bozgorailua();
		}
		return boz;
	}
	
	public AtzekoMusika getMusika() {
		return this.musika;
	}
	
	public void musikaReset() {
		this.musika.reset();
		this.galdu.pausatu();
		this.irabazi.pausatu();
	}
	
	public void musikaAldatu(String abes) {
		musika.pausatu();
		musika = BozgorailuFactory.getBF().getMusika(abes);
		musika.hasi();
		musikaOn = true;
	}
	
	public void musikaPausatuHasi() {
		if(!musikaOn) {
			musika.hasi();
			musikaOn = true;
		}
		else {
			musika.pausatu();
			musikaOn = false;
		}
		
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
					bonba.hasi();;
					break;
				case SUMOREA:
					bonba.hasi();
					break;
				case JOKALARIASUAREKIN:
					musika.pausatu();
					musikaOn = false;
					galdu.hasi();
					break;
				case JOKALARIAHARRAPATUTA:
					musika.pausatu();
					musikaOn = false;
					galdu.hasi();
					break;
				case IRABAZI:
					musika.pausatu();
					musikaOn = false;
					irabazi.hasi();
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
