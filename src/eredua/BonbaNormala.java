package eredua;

public class BonbaNormala implements BonbaPortaera{
	private int estaldura =1;
	
	public BonbaNormala() {
        //this.estaldura = estaldura;
    }
	
	@Override
	public int getBonbaEstaldura() {
		return this.estaldura;
	}

}
