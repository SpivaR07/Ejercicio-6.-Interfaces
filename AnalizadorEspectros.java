public class AnalizadorEspectros extends EquipoLaboratorio{
    private EspecificacionesElectronicas especElectronicas;
    private double rangoFrecuenciaMin;
    private double rangoFrecuenciaMax;
    
    public AnalizadorEspectros(String id, String nombre, String fabricante, double consumo, String caracteristicas, int canales, double frecMax, String protocolo, double rangoMin, double rangoMax) {
        super(id, nombre, "Analizador de Espectro", fabricante, consumo, caracteristicas);
        this.especElectronicas = new EspecificacionesElectronicas(canales, frecMax, protocolo);
        this.rangoFrecuenciaMin = rangoMin;
        this.rangoFrecuenciaMax = rangoMax;
    }

    
    @Override
    protected String obtenerDetallesEspecificos() {
        return especElectronicas.getDetalles() +
               String.format("\n- Rango de frecuencia: %.2f Hz - %.2f GHz", rangoFrecuenciaMin, rangoFrecuenciaMax);
    }
}
