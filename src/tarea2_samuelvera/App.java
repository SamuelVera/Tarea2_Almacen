/**
 * Universidad Metropolitana
 * Departamento de Sistemas
 * Estructuras de Datos
 * Preparaduría
 * Tarea 2
 */
package tarea2_samuelvera;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Samuel Vera
 * CI: 26475783
 * Carnet: 20171110080
 * 
 */
public class App {
        //Globales
    private Alimento almacen[] = new Alimento[5000];
    Random rand = new Random();
    private int capacidad = 0;
    private int dia=1; //Lunes = 1, Martes = 2, Miercoles = 3, Jueves = 4, Viernes = 5
    private double gastodia=0,gastosemana=0, ingresodia=0, ingresosemana=0;
        //Ejecución
    private void ejecutar(){
        while(dia <=5){
            if(dia == 1 || dia == 2 || dia == 4){
                capacidad = capacidad + 1000;
                entradas();
            }
            salidas();
            finalDia();
            dia++;
            gastodia=0;ingresodia=0;
        }
    }
        //Compras del dia
    private void entradas(){
        int aux, cont=0;
        int aux1=0, aux2=0, aux3=0;
        for(int i=0;i<capacidad;i++){
            aux = rand.nextInt(3);
            if(dia == 1 && almacen[i] == null){
                if(aux == 0){ 
                    almacen[i] = new Perecedero("Carne roja");
                    aux1++;
                }
                else if(aux == 1){
                    almacen[i] = new Perecedero("Pollo");
                    aux2++;
                }
                else if(aux == 2){
                    almacen[i] = new Perecedero("Vegetales");
                    aux3++;
                }
                cont++;
                gastodia = gastodia + almacen[i].getCosto();
            }else if((dia == 2 || dia == 4) && almacen[i] == null){
                if(aux == 0){
                    almacen[i] = new NoPerecedero("Enlatado de carne");
                    aux1++;
                }
                else if(aux == 1){
                    almacen[i] = new NoPerecedero("Enlatado de pollo");
                    aux2++;
                }
                else if(aux == 2){
                    almacen[i] = new NoPerecedero("Vegetales en lata");
                    aux3++;
                }cont++;
                gastodia = gastodia + almacen[i].getCosto();
                if(cont == 1000){
                    break;
                }
            }
        }
        if(dia == 1){
            System.out.println("================================================");
            System.out.println("================================================");
            System.out.println("**INGRESOS DEL DIA "+dia+"***");
            System.out.println("================================================");
            System.out.println("Kilos de Carne: "+aux1);
            System.out.println("================================================");
            System.out.println("Kilos de Pollo: "+aux2);
            System.out.println("================================================");
            System.out.println("Kilos de Vegetales: "+aux3);
            System.out.println("================================================");
        }else{
            System.out.println("================================================");
            System.out.println("================================================");
            System.out.println("**INGRESOS DEL DIA***");
            System.out.println("================================================");
            System.out.println("Latas de Carne: "+aux1);
            System.out.println("================================================");
            System.out.println("Latas de Pollo: "+aux2);
            System.out.println("================================================");
            System.out.println("Latas de Vegetales: "+aux3);
            System.out.println("================================================");
        }
    }
        //Ventas del día
    private void salidas(){
        int aux, cont=0;
          for(int i=0;i<almacen.length;i++){
            aux = rand.nextInt(4);
                if(almacen[i] instanceof Perecedero && ((Perecedero) almacen[i]).getFVence() == dia && almacen[i] != null){
                    ingresodia += almacen[i].getPrecio();
                    almacen[i] = null;
                    cont++;
                }
                else if(aux < 2 && almacen[i] != null && dia > 1){
                    ingresodia += almacen[i].getPrecio();
                    almacen[i] = null;
                    cont++;
                }
            }
        capacidad = capacidad - cont;
    }
        //Reporte del final del día
    private void finalDia(){
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("**REPORTE DEL FINAL DEL DIA "+dia+"***");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("Gastos en compras del dia: "+gastodia+" Bs.");
        if(dia > 1){
            System.out.println("================================================");
            System.out.println("Ingresos por ventas del dia: "+ingresodia+" Bs.");
            System.out.println("================================================");
            System.out.println("Balance general del dia: " +(ingresodia-gastodia)+" Bs.");
            System.out.println("================================================");
        }else{
            System.out.println("================================================");
            System.out.println("Ingresos por ventas del dia: 0 Bs.");
            System.out.println("================================================");
            System.out.println("Balance general del dia: " +(0-gastodia)+" Bs.");
            System.out.println("================================================");
        }
        System.out.println();
        ingresosemana = ingresosemana + ingresodia;
        gastosemana = gastosemana + gastodia; 
        status();
    }
        //Reporte Final de semana
    private void finalSemana(){
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("***REPORTE DEL FINAL DE SEMANA***");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("Gastos en la semana: "+gastosemana+" Bs.");
        System.out.println("================================================");
        System.out.println("Ingresos de la semana: "+ingresosemana+" Bs.");
        System.out.println("================================================");
        System.out.println("Balance general de la semana:"+(ingresosemana-gastosemana+" Bs."));
        System.out.println("================================================");
        System.out.println();
    }
        //Status del almacén al final del dia
    private void status(){
        System.out.println("================================================");
        System.out.println("***STATUS DEL ALMACEN AL FINAL DEL DIA***");
        System.out.println("================================================");
        System.out.println("================================================");
        int aux=0, aux2=0, aux3=0, aux4=0, aux5=0, aux6=0;
        Existencia[] status = new Existencia[6];
        for(int j=0;j<almacen.length;j++){
            if(almacen[j] != null){
                if(almacen[j].getNombre() == "Carne roja"){
                    aux ++;
                }else if(almacen[j].getNombre() == "Pollo"){
                aux2 ++;
                }else if(almacen[j].getNombre() == "Vegetales"){
                    aux3 ++;
                }else if(almacen[j].getNombre() == "Enlatado de carne"){
                    aux4 ++;
                }else if(almacen[j].getNombre() == "Enlatado de pollo"){
                    aux5++;
                }else if(almacen[j].getNombre() == "Vegetales en lata"){;
                    aux6++;
                }
            }
        }
        for(int i=0;i<status.length;i++){
            if(i==0) status[i] = new Existencia("Carne roja",aux,50,"Carnes S.A");
            else if(i==1) status[i] = new Existencia("Pollo",aux2,30,"Carnes S.A");
            else if(i==2) status[i] = new Existencia("Vegetales",aux3,20,"Abastos Co");
            else if(i==3) status[i] = new Existencia("Enlatado de carne",aux4,30,"Kreft");
            else if(i==4) status[i] = new Existencia("Enlatado de pollo",aux5,40,"Hainz");
            else if(i==5) status[i] = new Existencia("Vegetales en lata",aux6,60,"Abastos Co");
            System.out.println("================================================");
            System.out.println("Producto: " +status[i].getProducto());
            System.out.println("================================================");
            System.out.println("Precio por unidad: "+status[i].getPrecioUnidad()+" Bs.");
            System.out.println("================================================");
            System.out.println("Existencias: " +status[i].getExistencias());
            System.out.println("================================================");
            System.out.println("Proveedor: " +status[i].getProveedor());
            System.out.println("================================================");
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.ejecutar();
    }
}
