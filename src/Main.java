import bista.JokoBista;
import eredua.Matrizea;
import soinua.Bozgorailua;

public class Main {
	public static void main(String[] args) {
		
		JokoBista jb = JokoBista.getJokoBista();
		
		Bozgorailua musika = Bozgorailua.getBozgorailua();
		musika.getMusika().hasi();
		
		
		Matrizea mat = Matrizea.getMatrizea();
		mat.hasieratuBista();
		
	}
}
