
public class Plat {
	private int qty;
	private long id;
	private String nom;
	
	public Plat(int qty, long id, String nom) {
		super();
		this.qty = qty;
		this.id = id;
		this.nom = nom;
	}
	public Plat(int qty, long id) {
		super();
		this.qty = qty;
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	

}
