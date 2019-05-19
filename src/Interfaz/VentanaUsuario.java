package Interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ConexionBD.Dao_Empleado;
import ConexionBD.Dao_Producto;
import ConexionBD.Dao_Proveedor;
import Modelo.*;


public class VentanaUsuario extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu producto;
    private JMenu proveedores;
    private JMenu empleados;
    private JMenu contratos;
    private JMenu salir;
    private JMenuItem crearProducto;
    private JMenuItem consultarProducto;
    private JMenuItem modificarProducto;
    private JMenuItem eliminarProducto;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;
    private JMenuItem crearEmpleado;
    private JMenuItem consultarEmpleado;
    private JMenuItem modificarEmpleado;
    private JMenuItem eliminarEmpleado;

    private JMenuItem cerrarSesion;
    private JLabel label;
    private Persona usuario;
    private Tienda tienda;
    private JMenuItem CrearProveedor;
    private JMenuItem ConsultarProveedor;
    private JMenuItem EliminarProveedor;
    private JMenuItem modificarProveedor;

    public VentanaUsuario(Persona persona) {
        super();
        switch (persona.getRol()) {
            case 2:
                usuario = new Administrador(persona);
                break;
            case 3:
                usuario = new Empleado(persona);
                break;
        }
        //Singleton Una tienda
        tienda = Fachada.getInstance(usuario);

        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") - SuperMercado " + tienda.getNombre());
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagenes/SupermercadoVentanaPrincipal.jpg"))));
        Initialization(usuario.getRol());
    }

    private void crearMenu() {
        menu = new JMenuBar();
        setJMenuBar(menu);

        producto = new JMenu("Inventario");
        menu.add(producto);

        proveedores = new JMenu("Proveedores");
        menu.add(proveedores);


        CrearProveedor = new JMenuItem("Crear ");
        CrearProveedor.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        CrearProveedor.addActionListener(this);
        proveedores.add(CrearProveedor);

        ConsultarProveedor = new JMenuItem("Consultar ");
        ConsultarProveedor.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        ConsultarProveedor.addActionListener(this);
        proveedores.add(ConsultarProveedor);

        modificarProveedor = new JMenuItem("Modificar ");
        modificarProveedor.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarProveedor.addActionListener(this);
        proveedores.add(modificarProveedor);

        EliminarProveedor = new JMenuItem("Eliminar ");
        EliminarProveedor.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        EliminarProveedor.addActionListener(this);
        proveedores.add(EliminarProveedor);

        empleados = new JMenu("Empleados");
        menu.add(empleados);

        contratos = new JMenu("Compras");
        menu.add(contratos);

        salir = new JMenu("Salir");
        salir.addActionListener(this);
        menu.add(salir);

        crearProducto = new JMenuItem("Crear Producto");
        crearProducto.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearProducto.addActionListener(this);
        producto.add(crearProducto);

        consultarProducto = new JMenuItem("Consultar Producto");
        consultarProducto.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarProducto.addActionListener(this);
        producto.add(consultarProducto);

        modificarProducto = new JMenuItem("Modificar Producto");
        modificarProducto.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarProducto.addActionListener(this);
        producto.add(modificarProducto);

        eliminarProducto = new JMenuItem("Eliminar Productos");
        eliminarProducto.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        eliminarProducto.addActionListener(this);
        producto.add(eliminarProducto);


        crearEmpleado = new JMenuItem("Crear");
        crearEmpleado.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearEmpleado.addActionListener(this);
        empleados.add(crearEmpleado);

        consultarEmpleado = new JMenuItem("Consultar");
        consultarEmpleado.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarEmpleado.addActionListener(this);
        empleados.add(consultarEmpleado);

        modificarEmpleado = new JMenuItem("Modificar");
        modificarEmpleado.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarEmpleado.addActionListener(this);
        empleados.add(modificarEmpleado);

        eliminarEmpleado = new JMenuItem("Eliminar");
        eliminarEmpleado.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        eliminarEmpleado.addActionListener(this);
        empleados.add(eliminarEmpleado);

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == crearProducto) {
            CrearProducto ventana = new CrearProducto(usuario);
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == consultarProducto) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                ConsultarProductos ventana = new ConsultarProductos(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarProducto) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                ModificarProducto ventana = new ModificarProducto(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == eliminarProducto) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                EliminarProducto ventana = new EliminarProducto(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == CrearProveedor) {
            CrearProveedores ventana = new CrearProveedores(usuario);
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == ConsultarProveedor) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                ConsultarProveedor ventana = new ConsultarProveedor(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarProveedor) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                ModificarProveedor ventana = new ModificarProveedor(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == EliminarProveedor) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                EliminarProveedor ventana = new EliminarProveedor(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == crearEmpleado) {
            CrearEmpleado ventana = new CrearEmpleado();
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == consultarEmpleado) {
            if (tienda.getLstSEmpleados().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Empleado Registrado");
            } else {
                ConsultarEmpleado ventana = new ConsultarEmpleado();
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarEmpleado) {
            if (tienda.getLstSEmpleados().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Empleado Registrado");
            } else {
                ModificarEmpleado ventana = new ModificarEmpleado();
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == eliminarEmpleado) {
            if (tienda.getLstSEmpleados().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                EliminarEmpleado ventana = new EliminarEmpleado();
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == salir) {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            dispose();
        }
    }

    private void Initialization(int rol) {
        this.crearMenu();
        if (rol == 2) {
            daoEmpleado = new Dao_Empleado();
            daoProveedor= new Dao_Proveedor();
            tienda.setLstSEmpleados(daoEmpleado.ConsultarTodos(tienda.getId()));
            tienda.setLstProveedor(daoProveedor.ConsultaTodos(tienda.getId()));
        }
        daoProduct = new Dao_Producto();
        tienda.setLstProductos(daoProduct.ConsultaTodos(tienda.getId()));
    }
}