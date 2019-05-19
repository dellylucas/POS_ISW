package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ConexionBD.Dao_Producto;
import Modelo.Fachada;
import Modelo.Persona;
import Modelo.Producto;
import Modelo.Tienda;

public class CrearProducto extends JFrame implements ActionListener {
    private JLabel idProducto;
    private JLabel nombreProducto;
    private JLabel cantidadProducto;
    private JLabel precioIngreso;

    private JTextField txtIdProducto;
    private JTextField txtNombreProducto;
    private JTextField txtCantidad;
    private JTextField txtPrecioIngreso;

    private JButton btnCrearProducto;
    private JButton btnVolver;
    private Producto producto;

    private Dao_Producto daoProducto;
    private Tienda tienda;
    private JTextField txtPrecioVenta;
    private JTextField txtFechaVencimiento;
    private Persona persona;

    public CrearProducto(Persona persona) {
        super();
        this.persona =persona;
        tienda = Fachada.getTienda();
        daoProducto = new Dao_Producto();
        this.setTitle("Crear Producto");
        this.setSize(400, 350);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.crearVista();
    }

    private void crearVista() {
        this.idProducto = new JLabel();
        this.idProducto.setText("ID");
        this.idProducto.setBounds(10, 31, 79, 29);
        getContentPane().add(idProducto);

        this.nombreProducto = new JLabel();
        this.nombreProducto.setText("Nombre");
        this.nombreProducto.setBounds(10, 61, 79, 29);
        getContentPane().add(nombreProducto);

        this.cantidadProducto = new JLabel();
        this.cantidadProducto.setText("Cantidad");
        this.cantidadProducto.setBounds(10, 91, 79, 29);
        getContentPane().add(cantidadProducto);

        this.precioIngreso = new JLabel();
        this.precioIngreso.setText("Precio Ingreso");
        this.precioIngreso.setBounds(10, 121, 79, 29);
        getContentPane().add(precioIngreso);

        JLabel precioVenta = new JLabel();
        precioVenta.setText("Precio Venta");
        precioVenta.setBounds(10, 154, 79, 29);
        getContentPane().add(precioVenta);

        JLabel fechaDeVencimiento = new JLabel();
        fechaDeVencimiento.setText("Fecha De Vencimiento");
        fechaDeVencimiento.setBounds(10, 220, 105, 29);
        getContentPane().add(fechaDeVencimiento);

        this.txtIdProducto = new JTextField();
        this.txtIdProducto.setBounds(90, 35, 180, 20);
        getContentPane().add(txtIdProducto);

        this.txtNombreProducto = new JTextField();
        this.txtNombreProducto.setBounds(90, 65, 180, 20);
        getContentPane().add(txtNombreProducto);

        this.txtCantidad = new JTextField();
        this.txtCantidad.setBounds(90, 95, 180, 20);
        getContentPane().add(txtCantidad);

        this.txtPrecioIngreso = new JTextField();
        this.txtPrecioIngreso.setBounds(90, 125, 180, 20);
        getContentPane().add(txtPrecioIngreso);

        txtPrecioVenta = new JTextField();
        txtPrecioVenta.setBounds(90, 161, 180, 20);
        getContentPane().add(txtPrecioVenta);

        txtFechaVencimiento = new JTextField();
        txtFechaVencimiento.setBounds(120, 224, 180, 20);
        txtFechaVencimiento.setText("2019-05-18 13:46");
        getContentPane().add(txtFechaVencimiento);

        //Botones
        this.btnCrearProducto = new JButton();
        this.btnCrearProducto.setText("Crear");
        this.btnCrearProducto.setBounds(40, 280, 120, 20);
        btnCrearProducto.addActionListener(this);
        getContentPane().add(btnCrearProducto);

        this.btnVolver = new JButton();
        this.btnVolver.setText("Volver");
        this.btnVolver.setBounds(180, 280, 120, 20);
        btnVolver.addActionListener(this);
        getContentPane().add(btnVolver);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrearProducto) {
            if (txtIdProducto.getText().equals("") || txtNombreProducto.getText().equals("")
                    || txtCantidad.getText().equals("") || txtPrecioIngreso.getText().equals("")
                    || txtPrecioVenta.getText().equals("") || txtFechaVencimiento.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Completa el formulario");
            } else {
                producto = new Producto();
                producto.setId(txtIdProducto.getText());
                producto.setNombre(txtNombreProducto.getText());
                producto.setCantidad(txtCantidad.getText());
                producto.setPrecioIngreso(txtPrecioIngreso.getText());
                producto.setPrecioVenta(txtPrecioVenta.getText());
                producto.setFechaVencimiento(txtFechaVencimiento.getText());

                daoProducto.Crear(producto,tienda.getId());

                JOptionPane.showMessageDialog(null, "Producto Creado Exitosamente");

                limpiarFormulario();
            }
        }

        if (e.getSource() == btnVolver) {
			VentanaUsuario ventana = new VentanaUsuario(persona);
			ventana.setVisible(true);
			dispose();
        }
    }

    private void limpiarFormulario() {
        txtIdProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidad.setText("");
        txtPrecioIngreso.setText("");
        txtPrecioVenta.setText("");
        txtFechaVencimiento.setText("");

    }
}
