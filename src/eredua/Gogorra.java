package eredua;
import common.GelaxkaMota;

public class Gogorra extends Bloke{

	public Gogorra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void eguneratuGelaxka()
	{
		this.setChanged();
		this.notifyObservers(GelaxkaMota.GOGORRA);
	}

}
