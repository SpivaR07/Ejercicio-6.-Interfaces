public class Osciloscopio extends EquipoLaboratorio {
    private EspecificacionesElectronicas especElectronicas;
    private double anchoBanda;
    private double tasaMuestreo;


    public Osciloscopio(String id, String nombre, String fabricante, double consumo, String caracteristicas, int canales, double bandwidth, double sampleRate, String protocolo) {
        super(id, nombre, "Osciloscopio", fabricante, consumo, caracteristicas);
        this.especElectronicas = new EspecificacionesElectronicas(canales, bandwidth, protocolo);
        this.tasaMuestreo = sampleRate;
        this.anchoBanda = bandwidth;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especElectronicas.getDetalles() +
               String.format("\n- Tasa de muestreo: %.2f GSa/s\n- Ancho de banda: %.2f MHz", tasaMuestreo, anchoBanda);
    }
}
