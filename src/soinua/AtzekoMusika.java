package soinua;


import javax.sound.sampled.Clip;

public class AtzekoMusika extends Soinua{

	protected AtzekoMusika(String pMusika) {
		super(pMusika);
	}

	@Override
	public void hasi() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}

	@Override
	public void pausatu() {
		clip.stop();
		
	}

	public void reset() {
		clip.setFramePosition(0);
		
	}

}
