import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MySection extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField title=new JTextField();
	private JTextField qty=new JTextField();

	public MySection(String titre, String qte) {
		super();
		setLayout(new GridLayout(0, 2));
		this.title.setText(titre);
		this.qty.setText(qte);
		setUp();
	}

	public void setUp() {

		add(title);
		add(qty);

		if(title.getText().equals("Entrées")) {
			title.setBackground(Color.yellow);
			qty.setBackground(Color.yellow);
		}
		if(title.getText().equals("Plats")) {
			title.setBackground(Color.orange);
			qty.setBackground(Color.orange);
		}
		if(title.getText().equals("Desserts")) {
			title.setBackground(Color.pink);
			qty.setBackground(Color.pink);
		}

	}

	public void listen() {
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				title.setText("");
			}
		});
		qty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				qty.setText("");
			}
		});
		//pour avoir que des entiers
		qty.addKeyListener(new KeyAdapter() {
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
		if(qty.getText().equals("Quantité :")|| title.getText().equals("Entrées")||title.getText().equals("Plats")||title.getText().equals("Desserts")) {
			return null;
		}
		else{
			return ("\"description\": \"" + title.getText()+ "\","+ System.lineSeparator()+
					"\"qty\": "+ qty.getText())	+"    ";
		}
	
	}
}

