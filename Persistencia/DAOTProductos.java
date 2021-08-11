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
     
    /*public ArrayList<Producto> filtrarProductos(int id, String nombre, int cantidad, String categoria, double precio)
    {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        String sql = "SELECT id, nombre, cantidad, categoria, precio " +
                     "FROM TProductos ";
        
        String sqlQuery="";
        if (id>0)
        {
            sqlQuery = "WHERE id LIKE '%" + id + "%' ";
        }
        if (!nombre.equals(""))
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(marca) LIKE '%" + nombre.toLowerCase() + "%' ";
        }
        if (cantidad>0)
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(referencia) LIKE '%" + cantidad + "%' ";
        }
        if (!categoria.equals(""))
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "LOWER(placa) LIKE '%" + categoria.toLowerCase() + "%' ";
        }
        if (precio>0)
        {
            sqlQuery += sqlQuery.equals("") ? "WHERE " : "OR ";
            sqlQuery += "modelo LIKE '%" + precio + "%' ";
        }
        
        sql += sqlQuery;
        System.out.println(sql);
        System.out.println(sql);
        Conexion c = new Conexion();
        c.crearConexion();
        
        try
        {
            //EJECUTAR EL SQL y recibir el ResultSet
            ResultSet rs = c.ejecutarQuery(sql);
            //RECORRER TODOS LOS REGISTROS DEL RESULTSET
            while(rs.next())
            {
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                cantidad = rs.getInt("cantidad");
                categoria = rs.getString("categoria");
                precio = rs.getDouble("precio");
                //ARMAR EL OBJETO VEHICULO
                Producto v = new Producto(id, nombre, cantidad, categoria, precio);
                //ARMAR MI ARRAYLIST
                listaProductos.add(v);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //Cerrar conexion
        c.cerrarConexion();
        return listaProductos;
    }*/
    
    
}
