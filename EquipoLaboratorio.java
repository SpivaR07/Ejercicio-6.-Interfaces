abstract class EquipoLaboratorio implements IEquipo {
    protected String identificador;
    protected String nombre;
    protected String tipo;
    protected String fabricante;
    protected double consumoElectrico;
    protected String caracteristicas;


    public EquipoLaboratorio(String identificador, String nombre, String tipo, String fabricante, 
    double consumoElectrico, String caracteristicas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.caracteristicas = caracteristicas;
    }


    @Override public String getIdentificador() { return identificador; }
    @Override public String getNombre() { return nombre; }
    @Override public String getTipo() { return tipo; }
    @Override public String getFabricante() { return fabricante; }
    @Override public double getConsumoElectrico() { return consumoElectrico; }
    @Override public String getCaracteristicas() { return caracteristicas; }


    @Override
    public String obtenerDetalleCompleto() {
        String detalle = "========================================\n";
        detalle += String.format("EQUIPO: %s\n", nombre);
        detalle += "========================================\n";
        detalle += String.format("ID: %s\n", identificador);
        detalle += String.format("Tipo: %s\n", tipo);
        detalle += String.format("Fabricante: %s\n", fabricante);
        detalle += String.format("Consumo eléctrico: %.2f W\n", consumoElectrico);
        detalle += String.format("Características: %s\n", caracteristicas);
        
        String detallesEspecificos = obtenerDetallesEspecificos();
        if (detallesEspecificos != null && !detallesEspecificos.isEmpty()) {
            detalle += "\nDETALLES ESPECIFICOS:\n";
            detalle += detallesEspecificos;
        }
        
        detalle += "========================================\n";
        return detalle;
    }


    protected abstract String obtenerDetallesEspecificos();
}
