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
      double efectivoCaja = 0.0;
        int ventasRealizadas = 0;
        int comprasRealizadas = 0;
        double totalVentas = 0.0;
        double totalCompras = 0.0;
        double ganancia = 0.0;
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
                        System.out.println("No hay efetivo suficiente, por favor abra caja!!!");
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
                    boolean compra = false;
                    while(compra != true){
                        System.out.print("Ingrese el codigo del producto: ");
                        int cod = lea.nextInt();
                     if(tipo.equals("a")||tipo.equals("A")){
                         if(cod==1){
                             System.out.println("==============="
                                         +"\n"+"=Azucar 45lps.="
                                         +"\n"+"===============");
                             System.out.println("Ingrese los kilogramos: ");
                             int kg = lea.nextInt();
                             azucar -= kg;
                             
                         }else if(cod==2){
                             System.out.println("==============="
                                         +"\n"+"=Avena 50lps. ="
                                         +"\n"+"===============");
                              System.out.println("Ingrese los kilogramos: ");
                             int kg = lea.nextInt();
                             avena -= kg;
                         }else if(cod==3){
                             System.out.println("==============="
                                         +"\n"+"=Trigo 50lps. ="
                                         +"\n"+"===============");
                              System.out.println("Ingrese los kilogramos: ");
                             int kg = lea.nextInt();
                             trigo -= kg;
                         }else if(cod==4){
                              System.out.println("==============="
                                         +"\n"+"=Maiz 50lps.  ="
                                         +"\n"+"===============");
                               System.out.println("Ingrese los kilogramos: ");
                             int kg = lea.nextInt();
                             maiz -= kg;
                         }
                     }else if()
                     
                        System.out.println("¿Desea comprar otro producto? (Si/No): ");
                        String sn = lea.next();
                        sn = sn.toLowerCase();
                        
                        if(sn.equals("no")){
                            compra = true;
                        }
                                          
                    }
                    
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

                    
                    double promedioVentas = (ventasRealizadas > 0) ? totalVentas / ventasRealizadas : 0;
                    double promedioCompras = (comprasRealizadas > 0) ? totalCompras / comprasRealizadas : 0;
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

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (op != 5); 
    }
}