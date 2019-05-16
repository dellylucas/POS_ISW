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
            resultSet = queryLogin.executeQuery("select p.id,p.nombre,p.correo,p.direccion,p.telefono,rp.rolId " +
                    "from PERSONA p " +
                    "join ROL_PERSONA rp ON p.id = rp.personaId " +
                    "WHERE P.usuario = '" +user+"' "+
                    "AND p.clave = '" +pass+"' "+
                    "AND P.activo = 1");

            if (resultSet.next()) {
                persona= new Persona (resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        user,
                        pass,
                        resultSet.getInt(6)
                );

            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        return persona;
    }
}
