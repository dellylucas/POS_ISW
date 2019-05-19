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

import ConexionBD.Dao_Empleado;
import Modelo.Empleado;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Tienda;


public class ModificarEmpleado extends JFrame implements ActionListener {
    private JButton btnVolver;
    private JButton btnModificarEmpleador;
    private JLabel idEmpleado;
    private JLabel nombreEmpleado;
    private JLabel telefonoEmpleado;
    private JLabel direccionEmpleado;
    private JLabel correoEmpleadoo;
    private JLabel usuarioEmpleado;
    private JLabel claveEmpleado;
    private JLabel salarioEmpleadoo;
    private JLabel bonificacionEmpleado;
    private JLabel activoEmpleado;

    private JTextField txtIdEmpleado;
    private JTextField txtNombreEmpleador;
    private JTextField txtTelefonoEmpleado;
    private JTextField txtDireccionEmpleado;
    private JTextField txtCorreoEmpleado;
    private JTextField txtusuarioEmpleado;
    private JTextField txtclaveEmpleado;
    private JTextField txtSalarioEmpleado;
    private JTextField txtBonificaEmpleado;
    private JTextField txtActivoEmpleado;
    private Dao_Empleado daoEmpleado;
    private Persona persona;
    private JComboBox listaEmpleado;

    private Empleado empleado = new Empleado();

    private Tienda tienda = Fachada.getTienda();

    public ModificarEmpleado(Persona usuario) {
        super();
        persona = usuario;
        daoEmpleado = new Dao_Empleado();
        this.setTitle("Modificar Empleado");
        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearEtiquetas();
        this.crearIngresoDatos();
        this.crearBotones();
    }

    private void crearEtiquetas() {
        this.idEmpleado = new JLabel();
        this.idEmpleado.setText("ID");
        this.idEmpleado.setBounds(10, 39, 75, 42);
        getContentPane().add(idEmpleado);

        this.nombreEmpleado = new JLabel();
        this.nombreEmpleado.setText("Nombre");
        this.nombreEmpleado.setBounds(10, 50, 200, 80);
        getContentPane().add(nombreEmpleado);

        this.telefonoEmpleado = new JLabel();
        this.telefonoEmpleado.setText("Telefono");
        this.telefonoEmpleado.setBounds(10, 80, 200, 80);
        getContentPane().add(telefonoEmpleado);

        this.direccionEmpleado = new JLabel();
        this.direccionEmpleado.setText("Direccion");
        this.direccionEmpleado.setBounds(10, 110, 200, 80);
        getContentPane().add(direccionEmpleado);

        this.correoEmpleadoo = new JLabel();
        this.correoEmpleadoo.setText("Correo");
        this.correoEmpleadoo.setBounds(10, 140, 200, 80);
        getContentPane().add(correoEmpleadoo);


        this.usuarioEmpleado = new JLabel();
        this.usuarioEmpleado.setText("Usuario");
        this.usuarioEmpleado.setBounds(10, 165 + (154 - 121), 79, 29);
        getContentPane().add(usuarioEmpleado);

        this.claveEmpleado = new JLabel();
        this.claveEmpleado.setText("clave");
        this.claveEmpleado.setBounds(10, 165 + (2 * (154 - 121)), 79, 29);
        getContentPane().add(claveEmpleado);

        this.salarioEmpleadoo = new JLabel();
        this.salarioEmpleadoo.setText("Salario");
        this.salarioEmpleadoo.setBounds(10, 165 + (3 * (154 - 121)), 79, 29);
        getContentPane().add(salarioEmpleadoo);

        this.bonificacionEmpleado = new JLabel();
        this.bonificacionEmpleado.setText("Bonificacion");
        this.bonificacionEmpleado.setBounds(10, 165 + (4 * (154 - 121)), 79, 29);
        getContentPane().add(bonificacionEmpleado);

        this.activoEmpleado = new JLabel();
        this.activoEmpleado.setText("Activo");
        this.activoEmpleado.setBounds(10, 165 + (5 * (154 - 121)), 79, 29);
        getContentPane().add(activoEmpleado);
    }

    private void crearIngresoDatos() {
        this.txtIdEmpleado = new JTextField();
        this.txtIdEmpleado.setBounds(90, 50, 180, 20);
        txtIdEmpleado.setEditable(false);
        getContentPane().add(txtIdEmpleado);

        this.txtNombreEmpleador = new JTextField();
        this.txtNombreEmpleador.setBounds(90, 80, 180, 20);
        getContentPane().add(txtNombreEmpleador);

        this.txtTelefonoEmpleado = new JTextField();
        this.txtTelefonoEmpleado.setBounds(90, 110, 180, 20);
        getContentPane().add(txtTelefonoEmpleado);

        this.txtDireccionEmpleado = new JTextField();
        this.txtDireccionEmpleado.setBounds(90, 140, 180, 20);
        getContentPane().add(txtDireccionEmpleado);

        this.txtCorreoEmpleado = new JTextField();
        this.txtCorreoEmpleado.setBounds(90, 171, 180, 20);
        getContentPane().add(txtCorreoEmpleado);

        this.txtusuarioEmpleado = new JTextField();
        this.txtusuarioEmpleado.setBounds(90, 170 + (161 - 125), 180, 20);
        getContentPane().add(txtusuarioEmpleado);

        this.txtclaveEmpleado = new JTextField();
        this.txtclaveEmpleado.setBounds(90, 161 + (2 * (161 - 125)), 180, 20);
        getContentPane().add(txtclaveEmpleado);

        this.txtSalarioEmpleado = new JTextField();
        this.txtSalarioEmpleado.setBounds(90, 161 + (3 * (161 - 125)), 180, 20);
        getContentPane().add(txtSalarioEmpleado);

        this.txtBonificaEmpleado = new JTextField();
        this.txtBonificaEmpleado.setBounds(90, 161 + (4 * (161 - 125)), 180, 20);
        getContentPane().add(txtBonificaEmpleado);

        this.txtActivoEmpleado = new JTextField();
        this.txtActivoEmpleado.setBounds(90, 161 + (5 * (161 - 125)), 180, 20);
        getContentPane().add(txtActivoEmpleado);
    }

