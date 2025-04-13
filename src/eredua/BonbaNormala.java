package eredua;

public class BonbaNormala implements BonbaPortaera{
	
	public BonbaNormala() {
        //this.estaldura = estaldura;
    }
	
	@Override
	public void bonbaApurtu(int x, int y) {
		EreduMapa mapa = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa();
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
