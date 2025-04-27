package eredua;

public class Urdina extends Jokalaria{

	public Urdina() {
		super();
		this.color = "blue";
		int bonbaKop = Dadoa.getNireDadoa().zenbakiaAukeratu(1, 10);
		for(int i = 0; i < bonbaKop; i++) {
			if(Dadoa.getNireDadoa().gainditzenDu(0.5)) {
				bonbaGehitu(new BonbaNormala());			
			}
			else {
				bonbaGehitu(new UltraBonba());
			}
		}
	}
	
	@Override
	protected Bonba batGehitu() {
		if(Dadoa.getNireDadoa().gainditzenDu(0.5)) {
			return new BonbaNormala();			
		}
		else {
			return new UltraBonba();
		}
	}
}
