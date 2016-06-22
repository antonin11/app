package com.g4.app.models;


import com.g4.app.utils.DBConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HWoog on 17/06/2016.
 */
public class FicheEleve {
    public int id;
    public String nom;
    public String prenom;
    public String mail;
    public int type;
    public String remarque;


    public FicheEleve(int id, String nom, String prenom, String mail, int type, String remarque) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.type = type;
        this.remarque = remarque;

    }

    private static List<FicheEleve> getFicheEleves(ResultSet resultSet) throws SQLException {
        List<FicheEleve> ficheelevesList = new ArrayList<FicheEleve>();
        while (resultSet.next()) {
            FicheEleve ficheeleve = new FicheEleve(
                    resultSet.getInt("id_user"),
                    resultSet.getString("user_nom"),
                    resultSet.getString("user_prenom"),
                    resultSet.getString("user_mail"),
                    resultSet.getInt("user_type"),
                    resultSet.getString("user_remarque")
            );
            ficheelevesList.add(ficheeleve);
        }
        return ficheelevesList;
    }

    public static List<FicheEleve> findAll() {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            return getFicheEleves(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<FicheEleve> findById(int eleveId) {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id_user = ?");
            statement.setInt(1, eleveId);
            ResultSet resultSet = statement.executeQuery();
            return getFicheEleves(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  FicheEleve addRemarque(int id_eleve, String remarque) {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE gappg4.user SET user_remarque=? WHERE id_user=?;");
            statement.setString(1, remarque);
            statement.setInt(2, id_eleve);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getNom() {
        return nom;
    }

    public int getType() {
        return type;
    }

    public String getRemarque() {
        return remarque;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
