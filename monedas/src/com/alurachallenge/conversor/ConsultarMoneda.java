package com.alurachallenge.conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas buscarMonedas(String monedaBase, String monedaTarget) {

        String apiKey = "ff42ccb41f0b323e4fa4f8b1";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta es vacía o contiene un error en el cuerpo
            if (response.body() == null || response.body().isEmpty()) {
                throw new RuntimeException("*** Error: Respuesta de la API vacía ***");
            }

            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (HttpConnectTimeoutException e) {
            System.out.println("*** Error: Tiempo de conexión excedido al intentar acceder a la API ***");
            return null;

        } catch (IOException e) {
            System.out.println("*** Error: Problema de entrada/salida durante la conexión a la API ***");
            return null;

        } catch (InterruptedException e) {
            System.out.println("*** Error: La solicitud fue interrumpida inesperadamente ***");
            Thread.currentThread().interrupt();  // Restaurar el estado de interrupción
            return null;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());  // Mensaje de error personalizado
            return null;

        } catch (Exception e) {
            System.out.println("*** Error inesperado: " + e.getMessage() + " ***");
            return null;
        }

    }
}