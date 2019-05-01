package ConexionBD;

import java.sql.*;

import javax.swing.JOptionPane;

import Modelo.Empleado;
import Modelo.Producto;

public class DAO_Crear {
	private Connection conex ;
	private ResultSet resultSet;

	public DAO_Crear() {
		this.conex = Conexion.getConnection();
	}

	public void Producto(Producto pro) {

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
	public void Empleado(Empleado emp) {

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


}
