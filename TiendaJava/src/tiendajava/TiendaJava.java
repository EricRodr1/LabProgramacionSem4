/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tiendajava;

import java.util.Scanner;

/**
 *
 * @author t0cin
 */
public class TiendaJava {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");
        int azucar=10, avena=10, trigo=10, maiz=10;
      float efectivoCaja = (float) 0.0;
        int ventasRealizadas = 0;
        int comprasRealizadas = 0;
        float totalVentas = (float) 0.0;
        float totalCompras = (float) 0.0;
        float ganancia = (float) 0.0;
        int cantidadAzucarVendida = 0;
        int cantidadAvenaVendida = 0;
        int cantidadTrigoVendida = 0;
        int cantidadMaizVendida = 0;
        int cantidadTotalVendida = 0;
        String productoEstrella = "";
        
        int op = 0; 

        do {
            // Mostrar el menú
            System.out.println("**** MENU ****");
            System.out.println("1) Abrir Caja");
            System.out.println("2) Ventas");
            System.out.println("3) Compras");
            System.out.println("4) Reportes");
            System.out.println("5) Salir");
            System.out.println("===========================");
            System.out.print("Por favor ingrese una opcion: ");
            op = lea.nextInt(); 

           
            if (op > 5 || op < 1) {
                System.out.println("Opcion no valida!!!");
            }

           
            switch (op) {
                case 1:
                    
                    System.out.print("Por favor ingrese la cantidad de efectivo para abrir la caja: ");
                    double efectivo = lea.nextDouble(); 
                    
                    
                    efectivoCaja += efectivo;

                    
                    System.out.println("La caja se ha abierto con Lps. " + efectivoCaja);
                    break;
                 
                case 2:
               
if(efectivoCaja <= 0){
    System.out.println("No hay efectivo suficiente, por favor abra caja!!!");
    break;
}

boolean validacion = false;
String tipo = "";
while(validacion != true){
    System.out.print("Ingrese tipo de cliente: ");
    tipo = lea.next();
    if(tipo.equals("a")||tipo.equals("A")||tipo.equals("b")||tipo.equals("B")||tipo.equals("c")||tipo.equals("C")){
        validacion = true;
    }else{
        System.out.println("Opcion no valida!!!");
    }
}

// Variables para ir sumando la compra del cliente
String facturaDetalle = "";
double subtotalFactura = 0;

boolean compra = false;
while(compra != true){
    System.out.print("Ingrese el codigo del producto: ");
    int cod = lea.nextInt();
    String nombreProd = "";
    double precioProd = 0;
    boolean puedeComprar = false;

    // Validar si el cliente puede comprar ese producto
    if((tipo.equals("a")||tipo.equals("A")) && (cod==1||cod==2||cod==3||cod==4)){
        puedeComprar = true;
    }else if((tipo.equals("b")||tipo.equals("B")) && (cod==1||cod==2||cod==3)){
        puedeComprar = true;
    }else if((tipo.equals("c")||tipo.equals("C")) && (cod==4)){
        puedeComprar = true;
    }

    // Asignar nombre y precio
    if(cod == 1){
        nombreProd = "Azucar";
        precioProd = 45;
    }else if(cod == 2){
        nombreProd = "Avena";
        precioProd = 50;
    }else if(cod == 3){
        nombreProd = "Trigo";
        precioProd = 50;
    }else if(cod == 4){
        nombreProd = "Maiz";
        precioProd = 50;
    }else{
        puedeComprar = false; // Código no válido
    }

    if(puedeComprar){
        System.out.println("===============");
        System.out.println("=" + nombreProd + " " + precioProd + "lps.=");
        System.out.println("===============");
        System.out.print("Ingrese los kilogramos: ");
        int kg = lea.nextInt();
        // Actualizar stock:
        if(cod == 1) azucar -= kg;
        if(cod == 2) avena -= kg;
        if(cod == 3) trigo -= kg;
        if(cod == 4) maiz -= kg;

        double subtotal = kg * precioProd;
        subtotalFactura += subtotal;

        // Guardar detalle para factura
        facturaDetalle += "\nProducto: " + nombreProd + " | Kg: " + kg + " | Precio U: " + precioProd + " | Subtotal: " + subtotal;
    }else{
        System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO");
    }

    System.out.print("¿Desea comprar otro producto? (si/no): ");
    String sn = lea.next();
    if(sn.equalsIgnoreCase("no")){
        compra = true;
    }
}

// ---- Al FINAL, cuando el cliente termina, se imprime la factura ----
System.out.println("\n----------- FACTURA -----------");
System.out.println(facturaDetalle);
System.out.println("Subtotal: " + subtotalFactura + " lps.");

double descuento = 0;
if(subtotalFactura >= 1000 && subtotalFactura <= 5000){
    descuento = subtotalFactura * 0.05;
}else if(subtotalFactura > 5000){
    descuento = subtotalFactura * 0.10;
}
if(descuento > 0){
    System.out.println("Descuento aplicado: -" + descuento + " lps.");
}
double subtotalConDesc = subtotalFactura - descuento;
double impuesto = subtotalConDesc * 0.07;
double totalPagar = subtotalConDesc + impuesto;

System.out.println("Impuesto (7%): " + impuesto + " lps.");
System.out.println("TOTAL A PAGAR: " + totalPagar + " lps.");
System.out.println("-------------------------------");

// Sumar a caja
efectivoCaja += totalPagar;
System.out.println("Efectivo en caja ahora: " + efectivoCaja + " lps.");

// Al finalizar
System.out.println("Regresando a MENU PRINCIPAL...");

                    break;
          
                case 3:
                    System.out.println("Simulando compras...");
                    totalCompras += (3 * 25);
                    comprasRealizadas++;
                    break;
                case 4:
                    
                    System.out.println("**** REPORTES ****");
                    System.out.println("Cantidad actual en Caja: Lps. " + efectivoCaja);
                    System.out.println("Numero de ventas realizadas: " + ventasRealizadas);
                    System.out.println("Numero de compras realizadas: " + comprasRealizadas);
                    System.out.println("Volumen total de ventas: Lps. " + totalVentas);
                    System.out.println("Volumen total de compras: Lps. " + totalCompras);

                    
                    ganancia = totalVentas - totalCompras;
                    System.out.println("Margen de ganancia: Lps. " + ganancia);

                    
                    float promedioVentas = (ventasRealizadas > 0) ? totalVentas / ventasRealizadas : 0;
                    float promedioCompras = (comprasRealizadas > 0) ? totalCompras / comprasRealizadas : 0;
                    System.out.println("Valor medio de ventas: Lps. " + promedioVentas);
                    System.out.println("Valor medio de compras: Lps. " + promedioCompras);

                    
                    cantidadTotalVendida = cantidadAzucarVendida + cantidadAvenaVendida + cantidadTrigoVendida + cantidadMaizVendida;
                    if (cantidadAzucarVendida > cantidadTotalVendida / 4) {
                        productoEstrella = "Azúcar";
                    } else if (cantidadAvenaVendida > cantidadTotalVendida / 4) {
                        productoEstrella = "Avena";
                    } else if (cantidadTrigoVendida > cantidadTotalVendida / 4) {
                        productoEstrella = "Trigo";
                    } else {
                        productoEstrella = "Maíz";
                    }
                    System.out.println("Producto estrella: " + productoEstrella);

                    break;

                case 5:
                    
                    System.out.println("Hasta luego!");
                    break;

                
            }
        } while (op != 5); 
    }
}