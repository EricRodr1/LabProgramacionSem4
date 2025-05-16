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
        
        String frase = "";
        System.out.println("*** MENU ***");
        System.out.println("1. Cifrado");
        System.out.println("2. Filtrar");
        System.out.println("3. Codigo Enigma");
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
         
            case 2:
                sc.useDelimiter("\n"); 
        
        // Solicitud de datos
        System.out.print("Ingrese una frase: ");
        String frase2 = sc.next(); 
        
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
         default:
                System.out.println("Opcion no valida, intente de nuevo");
    }

           
            
        }
    }
    

