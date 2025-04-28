package eredua;

import bista.JokoBista;
import eredua.JokoKudeatzailea;

public class EreduMapaClassic extends EreduMapa {
	public EreduMapaClassic(int pJokalariMota) {
		super();
		jok = JokalariFactory.getJokFactory().sortuJokalaria(pJokalariMota);
		gelaxkak = matrizeaSortu();
	}
	
	private Gelaxka[][] matrizeaSortu() {
		Dadoa dado = Dadoa.getNireDadoa();
		Gelaxka[][] zerrenda = new Gelaxka[lerroak][zutabeak];	
		for(int i = 0; i < lerroak; i++) {
			for(int j = 0; j < zutabeak; j++) {
				zerrenda[i][j] = new Gelaxka();
				if(j == 0 && i == 0) {
					//jokalaria
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(1));
					zerrenda[i][j].setJokalaria(jok);
					
				}
				else if((j == 0 && i == 1) || (j == 1 && i == 0)) {
					//hutsik
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(1));
					//zerrenda[i][j].setBlokea(new Hutsik()); 
				}
				else if(i == 10 && j == 16) {
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(4));
				}
				else if((j % 2 != 0 && i % 2 != 0)) {
					//bloke gogorra
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(3));
					//zerrenda[i][j].setBlokea(new Gogorra()); 
				}
				else if(dado.gainditzenDu(0.4)){
					//bloke biguna
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(2));
					//zerrenda[i][j].setBlokea(new Biguna());
					blokeKop++;
				}
				//proba kutre
				else if(dado.gainditzenDu(0.9) && etsaiKop < 7) {
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(1));
					//zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setEtsaia(EtsaiaFactory.getEtsFactory().etsaiaSortu(Dadoa.getNireDadoa().zenbakiaAukeratu(0,2), j, i));
					zerrenda[i][j].getEtsaia().hasieratuEtsaia();
					etsaiKop ++;
				}
				else {
					//hutsik
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(1));
					//zerrenda[i][j].setBlokea(new Hutsik());
				}
			}
		}
		return zerrenda;
	}
	
	
}
