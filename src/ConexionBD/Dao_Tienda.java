package ConexionBD;
import Modelo.Producto;
import Modelo.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Dao_Tienda {


	    private Connection conex ;
	    private ResultSet resultSet;
	    public Dao_Tienda() {
	        this.conex =  new Conexion().getConnection();
	    }

	    public ArrayList<Tienda> ConsultaTodos() {
	        ArrayList<Tienda> lista = new ArrayList<>();
	        try {
	            Statement queryLogin = conex.createStatement();
	            resultSet = queryLogin.executeQuery("select id," +
	                    "nombre," +
	                    "ciudad," +
	                    "direccion," +
	                    "telefono " +
	                 
	                    "from TIENDA" );

	            while (resultSet.next()) {
	                lista.add(new Tienda(resultSet.getInt(1),
	                        resultSet.getString(2),
	                        resultSet.getString(3),
	                        resultSet.getString(4),
	                        resultSet.getString(5)));
	                       
	            }

	        } catch (SQLException | NullPointerException e) {

	            JOptionPane.showMessageDialog(null, e.toString());
	        }
	        return lista;
	    }
	    public void Crear(Tienda tienda, int id) {

	        try {
	            String queryIn="INSERT INTO TIENDA(nombre,ciudad,direccion,telefono)  VALUES ('"
	                    + tienda.getNombre() + "' , '"
	                    + tienda.getCiudad() + "' , '"
	                    + tienda.getDireccion() + "' , '"
	                    + tienda.getTelefono() + "')";
	            Statement addProduct = conex.createStatement();
	            addProduct.execute(queryIn);
	            addProduct.close();
	        } catch (SQLException | NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error insertando "+e.toString());
	        }
	    }
	    public void Modificar(Tienda tienda, int id) {

	        try {
	            String queryIn="UPDATE TIENDA SET nombre ='"
	                    + tienda.getNombre() + "' , telefono="
	                    + tienda.getTelefono() + " ,direccion="
	                    + tienda.getDireccion() + " , ciudad="
	                    + tienda.getCiudad() + "' WHERE ID ='"
                        + tienda.getId() + "' " +
	                    " AND tiendaId = "+id;
	            Statement addTienda = conex.createStatement();
	            addTienda.executeUpdate(queryIn);
	            addTienda.close();

	        } catch (SQLException | NullPointerException e) {
	            JOptionPane.showMessageDialog(null, "Error actualizando "+e.toString());
	        }
	    }

	    public void Eliminar(String id, int tiendaId)  {
	        try {
	            Statement GetFachada = conex.createStatement();
	            GetFachada.execute("DELETE FROM TIENDA WHERE id ='" + id + "' AND tiendaId ="+tiendaId);
	            GetFachada.close();
	        } catch (SQLException | NullPointerException e) {

	            JOptionPane.showMessageDialog(null, "Error eliminando " + e.toString());
	        }
	    }
	}

