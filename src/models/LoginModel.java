package models;

import DTO.User;
import Helpers.DatabaseConnector;
import controllers.LoginController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoginModel {
    private DatabaseConnector db;
    private Connection connection;

    public LoginModel() {
        // create a list of users
        try {
            this.db = DatabaseConnector.getInstance();
            this.connection = this.db.getConnection();
        } catch( Exception ex) {
            ex.printStackTrace();
        }
    }

    public User verifyUser(String username, String password) {
        try {
            String query = "SELECT * FROM users where email=? and password=?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()){
                return new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
