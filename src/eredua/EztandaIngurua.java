package eredua;

public class EztandaIngurua  implements BonbaEztandaPortaera {
	String kolorea="urdina";
	
	public void bonbaApurtu(int x, int y) {
		EreduMapa mapa = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa();
		
		int posHasX=0, posAmaX=16;
		int posHasY=0, posAmaY=10;
		//eskiñetakuk ezpari
		if (x>0) posHasX=x-1;
		if (x<16) posAmaX=x+1;
		if (y>0) posHasY=y-1;
		if (y<10) posAmaY=y+1;
		
		for (int i=posHasX; i<=posAmaX;i++) {
			for (int j=posHasY;j<=posAmaY;j++) {
				if (!(i == x && j == y)) {
					mapa.babestuBlokea(j,i,kolorea);
				}
			}
		}
		
	}
}
