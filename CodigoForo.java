import java.util.*;

public class CodigoForo {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la cantidad de notas
        System.out.print("Ingrese la cantidad de notas (entre 2 y 20): ");

        // Validar la entrada para asegurar que sea un número y está en el rango permitido
        int cantidadNotas = obtenerCantidadNotas(scanner);

        // Crear un arreglo para almacenar las notas
        double[] notas = new double[cantidadNotas];

        // Leer las notas desde el usuario
        for (int i = 0; i < cantidadNotas; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + " (entre 0.0 y 5.0): ");
            
            // Validar la entrada para asegurar que sea un número y está en el rango permitido
            notas[i] = obtenerNotaValida(scanner);
        }

        // Cerrar el objeto Scanner después de su uso
        scanner.close();

        // Calcular el promedio de las notas
        double promedio = calcularPromedio(notas);

        // Imprimir el resultado
        System.out.println("\nEl promedio de las notas es: " + promedio);
    }

    // Función para obtener la cantidad de notas, validando la entrada
    private static int obtenerCantidadNotas(Scanner scanner) {
        int cantidad = 0;
        while (true) {
            // Verificar si la entrada es un número y está en el rango permitido
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Ingrese un número entero válido. Por favor escriba un numero entre 2 y 20");
                scanner.next(); // Limpiar el buffer de entrada
            }

            cantidad = scanner.nextInt();

            // Verificar si la cantidad está en el rango permitido
            if (cantidad >= 2 && cantidad <= 20) {
                break;
            } else {
                System.out.println("Error: La cantidad de notas debe estar entre 2 y 20. Porfavor ingrese un numero entre 0.0 y 5.0");
            }
        }
        return cantidad;
    }

    // Función para obtener una nota, validando la entrada
    private static double obtenerNotaValida(Scanner scanner) {
        double nota = 0.0;
        while (true) {
            // Verificar si la entrada es un número y está en el rango permitido
            while (!scanner.hasNextDouble()) {
                System.out.println("Error: Ingrese un número válido. Porfavor ingrese un numero entre 0.0 y 5.0");
                scanner.next(); // Limpiar el buffer de entrada
            }

            nota = scanner.nextDouble();

            // Verificar si la nota está en el rango permitido
            if (nota >= 0.0 && nota <= 5.0) {
                break;
            } else {
                System.out.println("Error: La nota debe estar entre 0.0 y 5.0. Porfavor ingrese un numero entre 0.0 y 5.0");
            }
        }
        return nota;
    }

    // Función para calcular el promedio de un arreglo de notas
    private static double calcularPromedio(double[] notas) {
        // Calcular la suma de las notas
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }

        // Calcular el promedio
        return suma / notas.length;
    }
}