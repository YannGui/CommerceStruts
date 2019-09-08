package fr.imie.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ModelDAO {
    DataSource dataSource = null;
    Connection conn = null;

    public ModelDAO() {
    }

    public Connection getConnection() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup("jdbc/ConnectDB");
            this.conn = ds.getConnection();
        } catch (NamingException var4) {
            var4.printStackTrace();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return this.conn;
    }

    public void setConnection2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection1() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (Exception var3) {
            System.out.println(" Erreur pilote de " + var3.getMessage());
        }

        try {
            this.conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "root", "");
        } catch (SQLException var2) {
            System.out.println("Erreur de connection " + var2.toString());
        }

        return this.conn;
    }

    public Connection getConnection2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception var3) {
            System.out.println(" Erreur pilote de " + var3.getMessage());
        }

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/strut2", "root", "");
        } catch (SQLException var2) {
            System.out.println("Erreur de connection " + var2.toString());
        }

        return this.conn;
    }
}
