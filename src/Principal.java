import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        // Diccionario de monedas
        Map<Integer, String> monedas = new HashMap<>();
        monedas.put(1, "USD");
        monedas.put(2, "MXN");
        monedas.put(3, "ARS");

        String menu = """
                \n================================
                1.- EUA (USD)
                2.- MEXICO (MXN)
                3.- ARGENTINA (ARS)
                ================================
                """;

        while (true) {
            System.out.println(menu + "Elige la moneda que quieres usar como base:");
            String inputBase = teclado.nextLine();
            int opcionBase;

            // Validación de salida o número en la moneda base
            try {
                opcionBase = Integer.parseInt(inputBase);
            } catch (NumberFormatException e) {
                System.out.println("Gracias por usar el conversor.");
                break;
            }

            if (!monedas.containsKey(opcionBase)) {
                System.out.println("Opción no válida.");
                continue;
            }
            String monedaBase = monedas.get(opcionBase);

            // Validación de la cantidad
            double cantidad = 0;
            while (true) {
                System.out.println("Cantidad:");
                try {
                    cantidad = Double.parseDouble(teclado.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Número no válido.");
                }
            }

            System.out.println(menu + "A qué moneda quieres convertir:");
            int opcionDestino;

            // Validación para la moneda destino
            try {
                opcionDestino = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, volviendo al inicio...");
                continue;
            }

            if (!monedas.containsKey(opcionDestino)) {
                System.out.println("Opción no válida.");
                continue;
            }
            String monedaDestino = monedas.get(opcionDestino);

            // Consulta a la API y cálculo matemático
            try {
                Monedas record = consulta.buscaMoneda(monedaBase);
                double tasa = record.conversion_rates().get(monedaDestino);
                double resultado = cantidad * tasa;

                System.out.println("\n Resultado: " + cantidad + " " + monedaBase + " equivalen a " + resultado + " " + monedaDestino);
            } catch (Exception e) {
                System.out.println("Ocurrió un error en la conversión: " + e.getMessage());
            }
        }
    }
}