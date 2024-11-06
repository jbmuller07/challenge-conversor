package com.alurachallenge.conversor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consultar = new ConsultarMoneda();

        int opcion = 0;
        System.out.println("**********************************************");
        System.out.println("***  Bienvenido/a al conversor de Monedas  ***");
        System.out.println("**********************************************\n");

        while (opcion != 8) {
            System.out.println("*** 1. Dólar (USD) a Peso Argentino (ARS) ***");
            System.out.println("*** 2. Peso Argentino (ARS) a Dólar (USD) ***");
            System.out.println("*** 3. Dólar (USD) a Real Brasileño (BRL) ***");
            System.out.println("*** 4. Real Brasileño (BRL) a Dólar (USD) ***");
            System.out.println("*** 5. Dólar (USD) a Peso Colombiano(COL) ***");
            System.out.println("*** 6. Peso Colombiano(COL) a Dólar (USD) ***");
            System.out.println("*** 7.       Elegir otras monedas         ***");
            System.out.println("*** 8.       Salir del Conversor          ***");
            System.out.println("**********************************************\n");
            System.out.println("Por favor, ingrese una opción para continuar: ");

            // Verificar si la entrada es un número
            if (lectura.hasNextInt()) {
                opcion = lectura.nextInt();
                lectura.nextLine();

                // Validar si la opción está entre 1 y 8
                if (opcion >= 1 && opcion <= 8) {
            switch(opcion){

                case 1:
                    ConvertirMoneda.convertir("USD", "ARS",consultar, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consultar, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consultar, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consultar, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consultar, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consultar, lectura);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consultar, lectura);
                    break;
                case 8:
                    System.out.println("*************************************************");
                    System.out.println("*** Conversor de Monedas finalizado con Éxito ***");
                    System.out.println("*************************************************");
                    break;
            }
                } else {
                    System.out.println("La opción seleccionada no es válida. Por favor ingrese una opción entre 1 y 8.\n");
                }
            } else {
                // Si no es un número, mostramos el mensaje y limpiamos el buffer
                System.out.println("Entrada no válida. Por favor ingrese un número entre 1 y 8.\n");
                lectura.next(); // Limpiar la entrada inválida
            }
        }
    }
}