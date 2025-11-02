public class PenduloEcoder extends EquipoLaboratorio {
    private EspecificacionesMecanicas especMecanicas;
    private int resolucionEncoder;


    public PenduloEcoder(String id, String nombre, String fabricante, double consumo, String caracteristicas, double longitud, String notas, int resolucion) {
        super(id, nombre, "Péndulo con Encoder", fabricante, consumo, caracteristicas);
        this.especMecanicas = new EspecificacionesMecanicas(longitud, "metros", notas);
        this.resolucionEncoder = resolucion;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especMecanicas.getDetalles() + 
               String.format("\n- Resolución encoder: %d pulsos/revolución", resolucionEncoder);
    }
}
