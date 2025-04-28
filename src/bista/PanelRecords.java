package bista;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelRecords extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;

	public PanelRecords() {
		setLayout(new GridLayout(10,1,0,0));
		try {
			hasieratu();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void hasieratu() throws FileNotFoundException, UnsupportedEncodingException {
		this.removeAll();
		ArrayList<String> puntuazioak = new ArrayList<>();
		
		File fitxategia = new File("src/common/errekorrak.txt");
		if(fitxategia.exists()) {
			Scanner scan = new Scanner(fitxategia);
			while(scan.hasNextLine()) {
				puntuazioak.add(scan.nextLine());
			}
			scan.close();
		}
		
		for(String lerroa : puntuazioak) {
			String[] infoa = lerroa.split("::");
			JLabel re= new JLabel(infoa[0]+ " puntu "+ infoa[1]);
			re.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(re);
		}
		
	}

	@Override
	public void teklaSakatuta(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			JokoBista.getJokoBista().aldatuPanela("Hasiera");
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
			
		
	}

}
