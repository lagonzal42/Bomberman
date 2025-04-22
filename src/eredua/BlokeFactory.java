package eredua;

public class BlokeFactory {
	private static BlokeFactory bf;
	
	private BlokeFactory() {
		
	}
	
	public static BlokeFactory getBF() {
		if(bf == null) {
			bf = new BlokeFactory();
		}
		return bf;
	}
	
	public Bloke createBloke(int type) {
		Bloke blok = null;
		
		if(type == 1) {
			blok = new Hutsik();
		}
		else if(type == 2) {
			blok = new Biguna();
		}
		else if(type == 3) {
			blok = new Gogorra();
		}
		else if(type == 4) {
			blok = new Irteera();
		}
		return blok;
	}
}
