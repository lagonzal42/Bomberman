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
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(1));
					zerrenda[i][j].setJokalaria(jok);
					
				}
				else if(i == 10 && j == 16) {
					zerrenda[i][j].setBlokea(BlokeFactory.getBF().createBloke(4));
				}
				//ez daude blokerik
				//proba kutre
				else if(dado.gainditzenDu(0.95) && etsaiKop < 11) {
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
