package Interfaz;

import Modelo.Fachada;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpleado extends JFrame implements ActionListener {
    private JMenuBar menu;
    private JMenu producto;
    private JMenu proveedores;
    private JMenu cargar;
    private JMenu contratos;
    private JMenu salir;
    private JMenuItem crearProducto;
    private JMenuItem consultarProducto;
    private JMenuItem modificarProducto;
    private JMenuItem eliminarProducto;
    private JMenuItem cerrarSesion;
    private JLabel label;
    private Tienda a = Fachada.getTienda();
    private JMenuItem CrearProveedor;
    private JMenuItem ConsultarProveedor;
    private JMenuItem EliminarProveedor;
    private JMenuItem modificarProveedor;

    public VentanaEmpleado(){
        super();
        setIconImage(Toolkit.getDefaultToolkit().getImage
                (ClassLoader.getSystemResource("Imagenes/Hospital.jpg")));
        this.setTitle("SuperMercado "+a.getNombre()+" ALL RETAILER (Administrador)");
        this.setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagenes/SupermercadoVentanaPrincipal.jpg"))));
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.crearMenu();
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

        cargar = new JMenu("Empleados");
        menu.add(cargar);

        contratos = new JMenu("Compras");
        menu.add(contratos);

        salir = new JMenu("Salir");
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


//		CrearProveedor = new JMenuItem("Crear");
//		CrearProveedor.setIcon(new ImageIcon(
//		(ClassLoader.getSystemResource("Imagenes/Crear.png"))));
//		CrearProveedor.addActionListener(this);
//		proveedores.add(EliminarProveedor);
//
//		ConsultarProveedor = new JMenuItem("Consultar");
//		ConsultarProveedor.setIcon(new ImageIcon(
//		(ClassLoader.getSystemResource("Imagenes/Consultar.png"))));
//		ConsultarProveedor.addActionListener(this);
//		proveedores.add(ConsultarProveedor);
//
//		modificarProveedor = new JMenuItem("Modificar");
//		modificarProveedor.setIcon(new ImageIcon(
//		(ClassLoader.getSystemResource("Imagenes/Modificar.png"))));
//		modificarProveedor.addActionListener(this);
//		proveedores.add(modificarProveedor);
//
//		 EliminarProveedor= new JMenuItem("Eliminar");
//		EliminarProveedor.setIcon(new ImageIcon(
//		(ClassLoader.getSystemResource("Imagenes/Borrar.png"))));
//		EliminarProveedor.addActionListener(this);

//		proveedores.add(EliminarProveedor);

    }
//
//		cerrarSesion = new JMenuItem("Cerrar Sesion");
//		cerrarSesion.setIcon(new ImageIcon(
//		(ClassLoader.getSystemResource("Imagenes/Salir.png"))));
//		cerrarSesion.addActionListener(this);
//		salir.add(cerrarSesion);




    public void actionPerformed(ActionEvent e) {
        Producto productos = new Producto();
        Proveedor proveedor = new Proveedor();


        if(e.getSource()==CrearProveedor){
            //CrearProveedores ventana = new CrearProveedores(proveedor);
            //ventana.setVisible(true);
            setVisible(false);
        }

        if(e.getSource()==crearProducto){
            CrearProducto ventana = new CrearProducto(productos);
            ventana.setVisible(true);
            setVisible(false);
        }

        if(e.getSource()==consultarProducto){
            if(a.getLstProductos().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            }else{
                ConsultarProductos ventana = new ConsultarProductos();
                ventana.setVisible(true);
                setVisible(false);
            }
        }

        if(e.getSource()==modificarProducto){
            if(a.getLstProductos().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            }else{
                ModificarProducto ventana = new ModificarProducto();
                ventana.setVisible(true);
                setVisible(false);
            }
        }

        if(e.getSource()==eliminarProducto){
            if(a.getLstProductos().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Producto Registrado");
            }else{
                EliminarProducto ventana = new EliminarProducto();
                ventana.setVisible(true);
                setVisible(false);
            }
        }


        if(e.getSource()==ConsultarProveedor){
            if(a.getLstProveedor().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            }else{
								/*ConsultarProveedor ventana = new ConsultarProveedor();
								ventana.setVisible(true);
								setVisible(false);*/
            }
        }

        if(e.getSource()==modificarProveedor){
            if(a.getLstProveedor().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            }else{
								/*ModificarProveedor ventana = new ModificarProveedor();
								ventana.setVisible(true);
								setVisible(false);*/
            }
        }

        if(e.getSource()==EliminarProveedor){
            if(a.getLstProveedor().isEmpty()){
                JOptionPane.showMessageDialog(null, "No Hay Ningun Proveedor Registrado");
            }else{
								/*EliminarProveedor ventana = new EliminarProveedor();
								ventana.setVisible(true);
								setVisible(false);*/
            }
        }

        if(e.getSource()==cerrarSesion){
            VentanaPrincipal ventana = new VentanaPrincipal(a);
            ventana.setVisible(true);
            setVisible(false);
        }
    }
}