public class Edificio implements HuellaCarbono {

    private static final double FACTOR_ELECTRICIDAD = 0.20;
    private static final double FACTOR_GAS = 2.00;

    private String nombre;
    private String direccion;
    private int pisos;
    private double areaMetrosCuadrados;
    private double consumoElectricoAnualKwh;
    private double consumoGasAnualM3;
    private int ocupantes;

    public Edificio(String nombre, String direccion, int pisos, double areaMetrosCuadrados,
                    double consumoElectricoAnualKwh, double consumoGasAnualM3, int ocupantes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pisos = pisos;
        this.areaMetrosCuadrados = areaMetrosCuadrados;
        this.consumoElectricoAnualKwh = consumoElectricoAnualKwh;
        this.consumoGasAnualM3 = consumoGasAnualM3;
        this.ocupantes = ocupantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public double getAreaMetrosCuadrados() {
        return areaMetrosCuadrados;
    }

    public void setAreaMetrosCuadrados(double areaMetrosCuadrados) {
        this.areaMetrosCuadrados = areaMetrosCuadrados;
    }

    public double getConsumoElectricoAnualKwh() {
        return consumoElectricoAnualKwh;
    }

    public void setConsumoElectricoAnualKwh(double consumoElectricoAnualKwh) {
        this.consumoElectricoAnualKwh = consumoElectricoAnualKwh;
    }

    public double getConsumoGasAnualM3() {
        return consumoGasAnualM3;
    }

    public void setConsumoGasAnualM3(double consumoGasAnualM3) {
        this.consumoGasAnualM3 = consumoGasAnualM3;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }

    @Override
    public double getHuellaCarbono() {
        double huellaElectricidad = consumoElectricoAnualKwh * FACTOR_ELECTRICIDAD;
        double huellaGas = consumoGasAnualM3 * FACTOR_GAS;
        return huellaElectricidad + huellaGas;
    }

    @Override
    public String getInfo() {
        return "Edificio: " + nombre
                + " | Direccion: " + direccion
                + " | Pisos: " + pisos
                + " | Ocupantes: " + ocupantes;
    }

    @Override
    public String toString() {
        return "Edificio{"
                + "nombre='" + nombre + '\''
                + ", pisos=" + pisos
                + ", ocupantes=" + ocupantes
                + ", huella=" + String.format("%.2f", getHuellaCarbono()) + " kg CO2 al año"
                + '}';
    }
}
