package eredua;

public class EreduMapaEmpty extends EreduMapa{
	
	public EreduMapaEmpty(int pJokalariMota) {
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
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setJokalaria(jok);
					
				}
				else if((j == 0 && i == 1) || (j == 1 && i == 0)) {
					//hutsik
					zerrenda[i][j].setBlokea(new Hutsik()); 
				}
				//ez daude blokerik
				//proba kutre
				else if(dado.gainditzenDu(0.95) && etsaiKop < 11) {
					zerrenda[i][j].setBlokea(new Hutsik());
					zerrenda[i][j].setEtsaia(new Etsaia(j,i));
					zerrenda[i][j].getEtsaia().hasieratuEtsaia();
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
