package fr.imie.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import fr.imie.struts.javabeans.Produit;
import fr.imie.struts.modele.ProduitModele;

import java.util.List;

public class ProduitAction extends ActionSupport implements Preparable, ModelDriven {
    private Produit produit;
    private List<Produit> listeProduits;
    private int idProduitEnCours;

    public ProduitAction(){

    }

    public void prepare() throws Exception {
        if (this.idProduitEnCours == 0) {
            this.produit = new Produit();
        } else {
            this.produit = ProduitModele.getProduit(this.idProduitEnCours);
        }

    }

    public Object getModel() {
        return this.produit;
    }

    public int getIdProduitEnCours() {
        return this.idProduitEnCours;
    }

    public void setIdProduitEnCours(int idProduitEnCours) {
        this.idProduitEnCours = idProduitEnCours;
    }

    public Produit getProduit() {
        return this.produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getListeProduits() {
        this.listeProduits = ProduitModele.getListeProduits();
        return this.listeProduits;
    }

    public void setListeProduits(List<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }

    public String lister() {
        this.listeProduits = ProduitModele.getListeProduits();
        return "success";
    }

    public String ajouter() {
        ProduitModele.ajouter(this.produit);
        return "success";
    }

    public String editer() {
        return "success";
    }

    public String modifier() {
        ProduitModele.modifier(this.produit);
        return "success";
    }

    public String supprimer() {
        ProduitModele.supprimer(this.idProduitEnCours);
        return "success";
    }

}
