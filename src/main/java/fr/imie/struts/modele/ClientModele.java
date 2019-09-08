package fr.imie.struts.modele;
import java.util.ArrayList;
import java.util.List;
import fr.imie.struts.javabeans.Client;

public class ClientModele {
    private static List<Client> listeClients = new ArrayList();
    private static int id=1;

    static {
        listeClients.add(new Client(id++, "ALoukachenko ", "bielorussie"));
        listeClients.add(new Client(id++, "RMugabe ", "zimbabwe"));
        listeClients.add(new Client(id++, "Mswati", "swaziland"));
        listeClients.add(new Client(id++, "IAfewerki", "erythree"));
    }

    public ClientModele() {
    }

    public static List<Client> getListeClients() {
        return listeClients;
    }

    public static void setListeClients(List<Client> listeClients) {
        ClientModele.listeClients = listeClients;
    }

    public static void ajouter(Client client) {
        client.setIdClient(id++);
        listeClients.add(client);
    }

    // supprimer un client
    public static void supprimer(int idClient) {
        for(int i=0;i<listeClients.size();i++)
        {
            Client c=listeClients.get(i);
            if(c.getIdClient()==idClient)
            {
                listeClients.remove(c);
            }
        }
    }

    // modifier un client
    public static void modifier(Client client) {
        int idClient=client.getIdClient();
        for(int i=0;i<listeClients.size();i++)
        {
            Client c=listeClients.get(i);

            if(c.getIdClient()==idClient)
            {
                c.setIdentifiant(client.getIdentifiant());
                c.setMotdepasse(client.getMotdepasse());
                break;
            }
        }
    }

    public static Client getClient(int idClient) {
        for (int i = 0; i < listeClients.size(); ++i) {
            Client c = (Client) listeClients.get(i);
            if (c.getIdClient() == idClient) {
                return c;
            }
        }

        return null;
    }
}
