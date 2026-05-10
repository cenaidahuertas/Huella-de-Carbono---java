public class PruebaBicicleta {

    public static void main(String[] args) {
        Bicicleta bicicleta = new Bicicleta(
                "Ana Torres",
                "Trek",
                Bicicleta.TipoBicicleta.URBANA,
                21,
                3000,
                10,
                100,
                50
        );

        probarCalculoHuella(bicicleta);
        probarCambioDeVidaUtil(bicicleta);
        probarInformacion(bicicleta);

        System.out.println("Pruebas de Bicicleta finalizadas correctamente.");
    }

    private static void probarCalculoHuella(Bicicleta bicicleta) {
        double esperado = 35.0;
        assertIgual(esperado, bicicleta.getHuellaCarbono(), "La huella de la bicicleta no es correcta.");
    }

    private static void probarCambioDeVidaUtil(Bicicleta bicicleta) {
        double huellaInicial = bicicleta.getHuellaCarbono();
        bicicleta.setVidaUtilEnAños(20);
        double huellaNueva = bicicleta.getHuellaCarbono();
        assertVerdadero(huellaNueva < huellaInicial, "La huella debe bajar si aumenta la vida util.");
    }

    private static void probarInformacion(Bicicleta bicicleta) {
        assertVerdadero(bicicleta.getInfo().contains("Ana Torres"), "La informacion debe incluir al propietario.");
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
