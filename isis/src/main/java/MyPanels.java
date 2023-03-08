import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanels extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String title; //attribut classe
	private String qte; //attribut classe

	public MyPanels(String title, String qte) {
		super();
		this.title = title; //on instancie
		this.qte = qte; //on instancie
		
		setLayout(new BorderLayout());
		JPanel center = new JPanel(new GridLayout(0,1)); //rempli la première colonne puis la deuxième
		MySection section1 = new MySection(title, qte);
		MySection section2 = new MySection(title, qte);
		MySection section3 = new MySection(title, qte);
		
		center.add(section1);
		center.add(section2);
		center.add(section3);
		
		
		if(title.equals("Entrées")) {
			MySection section4 = new MySection(title, qte);
			center.add(section4);
		}
		if(title.equals("Desserts")) {
			MySection section5 = new MySection(title, qte);
			center.add(section5);
		}
		
		this.setLayout(new BorderLayout());
		this.add(center, BorderLayout.CENTER);
		this.add(new JLabel(title), BorderLayout.NORTH); // mettre un JLabel

	}

}
