package bista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelOptions extends JPanel implements PanelEgoera{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelOptions() {
		setLayout(new BorderLayout());
		setOpaque(false);
		gehituOsagaiak();
	}

	private void gehituOsagaiak() {
		JLabel titleLabel = new JLabel("Instrukzioak");
		titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JPanel erdikoPanela = new JPanel();
		erdikoPanela.setLayout(new GridLayout(6,1));
		JLabel g1 = new JLabel("<- gezia : ezkerrera mugitzeko.");
		JLabel g2 = new JLabel("-> gezia : eskumara mugitzeko.");
		JLabel g3 = new JLabel("^  gezia : gorantza mugitzeko.");
		JLabel g4 = new JLabel("v  gezia : beherantza mugitzeko.");
		
		JLabel b = new JLabel("b   tekla : bonba jartzeko.");
		erdikoPanela.add(g1);
		erdikoPanela.add(g2);
		erdikoPanela.add(g3);
		erdikoPanela.add(g4);
		erdikoPanela.add(b);
		add(erdikoPanela, BorderLayout.CENTER);
		JLabel atera = new JLabel("pantailatik ateratzeko spc sakatu.");
		atera.setHorizontalAlignment(SwingConstants.CENTER);
		add(atera,BorderLayout.SOUTH);
		
	}

	@Override
	public void teklaSakatuta(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			JokoBista.getJokoBista().aldatuPanela("Hasiera");
			break;
		}
	}

}
