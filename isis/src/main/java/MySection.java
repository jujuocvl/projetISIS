import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MySection extends JPanel {

	private static final long serialVersionUID = 1L;
	private String titre;
	private String qte;

	public MySection(String titre, String qte) {
		super();
		setLayout(new GridLayout(0, 2));
		this.titre=titre;
		this.qte = qte;
		setUp();
	}

	public void setUp() {

		JTextField title=new JTextField(titre);
		JTextField qty=new JTextField(qte);
		add(title);
		add(qty);

		if(titre.equals("Entrées")) {
			title.setBackground(Color.yellow);
			qty.setBackground(Color.yellow);
		}
		if(titre.equals("Plats")) {
			title.setBackground(Color.orange);
			qty.setBackground(Color.orange);
		}
		if(titre.equals("Desserts")) {
			title.setBackground(Color.pink);
			qty.setBackground(Color.pink);
		}
	}
}

