import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivo {

    private static final String NOMBRE_ARCHIVO = "reporte_huella_carbono.txt";

    public static void guardarReporte(ArrayList<HuellaCarbono> objetos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            escritor.write("REPORTE DE HUELLA DE CARBONO");
            escritor.newLine();
            escritor.write("--------------------------------------");
            escritor.newLine();

            double total = 0;

            for (HuellaCarbono objeto : objetos) {
                escritor.write(objeto.getInfo());
                escritor.newLine();
                escritor.write(String.format("Huella de carbono: %.2f kg de CO2", objeto.getHuellaCarbono()));
                escritor.newLine();
                escritor.write("--------------------------------------");
                escritor.newLine();
                total += objeto.getHuellaCarbono();
            }

            escritor.write(String.format("Total general: %.2f kg de CO2", total));
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No fue posible guardar el archivo: " + e.getMessage());
        }
    }

    public static String getNombreArchivo() {
        return NOMBRE_ARCHIVO;
    }
}
