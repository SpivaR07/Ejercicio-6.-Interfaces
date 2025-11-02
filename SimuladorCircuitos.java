public class SimuladorCircuitos extends EquipoLaboratorio{
    private EspecificacionesSimulacion especSimulacion;
    private int maxComponentes;


    public SimuladorCircuitos(String id, String nombre, String fabricante, double consumo, String caracteristicas, String tipoSim, String version, String requisitos, int maxComp) {
        super(id, nombre, "Simulador de Circuitos", fabricante, consumo, caracteristicas);
        this.especSimulacion = new EspecificacionesSimulacion(tipoSim, version, requisitos);
        this.maxComponentes = maxComp;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especSimulacion.getDetalles() +
               String.format("\n- Máximo de componentes: %d", maxComponentes);
    }
}   
