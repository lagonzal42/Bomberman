package eredua;

public class Zuria extends Jokalaria{

	public Zuria ()
	{
		super();
		this.bonbaKop = 10;
		this.color = "white";
	}
	
	public BonbaPortaera getBonba()
	{
		BonbaPortaera berria = null;
		
		if (this.bonbaKop > 0)
		{
			this.bonbaKop--;
			berria = new BonbaNormala();

			if (this.bonbaKop ==0) {
				bonbaBarik();
			}
		}
		return (berria);
	}	
}
