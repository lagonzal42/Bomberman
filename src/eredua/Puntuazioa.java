package eredua;

import javax.swing.Timer;

public class Puntuazioa {
	private int punt;
	private Timer timer;
	private int denbora;
	
	public Puntuazioa() {
		timer = new javax.swing.Timer(1000, e ->{
			this.updateKont();
		});
		timer.start();
		punt = 0;
		denbora = 0;
	}

	private void updateKont() {
		denbora ++;	
	}
	
	//Puntuazioa aldatu daiteke(puesto por poner)
	public void blokeaApurtu() {
		punt += 10;
	}
	
	public void etsaiaHil() {
		if(denbora < 10) {
			punt += 100;
		}
		else if(denbora < 20) {
			punt += 50;
		}
		else {
			punt += 25;
		}
	}
	public void irabazi() {
		punt += 1000-(10*denbora);
	}
	
	public void galdu() {
		if(punt >= 200) {
			punt -= 200;			
		}
		else {
			punt = 0;
		}
	}
	
	public int getPuntuak() {
		return this.punt;
	}

}
