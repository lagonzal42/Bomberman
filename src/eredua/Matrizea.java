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
<<<<<<< HEAD
=======
	
	public Gelaxka getGelaxka(int i, int j){
		return this.eMapa.getGelaxka(i, j);
	}
	
	public Jokalaria getJokalaria() {
		return jok;
	}
	
	
	public void mugituJokalaria(Mugimendu mugimendu)
	{
		eMapa.mugituJokalaria(mugimendu);
	}

	public void bonbaJarri() {
		eMapa.bonbaJarri();
	}
	
//	public void blokeBigunakApurtu(int x, int y) {
//		eMapa.blokeBigunakApurtu(x, y);
//	}
	
	public void etsaiakMurriztu() {
		etsaiKop --;
		if(etsaiKop == 0) {
			amaitu = true;
		}
	}
	
	public void etsaiakGelditu() {
		eMapa.etsaiakGelditu();
	}
	
	public boolean partidaBukatu()
	{
		return amaitu;
	}
	
>>>>>>> branch 'master' of https://github.com/lagonzal42/Bomberman.git
}
