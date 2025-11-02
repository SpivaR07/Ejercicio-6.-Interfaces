public class GeneradorSenales extends EquipoLaboratorio {
    private EspecificacionesElectronicas especElectronicas;
    private String formasOnda;


    public GeneradorSenales(String id, String nombre, String fabricante, double consumo, String caracteristicas, int canales, double frecMax, String protocolo, String formas) {
        super(id, nombre, "Generador de Señales", fabricante, consumo, caracteristicas);
        this.especElectronicas = new EspecificacionesElectronicas(canales, frecMax, protocolo);
        this.formasOnda = formas;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especElectronicas.getDetalles() +
               String.format("\n- Formas de onda: %s", formasOnda);
    }
}
