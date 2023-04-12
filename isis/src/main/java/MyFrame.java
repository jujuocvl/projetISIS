import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private Controller controller=new Controller(this);
	private ArrayList<MyPanels> panels = new ArrayList<MyPanels>();
	private LecteurDuJson lecteur = new LecteurDuJson();

	public MyFrame() {
		super();
		setUp();
	}

	private void setUp() {
		this.setTitle("Ma Cuisine");
		this.setSize(800, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setLayout(null); //null pour pouvoir recadrer librement

		JLabel restaurant = new JLabel ("Prima Java", JLabel.CENTER); // j'aimerai le texte soit au centre mais erreur si .CENTER du au HorizontalAlignement
		Font font = new Font("Mistral", Font.ITALIC, 40);
		restaurant.setFont(font);

		JPanel panelbtn = new JPanel();
		JButton valid = new JButton("Valider le menu");
		JButton annul = new JButton("Annuler le menu");
		JButton comd = new JButton("Préparer la commande");

		valid.setOpaque(true);
		valid.setBorderPainted(false);
		valid.setBackground(Color.GREEN);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		valid.setFont(font2);

		annul.setOpaque(true);
		annul.setBorderPainted(false);
		annul.setBackground(Color.RED);
		annul.setFont(font2);

		panelbtn.add(valid);
		panelbtn.add(annul);
		panelbtn.add(comd);
		
		comd.setOpaque(true);
		comd.setBorderPainted(false);
		comd.setBackground(Color.MAGENTA);
		comd.setFont(font2);

		valid.addActionListener(controller);
		annul.addActionListener(controller);
		comd.addActionListener(controller);

		container.setLayout(new GridLayout(0,1));
		container.add(restaurant);

		panels.add(new MyPanels("Entrées","Quantité :"));
		panels.add(new MyPanels("Plats", "Quantité :"));
		panels.add(new MyPanels("Desserts", "Quantité :"));

		for (int i=0; i<3; i++) {
			container.add(panels.get(i));
		}
		container.add(panelbtn);

		//container.add(nom, BorderLayout.NORTH);
		this.add(container);
		this.setContentPane(container);
		this.setVisible(true); 
	}
	public String getText() {
		String ch = ("{");
		for (int i=0; i<3; i++) {
			//ch+= System.lineSeparator() +"\t " + panels.get(i).getText() + ",";
			ch+="\t " + panels.get(i).getText() + ",";
		}
		ch=ch.substring(0, ch.length()-2)+"}";
		return ch;
	}

	public void annuler() {
		for (MyPanels p: panels) {
			p.annuler();
		}
		// TODO Auto-generated method stub
		
	}

	public ArrayList<MyPanels> getPanels() {
		return panels;
	}

	public LecteurDuJson getLecteur() {
		return lecteur;
	}

}
