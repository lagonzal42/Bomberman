package eredua;

import bista.JokoBista;
import common.Mugimendu;
import soinua.Bozgorailua;

public class JokoKudeatzailea{
	
	private static JokoKudeatzailea nJK = null;
	private EreduMapa eMapa;
	private boolean irabazi = false;
	
	private JokoKudeatzailea() {
		
	}
	
	public static JokoKudeatzailea getJokoKudeatzaileaa()
	{
		if(nJK == null) {
			nJK = new JokoKudeatzailea();
		}
		return nJK;
	}
	
	public EreduMapa getEreduMapa() {
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
		irabazi = false;
	}
	
	public void setIrabazi() {
		irabazi = true;
	}
	
	public boolean getIrabazi() {
		return irabazi;
	}
}
