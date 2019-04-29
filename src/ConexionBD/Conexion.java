package ConexionBD;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	private static String bd = "ALL_RETAILER";
	private static String login = "sa";
	private static String password = "123";
	private static String server = "PCDFL9";
	public static Connection connection;

	public Conexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://" + server + ":" + "1433" + ";user=" + login
					+ ";password=" + password + ";databasename=" + bd;
			connection = DriverManager.getConnection(connectionUrl);
			if (connection != null) {
				System.out.println("Conexion a base de datos " + bd + " OK\n");
			}
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public static Connection getConnection() {
		if (connection==null){ new Conexion(); } return connection;
	}

	public void desconectar() {
		connection = null;
	}
}