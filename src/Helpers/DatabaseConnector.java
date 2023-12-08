package Helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static DatabaseConnector dbInstance = null;
    private String driverClass = null;
    private String connectionString = null;
    private String hostName = null;
    private String portNumber = null;
    private String databaseName = null;
    private String dbUserName = null;
    private String dbPassword = null;

    private Connection conn = null;

    private void setConnectionString() {
        this.driverClass = "com.mysql.cj.jdbc.Driver";
        this.hostName = "localhost";
        this.portNumber = "3306";
        this.databaseName = "tomatogame";
        this.dbUserName = "Doruk";
        this.dbPassword = "dorukdb";

        this.connectionString = "jdbc:mysql://" + this.hostName + ":" + this.portNumber + "/" + this.databaseName;
    }

    private DatabaseConnector() throws Exception {
        try {
            this.setConnectionString();
            Class.forName(this.driverClass);
            this.conn = DriverManager.getConnection(this.connectionString, this.dbUserName, this.dbPassword);
        }catch (SQLException ex) {
            Exception e = new Exception(ex.getMessage() + "SQL Error Occured");
            throw e;
        }catch( ClassNotFoundException ex) {
            Exception e = new Exception(ex.getMessage() + "Class not found");
            throw e;
        }
    }

    public static DatabaseConnector getInstance() throws Exception{
        if(dbInstance == null) {
            try {
                dbInstance = new DatabaseConnector();
            }catch( Exception ex) {
                throw ex;
            }
        }
        return dbInstance;
    }

    public Connection getConnection() {
        return this.conn;
    }
}
