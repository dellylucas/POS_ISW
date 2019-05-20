package ConexionBD;

import java.sql.*;

import javax.swing.JOptionPane;

public  class Conexion {
	private static String bd = "ALL_RETAILER";
	private static String login = "sa";
	private static String password = "123";
	private static String server = "PCDFL9";
	private static  Connection connection ;

	public Conexion() {
	}

	private void Conectar() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://" + server + ":" + "1433" + ";user=" + login
					+ ";password=" + password + ";databasename=" + bd;
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException | ClassNotFoundException  e) {
			JOptionPane.showMessageDialog(null, e.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public Connection getConnection() {
		if (connection==null){ this.Conectar(); } return connection;
	}

	public void desconectar() throws SQLException {
		connection.close();
	}
}