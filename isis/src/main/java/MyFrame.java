import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();

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

		JLabel restaurant = new JLabel ("Ratatouille", JLabel.CENTER); // j'aimerai le texte soit au centre mais erreur si .CENTER du au HorizontalAlignement
		Font font = new Font("Mistral", Font.ITALIC, 40);
		restaurant.setFont(font);

        JPanel panelbtn = new JPanel();
        JButton button = new JButton("Valider la commande");
        
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setBackground(Color.GREEN);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		button.setFont(font2);
		
		panelbtn.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Commande validé");
			}
		});

			container.setLayout(new GridLayout(0,1));
			container.add(restaurant);
			container.add(new MyPanels("Entrées","Quantité :"));
			container.add(new MyPanels("Plats", "Quantité :"));
			container.add(new MyPanels("Desserts", "Quantité :"));
			container.add(panelbtn);

			//container.add(nom, BorderLayout.NORTH);
			this.add(container);
			this.setContentPane(container);
			this.setVisible(true); 
		}
	}
