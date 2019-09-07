package fr.imie.struts.javabeans;

public class Client {
    private int idClient;
    private String identifiant;
    private String motdepasse;

    public Client() {
    }

    public Client(int idClient, String identifiant, String motdepasse) {
        this.idClient = idClient;
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
