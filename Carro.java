public class Carro implements HuellaCarbono {

    public enum TipoCombustible {
        GASOLINA,
        DIESEL,
        ELECTRICO
    }

    private static final double FACTOR_GASOLINA = 2.31;
    private static final double FACTOR_DIESEL = 2.68;

    private String marca;
    private String modelo;
    private int año;
    private String color;
    private double eficienciaKmPorLitro;
    private double kilometrosPorAño;
    private TipoCombustible tipoCombustible;

    public Carro(String marca, String modelo, int año, String color,
                double eficienciaKmPorLitro, double kilometrosPorAño,
                TipoCombustible tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.eficienciaKmPorLitro = eficienciaKmPorLitro;
        this.kilometrosPorAño = kilometrosPorAño;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEficienciaKmPorLitro() {
        return eficienciaKmPorLitro;
    }

    public void setEficienciaKmPorLitro(double eficienciaKmPorLitro) {
        this.eficienciaKmPorLitro = eficienciaKmPorLitro;
    }

    public double getKilometrosPorAño() {
        return kilometrosPorAño;
    }

    public void setKilometrosPorAño(double kilometrosPorAño) {
        this.kilometrosPorAño = kilometrosPorAño;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public double getHuellaCarbono() {
        if (tipoCombustible == TipoCombustible.ELECTRICO) {
            return 0.0;
        }

        double litrosConsumidos = kilometrosPorAño / eficienciaKmPorLitro;
        double factorEmision = tipoCombustible == TipoCombustible.DIESEL
                ? FACTOR_DIESEL
                : FACTOR_GASOLINA;
        return litrosConsumidos * factorEmision;
    }

    @Override
    public String getInfo() {
        return "Carro: " + marca + " " + modelo
                + " | Año: " + año
                + " | Color: " + color
                + " | Combustible: " + tipoCombustible;
    }

    @Override
    public String toString() {
        return "Carro{"
                + "marca='" + marca + '\''
                + ", modelo='" + modelo + '\''
                + ", año=" + año
                + ", color='" + color + '\''
                + ", eficienciaKmPorLitro=" + eficienciaKmPorLitro
                + ", kilometrosPorAño=" + kilometrosPorAño
                + ", huella=" + String.format("%.2f", getHuellaCarbono()) + " kg CO2/año"
                + '}';
    }
}
