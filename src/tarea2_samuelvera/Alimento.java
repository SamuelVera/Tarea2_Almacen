package tarea2_samuelvera;


public abstract class Alimento {
    protected String nombre, proveedor;
    protected double precio, costo;
        //Constructor
    Alimento(String nombre){
        this.nombre = nombre;
    }
    public abstract String getNombre();
    public abstract String getProveedor();
    public abstract double getPrecio();
    public abstract double getCosto();
    public abstract void setProveedorPrecioCosto();
}
