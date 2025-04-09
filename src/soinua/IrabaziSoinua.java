package soinua;

public class IrabaziSoinua extends Soinua {

	protected IrabaziSoinua(String pMusika) {
		super(pMusika);
	}

	@Override
	public void hasi() {
//		if (clip.isRunning()) {
//            clip.stop();
//        }
//        clip.setFramePosition(0);
        clip.start();
	}

	@Override
	public void pausatu() {
		clip.stop();
		
	}

}
