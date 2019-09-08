package fr.imie.struts.modele;
import fr.imie.struts.javabeans.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitModele {
    private static List<Produit> listeProduits = new ArrayList();
    private static int id = 1;

    static {
        listeProduits.add(new Produit(id++, "dents blanches", "colgate","plus blanc que blanc"));
        listeProduits.add(new Produit(id++, "dents blanches1", "colgate1","plus blanc que blanc1"));
        listeProduits.add(new Produit(id++, "dents blanches2", "colgate2","plus blanc que blanc2"));
    }

    public ProduitModele() {
    }

    public static List<Produit> getListeProduits() {
        return listeProduits;
    }

    public static void setListeProduits(List<Produit> listeProduits) {
        ProduitModele.listeProduits = listeProduits;
    }

    public static void ajouter(Produit produit) {
        produit.setIdProduit(id++);
        listeProduits.add(produit);
    }

    public static void supprimer(int idProduit) {
        for (int i = 0; i < listeProduits.size(); ++i) {
            Produit c = (Produit) listeProduits.get(i);
            if (c.getIdProduit() == idProduit) {
                listeProduits.remove(c);
            }
        }

    }

    public static void modifier(Produit produit) {
        int idProduit = produit.getIdProduit();

        for (int i = 0; i < listeProduits.size(); ++i) {
            Produit c = (Produit) listeProduits.get(i);
            if (c.getIdProduit() == idProduit) {
                c.setNom(produit.getNom());
                c.setMarque(produit.getMarque());
                c.setCaracteristique(produit.getCaracteristique());
                break;
            }
        }
    }

    public static Produit getProduit(int idProduit) {
        for (int i = 0; i < listeProduits.size(); ++i) {
            Produit c = (Produit) listeProduits.get(i);
            if (c.getIdProduit() == idProduit) {
                return c;
            }
        }

        return null;
    }
}
