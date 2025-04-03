package eredua;

public class MatrizeFactory {
	private static MatrizeFactory nMP;
		private MatrizeFactory() {}
		
		public MatrizeFactory getMF() {
			if (nMP==null) {
				nMP = new MatrizeFactory();
			}
			return nMP;
		}
		
		public Matrize matrizeaSortu() {
			//TODO
		}

}

