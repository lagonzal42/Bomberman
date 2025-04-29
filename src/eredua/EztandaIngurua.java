package eredua;

public class EztandaIngurua  implements BonbaEztandaPortaera {
	String kolorea="urdina";
	
	public void bonbaApurtu(int x, int y) {
		EreduMapa mapa = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa();

		int posHasX=0, posAmaX=19;
		int posHasY=0, posAmaY=16;
		//eskiñakuk ezpari
		if (x>0) posHasX=x-1;
		if (x<19) posAmaX=x+1;
		if (y>0) posHasY=y-1;
		if (y<16) posAmaY=y+1;
		//bestelaik
		for (int i=posHasX; i<=posAmaX;i++) {
			for (int j=posHasY;j<=posAmaY;j++) {
				if (!(i == x && j == y)) {
					mapa.babestuBlokea(x,y,kolorea);
				}
			}
		}
	}
}
