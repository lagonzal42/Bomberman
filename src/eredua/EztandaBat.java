package eredua;

public class EztandaBat implements BonbaEztandaPortaera {
	
	public void bonbaApurtu(int x, int y) {
		EreduMapa mapa = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa();
		//berton
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(x, y).bonbaApurtu();
		//eskumata
		for (int kont=0; kont<=1; kont ++) {
				if (!mapa.apurtuBlokea(x,y+kont)) break;
		}
		//ezkerreta
		for (int kont=0; kont<=1; kont ++) {
			if (!mapa.apurtuBlokea(x,y-kont)) break;
		}
		//gora
		for (int kont=0; kont<=1; kont ++) {
			if (!mapa.apurtuBlokea(x+kont,y)) break;
		}
		//behera
		for (int kont=0; kont<=1; kont ++) {
			if(!mapa.apurtuBlokea(x-kont,y)) break;
		}
	}

}
