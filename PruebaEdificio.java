public class PruebaEdificio {

    public static void main(String[] args) {
        Edificio edificio = new Edificio(
                "Edificio Test",
                "Calle 1 # 2-3",
                5,
                2000,
                10000,
                1000,
                100
        );

        probarCalculoHuella(edificio);
        probarConsumosEnCero(edificio);
        probarGetInfo(edificio);

        System.out.println("Pruebas de Edificio finalizadas correctamente.");
    }

    private static void probarCalculoHuella(Edificio edificio) {
        double esperado = 4000.0;
        assertIgual(esperado, edificio.getHuellaCarbono(), "La huella del edificio no es correcta.");
    }

    private static void probarConsumosEnCero(Edificio edificio) {
        edificio.setConsumoElectricoAnualKwh(0);
        edificio.setConsumoGasAnualM3(0);
        assertIgual(0.0, edificio.getHuellaCarbono(), "La huella deberia ser 0 cuando no hay consumo.");
    }

    private static void probarGetInfo(Edificio edificio) {
        edificio.setNombre("Edificio Nuevo");
        assertVerdadero(edificio.getInfo().contains("Edificio Nuevo"), "getInfo debe mostrar el nombre.");
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
