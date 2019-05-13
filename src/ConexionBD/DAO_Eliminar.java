package ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DAO_Eliminar {
    private Connection conex ;

    public DAO_Eliminar() {
        this.conex = Conexion.getConnection();
    }

    public void Producto(String id) throws SQLException {

            Statement GetFachada = conex.createStatement();
            GetFachada.executeQuery("DELETE FROM PRODUCTO WHERE id ='"+id+"'");


    }
    public void Empleado(String id) throws SQLException {

        Statement EliminaRelacion = conex.createStatement();
        EliminaRelacion.executeQuery("DELETE FROM ROL_PERSONA WHERE personaid ='"+id+"'");
        EliminaRelacion.executeBatch();
        EliminaRelacion.close();
        Statement EliminaPersona = conex.createStatement();
        EliminaPersona.executeQuery("DELETE FROM PERSONA WHERE id ='"+id+"'");
        EliminaPersona.executeBatch();
        EliminaPersona.close();



    }

}
