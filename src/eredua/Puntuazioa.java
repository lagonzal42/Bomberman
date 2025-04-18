package eredua;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.Timer;

public class Puntuazioa {
	private int punt;
	private Timer timer;
	private int denbora;
	private boolean amaitu;
	
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
	
	public boolean errekorraDa() {
		try {
			Scanner scan = new Scanner(new FileReader("src/common/errekorrak.txt"));
			String lerroa;
			int i = 0;
			while(scan.hasNext()) {
				lerroa = scan.nextLine();
				String[] parteak = lerroa.split("::");
				int pPunt = Integer.parseInt(parteak[0]);
				if(pPunt < punt) {
					return true;
				}
				i++;
			}
			scan.close();
			if(i < 10) {
				return true;
			}
			return false;
		}catch(IOException e) {
			System.out.println("ez da fitxategirik aurkitu.");
			return false;
		}
	}
	
	public void fitxategiaEguneratu() throws FileNotFoundException, UnsupportedEncodingException {
		ArrayList<String> puntuazioak = new ArrayList<>();
		
		File fitxategia = new File("src/common/errekorrak.txt");
		if(fitxategia.exists()) {
			Scanner scan = new Scanner(fitxategia);
			while(scan.hasNextLine()) {
				puntuazioak.add(scan.nextLine());
			}
			scan.close();
		}
		Date data = Calendar.getInstance().getTime();
		
		if(!datuakDitu(puntuazioak,data, punt)) {
			puntuazioak.add(punt + "::"+ data);			
			List<String> top10 = puntuazioak.stream().sorted((a, b) -> {
				int puntuB = Integer.parseInt(b.split("::")[0]);
				int puntuA = Integer.parseInt(a.split("::")[0]);
				return Integer.compare(puntuB, puntuA);
			})
					.limit(10)
					.collect(Collectors.toList());
			
			PrintWriter writer = new PrintWriter("src/common/errekorrak.txt", "UTF-8");
			for(String lerroa : top10) {
				writer.println(lerroa);
			}
			writer.close();
		}
	}

	private boolean datuakDitu(ArrayList<String> datuak, Date data, int punt2) {
		
		String pData = data.toString();
		for(String d:datuak) {
			String[] s = d.split("::");
			if(Integer.parseInt(s[0]) == punt2 && s[1].equals(pData)) {
				return true;
			}
		}
		return false;
	}
		

}
