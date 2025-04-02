package eredua;

public class JokalariFactory {
	
	private static JokalariFactory jokFak;
	
	private JokalariFactory(){}
	
	public static JokalariFactory getJokFactory()
	{
		if (jokFak == null)
			jokFak = new JokalariFactory();
		return (jokFak);
	}
	
	public Jokalaria sortuJokalaria(int pJokMota)
	{
		Jokalaria jokBerria;
		
		if (pJokMota == 1)
			jokBerria = new Zuria();
		else
			jokBerria = new Beltza();
		return (jokBerria);
	}
}
