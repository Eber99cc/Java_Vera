package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Eber
 */
public class Base {

    //Implementación del método estático "leerDato"
    //se utiliza para pedir el ingreso de datos por consola
    public static String leerDato() {
        String dato;
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            dato = teclado.readLine();
        } catch (Exception exception) {
            System.out.println("Error al momento de Leer el dato por consola.");
            dato = "";
        }
        return dato;
    }

    //Este método recibe por parámetro una variable 'cadena' de tipo de dato String
    //Se hace uso del método 'parseInt()' de la clase Integer
    //Si sucede un error al momento de convertir el 'String' a 'int', se irá al bloque 'catch'
    //Si todo es correcto, se retorna el entero 'dato'
    public static int aEntero(String cadena) {
        int dato;
        try {
            dato = Integer.parseInt(cadena);
        } catch (Exception e) {
            System.out.println("Error al convertir un String a Entero.");
            dato = 999;
        }
        return dato;
    }

    //Este método recibe por parámetro una variable 'cadena' de tipo de dato String
    //Se hace uso del método 'parseDouble()' de la clase Double
    //Si sucede un error al momento de convertir el 'String' a 'double', se irá al bloque 'catch'
    //Si todo es correcto, se retorna el double 'dato'
    public static double aReal(String cadena) {
        double dato;
        try {
            dato = Double.parseDouble(cadena);
        } catch (Exception e) {
            System.out.println("Error al convertir un String a Real.");
            dato = 999;
        }
        return dato;
    }

    //Este método recibe por parámetro una cadena 'mensaje', la cual se va ha imprimir
    //Se hace uso del método 'leerDato()'
    //Se debe escribir un texto no vacio. Debido a que existe el bucle 'do-while'
    //este bucle, valida si lo ingresado es vacio
    //Si todo es correcto, se retorna el String 'dato'	
    public static String ingresarDato(String mensaje) {
        String dato;
        do {
            System.out.print(mensaje);
            dato = leerDato().trim();
        } while (dato.length() == 0);
        return dato;
    }

    //Método que devuelve una cadena en minúscula 
    public static String convertirCadenaAMinuscula(String sPalabra) {
        return sPalabra.toLowerCase();
    }

    //Método que devuelve una cadena en mayúscula 
    public static String convertirCadenaAMayuscula(String sPalabra) {
        return sPalabra.toUpperCase();
    }

    //Este método recibe por parámetro un arreglo de String 'mensaje'
    //El método construye un ménu de opciones, usando el bucle 'for'
    //Se pide al usuario ingresar su opción
    //Se convierte a entero dicha opción
    //Se devuelve la opcion ingresada
    public static int pintarMenu(String[] mensaje) {
        int opcion;
        do {
            for (String cadena : mensaje) {
                System.out.println(cadena);
            }
            System.out.println("Ingrese su opcion:");
            opcion = aEntero(leerDato());
        } while (opcion < 1 || opcion > mensaje.length);
        return opcion;
    }

}
