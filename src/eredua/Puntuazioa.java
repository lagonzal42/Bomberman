package eredua;

import javax.swing.Timer;

public class Puntuazioa {
	private int punt;
	private Timer timer;
	private int denbora;
	public boolean amaitu;
	
	public Puntuazioa() {
		timer = new javax.swing.Timer(1000, e ->{
			this.updateKont();
		});
		timer.start();
		punt = 0;
		denbora = 0;
		amaitu = false;
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
		if(amaitu == false) {
			punt = (punt+1000-denbora);
			amaitu = true;			
		}
	}
	
	public void galdu() {
		if(amaitu == false) {
			if(punt >= 200) {
				punt -= 200;			
			}
			else {
				punt = 0;
			}
			amaitu = true;			
		}
	}
	
	public int getPuntuak() {
		return this.punt;
	}

}
