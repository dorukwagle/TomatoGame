package models;

import DTO.User;
import Helpers.DatabaseConnector;
import controllers.RegistrationController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationModel {
    private DatabaseConnector db;
    private Connection connection;

    public RegistrationModel() {
        try {
            this.db = DatabaseConnector.getInstance();
            this.connection = this.db.getConnection();
        } catch( Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean registerUser(User user) {
        try {
            //create statement
            String query = "INSERT INTO users(name, email, password) VALUES(?,?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            //execute the query
            statement.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
