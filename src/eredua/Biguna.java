package eredua;
import common.GelaxkaMota;

public class Biguna extends Bloke {

	public Biguna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void eguneratuGelaxka()
	{
		this.setChanged();
		this.notifyObservers(GelaxkaMota.BIGUNA);
	}
}
