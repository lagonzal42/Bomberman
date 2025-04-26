package eredua;

public class EztandaHogei implements BonbaEztandaPortaera{
	String kolorea="morea";
	
	public void bonbaApurtu(int x, int y) {
		EreduMapa mapa = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa();
		//berton
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(x, y).bonbaApurtu();
		//eskumata
		for (int kont=0; kont<=20; kont ++) {
				if (!mapa.apurtuBlokea(x,y+kont,kolorea)) break;
		}
		//ezkerreta
		for (int kont=0; kont<=20; kont ++) {
			if (!mapa.apurtuBlokea(x,y-kont,kolorea)) break;
		}
		//gora
		for (int kont=0; kont<=20; kont ++) {
			if (!mapa.apurtuBlokea(x+kont,y,kolorea)) break;
		}
		//behera
		for (int kont=0; kont<=20; kont ++) {
			if(!mapa.apurtuBlokea(x-kont,y,kolorea)) break;
		}
	}
	
//	public String getSuarenKolorea() {
//		return "morea";
//	}

}
