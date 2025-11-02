public class SensorTemperatura extends EquipoLaboratorio{
    private EspecificacionesMecanicas especMecanicas;
    private String tipoSensor;
    
    public SensorTemperatura(String id, String nombre, String fabricante, double consumo, String caracteristicas, double rangoTemp, String notas, String tipoSens) {
        super(id, nombre, "Sensor de Temperatura", fabricante, consumo, caracteristicas);
        this.especMecanicas = new EspecificacionesMecanicas(rangoTemp, "°C", notas);
        this.tipoSensor = tipoSens;
    }
    
    
    @Override
    protected String obtenerDetallesEspecificos() {
        return especMecanicas.getDetalles() +
               String.format("\n- Tipo de sensor: %s", tipoSensor);
    }
}
