public class FotoCompuerta extends EquipoLaboratorio {
    private EspecificacionesMecanicas especMecanicas;
    private double tiempoRespuesta;
    
    
    public FotoCompuerta(String id, String nombre, String fabricante, double consumo, String caracteristicas, double anchoHaz, String notas, double tiempoResp) {
        super(id, nombre, "Fotocompuerta", fabricante, consumo, caracteristicas);
        this.especMecanicas = new EspecificacionesMecanicas(anchoHaz, "mm", notas);
        this.tiempoRespuesta = tiempoResp;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especMecanicas.getDetalles() + 
               String.format("\n- Tiempo de respuesta: %.3f ms", tiempoRespuesta);
    }
}