    private void crearBotones() {
        this.btnVolver = new JButton();
        this.btnVolver.setText("Volver");
        this.btnVolver.setBounds(200, 390, 120, 20);
        btnVolver.addActionListener(this);
        getContentPane().add(btnVolver);


        this.btnModificarEmpleador = new JButton();
        this.btnModificarEmpleador.setText("Modificar Empleado");
        this.btnModificarEmpleador.setBounds(20, 390, 150, 20);
        btnModificarEmpleador.setEnabled(false);
        btnModificarEmpleador.addActionListener(this);
        getContentPane().add(btnModificarEmpleador);

        this.listaEmpleado = new JComboBox();
        this.listaEmpleado.setBounds(10, 20, 149, 20);
        listaEmpleado.addActionListener(this);
        getContentPane().add(listaEmpleado);
        this.leerEmpleado();

    }

    public void actionPerformed(ActionEvent e) {
        String nombreEmpleado = (String) listaEmpleado.getSelectedItem();
        empleado = tienda.buscarEmpleado(empleado, nombreEmpleado);
        if (e.getSource() == btnVolver) {
            VentanaUsuario ventana = new VentanaUsuario(persona);
            ventana.setVisible(true);
            dispose();
        }

        if (e.getSource() == listaEmpleado) {
            llenarProducto();
        }

        if (e.getSource() == btnModificarEmpleador) {
            if (txtIdEmpleado.getText().equals("") || txtNombreEmpleador.getText().equals("")
                    || txtTelefonoEmpleado.getText().equals("") || txtDireccionEmpleado.getText().equals("")
                    || txtCorreoEmpleado.getText().equals("") || txtclaveEmpleado.getText().equals("")
                    || txtusuarioEmpleado.getText().equals("") || txtSalarioEmpleado.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Completa el formulario");
            } else {
                empleado.setNombre(txtNombreEmpleador.getText());
                empleado.setId(txtIdEmpleado.getText());
                empleado.setTelefono(txtTelefonoEmpleado.getText());
                empleado.setDireccion(txtDireccionEmpleado.getText());
                empleado.setCorreo(txtCorreoEmpleado.getText());
                empleado.setUsuario(txtusuarioEmpleado.getText());
                empleado.setClave(txtclaveEmpleado.getText());
                try {
                    empleado.setSalario(Integer.parseInt(txtSalarioEmpleado.getText()));
                    empleado.setActivo(Integer.parseInt(txtActivoEmpleado.getText()));

                    if (txtBonificaEmpleado.getText().isEmpty()) {
                        empleado.setBonificacion(0);
                    } else {
                        empleado.setBonificacion(Integer.parseInt(txtBonificaEmpleado.getText()));
                    }

                    daoEmpleado.Modifica(empleado);
                    leerEmpleado();
                    btnModificarEmpleador.setEnabled(false);
                    limpiarFormulario();
                    JOptionPane.showMessageDialog(null, "Empleado  Modificado");
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Campo numerico no usar letras");
                }
            }
        }
    }

    private void leerEmpleado() {
        DefaultComboBoxModel mlista = new DefaultComboBoxModel();
        tienda.setLstSEmpleados(daoEmpleado.ConsultarTodos(tienda.getId()));
        for (int i = 0; i < tienda.getLstSEmpleados().size(); i++) {
            mlista.addElement(tienda.getLstSEmpleados().get(i).getId());
        }
        listaEmpleado.setModel(mlista);
        getContentPane().add(listaEmpleado);
    }

    private void llenarProducto() {
        String id = (String) listaEmpleado.getSelectedItem();
        empleado = tienda.buscarEmpleado(empleado, id);
        txtIdEmpleado.setText(empleado.getId());
        txtNombreEmpleador.setText(empleado.getNombre());
        txtTelefonoEmpleado.setText(empleado.getTelefono());
        txtDireccionEmpleado.setText(empleado.getDireccion());
        txtCorreoEmpleado.setText(empleado.getCorreo());
        txtusuarioEmpleado.setText(empleado.getUsuario());
        txtclaveEmpleado.setText(empleado.getClave());
        txtSalarioEmpleado.setText(String.valueOf(empleado.getSalario()));
        txtBonificaEmpleado.setText(String.valueOf(empleado.getBonificacion()));
        txtActivoEmpleado.setText(String.valueOf(empleado.getActivo()));

        btnModificarEmpleador.setEnabled(true);
    }

    private void limpiarFormulario() {
        txtIdEmpleado.setText("");
        txtNombreEmpleador.setText("");
        txtTelefonoEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtCorreoEmpleado.setText("");
        txtusuarioEmpleado.setText("");
        txtclaveEmpleado.setText("");
        txtSalarioEmpleado.setText("");
        txtBonificaEmpleado.setText("");
        txtActivoEmpleado.setText("");
    }
}