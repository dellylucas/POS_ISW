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

    public ArrayList<Empleado> ConsultarTodos(int id) {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select id," +
                    "nombre," +
                    "correo," +
                    "direccion," +
                    "telefono," +
                    "usuario," +
                    "clave ," +
                    "salario ," +
                    "bonificacion, " +
                    "activo " +
                    "from PERSONA p" +
                    " join rol_persona rp ON p.id = rp.personaId" +
                    " where rp.tiendaid = "+id+
                    " AND rp.rolid = 3");

            while (resultSet.next()) {
                lista.add(new Empleado(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        3,
                        resultSet.getInt (8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)));
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }

    public void Crear(Empleado emp, int id) {

        try {
            String queryIn="INSERT INTO PERSONA  VALUES ('"
                    + emp.getId() + "' , '"
                    + emp.getNombre() + "' , '"
                    + emp.getCorreo() + "' , '"
                    + emp.getDireccion() + "' , '"
                    + emp.getTelefono() + "' , '"
                    + emp.getUsuario() + "' , '"
                    + emp.getClave() + "' ,"
                    +emp.getSalario()+",1, "
                    +emp.getBonificacion()+")";
            Statement addPEmple = conex.createStatement();
            addPEmple.execute(queryIn);
            addPEmple.close();

            queryIn="INSERT INTO ROL_PERSONA  VALUES (3,'"+emp.getId() +"',"+id+")";
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
                    + emp.getClave() + "' , salario="
                    + emp.getSalario() + " , activo="
                    + emp.getActivo() + " , bonificacion="
                    + emp.getBonificacion()+ " WHERE ID='"
                    + emp.getId() + "' ";
            Statement addProduct = conex.createStatement();
            addProduct.executeUpdate(queryIn);
            addProduct.close();

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
        }
    }
    public void Eliminar(String id) {

        Statement EliminaRelacion = null;
        try {
            EliminaRelacion = conex.createStatement();
            EliminaRelacion.addBatch("DELETE FROM ROL_PERSONA WHERE personaid ='"+id+"'");
            EliminaRelacion.addBatch("DELETE FROM PERSONA WHERE id ='"+id+"'");
            EliminaRelacion.executeBatch();
            EliminaRelacion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error eliminando "+e.toString());
        }

    }
}
