package eredua;

public abstract class Bonba {
	private BonbaEztandaPortaera bonbPort;
	
	protected Bonba (BonbaEztandaPortaera pBonbPort) {
		bonbPort= pBonbPort;
	}
	
	public void bonbaApurtu(int x, int y) {
		bonbPort.bonbaApurtu(x, y);
	}
	
	public void eztandaAldatu(BonbaEztandaPortaera pBonbPort) {
		this.bonbPort= pBonbPort;
	}
}
