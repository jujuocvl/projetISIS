
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

}
