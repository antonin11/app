package com.g4.app.models;

import com.g4.app.utils.DBConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by antoninpedotti on 25/05/2016.
 */
public class Deadlines {

    public int id;
    public String name;
    public Date milestone;
    public String description;
    public int groupId;

    public Deadlines() {
    }

    public Deadlines(int id, String name, Date milestone, String description, int groupId) {
        this.id = id;
        this.name = name;
        this.milestone = milestone;
        this.description = description;
        this.groupId = groupId;
    }

    private static List<Deadlines> getDeadlines(ResultSet resultSet) throws SQLException {
        List<Deadlines> deadlinesList = new ArrayList<Deadlines>();
        while (resultSet.next()) {
            Deadlines deadlines = new Deadlines(
                    resultSet.getInt("id_deadline"),
                    resultSet.getString("deadline_nom"),
                    resultSet.getDate("deadline_date"),
                    resultSet.getString("deadline_descri"),
                    resultSet.getInt("id_groupe")
            );
            deadlinesList.add(deadlines);
        }
        return deadlinesList;
    }

    public static List<Deadlines> findAll() {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM deadline");
            return getDeadlines(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Deadlines> findByGroups(int groupId) {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM deadline WHERE id_groupe = ?");
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            return getDeadlines(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Deadlines addDeadline(String name, Date milestone, String description, int groupId) {
        DBConnectionHandler dbConnectionHandler = new DBConnectionHandler();
        try {
            Connection connection = dbConnectionHandler.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `gappg4`.`deadline` (`id_deadline`, `deadline_nom`, `deadline_date`, `deadline_descri`, `id_groupe`) " +
                            "VALUES (NULL, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setDate(2, (java.sql.Date) milestone);
            statement.setString(3, description);
            statement.setInt(4, groupId);
            ResultSet resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
