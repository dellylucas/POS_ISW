package ConexionBD;

import Modelo.Producto;
import Modelo.Proveedor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Proveedor {
    private Connection conex ;
    private ResultSet resultSet;
    public Dao_Proveedor() {
        this.conex =  new Conexion().getConnection();
    }

    public ArrayList<Proveedor> ConsultaTodos(int id) {
        ArrayList<Proveedor> lista = new ArrayList<>();
        try {
            Statement queryLogin = conex.createStatement();
            resultSet = queryLogin.executeQuery("select id," +
                    "nombre," +
                    "telefono," +
                    "direccion," +
                    "ciudad," +
                    "tipoDeProducto " +
                    "from PROVEEDOR" +
                    " where tiendaId = "+id);

            while (resultSet.next()) {
                lista.add(new Proveedor(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }
    public void Crear(Proveedor pro, int id) {

        try {
            String queryIn="INSERT INTO PROVEEDOR  VALUES ('"
                    + pro.getId() + "' , '"
                    + pro.getNombre() + "' , '"
                    + pro.getTelefono() + "' , '"
                    + pro.getDireccion() + "' , '"
                    + pro.getCiudad()+ "' , '"
                    + pro.getTipoDeProducto() + "' ,"
                    + id +" )";
            Statement addProduct = conex.createStatement();
            addProduct.execute(queryIn);
            addProduct.close();

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error insertando "+e.toString());
        }
    }
    public void Modificar(Producto pro) {

        try {
            String queryIn="UPDATE PRODUCTO SET nombre ='"
                    + pro.getNombre() + "' , cantidad="
                    + pro.getCantidad() + " , precioIngreso="
                    + pro.getPrecioIngreso() + " , precioVenta="
                    + pro.getPrecioVenta() + " , fechaIngreso='"
                    + pro.getFechaIngreso() + "' , fechaVencimiento='"
                    + pro.getFechaVencimiento() + "' WHERE ID='"
                    + pro.getId() + "' --' ";
            Statement addProduct = conex.createStatement();
            addProduct.executeUpdate(queryIn);
            addProduct.close();

        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
        }
    }

    public void Eliminar(String id)  {
        try {
            Statement GetFachada = conex.createStatement();
            GetFachada.execute("DELETE FROM PRODUCTO WHERE id ='" + id + "'");
            GetFachada.close();
        } catch (SQLException | NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Error actualizando " + e.toString());
        }
    }
}
