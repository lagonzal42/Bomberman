package soinua;

public class BozgorailuFactory {
	
	private static BozgorailuFactory bF=null;
	private static Soinua backMusic=null;
	private static Soinua bonba=null;
	private static Soinua galdu = null;
	private static Soinua irabazi = null;
	
	private BozgorailuFactory() {
		
	}
	
	public static BozgorailuFactory getBF() {
		if(bF==null) {
			bF=new BozgorailuFactory();
		}
		return bF;
	}
	
	public AtzekoMusika getMusika(String abes) {
		AtzekoMusika musika = null;
		
		switch(abes) {
		case("pop"):
			musika = new AtzekoMusika("backMusic");
			break;
		case("heavy"):
			musika = new AtzekoMusika("acdc");
			break;
		case("classic"):
			musika = new AtzekoMusika("mozartNacht");
			break;
		default:
			musika = new AtzekoMusika("backMusic");
			break;
		}
		return musika;
	}

}
