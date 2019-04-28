package ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Consultar {
    private Connection conex ;
    public DAO_Consultar(Connection conn) {
        this.conex = conn;
    }

    public String ObtenerFachada() {
        String nombre="Sin Conexion Base de Datos";
        ResultSet resultSet = null;

        try {
            Statement GetFachada = conex.createStatement();
            resultSet = GetFachada.executeQuery("SELECT top 1 nombre FROM TIENDA WHERE id !=0");

            while (resultSet.next()) {
                nombre =  resultSet.getString(1);
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return nombre;
    }

}
