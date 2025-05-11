package com.AluraProyecto.ConversorDeDivisas.ConsultaApi;

import com.AluraProyecto.ConversorDeDivisas.Divisa.Divisa;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class ConsultaAPI {
    public double ObtenerValorDeDivisas(String valorBase, String valorCambio, double numeroBase) {
        String apiKey = "a5d6e5d386a8e4006adf9d20";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + valorBase + "/" + valorCambio;
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Error en la consulta: Codigo de estado HTTP" + response.statusCode());
            }
            String json = response.body();

            Divisa nuevaDivisa = gson.fromJson(json, Divisa.class);
            if (nuevaDivisa == null || nuevaDivisa.conversion_rate() == 0.0) {
                System.out.println("No se pudo obtener una tasa de conversión valida");
                return -1;
            }
            double tasaCambio = nuevaDivisa.conversion_rate();
            return numeroBase * tasaCambio;
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return -1;
        } catch (InterruptedException e) {
            System.out.println("Operación interrumpida.");
            Thread.currentThread().interrupt();
            return -1;
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado" + e.getMessage());
            return -1;
        }
    }
}
