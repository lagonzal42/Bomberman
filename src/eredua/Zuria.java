package eredua;

public class Zuria extends Jokalaria{

	public Zuria ()
	{
		super();
		this.color = "white";
		for (int i = 0; i < 10; i++) {
			bonbaGehitu(new BonbaNormala());
		}
	}
	
	@Override
	protected Bonba batGehitu() {
		return new BonbaNormala();
	}
}
