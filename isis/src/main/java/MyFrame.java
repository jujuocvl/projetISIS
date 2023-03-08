import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();

	public MyFrame() {
		super();
		setUp();
	}

	private void setUp() {
		this.setTitle("Ma Cuisine");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setLayout(null); //null pour pouvoir recadrer librement

		JLabel restaurant = new JLabel ("Ratatouille", JLabel.CENTER); // j'aimerai le texte soit au centre mais erreur si .CENTER du au HorizontalAlignement
		Font font = new Font("Mistral", Font.ITALIC, 40);
		restaurant.setFont(font);
		
		container.setLayout(new GridLayout(0,1));
		container.add(restaurant);
		container.add(new MyPanels("Entrées","Quantité :"));
		container.add(new MyPanels("Plats", "Quantité :"));
		container.add(new MyPanels("Desserts", "Quantité :"));
		
		//container.add(nom, BorderLayout.NORTH);
		this.add(container);
		this.setContentPane(container);
		this.setVisible(true); 
	}
}
