public class EspecificacionesSimulacion {
    private String tipoSimulacion;
    private String versionSoftware;
    private String requisitosHardware;


    public EspecificacionesSimulacion(String tipo, String version, String requisitos) {
        this.tipoSimulacion = tipo;
        this.versionSoftware = version;
        this.requisitosHardware = requisitos;
    }
    
    
    public String getDetalles() {
        return String.format("- Tipo de simulación: %s\n- Versión: %s\n- Requisitos: %s",
                           tipoSimulacion, versionSoftware, requisitosHardware);
    }
}
