package eredua;

public class Beltza extends Jokalaria {

	public Beltza ()
	{
		super();
		this.color = "black";
		bonbaGehitu(new UltraBonba());
	}
	
	@Override
	protected Bonba batGehitu() {
		return new UltraBonba();
	}
}
