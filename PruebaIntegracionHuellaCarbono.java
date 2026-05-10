import java.util.ArrayList;

public class PruebaIntegracionHuellaCarbono {

    public static void main(String[] args) {
        ArrayList<HuellaCarbono> lista = new ArrayList<>();

        lista.add(new Edificio("Torre Empresarial", "Bogota", 10, 3000, 50000, 2000, 200));
        lista.add(new Carro("Honda", "Civic", 2022, "Azul", 12, 15000, Carro.TipoCombustible.GASOLINA));
        lista.add(new Bicicleta("Pedro", "Giant", Bicicleta.TipoBicicleta.RUTA, 22, 5000, 8, 90, 40));

        probarTamanoLista(lista);
        probarHuellasNoNegativas(lista);
        probarPolimorfismo(lista);

        System.out.println("Pruebas finalizadas correctamente.");
    }

    private static void probarTamanoLista(ArrayList<HuellaCarbono> lista) {
        assertVerdadero(lista.size() == 3, "La lista deberia tener 3 objetos.");
    }

    private static void probarHuellasNoNegativas(ArrayList<HuellaCarbono> lista) {
        for (HuellaCarbono objeto : lista) {
            assertVerdadero(objeto.getHuellaCarbono() >= 0, "La huella no puede ser negativa.");
        }
    }

    private static void probarPolimorfismo(ArrayList<HuellaCarbono> lista) {
        double total = 0;
        for (HuellaCarbono objeto : lista) {
            total += objeto.getHuellaCarbono();
            assertVerdadero(!objeto.getInfo().isBlank(), "Cada objeto debe devolver informacion.");
        }
        assertVerdadero(total > 0, "La suma de las huellas debe ser mayor que cero.");
    }

    private static void assertVerdadero(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new IllegalStateException(mensaje);
        }
    }
}
