public class PruebaCarro {

    public static void main(String[] args) {
        Carro carroGasolina = new Carro("Toyota", "Corolla", 2020, "Rojo", 10, 10000, Carro.TipoCombustible.GASOLINA);
        Carro carroDiesel = new Carro("Ford", "Ranger", 2019, "Negro", 10, 10000, Carro.TipoCombustible.DIESEL);
        Carro carroElectrico = new Carro("Tesla", "Model 3", 2023, "Blanco", 999, 15000, Carro.TipoCombustible.ELECTRICO);

        probarCarroGasolina(carroGasolina);
        probarCarroDiesel(carroDiesel);
        probarCarroElectrico(carroElectrico);
        probarComparacion(carroGasolina, carroDiesel);

        System.out.println("Pruebas de Carro finalizadas correctamente.");
    }

    private static void probarCarroGasolina(Carro carroGasolina) {
        assertIgual(2310.0, carroGasolina.getHuellaCarbono(), "La huella del carro gasolina no es correcta.");
    }

    private static void probarCarroDiesel(Carro carroDiesel) {
        assertIgual(2680.0, carroDiesel.getHuellaCarbono(), "La huella del carro diesel no es correcta.");
    }

    private static void probarCarroElectrico(Carro carroElectrico) {
        assertIgual(0.0, carroElectrico.getHuellaCarbono(), "El carro electrico debe tener huella 0.");
    }

    private static void probarComparacion(Carro carroGasolina, Carro carroDiesel) {
        assertVerdadero(
                carroDiesel.getHuellaCarbono() > carroGasolina.getHuellaCarbono(),
                "El diesel deberia contaminar mas que la gasolina en este ejemplo."
        );
    }

    private static void assertIgual(double esperado, double real, String mensaje) {
        if (Math.abs(esperado - real) > 0.001) {
            throw new IllegalStateException(mensaje + " Esperado: " + esperado + " pero fue: " + real);
        }
    }

    private static void assertVerdadero(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new IllegalStateException(mensaje);
        }
    }
}
