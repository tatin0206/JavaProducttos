package Presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.ColeccionProductos;
import Logica.Producto;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class PantallaGrafica extends JFrame implements ActionListener
{   
    JLabel lblnombre,lblcantidad,lblprecio, lblid, lblnombre2, lblcantidad2, lblcategoria, lblcategoria2;
    
    JButton btneliminar,btnguardar,btnconsultar, btnactualizar;
    
    JTextField txtnombre,txtcantidad,txtprecio, txtid,txtnombre2,txtcantidad2,txtprecio2;
    
    JComboBox combo,combo2;   
    
    private ColeccionProductos col =  new ColeccionProductos();
    
    public PantallaGrafica()
    {
        col.cargarProductos();
        iniciarComponentes();
    }
    
    public void iniciarComponentes()
    {
        setBounds(200, 100, 600, 500);
        setTitle("Bienvenidos a las interfaces gráficas Java");
        
        //recuadro para vidsualizar las pestañas
        JTabbedPane pestaña=new JTabbedPane();
        pestaña.setBounds(0, 0, 600, 700);          
        //<----pestaña 1 ---->
        
        //pestaña1
        JPanel p1=new JPanel();
        p1.setLayout(null);
        pestaña.addTab("Registrar", p1);
        
        //nombre
        lblnombre = new JLabel("nombre");
        txtnombre = new JTextField();
        lblnombre.setBounds(50, 50, 200, 30);
        txtnombre.setBounds(120, 50, 150, 20);
        p1.add(lblnombre);
        p1.add(txtnombre);
        
        //cantidad
        lblcantidad = new JLabel("cantidad");
        txtcantidad = new JTextField();
        lblcantidad.setBounds(50, 90, 200, 30);
        txtcantidad.setBounds(120, 90, 250, 21);
        p1.add(lblcantidad);
        p1.add(txtcantidad);
        
        //precio
        lblprecio = new JLabel("precio");
        txtprecio = new JTextField();
        lblprecio.setBounds(50, 130, 200, 30);
        txtprecio.setBounds(120, 130, 250, 21);
        p1.add(lblprecio);
        p1.add(txtprecio);
        
        //categoria
        lblcategoria = new JLabel("Categoria");
        combo = new JComboBox();
        combo.addItem("granos");
        combo.addItem("viveres");
        combo.addItem("licores");
        lblcategoria.setBounds(50, 170, 250, 21);
        combo.setBounds(125, 170, 250, 21);
        combo.addActionListener(this);
        p1.add(lblcategoria);
        p1.add(combo);
        
        //boton guardar
        btnguardar = new JButton("Guardar");
        btnguardar.setBounds(50,210,95,20);
        btnguardar.addActionListener(this);
        p1.add(btnguardar);
        
        //<----pestaña 2 ---->
        
        //pestaña2
        JPanel p2=new JPanel();        
        //pestaña.addTab("Consultar", p2);
        p2.setBounds(0,0,300, 100);
       
        //traer los campos para la tabla
        
        String [] columnas = col.armarColumnas();
        Object [][] datos = col.armarMatrizVehiculos();
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        
        //creacion de la tabla en pestaña2
        JTable tabla = new JTable(dtm);
        tabla.setPreferredScrollableViewportSize(new Dimension(300, 100));
        JScrollPane scroll = new JScrollPane(tabla);
        //p2.add(scroll);
        
        //pestaña1
        JPanel p3=new JPanel();
        p3.setLayout(null);
        pestaña.addTab("Consultar", p3);
        p3.setBounds(0,0,500,400);
        
        JPanel p4=new JPanel();
        p4.setLayout(null);
        p4.setBounds(0,0,500,240);
        JPanel p5=new JPanel();
        p5.setLayout(null);
        p5.setBounds(50,260,500,100);
        p5.setLayout(new GridLayout(1, 0));
        p5.add(scroll);
        
        
        //label y texbox de id
        lblid = new JLabel("Id");
        txtid = new JTextField(5);
        lblid.setBounds(50, 15, 200, 30);
        txtid.setBounds(120, 15, 150, 20);
        p4.add(lblid);
        p4.add(txtid);
        //nombre
        lblnombre2 = new JLabel("nombre");
        txtnombre2 = new JTextField();
        lblnombre2.setBounds(50, 50, 200, 30);
        txtnombre2.setBounds(120, 50, 150, 20);
        p4.add(lblnombre2);
        p4.add(txtnombre2);
        
        //cantidad
        lblcantidad = new JLabel("cantidad");
        txtcantidad2 = new JTextField();
        lblcantidad.setBounds(50, 90, 200, 30);
        txtcantidad2.setBounds(120, 90, 100, 20);
        p4.add(lblcantidad);
        p4.add(txtcantidad2);
        
        //precio
        lblprecio = new JLabel("precio");
        txtprecio2 = new JTextField();
        lblprecio.setBounds(50, 130, 200, 30);
        txtprecio2.setBounds(120, 130, 100, 21);
        p4.add(lblprecio);
        p4.add(txtprecio2);
        
        //categoria
        combo2 = new JComboBox();
        combo2.addItem("granos");
        combo2.addItem("viveres");
        combo2.addItem("licores");
        p4.add(combo2);
        lblcategoria2 = new JLabel("Categoria");
        p4.add(lblcategoria2);
        lblcategoria2.setBounds(50, 170, 100, 21);
        combo2.setBounds(125, 170, 100, 21);
        
        //botones pestaña2
        
        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(50,210,90,20);
        btneliminar.addActionListener(this);
        p4.add(btneliminar);
        
        btnconsultar = new JButton("Consultar");
        btnconsultar.setBounds(145,210,110,20);
        btneliminar.addActionListener(this);
        p4.add(btnconsultar);
        
        btnactualizar = new JButton("Actualizar");
        btnactualizar.setBounds(260,210,110,20);
        btneliminar.addActionListener(this);
        p4.add(btnactualizar);
        
        //<---adicionar a el panel de la pestaña2
        p3.add(p4);
        p3.add(p5);
        
        
        add(pestaña);
        setLayout(null);  
        setVisible(true);
    }
    
    public void ingresarProducto()
    {
        String nombre = txtnombre.getText();
        System.out.println(nombre);
        int cantidad = Integer.parseInt(txtcantidad.getText());
        String categoria = combo.getSelectedItem().toString();
        double precio = Double.parseDouble(txtprecio.getText());
        Producto p = new Producto(nombre, cantidad, categoria, precio);   
        boolean guardado = col.guardarProducto(p);
        String [] columnas = col.armarColumnas();
        Object [][] datos = col.armarMatrizVehiculos();
        DefaultTableModel dtm = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(dtm);
    }
    
    public void eliminarProducto()
    {
        int index = Integer.parseInt(txtid.getText());
         
        Producto p = col.getProducto(index);
        col.borrarProducto(index);
        
    }
    
    public void actualizarProducto()
    {
        int index = Integer.parseInt(txtid.getText());
                if (index <0 || index > col.getSize() - 1)
                {
                    JOptionPane.showMessageDialog(null, "No se puede modificar");
                }
                else 
                {
                    Producto p = col.getProducto(index);
                    String nombre =  txtnombre2.getText();
                    int cantidad = Integer.parseInt(txtcantidad2.getText());
                    String categoria = combo2.getSelectedItem().toString();
                    double precio = Double.parseDouble(txtprecio2.getText());
                    p.setNombre(nombre);
                    p.setCantidad(cantidad);
                    p.setCategoria(categoria);
                    p.setPrecio(precio);
                    col.actualizarProducto(index, p);
                    JOptionPane.showMessageDialog(null, "Producto actualizado");
                }  
        System.out.println("Actualizado");
    }
    
    public void consultarProducto()
    {
        int index = Integer.parseInt(txtid.getText());
        Producto p = col.getProducto(index);
        String nombre = p.getNombre();
        System.out.println(nombre);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnguardar)
        {
            ingresarProducto();
        }
        
        else if (e.getSource() == btneliminar)
        {
            eliminarProducto();
        }
        
        else if (e.getSource() == btnactualizar)
        {
            actualizarProducto();
        }
        
        else if (e.getSource() == btnconsultar)
        {
            consultarProducto();
        }
    }
    
    
    
    
    
}