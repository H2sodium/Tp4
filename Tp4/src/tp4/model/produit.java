package tp4.model;

public class produit {
	private int id;
	private String name;
	private String prix;
	private String quantité;
	
	
	
	public Integer getId() {
        return id;
    }
	
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getPrix() {
		return ""+prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getQuantité() {
		return "" + quantité;
	}
	public void setQuantité(String quantité) {
		this.quantité = quantité;
	}
	
}
