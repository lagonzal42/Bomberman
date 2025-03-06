import bista.JokoBista;
import eredua.Matrizea;
import soinua.Bozgorailua;

public class Main {
	public static void main(String[] args) {
		
		JokoBista jb = new JokoBista();
		
		Bozgorailua musika = Bozgorailua.getBackMusic();
		musika.backMusicHasi();
		
		Matrizea mat = Matrizea.getMatrizea();
		
	}
}
