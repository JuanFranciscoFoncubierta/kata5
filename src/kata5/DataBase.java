package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private String url;
    Connection connection = null;
    
    DataBase(String url) {
        this.url = url;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(url);
            System.out.println("Base de datos abierta");
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException)" + ex.getMessage());
        }
    }

    void close() {
        if (this.connection != null) {
            try {
                connection.close();
                System.out.println("Base de datos cerrada");
            } catch (SQLException ex) {
                System.out.println("ERROR DataBase::close (SQLException)" + ex.getMessage());
            }
        }
    }

    void select_PERSONAS() {
        String SQL = "SELECT * FROM PERSONAS";
        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            System.out.println("ID \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            System.out.println("-- \t ------ \t --------- \t ------------");
            while (result.next()) {
                System.out.println(result.getInt("ID") + " \t " + result.getString("NOMBRE") + " \t " + 
                        result.getString("APELLIDOS") + " \t " + result.getString("DEPARTMENT"));
            }
         } catch (SQLException ex) {
            System.out.println("ERROR DataBase::select_personas (SQLERROR) " + ex.getMessage());
        }
    }

    void insert_PERSONAS(Person person) {
        
        String SQL = "INSERT INTO PERSONAS(NOMBRE,APELLIDOS,DEPARTMENT) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL);
            preparedStatement.setString(1, person.getNombre());
            preparedStatement.setString(2, person.getApellidos());
            preparedStatement.setString(3, person.getDepartamento());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::insert_personas (SQLERROR) " + ex.getMessage());
        }
    }
}
