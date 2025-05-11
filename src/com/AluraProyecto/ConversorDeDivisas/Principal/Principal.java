package com.AluraProyecto.ConversorDeDivisas.Principal;

import com.AluraProyecto.ConversorDeDivisas.ConsultaApi.ConsultaAPI;

import java.util.Scanner;

public class Principal {
    static final int OPCION_ABANDONAR = 7;

    public static void main(String[] args) {
        int opcionUsuario = 0;
        String divisaBase = "USD";
        String divisaACambiar = "PEN";
        double valorDelUsuario = 0;
        double valorConvertido = 0;
        Scanner usuario = new Scanner(System.in);
        ConsultaAPI newConsult = new ConsultaAPI();

        while (opcionUsuario != OPCION_ABANDONAR) {
            ImprimirMenu();
            opcionUsuario = usuario.nextInt();

            switch (opcionUsuario) {
                case 1 -> { divisaBase = "USD"; divisaACambiar = "ARS";}
                case 2 -> { divisaBase = "ARS"; divisaACambiar = "USD";}
                case 3 -> { divisaBase = "USD"; divisaACambiar = "BRL";}
                case 4 -> { divisaBase = "BRL"; divisaACambiar = "USD";}
                case 5 -> { divisaBase = "USD"; divisaACambiar = "PEN";}
                case 6 -> { divisaBase = "PEN"; divisaACambiar = "USD";}
                default -> {
                    System.out.println("Ingrese un valor valido");
                    System.out.println("*********************************");
                    continue;
                }
            }
            System.out.println("Ingresa el valor que deseas convertir:");
            if (usuario.hasNextDouble()) {
                valorDelUsuario = usuario.nextDouble();
                if (valorDelUsuario <= 0) {
                    System.out.println("El valor debe ser un número positivo. Intente de nuevo.");
                    continue;
                }
            } else {
                System.out.println("Entrada inválida. Debe ser un número. Intente de nuevo.");
                usuario.next();
                continue;
            }
            valorConvertido = newConsult.ObtenerValorDeDivisas(divisaBase, divisaACambiar, valorDelUsuario);
            if (valorConvertido != -1) {
                System.out.printf("El valor de %.2f [%s] equivale al valor final de %.2f [%s]\n",
                        valorDelUsuario, divisaBase, valorConvertido, divisaACambiar);
                System.out.println("**********************************************************");
            } else {
                System.out.println("La conversión no se pudo realizar, intentelo más tarde");
            }
        }
        usuario.close();
        System.out.println("El programa finalizó correctamente");
    }

    public static void ImprimirMenu() {
        System.out.println("""
                //////////////////////////////////////////////
                Sea Bienvenido/a al Conversor De Monedas :)
                
                1) Dólar => Peso Argentino
                2) Peso Argentino => Dólar
                3) Dólar => Real Brasileño
                4) Real Brasileño => Dólar
                5) Dólar => Sol Peruano
                6) Sol Peruano => Dólar 
                7) Salir
                Elija una opción valida:
                //////////////////////////////////////////////  
                """);

    }
}


