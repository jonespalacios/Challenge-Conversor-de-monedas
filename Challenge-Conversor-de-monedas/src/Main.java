import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();


        String dolar = "USD";
        String pesoArg = "ARS";
        String realBr = "BRL";
        String pesoCol = "COP";
        var eleccion = 0;

        while ( eleccion != 7) {
            System.out.println("******************************************\n");
            System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
            System.out.println("1) " + dolar + " =>> " + pesoArg);
            System.out.println("2) " + pesoArg + " =>> " + dolar);
            System.out.println("3) " + dolar+ " =>> " + realBr);
            System.out.println("4) " + realBr + " =>> " + dolar);
            System.out.println("5) " + dolar + " =>> " + pesoCol);
            System.out.println("6) " + pesoCol + " =>> " + dolar);
            System.out.println("7) Salir");

            System.out.println("Elija una opción válida\n");
            System.out.println("******************************************\n");

            try {
                eleccion = Integer.valueOf(lectura.nextLine());
                var valor = 0.0;

                if( eleccion > 0 && eleccion < 8) {
                    if ( eleccion == 1 ) {
                        Moneda moneda = consulta.buscarMoneda("USD","ARS");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [USD] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [ARS]");

                    }

                    if ( eleccion == 2 ) {
                        Moneda moneda = consulta.buscarMoneda("ARS","USD");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [ARS] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [USD]");
                    }

                    if ( eleccion == 3 ) {
                        Moneda moneda = consulta.buscarMoneda("USD","BRL");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [USD] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [BRL]");
                    }

                    if ( eleccion == 4 ) {
                        Moneda moneda = consulta.buscarMoneda("BRL","USD");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [BRL] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [USD]");
                    }

                    if ( eleccion == 5 ) {
                        Moneda moneda = consulta.buscarMoneda("USD","COP");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [USD] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [COP]");
                    }

                    if ( eleccion == 6 ) {
                        Moneda moneda = consulta.buscarMoneda("COP","USD");
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " [COP] corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " [USD]");
                    }

                    if ( eleccion == 7 ) {
                        System.out.println("Gracias por usar nuestro serivicio de consulta de divisas");
                        return;
                    }
                } else {
                    System.out.println("Debe elegir una opcion del 1 al 7!!!");
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " !!!!Solo se permite valores numéricos!!!!");

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
          //  System.out.println("\n");
        }
    }


}