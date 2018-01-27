package tarea2_samuelvera;

import java.util.Random;

public class Perecedero extends Alimento{
    private final int FVence;
    Random rand = new Random();
    public Perecedero(String nombre){
        super(nombre);
        setProveedorPrecioCosto();
        this.FVence = rand.nextInt(4)+2;
    }
    public int getFVence(){
        return this.FVence;
    }
    @Override
    public void setProveedorPrecioCosto(){ //Nombre aleatorio y Proveedor correspondiente
        if(this.nombre == "Carne roja"){
            this.proveedor = "Carnes S.A";
            this.costo = 20;
            this.precio = 50;
        }else if(this.nombre == "Pollo"){
            this.precio = 30;
            this.costo  = 10;
            this.proveedor = "Carnes S.A";
        }else if(this.nombre == "Vegetales"){
            this.proveedor = "Abastos Co";
            this.costo = 5;
            this.precio = 20;
        }
    }
    @Override
    public String getNombre() {
        return this.nombre;
    }
    @Override
    public String getProveedor() {
        return this.proveedor;
    }
    @Override
    public double getPrecio() {
        return this.precio;
    }
    @Override
    public double getCosto(){
        return this.costo;
    }
}