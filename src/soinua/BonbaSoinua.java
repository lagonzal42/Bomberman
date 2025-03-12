package soinua;

public class BonbaSoinua extends Soinua{

	protected BonbaSoinua(String pMusika) {
		super(pMusika);
	}

	@Override
	public void hasi() {
		if (clip.isRunning()) {
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
		
	}

	@Override
	public void pausatu() {
		clip.stop();
		
	}

}
