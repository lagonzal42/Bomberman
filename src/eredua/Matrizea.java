package eredua;

import bista.JokoBista;
import common.Mugimendu;

public class Matrizea{
	
	private static Matrizea nMatrizea = null;
	private EreduMapa eMapa;
	private int lerroak = 11;
	private int zutabeak = 17;
	private Jokalaria jok;
	private int blokeKop;
	private int etsaiKop;
	private boolean amaitu = false;
	
	private Matrizea() {
		
	}
	
	public static Matrizea getMatrizea()
	{
		if(nMatrizea == null) {
			nMatrizea = new Matrizea();
		}
		return nMatrizea;
	}
	
	//private izan behar du.
	public void mapaSortu(int pMapaMota, int pJokalariMota)
	{
		eMapa = EreduMapaFactory.getMF().mapaSortu(pMapaMota, pJokalariMota);
		jok = eMapa.getJokalaria();
	}
	
	public void hasieratuBista()
	{
		eMapa.hasieratuBista();
	}
	
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
	
	public void blokeBigunakApurtu(int x, int y) {
		eMapa.blokeBigunakApurtu(x, y);
	}
	
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
	
}
