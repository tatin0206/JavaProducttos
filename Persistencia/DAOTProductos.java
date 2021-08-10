package Persistencia;
import Logica.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOTProductos
{
    private int idInsertado = 0;
    private ArrayList<Producto> listaConsultada;
    
    public int guardarProducto(Producto p)
    {
        int id = 0;
        //Armar el SQL
        String sql = "INSERT INTO TProductos "+
                    "(nombre, cantidad, categoria, precio) "+
                    "VALUES ('" +p.getNombre()+"', '"+p.getCantidad()+"', '"+
                    p.getCategoria()+"', '"+p.getPrecio()+"')";
        System.out.println(sql);           
        //Crear conexion
        Conexion c = new Conexion();        
        c.crearConexion();
        //Ejecutar el sql
        try
        {
            ResultSet rs = c.ejecutarUpdate(sql);
            if (rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Cerrar conexion
        c.cerrarConexion();    
        return id;
    }
    
    public boolean  obtenerProductos2()
    {
        listaConsultada = new ArrayList<Producto>();
        
        //Armar el sql
        String sql = "SELECT id, nombre, cantidad, categoria, precio "+
                    "FROM TProductos";
        
        //Crear la conexion
        Conexion c = new Conexion();
        c.crearConexion();
        
        try
        {
            //Ejecutar el SQL y recibir el ResultSet
            ResultSet rs = c.ejecutarQuery(sql);
            
            //Recorrer todos los registros ResultSet
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                
                //Armar el objeto Producto
                Producto p = new Producto(id, nombre, cantidad, categoria, precio);
                
                //Armar el ArrayList
                listaConsultada.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        //Cerrar conexion
        c.cerrarConexion();
        return true;
        //return listaProductos;
    }
    
    public ArrayList<Producto> obtenerProductos()
    {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        //Armar el sql
        String sql = "SELECT id, nombre, cantidad, categoria, precio "+
                    "FROM TProductos";
        
        //Crear la conexion
        Conexion c = new Conexion();
        c.crearConexion();
        
        try
        {
            //Ejecutar el SQL y recibir el ResultSet
            ResultSet rs = c.ejecutarQuery(sql);
            
            //Recorrer todos los registros ResultSet
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                String categoria = rs.getString("categoria");
                double precio = rs.getDouble("precio");
                
                //Armar el objeto Producto
                Producto p = new Producto(id, nombre, cantidad, categoria, precio);
                
                //Armar el ArrayList
                listaProductos.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Cerrar conexion
        c.cerrarConexion();
        return listaProductos;
    }
    
    public void modificarProducto(Producto p)
    {
        String sql = "UPDATE TProductos "+
                     "SET nombre = '"+ p.getNombre()+"', cantidad = '"+ p.getCantidad()+"', precio = '"+p.getPrecio()+ "' "+
                     "WHERE id = "+p.getId()+"";
        System.out.println(sql);
        //Crear conexion
        Conexion c = new Conexion();
        c.crearConexion();
        c.ejecutarUpdate(sql);
        c.cerrarConexion();
    }
    
    public void borrarProducto(Producto p)
    {
        String sql = "DELETE FROM TProductos "+
                 "WHERE id = " + p.getId()+ "";
        
        //Crear conexion
        Conexion c = new Conexion();
        c.crearConexion();
        c.ejecutarUpdate(sql);
        c.cerrarConexion();
    }
    
    public ArrayList<Producto> getListaConsultada()
    {
        return this.listaConsultada;
    }
}