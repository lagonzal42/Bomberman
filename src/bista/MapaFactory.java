package bista;

public class MapaFactory {
	private static MapaFactory nMP;
	private MapaFactory() {}
	
	public MapaFactory getMF() {
		if (nMP==null) {
			nMP = new MapaFactory();
		}
		return nMP;
	}
}
