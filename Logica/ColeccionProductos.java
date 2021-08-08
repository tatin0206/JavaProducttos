package Logica;
import java.util.ArrayList;
import Persistencia.DAOTProductos;
//import Persistencia.Archivo;

public class ColeccionProductos
{
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    
    public void addProducto(Producto p)
    {
        productos.add(p);
    }
    
    public Producto getProducto(int index)
    {
        return productos.get(index);
    }
    
    public void deleteProducto(int index)
    {
        productos.remove(index);
    }
    
    public int getSize()
    {
        return productos.size();
    }
    
    public void setProducto(int index, Producto p)
    {
        productos.set(index, p);
    }
    
    public boolean guardarProducto(Producto p)
    {
        DAOTProductos dao = new DAOTProductos();
        int id = dao.guardarProducto(p);
        if (id > 0)
        {
            p.setId(id);
            addProducto(p);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void actualizarProducto(int index, Producto p)
    {
        DAOTProductos dao = new DAOTProductos();
        dao.modificarProducto(p);
        setProducto(index, p);
    }
    
    public void cargarProductos()
    {
        DAOTProductos dao = new DAOTProductos();
        productos = dao.obtenerProductos();
    }
    
    public void borrarProducto(int index)
    {
        DAOTProductos dao = new DAOTProductos();
        dao.borrarProducto(getProducto(index));
        deleteProducto(index);
    }
    
    public Object[][] armarMatrizVehiculos()
    {
        int cantColumnas = 5;
        int cant = getSize();
        Object[][] datos = new Object[cant][cantColumnas];
        
        for (int i =0; i<cant; i++)
        {
            datos[i] = getProducto(i).toArray();
        }
        return datos;

    }
    
    public String[] armarColumnas()
    {
        String [] columnas = {"Id", "Nombre", "Cantidad", "Categoria", "Precio" };
        return columnas;
    }
}