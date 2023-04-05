import java.util.ArrayList;

public class CheckQty {
	private ArrayList<Plat> cmd;
	private ArrayList<Plat> resto;

	public void setCmd(ArrayList<Plat> cmd) {
		this.cmd = cmd;
	}

	public void setResto(ArrayList<Plat> resto) {
		this.resto = resto;
	}

	public void CheckQty() throws QtyException { //il faut comparer la quantité entrée et la quantité stockée
		for (Plat p:cmd) {
			for (Plat p2: resto) {
				if (p.getId()==p2.getId()) {
					if (p.getQty()>p2.getQty()) {
						throw new QtyException("Quantité insuffisante, la recettte n'est pas préparable");
					}
					else {
						p2.setQty(p2.getQty()-p.getQty());
					}

					break;

				}
			}
		}

	}
}