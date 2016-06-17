package com.g4.app.models;


import com.g4.app.utils.DBConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public FicheEleve() {
    }

    public FicheEleve(int id, String nom, String prenom, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    private static List<FicheEleve> getFicheEleve(ResultSet resultSet) throws SQLException {
        List<FicheEleve> ficheelevesList = new ArrayList<FicheEleve>();
        while (resultSet.next()) {
            FicheEleve ficheeleve = new FicheEleve(
                    resultSet.getInt("id_user"),
                    resultSet.getString("user_nom"),
                    resultSet.getString("user_prenom"),
                    resultSet.getString("user_mail")
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
            return getFicheEleve(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
