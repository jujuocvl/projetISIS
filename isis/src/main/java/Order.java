
public class Order {

	private Long id;
	private String qtycmd;

	public Order(Long id2, String description) {
		this.id = id2;
		this.qtycmd = description;

	}

	public Long getId() {
		return id;
	}

	public String getQty() {
		return qtycmd;
	}


	/*TO DO:
	NEXT STEP: lire un fichier json et voir si c'est préparable:
		parcourrir les recettes et leurs quantités et les comparer au stock du resto. Hash map ou Array List pour parcourir les recettes et leurs qte
		si oui = déduire les quantités des plats préparés+ syso commande préparable/ si non = message erreur w/ nom commande + plats non préparables
		recupérer la quantité de cahque recette si c'est bon la commande peut etre validée. 

		Si c'est pas bon, le fichier json avec la commande et la recette non préparable sont reportés

	FINAL STEP: vérifier si le projet fonctionne bien avec d'autres ordis
	 */

}
