package tp4.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import tp4.model.categorie;
import tp4.model.produit;

public class doaMetier implements IMetier{
	Connection connection;
    final String insertProduit = "INSERT INTO produit (name, prix, quantite) VALUES ( ?, ?, ?);";
    final String insertCategorie = "INSERT INTO Categorie (name) VALUES (?);";
    
    final String updateProduit = "UPDATE produit set name=?, nom=?, adresse=? where id=? ;";
    final String updateCategorie = "UPDATE Categorie set name=?, where id=? ;";

    final String deleteProduit = "DELETE FROM produit where id=? ;";
    final String deleteCategorie = "DELETE FROM Categorie where id=?;";
    
    final String selectProduit = "SELECT * FROM produit;";
    final String selectCategorie = "SELECT * FROM Categorie;";
    
    final String recherchenom = "SELECT * FROM produit where nom like ?";

    public doaMetier() {
        connection = tp4.connexion.connexion.connection();
    }
    
    public void ajouter(produit b) {
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertProduit);
            statement.setString(1, b.getName());
            statement.setString(2, b.getPrix());
            statement.setString(3, b.getQuantité());
            statement.executeUpdate();
            java.sql.ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
               
            }
        } catch (SQLException ex) {
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void ajouter(categorie b) {
        java.sql.PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertCategorie);
            statement.setString(1, b.getNom());
            statement.executeUpdate();
            java.sql.ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
               
            }
        } catch (SQLException ex) {
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void supprimerProduit(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteProduit);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void supprimerCategorie(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteCategorie);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void update(produit b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateProduit);
            statement.setString(1, b.getName());
            statement.setString(2, b.getPrix());
            statement.setString(3, b.getQuantité());
            statement.setInt(4, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void update(categorie b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateCategorie);
            statement.setString(1, b.getNom());
            statement.setInt(4, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<produit> getALLP() {
        List<produit> lb = null;
        try {
            lb = new ArrayList<produit>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectProduit);
            while (rs.next()) {
                produit b = new produit();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setPrix(rs.getString("prix"));
                b.setQuantité(rs.getString("quantite"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(doaMetier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    
    public List<categorie> getALLC() {
        List<categorie> lb = null;
        try {
            lb = new ArrayList<categorie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectCategorie);
            while (rs.next()) {
                categorie b = new categorie();
                b.setId(rs.getInt("id"));
                b.setNom(rs.getString("nom"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(doaMetier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
    
}
