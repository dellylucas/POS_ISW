package ConexionBD;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	static String bd = "ALL_RETAILER";
	static String login = "sa";
	static String password = "123";
	static Connection connection = null;
	//ResultSet resultSet = null;
	  String connectionUrl =
			   "jdbc:sqlserver://" + "PCDFL9" + ":" + "1433" + ";user=" + login
			    + ";password=" + password + ";databasename=" + bd + "";

	public Conexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionUrl);
			if (connection != null) {
				System.out.println("Conexión a base de datos " + bd + " OK\n");
			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.toString());
		} catch (ClassNotFoundException e) {

			JOptionPane.showMessageDialog(null, e.toString());
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}