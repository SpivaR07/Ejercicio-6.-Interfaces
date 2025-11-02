public class Multimetro extends EquipoLaboratorio{
    private EspecificacionesElectronicas especElectronicas;
    private String rangosVoltaje;
    private double precision;

    
    public Multimetro(String id, String nombre, String fabricante, double consumo, String caracteristicas, int canales, double frecMax, String protocolo, String rangos, double prec) {
        super(id, nombre, "Multímetro Digital", fabricante, consumo, caracteristicas);
        this.especElectronicas = new EspecificacionesElectronicas(canales, frecMax, protocolo);
        this.rangosVoltaje = rangos;
        this.precision = prec;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especElectronicas.getDetalles() +
               String.format("\n- Rangos de voltaje: %s\n- Precisión: %.2f%%", rangosVoltaje, precision);
    }
}
