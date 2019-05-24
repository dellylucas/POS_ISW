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

import ConexionBD.*;
import Modelo.*;


public class VentanaSuperAd extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu administradores;
    private JMenu tiendas;
    private JMenu salir;
    private JMenuItem salirite;
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
    private JMenuItem eliminarTienda;
    private JMenuItem modificarTienda;
    private JMenuItem crearTienda;
    private JMenuItem consultarTienda;
    private Dao_Tienda dao_Tienda;

    public VentanaSuperAd(Persona persona) {
        super();
        usuario = new SuperAdmin(persona);
        dao_Tienda = new Dao_Tienda();
        //Singleton Una tienda
        tienda = Fachada.getInstance(usuario);
        tienda.setLstTienda(dao_Tienda.ConsultaTodos());
        this.setTitle(usuario.getNombre() + "(" + usuario.toString() + ") -  " + tienda.getNombre());
        this.setSize(750, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagenes/SupermercadoVentanaPrincipal.jpg"))));
        crearMenu();
    }

    private void crearMenu() {
        menu = new JMenuBar();
        setJMenuBar(menu);
        tiendas = new JMenu("tienda");
        menu.add(tiendas);

        administradores = new JMenu("administradores");
        menu.add(administradores);

        salir = new JMenu("Salir");
        salir.addActionListener(this);
        menu.add(salir);


        salirite = new JMenuItem("Cerrar sesion");
        salirite.addActionListener(this);
        salir.add(salirite);

        crearTienda = new JMenuItem("Crear");
        crearTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearTienda.addActionListener(this);
        tiendas.add(crearTienda);

        consultarTienda = new JMenuItem("Consultar");
        consultarTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarTienda.addActionListener(this);
        tiendas.add(consultarTienda);


        eliminarTienda = new JMenuItem("Eliminar ");
        eliminarTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
        eliminarTienda.addActionListener(this);
        tiendas.add(eliminarTienda);

        modificarTienda = new JMenuItem("Modificar ");
        modificarTienda.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarTienda.addActionListener(this);
        tiendas.add(modificarTienda);
//////////////////////////////////////////////////////////////////////////////////

        crearAdministrador = new JMenuItem("Crear Administrador");
        crearAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Crear.png"))));
        crearAdministrador.addActionListener(this);
        administradores.add(crearAdministrador);

        consultarAdministrador = new JMenuItem("Consultar Administrador");
        consultarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
        consultarAdministrador.addActionListener(this);
        administradores.add(consultarAdministrador);

        modificarAdministrador = new JMenuItem("Modificar Administrador");
        modificarAdministrador.setIcon(new ImageIcon(
                (ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
        modificarAdministrador.addActionListener(this);
        administradores.add(modificarAdministrador);

        eliminarAdministrador = new JMenuItem("Eliminar Administrador");
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
        if (e.getSource() == crearTienda) {
            CrearTienda ventana = new CrearTienda(usuario);
            ventana.setVisible(true);
            dispose();
        }
        if (e.getSource() == consultarTienda) {
            if (tienda.getLstTienda().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ninguna Tienda Registrada");
            } else {
                ConsultarTienda ventana = new ConsultarTienda(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == modificarTienda) {
            if (tienda.getLstTienda().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ninguna Tienda Registrada");
            } else {
                ModificarTienda ventana = new ModificarTienda(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }
        if (e.getSource() == eliminarTienda) {
            if (tienda.getLstTienda().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Hay Ninguna Tienda Registrada");
            } else {
                EliminarTienda ventana = new EliminarTienda(usuario);
                ventana.setVisible(true);
                dispose();
            }
        }

        if (e.getSource() == salirite) {
            Dao_Login dao = new Dao_Login();
            dao.ModificarSesion(usuario.getId(),0);
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            dispose();
        }
    }

}
	    

