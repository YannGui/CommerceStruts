package fr.imie.struts.javabeans;


public class Produit {
    private int idProduit;
    private String nom;
    private String marque;
    private String caracteristique;


    public Produit() {
    }


    public Produit(int idProduit, String nom, String marque, String caracteristique) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.marque = marque;
        this.caracteristique = caracteristique;
    }


    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idproduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }
}
