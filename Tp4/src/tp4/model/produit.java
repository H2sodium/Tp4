package tp4.model;

public class produit {
	private int id;
	private String name;
	private String prix;
	private String quantit�;
	
	
	
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
	public String getQuantit�() {
		return "" + quantit�;
	}
	public void setQuantit�(String quantit�) {
		this.quantit� = quantit�;
	}
	
}
