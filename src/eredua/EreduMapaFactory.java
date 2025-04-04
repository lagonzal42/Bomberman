package eredua;

public class EreduMapaFactory {
	private static EreduMapaFactory nMP;
		private EreduMapaFactory() {}
		
		public static EreduMapaFactory getMF() {
			if (nMP==null) {
				nMP = new EreduMapaFactory();
			}
			return nMP;
		}
		
		public EreduMapa mapaSortu(int pMapaMota, int pJokalariMota)
		{
			EreduMapa eM = null;
			
			if(pMapaMota==1)
				eM = new EreduMapaClassic(pJokalariMota);
			else if(pMapaMota==2)
				eM = new EreduMapaSoft(pJokalariMota);
			else if(pMapaMota==3)
				eM = new EreduMapaEmpty(pJokalariMota);
			return (eM);
		}

}

