package lab4p1_hectorflores;
import java.util.Scanner;

public class Lab4P1_HectorFlores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Inversion especial");
        System.out.println("2. Balanza de cadenas");
        System.out.println("3. Cifrado de mensajes");
        System.out.println("4. Salir del programa");
        System.out.println(" ");
        System.out.print("Ingrese su opcion: ");
        System.out.println(" ");
        
        int opcion = sc.nextInt();
        
        
        while (opcion >= 1 && opcion <= 3){
            switch (opcion){
                case 1:
                    String cadena = "";
                    String substring = "";
                    int iniciopalabra = 0;
                    String invertida = "";
                    boolean hayespacio = false;
                    
                    System.out.println("1. Inversion especial:");
                    System.out.println(" ");
                    System.out.print("Ingrese una cadena de al menos 5 caracteres: ");
                    
                    sc.nextLine();
                    cadena = sc.nextLine();
                    
                    while (cadena.length() < 5){ //revisa que la cadena sea mayor a 5
                        System.out.println("Ingrese una cadena de al menos 5 caracteres.");
                        sc.nextLine();
                        cadena = sc.nextLine();
                    }
                    
                    
                    for (int a = 0; a < cadena.length() - 1; a++){
                        if ((int)cadena.charAt(a) == 32){
                            hayespacio = true;
                            a = cadena.length() - 1;
                        }
                    } // valida si la cadena tiene espacio o no
                    
                    if (hayespacio){ //si tiene espacio se corre este for
                        cadena += " "; //necesario para invertir la ultima palabra de la cadena
                        for (int a = iniciopalabra; a < cadena.length(); a++){
                            if ((int)cadena.charAt(a) == 32){
                                substring = cadena.substring(iniciopalabra, a); // saca el substring de la palabra hasta el espacio
                                for (int b = substring.length() - 1; b >= 0; b--){
                                    invertida += substring.charAt(b);//invierte una palabra
                                }
                                iniciopalabra = a + 1; //establece el inicio de unanueva palabra que empieza en el indice despues del espacio
                                invertida += " ";//adiciona el espacio donde se paro el substring a la inversion
                            }
                        }
                    } else { //este corre en el caso de que la cadena no tenga espacio, simplemente invierte la cadena ingresada
                        for (int a = cadena.length() - 1; a >= 0; a--){
                            invertida += cadena.charAt(a);
                        }
                    }
                    System.out.println("Cadena invertida: " + invertida); //imprime la inversion
                    System.out.println(" ");
                    break;//fin de caso 1
                case 2:
                    int suma1 = 0, suma2 = 0, suma3 = 0;
                    System.out.println("2. Balanza de cadenas");
                    System.out.println(" ");
                    System.out.println("Ingrese cadena 1: ");
                    sc.nextLine();
                    String cad1 = sc.nextLine();//pide cadena 1
                    
                    System.out.println("Ingrese cadena 2: ");
                    String cad2 = sc.nextLine();//pide cadena 2
                    
                    System.out.println("Ingrese cadena 3: ");
                    String cad3 = sc.nextLine();//pide cadena 3
                    
                    for (int a = 0; a < cad1.length(); a++){
                        suma1 += (int)cad1.charAt(a);
                    }//encuenra la sumatoria de los ASCII de los caracteres de la cadena
                    int mayor = suma1;//asigna el valor mayor a este ya que es el unic aun
                    
                    for (int a = 0; a < cad2.length(); a++){
                        suma2 += (int)cad2.charAt(a);
                    }//encuenra la sumatoria de los ASCII de los caracteres de la cadena
                    if (suma2 > mayor){
                        mayor = suma2;
                    }//valida si esta sumatoria es mayor
                    
                    for (int a = 0; a < cad3.length(); a++){
                        suma3 += (int)cad3.charAt(a);
                    }//encuenra la sumatoria de los ASCII de los caracteres de la cadena
                    if (suma3 > mayor){
                        mayor = suma3;
                    }//valida si esta sumatoria es mayor
                    
                    //muestra los pesos de cada 
                    System.out.println("Peso 1: " + suma1);
                    System.out.println("Peso 2: " + suma2);
                    System.out.println("Peso 3: " + suma3);
                    
                    //evalua cual o cuales son el mayor
                    if (suma1 == suma2 && suma1 == suma3){
                        System.out.println("El peso " + suma1 + " es el mismo para todas las cadenas");
                    } else if (suma1 == suma2 && suma1 == mayor){
                        System.out.println("El peso " + suma1 + " es el mayor y mismo para las cadenas 1 y 2");
                    } else if (suma1 == suma3 && suma1 == mayor){
                        System.out.println("El peso " + suma1 + " es el mayor y mismo para las cadenas 1 y 3");
                    } else if (suma2 == suma3 && suma2 == mayor){
                        System.out.println("El peso " + suma2 + " es el mayor y mismo para las cadenas 2 y 3");
                    } else if (suma1 == mayor){
                        System.out.println("El peso " + mayor + " es el mayor y pertenece a la cadena 1");
                    } else if (suma2 == mayor){
                        System.out.println("El peso " + mayor + " es el mayor y pertenece a la cadena 2");
                    } else {
                        System.out.println("El peso " + mayor + " es el mayor y pertenece a la cadena 3");
                    }
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("3. Cifrado de mensajes:");
                    System.out.println("Ingrese el mensaje a cifrar:");
                    String mensaje;
                    sc.nextLine();
                    mensaje = sc.nextLine();//pide el mensaje a codificar
                    String codificado = "";
                    
                    while (mensaje.length() == 0){
                        System.out.println("La cadena no puede ser nula");
                        mensaje = sc.nextLine();
                    }//Valida que no sea nula la cadena
                    
                    for (int a = 0; a < mensaje.length(); a++){
                        int ascii_nuevo = mensaje.charAt(a) + 2;
                        codificado += (char)ascii_nuevo;
                    }//codifica cada letra y la acumula en codificado, letra por letra
                    
                    System.out.println("El mensaje codificado es: " + codificado);//muestra elmensaje codificado
                    System.out.println(" ");
                    break;
            }
            
            System.out.println("1. Inversion especial");
            System.out.println("2. Balanza de cadenas");
            System.out.println("3. Cifrado de mensajes");
            System.out.println("4. Salir del programa");
            System.out.println(" ");
            System.out.print("Ingrese su opcion: ");
            System.out.println(" ");

            opcion = sc.nextInt();//nueva opcion para el ciclo repetitivo
        }
    }   
}
