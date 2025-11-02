public class BalanzaPrecision extends EquipoLaboratorio{
    private EspecificacionesMecanicas especMecanicas;
    private double capacidadMaxima;
    
    
    public BalanzaPrecision(String id, String nombre, String fabricante, double consumo, String caracteristicas, double precision, String notas, double capacidad) {
        super(id, nombre, "Balanza de Precisión", fabricante, consumo, caracteristicas);
        this.especMecanicas = new EspecificacionesMecanicas(precision, "gramos", notas);
        this.capacidadMaxima = capacidad;
    }

    
    @Override
    protected String obtenerDetallesEspecificos() {
        return especMecanicas.getDetalles() +
               String.format("\n- Capacidad máxima: %.2f kg", capacidadMaxima);
    }
}   
