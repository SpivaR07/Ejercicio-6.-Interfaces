public class EspecificacionesMecanicas {
    private double rangoMedicion;
    private String unidadMedida;
    private String notasCalibracion;


    public EspecificacionesMecanicas(double rango, String unidad, String notas) {
        this.rangoMedicion = rango;
        this.unidadMedida = unidad;
        this.notasCalibracion = notas;
    }


    public String getDetalles() {
        return String.format("- Rango de medición: %.2f %s\n- Calibración: %s",
                           rangoMedicion, unidadMedida, notasCalibracion);
    }
}
