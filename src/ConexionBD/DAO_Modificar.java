package ConexionBD;

import Modelo.Empleado;
import Modelo.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DAO_Modificar {


    private Connection conex ;
    private ResultSet resultSet;

    public DAO_Modificar() {
        this.conex = Conexion.getConnection();
    }

    public void Producto(Producto pro) {

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
    public void Empleado(Empleado emp) {

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
}
