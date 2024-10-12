
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        var eleccion = 0;

        while ( eleccion != 4) {
            System.out.println("******************************************\n");
            System.out.println("Sea bienvenido/a al Conversor de Moneda\n");
            System.out.println("1) Conversion en monedas más comunes");
            System.out.println("2) Conversion escribiendo los pares");
            System.out.println("3) Lista de monedas existentes");
            System.out.println("4) Salir");

            System.out.println("Elija una opción válida\n");
            System.out.println("******************************************\n");

            try {
                eleccion = Integer.valueOf(lectura.nextLine());
                var valor = 0.0;

                if( eleccion > 0 && eleccion < 5) {

                    if( eleccion == 1) {

                        System.out.println("1) USD A ARS");
                        System.out.println("2) ARS A USD");
                        System.out.println("3) USD A BRL");
                        System.out.println("4) BRL A USD");
                        System.out.println("5) USD A COP");
                        System.out.println("6) COP A USD");
                        System.out.println("Elija una opción válida\n");
                        eleccion = Integer.valueOf(lectura.nextLine());

                        if ( eleccion > 0 && eleccion < 7) {
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
                        } else {
                            System.out.println("Volviendo al menú principal");
                            continue;
                        }
                    }

                    if ( eleccion == 2 ) {
                        System.out.println("Ingrese la moneda base:");
                        String monedaBase = String.valueOf((lectura.nextLine()));
                        System.out.println("Ingrese la moneda final");
                        String monedaTarget = String.valueOf((lectura.nextLine()));
                        Moneda moneda = consulta.buscarMoneda(monedaBase,monedaTarget);
                        System.out.println("Ingrese el valor que deseas convertir");
                        valor = Double.valueOf(lectura.nextLine());
                        System.out.println("El valor de " + valor + " " +  monedaBase + " corresponde al valor final de =>>> " + moneda.conversion_rate() * valor + " " + monedaTarget);
                    }

                    if ( eleccion == 3 ) {

                        ConsultaMonedaBase consultaBase = new ConsultaMonedaBase();
                        MonedaAll moneda = consultaBase.baseToAll();
                        System.out.println(moneda.supported_codes());
                       // System.out.println(moneda.supported_codes().keySet() + " \n " + moneda.supported_codes().values() + "\n");
                    }

                    if ( eleccion == 4 ) {
                        System.out.println("Gracias por usar nuestro serivicio de consulta de divisas");
                        return;
                    }
                } else {
                    System.out.println("Debe elegir una opcion del 1 al 4!!!");
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " !!!!Solo se permite valores numéricos!!!!");

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}