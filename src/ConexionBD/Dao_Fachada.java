package ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao_Fachada {

        private Connection conex ;
        private ResultSet resultSet;
        public Dao_Fachada() {
            this.conex = Conexion.connection;
        }

        public String Obtener() {
            String nombre="Sin Conexion Base de Datos";
            try {
                Statement GetFachada = conex.createStatement();
                resultSet = GetFachada.executeQuery("SELECT top 1 nombre FROM TIENDA WHERE id !=0");

                while (resultSet.next()) {
                    nombre =  resultSet.getString(1);
                }

            } catch (SQLException | NullPointerException e) {

                JOptionPane.showMessageDialog(null, "Sin Conexion Base de Datos");
            }
            return nombre;
        }

}
