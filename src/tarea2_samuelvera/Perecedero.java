package tarea2_samuelvera;

import java.util.Random;

public class Perecedero extends Alimento{
    Random rand = new Random();
    public Perecedero(int cantidad, String proveedor){
        super(cantidad, proveedor);
        this.FVence = Almacen.dia + rand.nextInt(5-Almacen.dia)+1; //Fecha de expiracióno aleatoria
        setNombre(); //Elección del nombre y el precio
    }
    @Override
    public int getFVence(){
        return this.FVence;
    }
    @Override
    public void setNombre(){ //Nombre aleatorio y precio correspondiente
        if(getProveedor()== "Hanz.CA"){
            this.aux = rand.nextInt(3);
                if(this.aux == 0){
                    this.nombre = "Manzanas";
                    this.precio = 80;
                }else if(this.aux == 1){
                    this.nombre = "Verdura";
                    this.precio = 20;
                }else{
                    this.nombre = "Frijoles";
                    this.precio = 30;
                }
        }else if(getProveedor() == "Food.CA"){
            this.aux = rand.nextInt(3);
                if(this.aux == 0){
                    this.nombre = "Carne";
                    this.precio = 45;
                }else if(this.aux == 1){
                    this.nombre = "Pollo";
                    this.precio = 35;
                }else{
                    this.nombre = "Pescado";
                    this.precio = 60;
                }
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
    public int getCantidad() {
        return this.cantidad;
    }
    @Override
    public float getPrecio() {
        return this.precio;
    }
    
}
