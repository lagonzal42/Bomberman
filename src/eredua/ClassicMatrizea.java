package eredua;

import bista.JokoBista;
import eredua.Matrizea;

public class ClassicMatrizea extends Matrizea {
	public ClassicMatrizea() {
		super(1);
	}
	
	private Gelaxka[][] matrizeaSortu() {
		Dadoa dado = Dadoa.getNireDadoa();
		Gelaxka[][] zerrenda = new Gelaxka[lerroak][zutabeak];
		for(int i = 0; i < lerroak; i++) {
			for(int j = 0; j < zutabeak; j++) {
				zerrenda[i][j] = new Gelaxka();
				if(j == 0 && i == 0) {
					//jokalaria
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setJokalaria(new Zuria());
					
				}
				else if((j == 0 && i == 1) || (j == 1 && i == 0)) {
					//hutsik
					zerrenda[i][j].setBlokea(new Hutsik()); 
				}
				else if((j % 2 != 0 && i % 2 != 0)) {
					//bloke gogorra
					zerrenda[i][j].setBlokea(new Gogorra()); 
				}
				else if(dado.gainditzenDu(0.4)){
					//bloke biguna
					zerrenda[i][j].setBlokea(new Biguna());
					blokeKop++;
				}
				//proba kutre
				else if(dado.gainditzenDu(0.9) && etsaiKop < 7) {
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setEtsaia(new Etsaia(j,i));
					etsaiKop ++;
				}
				else {
					//hutsik
					zerrenda[i][j].setBlokea(new Hutsik());
				}
			}
		}
		return zerrenda;
	}
	

}
