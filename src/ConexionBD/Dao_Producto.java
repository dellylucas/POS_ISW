package ConexionBD;

import Modelo.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Producto {
    private Connection conex ;
    private ResultSet resultSet;
    public Dao_Producto() {
        this.conex = Conexion.connection ;
    }

    public ArrayList<Producto> ConsultaTodos() {
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
    public void Crear(Producto pro) {

        try {
            String queryIn="INSERT INTO PRODUCTO  VALUES ('"
                    + pro.getId() + "' , '"
                    + pro.getNombre() + "' , "
                    + pro.getCantidad() + " , "
                    + pro.getPrecioIngreso() + " , "
                    + pro.getPrecioVenta() + " , default , '"
                    + pro.getFechaVencimiento() + "' , NULL)";
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
    public void Eliminar(String id) throws SQLException {

        Statement GetFachada = conex.createStatement();
        GetFachada.executeQuery("DELETE FROM PRODUCTO WHERE id ='"+id+"'");


    }
}
