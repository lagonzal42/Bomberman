package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import eredua.JokoKudeatzailea;
import soinua.Bozgorailua;

public class PanelHasiera extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;
	
	private Image titulua;
	private Image[] pertsonaiak;
	private Image backHasiera;
	private JPanel pertsonaienPanela;
	private JPanel mapenPanela;
	private JRadioButton classic;
	private JRadioButton soft;
	private JRadioButton empty;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private int aukeratutakoPertsonaia = 1;

	/**
	 * Create the panel.
	 */
	public PanelHasiera() {
		this.irudiakKargatu();
		setLayout(new BorderLayout());
		setOpaque(false);
		gehituOsagaiak();
	}
	
	 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(backHasiera != null) {
            g.drawImage(backHasiera, 0, 0, getWidth(), getHeight(), this);
        }
    }
	 
	private void gehituOsagaiak() {
		setLayout(new BorderLayout());
		
		//hasierako panelaren goikaldean tituluaren irudia jartzen du(zentroan)
		JLabel titleLabel = new JLabel(new ImageIcon(titulua));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		//erdian elementu bat baino gehiago egon ahal izateko panel bat sortu
		JPanel erdikoPanela = new JPanel();
		erdikoPanela.setLayout(new BorderLayout());
		erdikoPanela.setOpaque(false);
		
		//jokalaria erabakitzeko textua
		JLabel erabaki = new JLabel("<Jokalaria eta mapa aukeratu>");
		erabaki.setFont(new Font("Times New Roman", Font.BOLD, 24));
		erabaki.setForeground(Color.BLACK);
		erabaki.setHorizontalAlignment(SwingConstants.CENTER);
		erabaki.setVerticalAlignment(SwingConstants.NORTH);
		erdikoPanela.add(erabaki, BorderLayout.NORTH);
		
		//Jokalarien irudiak erakutzi
		pertsonaienPanela = new JPanel(new GridLayout(1,2,0,0));
		pertsonaienPanela.setOpaque(false);
		updatePertsonaienPanela();
		erdikoPanela.add(pertsonaienPanela, BorderLayout.CENTER);
		
		mapenPanela = new JPanel(new GridLayout(1,3,0,0));
		mapenPanela.setOpaque(false);
		classic = new JRadioButton("Classic");
		classic.setHorizontalAlignment(SwingConstants.CENTER);
		classic.setOpaque(false);
		classic.setFocusable(false);
		classic.setSelected(true);
		
		soft = new JRadioButton("Soft");
		soft.setHorizontalAlignment(SwingConstants.CENTER);
		soft.setOpaque(false);
		soft.setFocusable(false);
		
		empty = new JRadioButton("Empty");
		empty.setHorizontalAlignment(SwingConstants.CENTER);
		empty.setOpaque(false);
		empty.setFocusable(false);
		
		buttonGroup.add(classic);
		buttonGroup.add(soft);
		buttonGroup.add(empty);
		mapenPanela.add(classic);
		mapenPanela.add(soft);
		mapenPanela.add(empty);
		erdikoPanela.add(mapenPanela, BorderLayout.SOUTH);
		
		add(erdikoPanela, BorderLayout.CENTER);
		
		
		
		//Mezua jarri
		JLabel mezua = new JLabel("<space> to start, <m>usic, <o>ptions && <esc> to exit");
		mezua.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        mezua.setForeground(Color.BLACK);
        mezua.setHorizontalAlignment(SwingConstants.CENTER);
        add(mezua, BorderLayout.SOUTH);
		
		
	}
	
	public void updatePertsonaienPanela() {
		pertsonaienPanela.removeAll();
		ImageIcon icon;
		for(int i = 1; i < pertsonaiak.length; i++) {
			if(i == aukeratutakoPertsonaia) {
				icon = new  ImageIcon(getClass().getResource("/bista/Sprites/bomber"+i+"selectedhandia.png"));
			}
			else {
				icon = new ImageIcon(pertsonaiak[i]);	
			}
			JLabel perLabel = new JLabel(icon);
			pertsonaienPanela.add(perLabel);
		}
		pertsonaienPanela.revalidate();
		pertsonaienPanela.repaint();
	}

	private void irudiakKargatu() {
		backHasiera = new ImageIcon(getClass().getResource("/bista/Sprites/back.png")).getImage();
		titulua = new ImageIcon(getClass().getResource("/bista/Sprites/title.png")).getImage();
		pertsonaiak = new Image[3];
		for (int i = 1; i < pertsonaiak.length; i++) {
			pertsonaiak[i] = new ImageIcon(getClass().getResource("/bista/Sprites/bomber"+i+"handia.png")).getImage();
		}	
	}
	
	public void setAukeratutakoPertsonaia(int index) {
        this.aukeratutakoPertsonaia = index;
        updatePertsonaienPanela();
    }
	
	public int getAukeratutakoMapa() {
		if(classic.isSelected()) {
			return 1;
		}
		else if(soft.isSelected()) {
			return 2;
		}
		else {
			return 3;
		}
	}

	@Override
	public void teklaSakatuta(KeyEvent e) {
		System.out.println("1");
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			System.out.println("2");
			//TODO: aukeratu hurrengo pertsonaia
			if(aukeratutakoPertsonaia -1 == 1) {
				aukeratutakoPertsonaia --;
				this.setAukeratutakoPertsonaia(aukeratutakoPertsonaia);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(aukeratutakoPertsonaia + 1 == 2) {
				aukeratutakoPertsonaia ++;
				this.setAukeratutakoPertsonaia(aukeratutakoPertsonaia);
			}
			break;
		case KeyEvent.VK_M:
			Bozgorailua musika = Bozgorailua.getBozgorailua();
			Bozgorailua.getBozgorailua().musikaPausatuHasi();
			break;
		case KeyEvent.VK_O:
			JokoBista.getJokoBista().aldatuPanela("Options");
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("2");
			int aukeratutakoMapa = this.getAukeratutakoMapa();
			JokoBista.getJokoBista().setPanelJokoaFondoa(aukeratutakoMapa);
			System.out.println(aukeratutakoMapa + " " + aukeratutakoPertsonaia);
			JokoKudeatzailea.getJokoKudeatzaileaa().mapaSortu(aukeratutakoMapa, aukeratutakoPertsonaia);
			JokoBista.getJokoBista().aldatuPanela("Jokoa");
			break;
		}
		
	}
}
