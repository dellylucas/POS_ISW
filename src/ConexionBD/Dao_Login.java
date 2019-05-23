package ConexionBD;

import Modelo.Persona;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao_Login {
    private Connection conex ;
    private ResultSet resultSet;
    private Persona persona;
    public Dao_Login() {
        this.conex =  new Conexion().getConnection() ;
    }

    public Persona Consultar(String user, String pass) {

        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select p.id,p.nombre,p.correo,p.direccion,p.telefono,rp.rolId,p.salario,p.bonificacion,p.activo " +
                    "from PERSONA p " +
                    "join ROL_PERSONA rp ON p.id = rp.personaId " +
                    "WHERE P.usuario = '" +user+"' "+
                    "AND p.clave = '" +pass+"' ");

            if (resultSet.next()) {
                persona= new Persona (resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        user,
                        pass,
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9)
                );

            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        return persona;
    }
    public void ModificarSesion(String id,int activo) {

        try {
            String queryIn="UPDATE PERSONA SET  activo="
                    + activo + " WHERE ID ='"
                    + id+"' " ;
            Statement modProduct = conex.createStatement();
            modProduct.executeUpdate(queryIn);
            modProduct.close();

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
        }
    }
}
