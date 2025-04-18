package eredua;

import common.Mugimendu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.Timer;

public class Etsaia {
	
	private int xPos;
	private int yPos;
	private Mugimendu azkenMugi;
	private Timer denbora;
	
	public Etsaia(int x, int y) {
		xPos = x;
		yPos = y;
		azkenMugi = Mugimendu.ESKUIN;
	}
	
	public void hasieratuEtsaia() {
		denbora = new Timer(1000, e ->{
			mugitu();
		});
		denbora.setRepeats(true);
		denbora.start();
	}
	
	private void mugitu() {
		int bidea = this.biderikMotzena();
		
		if(bidea != -1) {
			int x = bidea%10;
			int y = bidea/10;
			
			if(x == this.xPos-1 && this.mugituAhal(y, x)) {
				this.mugituEzkerra();
			}
			else if(x == this.xPos+1 && this.mugituAhal(y, x)) {
				this.mugituEskuma();
			}
			else if(y == this.yPos-1 && this.mugituAhal(y, x)) {
				this.mugituGora();
			}
			else if(y == this.yPos+1 && this.mugituAhal(y, x)) {
				this.mugituBehera();
			}
		}
		else {
			ArrayList<Integer> mugimenduPosibleak = new ArrayList();
			if (mugituAhal(this.yPos-1,this.xPos)) {
				mugimenduPosibleak.add(1);
			} 
			if (mugituAhal(this.yPos+1,this.xPos)) {
				mugimenduPosibleak.add(2);
			}
			if (mugituAhal(this.yPos,this.xPos-1)) {
				mugimenduPosibleak.add(3);
			} 
			if (mugituAhal(this.yPos,this.xPos+1)) {
				mugimenduPosibleak.add(4);
			}
			mugimenduPosibleak.add(5);
			int zenbRandom = Dadoa.getNireDadoa().zenbakiaAukeratu(1,mugimenduPosibleak.size()+1);
			int zenb = mugimenduPosibleak.get(zenbRandom-1);
			if (zenb == 1) {
				mugituGora();
			} else if (zenb == 2) {
				mugituBehera();
			} else if (zenb == 3) {
				mugituEzkerra();
			} else if (zenb == 4) {
				mugituEskuma();
			}	
		}
		
	}
	
	//smart
	private int biderikMotzena() {
		int etsaiPos = yPos*10+xPos;
		int jokPos = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getY()*10 + JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getX();
		int pos = -1;
		
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		HashMap<Integer, Integer> backPointers = new HashMap<Integer,Integer>();
		ArrayList<Integer> bidea = new ArrayList<Integer>();
		
		boolean aurkitua = false;
		aztertuGabeak.add(etsaiPos);
		backPointers.put(etsaiPos, null);
		
		while(!aztertuGabeak.isEmpty() && !aurkitua) {
			Integer unekoa = aztertuGabeak.peek();
			int y = unekoa /10;
			int x = unekoa %10;
			if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x).getJokalaria()!=null) {
				aurkitua = true;
			}
			else {
				int auk1 = (y-1)*10+x;
				int auk2 = (y+1)*10+x;
				int auk3 = y*10+x-1;
				int auk4 = y*10+x+1;
				if(!backPointers.containsKey(auk1) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/10, auk1%10)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/10, auk1%10).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/10, auk1%10).getBonba()==null) {
					backPointers.put(auk1, unekoa);
					aztertuGabeak.add(auk1);
				}
				if(!backPointers.containsKey(auk2) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/10, auk2%10)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/10, auk2%10).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/10, auk2%10).getBonba()==null) {
					backPointers.put(auk2, unekoa);
					aztertuGabeak.add(auk2);
				}
				if(!backPointers.containsKey(auk3) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/10, auk3%10)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/10, auk3%10).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/10, auk3%10).getBonba()==null) {
					backPointers.put(auk3, unekoa);
					aztertuGabeak.add(auk3);
				}
				if(!backPointers.containsKey(auk4) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/10, auk4%10)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/10, auk4%10).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/10, auk4%10).getBonba()==null) {
					backPointers.put(auk4, unekoa);
					aztertuGabeak.add(auk4);
				}
				aztertuGabeak.remove();
			}
		}
		if(aurkitua) {
			int unekoa = aztertuGabeak.poll();
			while(backPointers.get(unekoa) != null) {
				bidea.add(0,unekoa);
				unekoa = backPointers.get(unekoa);
			}
			//interesatzen zaigun pozizioa
			if(!bidea.isEmpty()) {
				pos = bidea.get(0);				
			}
		}
		return pos;
		
	}
	//smart
	
	private void mugituGora() {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos -1, xPos).setEtsaia(this);
		this.yPos = this.yPos -1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituBehera() {
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos +1, xPos).setEtsaia(this);
		this.yPos = this.yPos +1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEzkerra() {
		this.setAzkenMugi(Mugimendu.EZKER);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos -1).setEtsaia(this);
		this.xPos = this.xPos -1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void mugituEskuma() {
		this.setAzkenMugi(Mugimendu.ESKUIN);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).setEtsaia(null);
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos +1).setEtsaia(this);
		this.xPos = this.xPos +1;
		if (JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria() != null) {
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setHilda();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).getJokalaria().setAzkenMugi(Mugimendu.HILDAE);
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getPuntuazioa().galdu();
			JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().etsaiakGelditu();
		}
		JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(yPos, xPos).eguneratuGelaxka();
	}
	
	private void setAzkenMugi(Mugimendu m) {
		this.azkenMugi = m;
	}
	
	public Mugimendu getAzkenMugi() {
		return this.azkenMugi;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	public void geldituEtsaia() {
		if(denbora != null && denbora.isRunning()) {
			denbora.stop();
		}
		
	}
	private boolean mugituAhal(int y, int x) {
		boolean ema = false;
		Gelaxka gel = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x);
		if (!(y < 0 || x< 0 || y > 10 || x > 16) && gel != null && gel.hutsikDago() && gel.getBonba()==null && gel.getSua()==false && gel.getEtsaia()==null) {
			ema = true;
		}
		return ema;
	}
}	
