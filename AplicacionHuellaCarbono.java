import java.util.ArrayList;

public class AplicacionHuellaCarbono {

    public static void main(String[] args) {
        ArrayList<HuellaCarbono> objetos = new ArrayList<>();

        Edificio edificio = new Edificio(
                "Biblioteca del barrio",
                "Calle 10 # 15-20",
                3,
                600,
                4000,
                300,
                40
        );

        Carro carro = new Carro(
                "Mazda",
                "2",
                2018,
                "Gris",
                12,
                10000,
                Carro.TipoCombustible.GASOLINA
        );

        Bicicleta bicicleta = new Bicicleta(
                "Laura",
                "GW",
                Bicicleta.TipoBicicleta.URBANA,
                7,
                2500,
                8,
                40,
                20
        );

        objetos.add(edificio);
        objetos.add(carro);
        objetos.add(bicicleta);

        mostrarEncabezado();

        double total = 0;

        for (HuellaCarbono objeto : objetos) {
            System.out.println(objeto.getInfo());
            System.out.printf("Huella de carbono aproximada: %.2f kg CO2 al año", objeto.getHuellaCarbono());
            System.out.println();
            total += objeto.getHuellaCarbono();
        }

        System.out.printf("Huella total del listado: %.2f kg CO2 al año", total);

        GestorArchivo.guardarReporte(objetos);
    }

    private static void mostrarEncabezado() {
        System.out.println("==============================================");
        System.out.println("      CALCULO DE HUELLA DE CARBONO");
        System.out.println("==============================================");
        System.out.println();
    }
}
