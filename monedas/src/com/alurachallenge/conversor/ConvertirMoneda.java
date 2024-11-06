package com.alurachallenge.conversor;

import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura) {
        double cantidad = 0;
        double cantidadConvertida;
        boolean cantidadValida = false;

        Monedas monedas = consulta.buscarMonedas(monedaBase, monedaTarget);

        System.out.println("La tasa de conversión actual es: 1 " + monedaBase + " = " + monedas.conversion_rate() + " " + monedaTarget);

        // Validación para asegurarse de que el usuario ingrese solo un valor numérico
        while (!cantidadValida) {
            System.out.println("Ingrese la cantidad de " + monedaBase + " que desea convertir: ");

            // Verificar si la entrada es un número válido
            if (lectura.hasNextDouble()) {
                cantidad = lectura.nextDouble();
                cantidadValida = true;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un valor numérico.");
                lectura.next(); // Limpiar el buffer de entrada inválida
            }
        }

        // Calcular la cantidad convertida
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad + " " + monedaBase + " son equivalentes a " + cantidadConvertida + " " + monedas.target_code());
        System.out.println("*************************************************\n");
    }

    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {
        System.out.println("""
            Códigos para seleccionar otras monedas:
            
            AUD - Australian Dollar
            BOB - Bolivian Boliviano
            CAD - Canadian Dollar
            CLP - Chilean Peso
            EUR - Euro
            JPY - Japanese Yen
            MXN - Mexican Peso
            UYU - Uruguayan Peso
            """);

        // Solicitar y validar los códigos de moneda
        String monedaBase = solicitarCodigoMoneda("Ingrese el código de la moneda que desea convertir:", lectura);
        String monedaObjetivo = solicitarCodigoMoneda("Ingrese el código de la moneda que desea obtener luego de la conversión:", lectura);

        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }

    // Metodo auxiliar para solicitar y validar el código de moneda
    private static String solicitarCodigoMoneda(String mensaje, Scanner lectura) {
        String codigoMoneda;
        do {
            System.out.print(mensaje + "\n");
            codigoMoneda = lectura.nextLine().trim().toUpperCase();

            // Validar que el código tenga exactamente 3 letras
            if (!codigoMoneda.matches("[A-Z]{3}")) {
                System.out.println("Entrada no válida. Por favor, ingrese un código de moneda de exactamente 3 letras.");
            }
        } while (!codigoMoneda.matches("[A-Z]{3}"));
        return codigoMoneda;
    }
}