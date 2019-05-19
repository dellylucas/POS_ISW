package ConexionBD;

import Modelo.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao_Fachada {

        private Connection conex ;
        private ResultSet resultSet;
        private Tienda tienda;
        public Dao_Fachada() {
            this.conex =  new Conexion().getConnection();
        }

        public Tienda Obtener(int rol, String id) {

            try {
                Statement GetFachada = conex.createStatement();
                resultSet = GetFachada.executeQuery("select t.id,t.nombre,t.ciudad,t.direccion,t.telefono " +
                        "from tienda t " +
                        "join rol_persona rp ON t.id  = rp.tiendaId " +
                        "where rp.rolId = " +rol +
                        " and rp.personaId = '"+id +"'");

                if (resultSet.next()) {
                    tienda= new Tienda (resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    );
                }

            } catch (SQLException | NullPointerException e) {

                JOptionPane.showMessageDialog(null, "Sin Conexion Base de Datos");
            }
            return tienda;
        }

}
