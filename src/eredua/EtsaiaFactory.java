package eredua;

public class EtsaiaFactory {
	
	private static EtsaiaFactory etsFak;
	
	private EtsaiaFactory() {}
	
	public static EtsaiaFactory getEtsFactory() {
		if(etsFak == null) {
			etsFak = new EtsaiaFactory();
		}
		return etsFak;
	}
	
	public Etsaia etsaiaSortu(int mota, int y, int x) {
		Etsaia etsaia;
		
		if(mota == 1) {
			etsaia = new EtsaiNormala(y, x);
		}
		else {
			etsaia = new EtsaiIntelijentea(y, x);
		}
		return etsaia;
	}

}
