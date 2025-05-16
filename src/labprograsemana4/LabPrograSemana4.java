/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labprograsemana4;
import java.util.Scanner;
/**
 *
 * @author Eric Rodriguez
 */
public class LabPrograSemana4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String fraseog;
        int opcion;
        int desplazamiento;
        do{ 
        String frase = "";
        System.out.println("*** MENU ***");
        System.out.println("1. Cifrado");
        System.out.println("2. Filtrar");
        System.out.println("3. Codigo Enigma");
            System.out.println("4. Salir");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                 System.out.println("Ingrese la frase a cifrar:");
        fraseog = sc.next();
        
                System.out.println("Ingrese el numero de posiciones a desplazar:");
         desplazamiento = sc.nextInt();
        
        String fraseCifrada = "";
        int longitud = fraseog.length();
        int i = 0;

        while (i < longitud) {
            char caracterog = fraseog.charAt(i);
            char caractercifrado;

            if (caracterog >= 'a' && caracterog <= 'z') {
                int posicionog = caracterog - 'a';
                int posicioncr = (posicionog + desplazamiento) % 26;
                caractercifrado = (char) ('a' + posicioncr);
            } else if (caracterog >= 'A' && caracterog <= 'Z') {
                int posicionOriginal = caracterog - 'A';
                int posicioncr = (posicionOriginal + desplazamiento) % 26;
                caractercifrado = (char) ('A' + posicioncr);
            } else {
                caractercifrado = caracterog;
            }

            fraseCifrada = fraseCifrada + caractercifrado;
            i = i + 1;
        }

        System.out.println("Su frase cifrada es: " + fraseCifrada);
         break;
            case 2:
                sc.useDelimiter("\n"); 
        
        // Solicitud de datos
        System.out.print("Ingrese una frase: ");
          frase = sc.next(); 
        
        System.out.print("Ingrese una cantidad: ");
        int cantidad = sc.nextInt();
        
        // Variables para procesar las palabras
        String palabra = "";
        System.out.println("Palabras con mayor longitud de " + cantidad + ":");

        
        int cont = 0;
         
        while (cont < frase.length()) {
            char c = frase.charAt(cont); 

             
            if (c == ' ') {
                if (palabra.length() >= cantidad) {  // Mayor o igual longitud
                    System.out.println(palabra); // Imprimir palabra si cumple con la longitud
                }
                palabra = ""; // Limpiar la variable para la siguiente palabra
            } else {
                palabra += c;  
            }

            cont++;  // Incrementar el contador para continuar con el siguiente caracter
        }

        
        if (palabra.length() >= cantidad) {  // Mayor o igual 
            System.out.println(palabra); 
        }
        break;
        //Enigma
            case 3: 
                int sm = 0;

        do {
            System.out.println("1) Encriptar texto");
            System.out.println("2) Desencriptar texto");
            System.out.println("3) Regresar");
            System.out.print("Por favor ingrese una opcion: ");
            sm = sc.nextInt();

            if (sm < 1 || sm > 3) {
                System.out.println("Opción no válida!!");
            }

            switch (sm) {
                case 1:
                    System.out.println("==== ENCRIPTAR ====");
                    System.out.print("Ingrese el mensaje a encriptar: ");
                    String mensaje = sc.next();

                    int cont2 = 0;
                    String pares = "";  // Inicializamos la cadena sin espacios extra
                    String impares = "";  

                    // Recorremos el mensaje y separamos las posiciones pares e impares
                    while (cont2 < mensaje.length()) {
                        char c = mensaje.charAt(cont2);  // Obtener el carácter actual

                        if (cont2 % 2 == 0) {  // Si la posición es par
                            pares += c;  // Concatenamos los caracteres pares
                        } else {  // Si la posicion es impar 
                            impares += c;  // Concatenamos los caracteres impares
                        }

                        cont2++;
                    }

                    // Mostrar el resultado encriptado: primero los pares, luego los impares
                    String mensajeEncriptado = pares + impares;
                    System.out.println("Posiciones pares: "+pares);
                    System.out.println("Posiciones impares: "+impares);
                    System.out.println("Texto encriptado: " + mensajeEncriptado);
                    break;

                case 2:
                    System.out.println("==== DESENCRIPTAR ====");
                    System.out.print("Ingrese el mensaje a desencriptar: ");
                    String mensaje2 = sc.next();

                    // La longitud de la mitad de la cadena
                    int mitad = mensaje2.length() / 2 + mensaje2.length() % 2;  
                   
                    String pares2 = "";
                    String impares2 = "";

                    // Repartir el mensaje en dos partes: pares y impares
                    int ii = 0;
                    while (ii < mitad) {
                        pares2 += mensaje2.charAt(ii);  
                        if (ii + mitad < mensaje2.length()) {
                            impares2 += mensaje2.charAt(ii + mitad);  
                        }
                        ii++;
                    }

                    // Reconstruir el mensaje original alternando los caracteres de pares e impares
                    String mensajeDesencriptado = "";
                    int j = 0;
                    while (j < pares2.length()) {
                        mensajeDesencriptado += pares2.charAt(j);  // Agregar caracter de pares
                        if (j < impares2.length()) {
                            mensajeDesencriptado += impares2.charAt(j);  // Agregar caracter de impares
                        }
                        j++;
                    }

                    // Mostrar el resultado desencriptado
                    System.out.println("Texto desencriptado: " + mensajeDesencriptado);
                    break;

                case 3:
                    System.out.println("Regresando...");
                    break;
            }
            
        } while (sm != 3);  
    
            case 4:
                System.out.println("Saliendo..");
                break;
    } 

           
        } while (opcion !=4);
        }
    }
    

