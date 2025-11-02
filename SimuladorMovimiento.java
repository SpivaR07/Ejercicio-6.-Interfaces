public class SimuladorMovimiento extends EquipoLaboratorio {
   private EspecificacionesSimulacion especSimulacion;
    private boolean soporta3D;
    
    
    public SimuladorMovimiento(String id, String nombre, String fabricante, double consumo, String caracteristicas, String tipoSim, String version, String requisitos, boolean soporte3D) {
        super(id, nombre, "Simulador de Movimiento", fabricante, consumo, caracteristicas);
        this.especSimulacion = new EspecificacionesSimulacion(tipoSim, version, requisitos);
        this.soporta3D = soporte3D;
    }


    @Override
    protected String obtenerDetallesEspecificos() {
        return especSimulacion.getDetalles() +
               String.format("\n- Soporte 3D: %s", soporta3D ? "Sí" : "No");
    }
}
