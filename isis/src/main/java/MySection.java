import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MySection extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField title=new JTextField();
	private JTextField qtyresto=new JTextField(); //quantité plats
	private String titre;

	public MySection(String titre, String qty) {
		super();
		this.titre=titre;
		setLayout(new GridLayout(0, 2));
		this.title.setText(titre);
		this.qtyresto.setText(qty);
		setUp();
	}

	public void setUp() {

		add(title);
		add(qtyresto);

		if(title.getText().equals("Entrées")) {
			title.setBackground(Color.yellow);
			qtyresto.setBackground(Color.yellow);
		}
		if(title.getText().equals("Plats")) {
			title.setBackground(Color.orange);
			qtyresto.setBackground(Color.orange);
		}
		if(title.getText().equals("Desserts")) {
			title.setBackground(Color.pink);
			qtyresto.setBackground(Color.pink);
		}

	}

	
	public void listen() {
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				title.setText("");
			}
		});
		qtyresto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				qtyresto.setText("");
			}
		});
		//pour avoir que des entiers
		qtyresto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				//ecoute un caractère par un caractère
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();  // ignorer l'événement
				}
			}
		});
	}

	public String getText() {
		if(qtyresto.getText().equals("Quantité :")|| title.getText().equals("Entrées")||title.getText().equals("Plats")||title.getText().equals("Desserts")) {
			return null;
		}
		else{
			return ("\"description\": \"" + title.getText()+ "\","+ System.lineSeparator()+
					"\"qty\": "+ qtyresto.getText())	+"    ";
		}

	}

	public JTextField getQty() {
		return qtyresto;
	}
	public JTextField getTitle() {
		return title;
	}

	public void annuler() {
		title.setText(titre);
		qtyresto.setText("Quantité:" );
	}
	
	//public class ArrayList<Order> recettes;

}

