package fr.imie.struts.dao;

import fr.imie.struts.javabeans.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientModel extends ModelDAO {
    Connection connection = null;
    ResultSet resultSet = null;
    private ArrayList<Client> allClient = new ArrayList();

    public ClientModel() {
    }

    public int ajouterClient(Client client, String compte) {
        PreparedStatement prepStat = null;
        String laRequete = null;
        boolean var5 = false;

        int valErreur;
        try {
            this.connection = super.getConnection();
            laRequete = "INSERT INTO client (identifiant, motdepasse) VALUES(?,?)";
            prepStat = this.connection.prepareStatement(laRequete);
            prepStat.setString(1, client.getIdentifiant());
            prepStat.setString(2, client.getMotdepasse());
            valErreur = prepStat.executeUpdate();
        } catch (Exception var8) {
            valErreur = 0;
            System.out.println("Erreur lors de l'insertion d'un objet");
            var8.printStackTrace();
        }

        try {
            prepStat.close();
            this.connection.close();
        } catch (Exception var7) {
            System.out.println("Impossible de fermer un objet");
            var7.printStackTrace();
        }

        return valErreur;
    }

    public Client getClient(String identifiant, String motdepasse) {
        PreparedStatement prepStat = null;
        Client client = null;
        String laRequete = null;

        try {
            this.connection = super.getConnection();
            laRequete = "SELECT * FROM client WHERE identifiant=? and motdepasse=?";
            prepStat = this.connection.prepareStatement(laRequete);
            prepStat.setString(1, identifiant);
            prepStat.setString(2, motdepasse);
            this.resultSet = prepStat.executeQuery();
            if (this.resultSet != null) {
                if (this.resultSet.next()) {
                    client = this.mapperClient(this.resultSet);
                }
            } else {
                System.out.println("Client introuvable dans la base");
            }
        } catch (Exception var8) {
            client = null;
            System.out.println("erreur dans la requete" + var8);
        }

        try {
            this.resultSet.close();
            prepStat.close();
            this.connection.close();
        } catch (Exception var7) {
            System.out.println("Impossible de fermer un objet");
            var7.printStackTrace();
        }

        return client;
    }

//    public ArrayList<Client> getDeveloppeurByPseudo(String pseudo, String compte) {
//        PreparedStatement prepStat = null;
//        Developpeur developpeur = null;
//        String laRequete = null;
//
//        try {
//            this.connection = super.getConnection();
//            laRequete = "SELECT * FROM developpeur WHERE UPPER(PSEUDO) LIKE UPPER(?) and COMPTE=?";
//            prepStat = this.connection.prepareStatement(laRequete);
//            prepStat.setString(1, "%" + pseudo + "%");
//            prepStat.setString(2, compte);
//            this.resultSet = prepStat.executeQuery();
//            if (this.resultSet != null) {
//                while (this.resultSet.next()) {
//                    developpeur = this.mapperDeveloppeur(this.resultSet);
//                    this.allDeveloppeurs.add(developpeur);
//                }
//            } else {
//                System.out.println("Developpeur introuvable dans la base");
//            }
//        } catch (Exception var8) {
//            developpeur = null;
//            System.out.println("erreur dans la requette" + var8);
//        }
//
//        try {
//            this.resultSet.close();
//            prepStat.close();
//            this.connection.close();
//        } catch (Exception var7) {
//            System.out.println("Impossible de fermer un objet");
//            var7.printStackTrace();
//        }
//
//        return this.allDeveloppeurs;
//    }

    public Client mapperClient(ResultSet resultSet) {
        Client client = new Client();

        try {
            if (resultSet.getString("identifiant") == null) {
                client.setIdentifiant("");
            } else {
                client.setIdentifiant(resultSet.getString("identifiant"));
            }

            if (resultSet.getString("motdepasse") == null) {
                client.setMotdepasse("");
            } else {
                client.setMotdepasse(resultSet.getString("pseudo"));
            }


        } catch (Exception var4) {
            client = null;
            System.out.println("Erreur lors du mapping des attributs" + var4);
        }

        return client;
    }

//    public int supprimerAllDeveloppeur(String compte) {
//        PreparedStatement prepStat = null;
//        String laRequete = null;
//        boolean var4 = false;
//
//        int valErreur;
//        try {
//            this.connection = super.getConnection();
//            laRequete = "DELETE FROM developpeur WHERE COMPTE=?";
//            prepStat = this.connection.prepareStatement(laRequete);
//            prepStat.setString(1, compte);
//            valErreur = prepStat.executeUpdate();
//        } catch (Exception var7) {
//            valErreur = 0;
//            System.out.println("Erreur lors de l'insertion d'un objet");
//            var7.printStackTrace();
//        }
//
//        try {
//            prepStat.close();
//            this.connection.close();
//        } catch (Exception var6) {
//            System.out.println("Impossible de fermer un objet");
//            var6.printStackTrace();
//        }
//
//        return valErreur;
//    }

//    public int supprimerUnDeveloppeur(String pseudo, String compte) {
//        PreparedStatement prepStat = null;
//        String laRequete = null;
//        boolean var5 = false;
//
//        int valErreur;
//        try {
//            this.connection = super.getConnection();
//            laRequete = "DELETE FROM developpeur WHERE PSEUDO = ? AND COMPTE=?";
//            prepStat = this.connection.prepareStatement(laRequete);
//            prepStat.setString(1, pseudo);
//            prepStat.setString(2, compte);
//            valErreur = prepStat.executeUpdate();
//        } catch (Exception var8) {
//            valErreur = 0;
//            System.out.println("Erreur lors de l'insertion d'un objet");
//            var8.printStackTrace();
//        }
//
//        try {
//            prepStat.close();
//            this.connection.close();
//        } catch (Exception var7) {
//            System.out.println("Impossible de fermer un objet");
//            var7.printStackTrace();
//        }
//
//        return valErreur;
//    }

    public ArrayList<Client> getAllClient() {
        PreparedStatement prepStat = null;
        Client client = null;
        String laRequete = null;

        try {
            this.connection = super.getConnection();
            laRequete = "SELECT * FROM client ";
            prepStat = this.connection.prepareStatement(laRequete);
//            prepStat.setString(1, compte);
            this.resultSet = prepStat.executeQuery();
            if (this.resultSet != null) {
                while (this.resultSet.next()) {
                    client = this.mapperClient(this.resultSet);
                    this.allClient.add(client);
                }
            } else {
                System.out.println("Aucun client dans la base");
            }
        } catch (Exception var7) {
            client = null;
            System.out.println("erreur dans la requete " + var7);
        }

        try {
            this.resultSet.close();
            prepStat.close();
            this.connection.close();
        } catch (Exception var6) {
            System.out.println("Impossible de fermer un objet");
            var6.printStackTrace();
        }

        return this.allClient;
    }

//    public boolean isDeveloppeurExist(String pseudo) {
//        PreparedStatement prepStat = null;
//        String laRequete = null;
//
//        try {
//            this.connection = super.getConnection();
//            laRequete = "SELECT * FROM developpeur WHERE PSEUDO=?";
//            prepStat = this.connection.prepareStatement(laRequete);
//            prepStat.setString(1, pseudo);
//            this.resultSet = prepStat.executeQuery();
//            if (this.resultSet != null) {
//                if (this.resultSet.next()) {
//                    return true;
//                }
//            } else {
//                System.out.println("Developpeur introuvable dans la base");
//            }
//        } catch (Exception var6) {
//            System.out.println("erreur dans la requette" + var6);
//        }
//
//        try {
//            this.resultSet.close();
//            prepStat.close();
//            this.connection.close();
//        } catch (Exception var5) {
//            System.out.println("Impossible de fermer un objet");
//            var5.printStackTrace();
//        }
//
//        return false;
//    }

    public boolean isClientExist(String identifiant) {
        PreparedStatement prepStat = null;
        String laRequete = null;
        boolean isExist = false;

        try {
            this.connection = super.getConnection();
            laRequete = "SELECT * FROM client WHERE IDENTIFIANT=?";
            prepStat = this.connection.prepareStatement(laRequete);
            prepStat.setString(1, identifiant);
            this.resultSet = prepStat.executeQuery();
            if (this.resultSet != null && this.resultSet.next()) {
                isExist = true;
            }
        } catch (Exception var7) {
            System.out.println("erreur dans la requete" + var7);
        }

        try {
            this.resultSet.close();
            prepStat.close();
            this.connection.close();
        } catch (Exception var6) {
            System.out.println("Impossible de fermer un objet");
            var6.printStackTrace();
        }

        return isExist;
    }
}
