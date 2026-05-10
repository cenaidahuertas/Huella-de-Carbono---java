public class Bicicleta implements HuellaCarbono {

    public enum TipoBicicleta {
        URBANA,
        MONTANA,
        RUTA,
        ELECTRICA
    }

    private static final double FACTOR_MANTENIMIENTO = 0.5;

    private String propietario;
    private String marca;
    private TipoBicicleta tipo;
    private int cambios;
    private double kilometrosPorAño;
    private int vidaUtilEnAños;
    private double carbonoFabricacionKg;
    private double costoMantenimientoAnual;

    public Bicicleta(String propietario, String marca, TipoBicicleta tipo, int cambios,
                    double kilometrosPorAño, int vidaUtilEnAños,
                    double carbonoFabricacionKg, double costoMantenimientoAnual) {
        this.propietario = propietario;
        this.marca = marca;
        this.tipo = tipo;
        this.cambios = cambios;
        this.kilometrosPorAño = kilometrosPorAño;
        this.vidaUtilEnAños = vidaUtilEnAños;
        this.carbonoFabricacionKg = carbonoFabricacionKg;
        this.costoMantenimientoAnual = costoMantenimientoAnual;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }

    public void setTipo(TipoBicicleta tipo) {
        this.tipo = tipo;
    }

    public int getCambios() {
        return cambios;
    }

    public void setCambios(int cambios) {
        this.cambios = cambios;
    }

    public double getKilometrosPorAño() {
        return kilometrosPorAño;
    }

    public void setKilometrosPorAño(double kilometrosPorAño) {
        this.kilometrosPorAño = kilometrosPorAño;
    }

    public int getVidaUtilEnAños() {
        return vidaUtilEnAños;
    }

    public void setVidaUtilEnAños(int vidaUtilEnAños) {
        this.vidaUtilEnAños = vidaUtilEnAños;
    }

    public double getCarbonoFabricacionKg() {
        return carbonoFabricacionKg;
    }

    public void setCarbonoFabricacionKg(double carbonoFabricacionKg) {
        this.carbonoFabricacionKg = carbonoFabricacionKg;
    }

    public double getCostoMantenimientoAnual() {
        return costoMantenimientoAnual;
    }

    public void setCostoMantenimientoAnual(double costoMantenimientoAnual) {
        this.costoMantenimientoAnual = costoMantenimientoAnual;
    }

    @Override
    public double getHuellaCarbono() {
        double huellaPorFabricacion = carbonoFabricacionKg / vidaUtilEnAños;
        double huellaPorMantenimiento = costoMantenimientoAnual * FACTOR_MANTENIMIENTO;
        return huellaPorFabricacion + huellaPorMantenimiento;
    }

    @Override
    public String getInfo() {
        return "Bicicleta de " + propietario
                + " | Marca: " + marca
                + " | Tipo: " + tipo
                + " | Cambios: " + cambios;
    }

    @Override
    public String toString() {
        return "Bicicleta{"
                + "propietario='" + propietario + '\''
                + ", marca='" + marca + '\''
                + ", tipo=" + tipo
                + ", cambios=" + cambios
                + ", kilometrosPorAño=" + kilometrosPorAño
                + ", vidaUtilEnAños=" + vidaUtilEnAños
                + ", huella=" + String.format("%.2f", getHuellaCarbono()) + " kg CO2/año"
                + '}';
    }
}
