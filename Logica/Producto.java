package Logica;

public class Producto
{
    //creacion de variables
    private int id;
    private String nombre;
    private int cantidad;
    private String categoria;
    private double precio;
    
    //crear constructor vacio   
    public Producto()
    {
        this.nombre = "";
        this.cantidad = 0;
        this.categoria = "";
        this.precio = 0;    
    }
    
    //constructor que retorna variable
    public Producto(String nombre, int cantidad, String categoria, double precio)
    {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    public Producto(int id, String nombre, int cantidad, String categoria, double precio)
    {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    //creacion de get y set
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public int getCantidad()
    {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
    
    public String getCategoria()
    {
        return this.categoria;
    }
    
    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }
    
    public double getPrecio()
    {
        return this.precio;
    }
    
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    //creacion de toString
    
    public String toString()
    {
        return "Producto "+this.nombre+" Cantidad "+this.cantidad+" Categoria "+this.categoria+" Precio "+this.precio;
    }
    
    public Object[] toArray()
    {
        Object [] r = {id, nombre, cantidad, categoria, precio};
        return r; 
    }
    
}