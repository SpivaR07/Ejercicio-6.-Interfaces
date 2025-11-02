public class EspecificacionesElectronicas {
    private int numeroCanales;
    private double frecuenciaMax;
    private String protocoloComunicacion;


    public EspecificacionesElectronicas(int canales, double freq, String protocolo) {
        this.numeroCanales = canales;
        this.frecuenciaMax = freq;
        this.protocoloComunicacion = protocolo;
    }
    
    
    public String getDetalles() {
        return String.format("- Canales: %d\n- Frecuencia máxima: %.2f MHz\n- Protocolo: %s",
                           numeroCanales, frecuenciaMax, protocoloComunicacion);
    }
}
