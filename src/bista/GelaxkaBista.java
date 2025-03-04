package bista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import eredua.Matrizea;

public class GelaxkaBista extends JLabel implements Observer{
	
	private String irudia = null;
	public GelaxkaBista() {
		super();
	}
	
	public void setIrudia(String pIrudia) {
		this.irudia = pIrudia;
	}
	
	public String getIrudia() {
		return this.irudia;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public void eguneratu() {
		//String	path;
		//Matrizea	m = Matrizea.getMatrizea();
		//TODO for eta if-ak
		//switch (m.getJokalaria().getAzkenMugi()??) {
		//	case JOKALARIA:
		//		gel.setIrudia("/bista/Sprites/whiteup1.png");
		//		//path = "/bista/Sprites/whiteup1.png";
		//		break;
		//	case HUTSIK:
		//		gel.setIrudia("/bista/Sprites/whiteleft1.png");
		//		//path = "/bista/Sprites/whiteleft1.png";
		//		break;
		//	case BONBA:
		//		gel.setIrudia("/bista/Sprites/whiteright1.png");
		//		//path = "/bista/Sprites/whiteright1.png";
		//		break;
		//	case SUA:
		//		gel.setIrudia("/bista/Sprites/whiteright1.png");
		//		//path = "/bista/Sprites/whiteright1.png";
		//		break;
		//	case BIGUNA:
		//		gel.setIrudia("/bista/Sprites/whiteright1.png");
		//		//path = "/bista/Sprites/whiteright1.png";
		//		break;
		//	case GOGORRA:
		//		gel.setIrudia("/bista/Sprites/whiteright1.png");
		//		//path = "/bista/Sprites/whiteright1.png";
		//		break;
		//	default:
		//		gel.setIrudia("/bista/Sprites/whitedown1.png");
		//		//path = "/bista/Sprites/whitedown1.png";
		//		break;
		//}
		//TODO 
	}
}
