import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

public class Controller extends AbstractAction {

	private final MyFrame frame;

	public Controller(MyFrame frame) {
		this.frame = frame;
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		// Le bouton source de l'événement
		JButton button = (JButton) e.getSource();
		// Gestion de l'événement selon le bouton cliqué
		switch (button.getText()) {
		case "Valider le menu":
			System.out.println("Menu validée, voir fichier json dans les téléchargements.");
			FileWriter file;
			try {
				file = new FileWriter("orders.json");
				file.write(frame.getText());
				file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			//hashmap recette id avec quantité

			break;

		case "Annuler le menu":
			System.out.println("Commande annulée");
			frame.annuler();


			break;

		case "Préparer la commande":
			
			try {
				CheckQty comparateur = new CheckQty();
				comparateur.setResto(frame.getPanels().get(0).getPlats());
				comparateur.setCmd(frame.getLecteur().lireEntrées());
				comparateur.CheckQty();
				comparateur.setResto(frame.getPanels().get(1).getPlats());
				comparateur.setCmd(frame.getLecteur().lirePlats());
				comparateur.CheckQty();
				comparateur.setResto(frame.getPanels().get(2).getPlats());
				comparateur.setCmd(frame.getLecteur().lireDesserts());
				comparateur.CheckQty();
			} catch (QtyException | IOException | ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			
			
			break;

	}
}

}


