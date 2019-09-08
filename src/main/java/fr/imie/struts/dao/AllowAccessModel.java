package fr.imie.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllowAccessModel extends ModelDAO{


    Connection connection = null;
    ResultSet resultSet = null;

    public AllowAccessModel()  {
    }

    public boolean authentifier(String login, String password) {
        PreparedStatement prepStat = null;
        String laRequete = null;

        try {
            this.connection = super.getConnection();
            laRequete = "SELECT * FROM client WHERE identifiant=? and motdepasse=?";
            prepStat = this.connection.prepareStatement(laRequete);
            prepStat.setString(1, login);
            prepStat.setString(2, password);
            this.resultSet = prepStat.executeQuery();
            if (this.resultSet != null) {
                if (this.resultSet.next()) {
                    return true;
                }
            } else {
                    System.out.println("non authentifié");
            }
        } catch (Exception var6) {
            System.out.println("erreur dans la requete" + var6);
        }

        return false;
    }
}
