package br.com.contato.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "538944";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/agenda";
    private static final String DRIVER_URL = "com.mysql.cj.jdbc.Driver";

    public static Connection createConnectionToMySQL(){

        Connection connection = null;

            try {
                Class.forName(DRIVER_URL);
                connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
        return connection;
    }

    public static void main(String[] args) throws SQLException {

        Connection con = createConnectionToMySQL();

        if(con!=null){
            System.out.println("Conectado");
            con.close();
        }
    }
}
