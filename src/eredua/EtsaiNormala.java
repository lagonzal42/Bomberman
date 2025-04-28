package eredua;

import java.util.ArrayList;

public class EtsaiNormala extends Etsaia{

	public EtsaiNormala(int x, int y) {
		super(x, y);
	}

	@Override
	protected void mugitu() {
		
		ArrayList<Integer> mugimenduPosibleak = new ArrayList<>();
		if (mugituAhal(this.yPos-1,this.xPos)) {
			mugimenduPosibleak.add(1);
		} 
		if (mugituAhal(this.yPos+1,this.xPos)) {
			mugimenduPosibleak.add(2);
		}
		if (mugituAhal(this.yPos,this.xPos-1)) {
			mugimenduPosibleak.add(3);
		} 
		if (mugituAhal(this.yPos,this.xPos+1)) {
			mugimenduPosibleak.add(4);
		}
		mugimenduPosibleak.add(5);
		int zenbRandom = Dadoa.getNireDadoa().zenbakiaAukeratu(1,mugimenduPosibleak.size()+1);
		int zenb = mugimenduPosibleak.get(zenbRandom-1);
		if (zenb == 1) {
			mugituGora();
		} else if (zenb == 2) {
			mugituBehera();
		} else if (zenb == 3) {
			mugituEzkerra();
		} else if (zenb == 4) {
			mugituEskuma();
		}
	}

}
