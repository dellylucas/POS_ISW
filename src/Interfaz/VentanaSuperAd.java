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


public class VentanaSuperAd extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu administradores;
    private JMenu tiendas;
    private JMenu perdidas;
    private JMenu ganancias;
    private JMenu salir;
    private JMenuItem crearAdministrador;
    private JMenuItem consultarAdministrador;
    private JMenuItem modificarAdministrador;
    private JMenuItem eliminarAdministrador;

    private Dao_Producto daoProduct;
    private Dao_Empleado daoEmpleado;
    private Dao_Proveedor daoProveedor;

    private JMenuItem cerrarSesion;
    private JLabel label;
    private Persona usuario;
    private Tienda tienda;
    private JMenuItem crearTienda;
    private JMenuItem consultarTienda;
    private JMenuItem eliminarTienda;
    private JMenuItem modificarTienda;

    public VentanaSuperAd(Persona persona) {
        super();
        switch (persona.getRol()) {
            case 1:
                usuario = new SuperAdmin(persona);
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

        administradores = new JMenu("administradores");
        menu.add(administradores);
        
        crearAdministrador = new JMenuItem("Crear ");
        crearAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearAdministrador.addActionListener(this);
        tiendas.add(crearAdministrador);

        consultarAdministrador = new JMenuItem("Consultar ");
        consultarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarAdministrador.addActionListener(this);
        tiendas.add(consultarAdministrador);

        modificarAdministrador = new JMenuItem("Modificar ");
        modificarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarAdministrador.addActionListener(this);
        tiendas.add(modificarAdministrador);

        eliminarAdministrador = new JMenuItem("Eliminar ");
        eliminarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));        
        eliminarAdministrador.addActionListener(this);
        tiendas.add(eliminarAdministrador);        

        tiendas = new JMenu("tienda");
        menu.add(tiendas);

        crearTienda = new JMenuItem("Crear ");
        crearTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearTienda.addActionListener(this);
        tiendas.add(crearTienda);

        consultarTienda = new JMenuItem("Consultar ");
        consultarTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarTienda.addActionListener(this);
        tiendas.add(consultarTienda);

        modificarTienda = new JMenuItem("Modificar ");
        modificarTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarAdministrador.addActionListener(this);
        tiendas.add(modificarAdministrador);

        eliminarAdministrador = new JMenuItem("Eliminar ");
        eliminarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        eliminarAdministrador.addActionListener(this);
        tiendas.add(eliminarAdministrador);

        perdidas = new JMenu("Perdidas");
        menu.add(perdidas);

        ganancias = new JMenu("Ganancias");
        menu.add(ganancias);

        salir = new JMenu("Salir");
        salir.addActionListener(this);
        menu.add(salir);

        crearAdministrador = new JMenuItem("Crear Producto");
        crearAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearAdministrador.addActionListener(this);
        administradores.add(crearAdministrador);

        consultarAdministrador = new JMenuItem("Consultar Producto");
        consultarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarAdministrador.addActionListener(this);
        administradores.add(consultarAdministrador);

        modificarAdministrador = new JMenuItem("Modificar Producto");
        modificarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarAdministrador.addActionListener(this);
        administradores.add(modificarAdministrador);

        eliminarAdministrador = new JMenuItem("Eliminar Productos");
        eliminarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        eliminarAdministrador.addActionListener(this);
        administradores.add(eliminarAdministrador);

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == crearAdministrador) {
            CrearProducto ventana = new CrearProducto(usuario);
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == consultarAdministrador) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                ConsultarProductos ventana = new ConsultarProductos(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarAdministrador) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                ModificarProducto ventana = new ModificarProducto(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == eliminarAdministrador) {
            if (tienda.getLstProductos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            } else {
                EliminarProducto ventana = new EliminarProducto(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == crearTienda) {
            CrearProveedores ventana = new CrearProveedores(usuario);
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == consultarAdministrador) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                ConsultarProveedor ventana = new ConsultarProveedor(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarAdministrador) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                ModificarProveedor ventana = new ModificarProveedor(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == eliminarAdministrador) {
            if (tienda.getLstProveedor().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            } else {
                EliminarProveedor ventana = new EliminarProveedor(usuario);
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
            daoProveedor = new Dao_Proveedor();
            tienda.setLstSEmpleados(daoEmpleado.ConsultarTodos(tienda.getId()));
            tienda.setLstProveedor(daoProveedor.ConsultaTodos(tienda.getId()));
        }
        daoProduct = new Dao_Producto();
        tienda.setLstProductos(daoProduct.ConsultaTodos(tienda.getId()));
    }
}