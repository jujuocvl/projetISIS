
public class CheckQty {
	public void CheckQty(int qtyresto, int qtycmd ) { //il faut comparer la quantité entrée et la quantité stockée

		//si on a pas assez de stock
		if(qtycmd>qtyresto) {
			System.out.println("Quantité insuffisante, la recettte n'est pas préparable");

			//si on en a assez, alors on déduit du stock
		} else {
			qtyresto+=-qtycmd;
			System.out.println("La recettte est préparable");
		}

	}
}
