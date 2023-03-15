import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanels extends JPanel {

	private static final long serialVersionUID = 1L;

	private String title; //attribut classe
	private String qte; //attribut classe
	private ArrayList<MySection> sections;
	private int nb = 3;

	public MyPanels(String title, String qte) {
		super();
		this.title = title; //on instancie
		this.qte = qte; //on instancie
		sections = new ArrayList<MySection>();

		setLayout(new BorderLayout());
		JPanel center = new JPanel(new GridLayout(0,1)); //rempli la première colonne puis la deuxième

		if(title.equals("Entrées") || (title.equals("Desserts"))) {
			nb=4;
		}

		for(int i=0; i<nb; i++) {
			sections.add(new MySection(title, qte));
			center.add(sections.get(i));
			sections.get(i).listen();
		}

		this.setLayout(new BorderLayout());
		this.add(center, BorderLayout.CENTER);
		this.add(new JLabel(title), BorderLayout.NORTH); // mettre un JLabel

	}
	public String getText() {
		String ch = ("\"" + title + "\": [");
		for (int i=0; i<nb; i++) {
			if(sections.get(i).getText()!=null) {
				ch+= System.lineSeparator() +"\t {" + System.lineSeparator() + "\t \t" + "\"id\": " + Integer.toString(i+1) +","
				+ System.lineSeparator()+ sections.get(i).getText() + System.lineSeparator() + "},";
			}
		}
		if(sections.get(sections.size()-1)!=null) {
			ch=ch.substring(0, ch.length()-2)+"]";	
		}
		return ch;
	}


	}
