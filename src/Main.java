import bista.JokoBista;
import eredua.Matrizea;
import soinua.Bozgorailua;

public class Main {
	public static void main(String[] args) {
		Matrizea mat = Matrizea.getMatrizea();
		mat.hasieratuBista();
		Bozgorailua musika = Bozgorailua.getBozgorailua();
		musika.getMusika().hasi();
		
		while (!mat.partidaBukatu());
		JokoBista.getJokoBista().itxi();
		return;
	}
}
