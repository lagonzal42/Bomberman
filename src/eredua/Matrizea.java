package eredua;

import bista.JokoBista;
import common.Mugimendu;
import soinua.Bozgorailua;

public class Matrizea{
	
	private static Matrizea nMatrizea = null;
	private static EreduMapa eMapa;
	
	private Matrizea() {
		
	}
	
	public static Matrizea getMatrizea()
	{
		if(nMatrizea == null) {
			nMatrizea = new Matrizea();
		}
		return nMatrizea;
	}
	
	public static EreduMapa getEreduMapa() {
		return eMapa;
	}
	
	//private izan behar du.
	public void mapaSortu(int pMapaMota, int pJokalariMota)
	{
		eMapa = EreduMapaFactory.getMF().mapaSortu(pMapaMota, pJokalariMota);
		Bozgorailua.getBozgorailua().jarriListenerrak();
	}
	
	public void mapaErreseteatu() {
		eMapa = null;
	}
}
