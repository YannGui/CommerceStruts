package fr.imie.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import fr.imie.struts.javabeans.Client;
import fr.imie.struts.modele.ClientModele;

import java.util.List;


public class ClientAction extends ActionSupport implements Preparable, ModelDriven {
    private Client client;
    private List<Client> listeClients;
    private int idClientEnCours;

    public ClientAction() {
    }

    public void prepare() throws Exception {
        if (this.idClientEnCours == 0) {
            this.client = new Client();
        } else {
            this.client = ClientModele.getClient(this.idClientEnCours);
        }

    }

    public Object getModel() {
        return this.client;
    }

    public int getIdClientEnCours() {
        return this.idClientEnCours;
    }

    public void setIdClientEnCours(int idClientEnCours) {
        this.idClientEnCours = idClientEnCours;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getListeClients() {
        this.listeClients = ClientModele.getListeClients();
        return this.listeClients;
    }

    public void setListeClients(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    public String lister() {
        this.listeClients = ClientModele.getListeClients();
        return "success";
    }

    public String ajouter() {
        ClientModele.ajouter(this.client);
        return "success";
    }

    public String editer() {
        return "success";
    }

    public String modifier() {
        ClientModele.modifier(this.client);
        return "success";
    }

    public String supprimer() {
        ClientModele.supprimer(this.idClientEnCours);
        return "success";
    }
}