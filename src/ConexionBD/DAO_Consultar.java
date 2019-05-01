package ConexionBD;

import Modelo.Empleado;
import Modelo.Persona;
import Modelo.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Consultar {
    private Connection conex ;
    private ResultSet resultSet;
    public DAO_Consultar() {
        this.conex = Conexion.getConnection();
    }

    public String ObtenerFachada() {
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
    public int ConsultarLogin(String user,String pass) {
       int rolid=0;
        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select rp.rolId " +
                                                    "from PERSONA p " +
                                                    "join ROL_PERSONA rp ON p.id = rp.personaId " +
                                                    "WHERE P.usuario = '" +user+"' "+
                                                    "AND p.clave = '" +pass+"'");

            while (resultSet.next()) {
                rolid =  resultSet.getInt(1);
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Sin Conexion Base de Datos");
        }
        return rolid;
    }
    public ArrayList<Producto> Productos() {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select id," +
                    "nombre," +
                    "cantidad," +
                    "precioIngreso," +
                    "precioVenta," +
                    "fechaIngreso," +
                    "fechaVencimiento," +
                    "proveedorId from PRODUCTO");

            while (resultSet.next()) {
                lista.add(new Producto(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)));
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }
    public ArrayList<Empleado> Empleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select id," +
                    "nombre," +
                    "correo," +
                    "direccion," +
                    "telefono," +
                    "usuario," +
                    "clave  from PERSONA");

            while (resultSet.next()) {
                lista.add(new Empleado(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }
}
