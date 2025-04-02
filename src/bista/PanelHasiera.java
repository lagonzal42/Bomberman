package bista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelHasiera extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image titulua;
	private Image[] pertsonaiak;
	private Image backHasiera;
	private JPanel pertsonaienPanela;
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
		erdikoPanela.setLayout(new GridLayout(2,1,0,0));
		erdikoPanela.setOpaque(false);
		
		//jokalaria erabakitzeko textua
		JLabel erabaki = new JLabel("<Jokalaria erabaki -><- geziekin>");
		erabaki.setFont(new Font("Arial",Font.PLAIN,24));
		erabaki.setForeground(Color.BLACK);
		erabaki.setHorizontalAlignment(SwingConstants.CENTER);
		erabaki.setVerticalAlignment(SwingConstants.NORTH);
		erdikoPanela.add(erabaki);
		
		//Jokalarien irudiak erakutzi
		pertsonaienPanela = new JPanel(new GridLayout(1,2,0,0));
		pertsonaienPanela.setOpaque(false);
		updatePertsonaienPanela();
		erdikoPanela.add(pertsonaienPanela);
		
		add(erdikoPanela, BorderLayout.CENTER);
		
		//Mezua jarri
		JLabel mezua = new JLabel("<space> to start, <m>usic, <o>ptions && <esc> to exit");
		mezua.setFont(new Font("Arial", Font.PLAIN, 18));
        mezua.setForeground(Color.BLACK);
        mezua.setHorizontalAlignment(SwingConstants.CENTER);
        add(mezua, BorderLayout.SOUTH);
		
		
	}
	
	public void updatePertsonaienPanela() {
		pertsonaienPanela.removeAll();
		for(int i = 1; i < pertsonaiak.length; i++) {
			ImageIcon icon = new ImageIcon(pertsonaiak[i]);
			JLabel perLabel = new JLabel(icon);
			perLabel.setBorder(i == aukeratutakoPertsonaia ? BorderFactory.createLineBorder(Color.GRAY, 3) : null);
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
			pertsonaiak[i] = new ImageIcon(getClass().getResource("/bista/Sprites/bomber"+i+".png")).getImage();
		}	
	}
	
	public void setAukeratutakoPertsonaia(int index) {
        this.aukeratutakoPertsonaia = index;
        updatePertsonaienPanela();
    }


}
