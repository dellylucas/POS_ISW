package Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Tienda;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Producto;
import Modelo.Tienda;

public class EliminarTienda extends JFrame implements ActionListener {
    private JButton btnVolver;
    private JButton btnEliminarTienda;
    private JLabel idTienda;
    private JLabel nombreTienda;
    private JLabel telefonoTienda;
    private JLabel direccionTienda;
    private JLabel ciudadTienda;
    
    private JTextField txtidTienda;
    private JTextField txtnombreTienda;
    private JTextField txttelefonoTienda;
    private JTextField txtdireccionTienda;
    private JTextField txtciudadTienda;
    private JComboBox listaTiendas;
//    private String identificacion, nombre, fecha;
    private Producto producto = new Producto();
    private Dao_Tienda daoTienda;
    private Tienda tienda = Fachada.getTienda();

    private Persona persona;

    public EliminarTienda(Persona usuario) {
        super();
        persona = usuario;
        daoTienda = new Dao_Tienda();
        this.setTitle("Eliminar Tienda");
        this.setSize(400, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearEtiquetas();
        this.crearIngresoDatos();
        this.crearBotones();
    }

    private void crearEtiquetas() {
        this.idTienda = new JLabel();
        this.idTienda.setText("Identificacion");
        this.idTienda.setBounds(10, 37, 200, 32);
        getContentPane().add(idTienda);

        this.nombreTienda = new JLabel();
        this.nombreTienda.setText("Nombres");
        this.nombreTienda.setBounds(10, 61, 91, 32);
        getContentPane().add(nombreTienda);

        this.telefonoTienda = new JLabel();
        this.telefonoTienda.setText("Telefono");
        this.telefonoTienda.setBounds(10, 91, 86, 32);
        getContentPane().add(telefonoTienda);

        this.direccionTienda = new JLabel();
        this.direccionTienda.setText("Direccion");
        this.direccionTienda.setBounds(10, 124, 75, 26);
        getContentPane().add(direccionTienda);

        this.ciudadTienda = new JLabel();
        this.ciudadTienda.setText("Ciudad");
        this.ciudadTienda.setBounds(10, 152, 75, 32);
        getContentPane().add(ciudadTienda);

    }

    private void crearIngresoDatos() {
        this.txtidTienda = new JTextField();
        this.txtidTienda.setEditable(false);
        this.txtidTienda.setBounds(95, 43, 180, 20);
        getContentPane().add(txtidTienda);

        this.txtnombreTienda = new JTextField();
        this.txtnombreTienda.setEditable(false);
        this.txtnombreTienda.setBounds(95, 67, 180, 20);
        getContentPane().add(txtnombreTienda);

        this.txttelefonoTienda = new JTextField();
        this.txttelefonoTienda.setEditable(false);
        this.txttelefonoTienda.setBounds(95, 97, 180, 20);
        getContentPane().add(txttelefonoTienda);

        this.txtciudadTienda = new JTextField();
        this.txtciudadTienda.setEditable(false);
        this.txtciudadTienda.setBounds(95, 127, 180, 20);
        getContentPane().add(txtciudadTienda);
    }

    private void crearBotones() {
        this.btnVolver = new JButton();
        this.btnVolver.setText("Volver");
        this.btnVolver.setBounds(212, 249, 120, 20);
        btnVolver.addActionListener(this);
        getContentPane().add(btnVolver);

        this.btnEliminarTienda = new JButton();
        this.btnEliminarTienda.setText("Eliminar Producto");
        this.btnEliminarTienda.setBounds(20, 249, 130, 20);
        btnEliminarTienda.addActionListener(this);
        getContentPane().add(btnEliminarTienda);

        this.listaTiendas = new JComboBox();
        this.listaTiendas.setBounds(10, 11, 149, 20);
        this.listaTiendas.addActionListener(this);
        getContentPane().add(listaTiendas);

 
//
       btnEliminarTienda.setEnabled(false);
       this.leerTienda();

    }

    public void actionPerformed(ActionEvent e) {

        String id = (String) listaTiendas.getSelectedItem();

        if (e.getSource() == btnVolver) {
            VentanaUsuario ventana = new VentanaUsuario(persona);
            ventana.setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == btnEliminarTienda) {

                daoTienda.Eliminar(id,tienda.getId());

            limpiarFormulario();
            leerTienda();
            btnEliminarTienda.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
        }
        if (e.getSource() == listaTiendas) {
            llenarTienda();
            btnEliminarTienda.setEnabled(true);
        }
    }

    private void leerTienda() {
        DefaultComboBoxModel mlista = new DefaultComboBoxModel();
     //   tienda.setLstTienda(daoTienda.ConsultaTodos(tienda.getId()));
        for (int i = 0; i < tienda.getLstTienda().size(); i++) {
            mlista.addElement(tienda.getLstTienda().get(i).getId());
        }
        listaTiendas.setModel(mlista);
    }


    private void llenarTienda() {
        Integer id = (Integer) listaTiendas.getSelectedItem();
        tienda = tienda.buscarTienda(tienda, id);
        txtidTienda.setText(String.valueOf(tienda.getId()));
        txtnombreTienda.setText(tienda.getNombre());
        txttelefonoTienda.setText(tienda.getTelefono());
        txtdireccionTienda.setText(tienda.getDireccion());
        txtciudadTienda.setText(tienda.getCiudad());
     

    }

    private void limpiarFormulario() {
        txtidTienda.setText("");
        txtnombreTienda.setText("");
        txttelefonoTienda.setText("");
        txtciudadTienda.setText("");
        txtdireccionTienda.setText("");

    }
}
