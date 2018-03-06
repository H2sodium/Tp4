package tp4.dao;

import java.util.List;

import tp4.model.categorie;
import tp4.model.produit;

public interface IMetier {
	
	 public void ajouter(categorie b);
	 public void ajouter(produit b);
	 
	 public void update(categorie b);
	 public void update(produit b);
	 
	 public void supprimerCategorie(int id);
	 public void supprimerProduit(int id);
	 
	 public List<categorie> getALLC();
	 public List<produit> getALLP();
}
