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
			Matrizea nMatrizea = null;
			if(type==1) {
				nMatrizea = new ClassicMatrize();
			}
			else if(type==2) {
				nMatrizea = new SoftMatrize();
			}
			else if(type==3) {
				nMatrizea = new EmptyMatrize();
			}		
		}

}

