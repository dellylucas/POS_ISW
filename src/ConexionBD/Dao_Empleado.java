package ConexionBD;

import Modelo.Empleado;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Empleado {
    private Connection conex ;
    private ResultSet resultSet;
    public Dao_Empleado() {
        this.conex =  new Conexion().getConnection() ;
    }

    public ArrayList<Empleado> ConsultarTodos() {
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
               /* lista.add(new Empleado(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));*/
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }

    public void Crear(Empleado emp) {

        try {
            String queryIn="INSERT INTO PERSONA  VALUES ('"
                    + emp.getId() + "' , '"
                    + emp.getNombre() + "' , '"
                    + emp.getCorreo() + "' , '"
                    + emp.getDireccion() + "' , '"
                    + emp.getTelefono() + "' , '"
                    + emp.getUsuario() + "' , '"
                    + emp.getClave() + "' , 0,1,0)";
            Statement addPEmple = conex.createStatement();
            addPEmple.execute(queryIn);
            addPEmple.close();

            queryIn="INSERT INTO ROL_PERSONA  VALUES (3,"+emp.getId() +",1)";
            addPEmple = conex.createStatement();
            addPEmple.execute(queryIn);
            addPEmple.close();

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error insertando "+e.toString());
        }
    }
    public void Modifica(Empleado emp) {

        try {
            String queryIn="UPDATE PERSONA SET nombre ='"
                    + emp.getNombre() + "' , correo='"
                    + emp.getCorreo() + "' , direccion='"
                    + emp.getDireccion() + "' , telefono='"
                    + emp.getTelefono() + "' , usuario='"
                    + emp.getUsuario() + "' , clave='"
                    + emp.getClave() + "' WHERE ID='"
                    + emp.getId() + "' --' ";
            Statement addProduct = conex.createStatement();
            addProduct.executeUpdate(queryIn);
            addProduct.close();

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
        }
    }
    public void Eliminar(String id) throws SQLException {

        Statement EliminaRelacion = conex.createStatement();
        EliminaRelacion.executeQuery("DELETE FROM ROL_PERSONA WHERE personaid ='"+id+"'");
        EliminaRelacion.executeBatch();
        EliminaRelacion.close();
        Statement EliminaPersona = conex.createStatement();
        EliminaPersona.executeQuery("DELETE FROM PERSONA WHERE id ='"+id+"'");
        EliminaPersona.executeBatch();
        EliminaPersona.close();



    }
}
