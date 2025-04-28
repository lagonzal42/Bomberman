package eredua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class EtsaiIntelijentea extends Etsaia{

	public EtsaiIntelijentea(int x, int y) {
		super(x, y);
	}
	
	protected void mugitu() {
		int bidea = this.biderikMotzena();
		System.out.println("Bidea:"+bidea);
		
		if(bidea != -1) {
			int x = bidea%100;
			int y = bidea/100;
			
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
			ArrayList<Integer> mugimenduPosibleak = new ArrayList<>();
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
		int etsaiPos = yPos*100+xPos;
		int jokPos = JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getY()*100 + JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getJokalaria().getX();
		int pos = -1;
		
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		HashMap<Integer, Integer> backPointers = new HashMap<Integer,Integer>();
		ArrayList<Integer> bidea = new ArrayList<Integer>();
		
		boolean aurkitua = false;
		aztertuGabeak.add(etsaiPos);
		backPointers.put(etsaiPos, null);
		
		while(!aztertuGabeak.isEmpty() && !aurkitua) {
			Integer unekoa = aztertuGabeak.peek();
			int y = unekoa /100;
			int x = unekoa %100;
			if(JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x)!= null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(y, x).getJokalaria()!=null) {
				aurkitua = true;
			}
			else {
				int auk1 = (y-1)*100+x;
				int auk2 = (y+1)*100+x;
				int auk3 = y*100+x-1;
				int auk4 = y*100+x+1;
				if(!backPointers.containsKey(auk1) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/100, auk1%100)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/100, auk1%100).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk1/100, auk1%100).getBonba()==null) {
					backPointers.put(auk1, unekoa);
					aztertuGabeak.add(auk1);
				}
				if(!backPointers.containsKey(auk2) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/100, auk2%100)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/100, auk2%100).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk2/100, auk2%100).getBonba()==null) {
					backPointers.put(auk2, unekoa);
					aztertuGabeak.add(auk2);
				}
				if(!backPointers.containsKey(auk3) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/100, auk3%100)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/100, auk3%100).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk3/100, auk3%100).getBonba()==null) {
					backPointers.put(auk3, unekoa);
					aztertuGabeak.add(auk3);
				}
				if(!backPointers.containsKey(auk4) && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/100, auk4%100)!=null && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/100, auk4%100).hutsikDago() && JokoKudeatzailea.getJokoKudeatzaileaa().getEreduMapa().getGelaxka(auk4/100, auk4%100).getBonba()==null) {
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

}
