package ConexionBD;

import java.sql.*;

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
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}