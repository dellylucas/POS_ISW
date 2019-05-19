package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import ConexionBD.Dao_Proveedor;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Proveedor;
import Modelo.Tienda;

public class EliminarProveedor extends JFrame implements ActionListener {
    private JButton btnVolver;
    private JButton btnEliminarProveedor;
    private JLabel identificacionProveedor;
    private JLabel nombreProveedor;
    private JLabel telefonoProveedor;
    private JLabel direccionProveedor;
    private JLabel ciudadProveedor;
    private JLabel tipodeProducto;
    private JTextField txtId;
    private JTextField txtNombreProveedor;
    private JTextField txtTelefonoProveedor;
    private JTextField txtDireccionProveedor;
    private JTextField txtCiudadProveedor;
    private JTextField txtTipoDeProducto;
    private JComboBox listaProveedor;
    private Proveedor proveedor = new Proveedor();
    private Tienda tienda = Fachada.getTienda();
    private Persona persona;
    private Dao_Proveedor daoProveedor;

    public EliminarProveedor(Persona usuario) {
        super();
        persona = usuario;
        daoProveedor = new Dao_Proveedor();
        this.setTitle("Eliminar Proveedor");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearEtiquetas();
        this.crearIngresoDatos();
        this.crearBotones();
    }

    private void crearEtiquetas() {
        this.identificacionProveedor = new JLabel();
        this.identificacionProveedor.setText("Identificacion");
        this.identificacionProveedor.setBounds(10, 37, 200, 32);
        getContentPane().add(identificacionProveedor);

        this.nombreProveedor = new JLabel();
        this.nombreProveedor.setText("Nombre");
        this.nombreProveedor.setBounds(10, 61, 91, 32);
        getContentPane().add(nombreProveedor);

        this.telefonoProveedor = new JLabel();
        this.telefonoProveedor.setText("Telefono");
        this.telefonoProveedor.setBounds(10, 91, 86, 32);
        getContentPane().add(telefonoProveedor);

        this.direccionProveedor = new JLabel();
        this.direccionProveedor.setText("Direccion");
        this.direccionProveedor.setBounds(10, 124, 75, 26);
        getContentPane().add(direccionProveedor);

        this.ciudadProveedor = new JLabel();
        this.ciudadProveedor.setText("Ciudad");
        this.ciudadProveedor.setBounds(10, 152, 75, 32);
        getContentPane().add(ciudadProveedor);

        this.tipodeProducto = new JLabel();
        this.tipodeProducto.setText("Tipo De Producto");
        this.tipodeProducto.setBounds(10, 182, 91, 32);
        getContentPane().add(tipodeProducto);
    }

    private void crearIngresoDatos() {
        this.txtId = new JTextField();
        this.txtId.setEditable(false);
        this.txtId.setBounds(95, 43, 180, 20);
        getContentPane().add(txtId);

        this.txtNombreProveedor = new JTextField();
        this.txtNombreProveedor.setEditable(false);
        this.txtNombreProveedor.setBounds(95, 67, 180, 20);
        getContentPane().add(txtNombreProveedor);

        this.txtTelefonoProveedor = new JTextField();
        this.txtTelefonoProveedor.setEditable(false);
        this.txtTelefonoProveedor.setBounds(95, 97, 180, 20);
        getContentPane().add(txtTelefonoProveedor);

        this.txtDireccionProveedor = new JTextField();
        this.txtDireccionProveedor.setEditable(false);
        this.txtDireccionProveedor.setBounds(95, 127, 180, 20);
        getContentPane().add(txtDireccionProveedor);

        this.txtCiudadProveedor = new JTextField();
        this.txtCiudadProveedor.setEditable(false);
        this.txtCiudadProveedor.setBounds(95, 158, 180, 20);
        getContentPane().add(txtCiudadProveedor);

        this.txtTipoDeProducto = new JTextField();
        this.txtTipoDeProducto.setEditable(false);
        this.txtTipoDeProducto.setBounds(106, 188, 180, 20);
        getContentPane().add(txtTipoDeProducto);
    }

    private void crearBotones() {
        this.btnVolver = new JButton();
        this.btnVolver.setText("Volver");
        this.btnVolver.setBounds(212, 249, 120, 20);
        btnVolver.addActionListener(this);
        getContentPane().add(btnVolver);

        this.btnEliminarProveedor = new JButton();
        this.btnEliminarProveedor.setText("Eliminar Proveedor");
        this.btnEliminarProveedor.setBounds(20, 249, 130, 20);
        btnEliminarProveedor.setEnabled(false);
        btnEliminarProveedor.addActionListener(this);
        getContentPane().add(btnEliminarProveedor);

        this.listaProveedor = new JComboBox();
        this.listaProveedor.setBounds(10, 11, 149, 20);
        listaProveedor.addActionListener(this);
        getContentPane().add(listaProveedor);


        this.leerProveedor();
        this.llenarProveedor();
    }

    public void actionPerformed(ActionEvent e) {

        String id = (String) listaProveedor.getSelectedItem();

        if (e.getSource() == btnVolver) {
            VentanaUsuario ventana = new VentanaUsuario(persona);
            ventana.setVisible(true);
            dispose();
        }

        if (e.getSource() == btnEliminarProveedor) {
            daoProveedor.Eliminar(id,tienda.getId());
            leerProveedor();
            limpiarFormulario();
            btnEliminarProveedor.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
        }

        if (e.getSource() == listaProveedor) {
            llenarProveedor();
        }
    }

    private void leerProveedor() {
        DefaultComboBoxModel mlista = new DefaultComboBoxModel();
        tienda.setLstProveedor(daoProveedor.ConsultaTodos(tienda.getId()));
        for (int i = 0; i < tienda.getLstProveedor().size(); i++) {
            mlista.addElement(tienda.getLstProveedor().get(i).getId());
        }
        listaProveedor.setModel(mlista);
    }
    private void llenarProveedor() {
        String id = (String) listaProveedor.getSelectedItem();
        proveedor = tienda.buscarProveedor(proveedor, id);
        txtId.setText(proveedor.getId());
        txtNombreProveedor.setText(proveedor.getNombre());
        txtTelefonoProveedor.setText(proveedor.getTelefono());
        txtDireccionProveedor.setText(proveedor.getDireccion());
        txtCiudadProveedor.setText(proveedor.getCiudad());
        txtTipoDeProducto.setText(proveedor.getTipoDeProducto());
        btnEliminarProveedor.setEnabled(true);
    }
    private void limpiarFormulario() {
        txtId.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtCiudadProveedor.setText("");
        txtTipoDeProducto.setText("");
    }
}
