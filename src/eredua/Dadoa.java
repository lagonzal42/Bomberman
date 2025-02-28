package eredua;

import java.util.Random;

public class Dadoa {
	
	private static Dadoa nireDadoa;
	private Random ran;
	
	private Dadoa()
	{
		this.ran = new Random();
	}
	
	public static Dadoa getNireDadoa()
	{
		if (nireDadoa == null)
			nireDadoa = new Dadoa();
		return (nireDadoa);
	}
	
	public boolean gainditzenDu(double gainditzeko)
	{
		return (ran.nextDouble() > gainditzeko);
	}
	
	public int zenbakiaAukeratu(int z1, int z2) 
	{
		return(ran.nextInt(z1,z2));
	}
}
