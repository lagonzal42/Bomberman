package soinua;

public class BozgorailuFactory {
	
	private static BozgorailuFactory bF=null;
	private static Soinua backMusic=null;
	private static Soinua bonba=null;
	private static Soinua galdu = null;
	
	private BozgorailuFactory() {
		
	}
	
	public static BozgorailuFactory getBF() {
		if(bF==null) {
			bF=new BozgorailuFactory();
		}
		return bF;
	}
	
	public static Soinua getMusika() {
        if (backMusic == null) {
            backMusic = new AtzekoMusika("backMusic");
        }
        return backMusic;
    }

    public static Soinua getBonba() {
        if (bonba == null) {
            bonba = new BonbaSoinua("bomba");
        }
        return bonba;
    }
    
    public static Soinua getGaldu() {
        if (galdu == null) {
            galdu = new GalduSoinua("galdu");
        }
        return galdu;
    }

}
