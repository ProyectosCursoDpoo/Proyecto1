package logica;

public class Consumo {

    public String fecha;
    public Grupo grupo;
    public Servicios servicios;
    public Habitacion habitacion;
    public int impuesto;
    public int tarifaTotal;
    public boolean pagado;
    public Factura factura;


    public Consumo(String fecha, Grupo grupo, Servicios servicios, Habitacion habitacion, int impuesto, int tarifaTotal,
            boolean pagado, Factura factura) {
        this.fecha = fecha;
        this.grupo = grupo;
        this.servicios = servicios;
        this.habitacion = habitacion;
        this.impuesto = impuesto;
        this.tarifaTotal = tarifaTotal;
        this.pagado = pagado;
        this.factura = factura;


        
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }


    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }


    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }


    public void setTarifaTotal(int tarifaTotal) {
        this.tarifaTotal = tarifaTotal;
    }


    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }


    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    public String getFecha() {
        return fecha;
    }


    public Grupo getGrupo() {
        return grupo;
    }


    public Servicios getServicios() {
        return servicios;
    }


    public Habitacion getHabitacion() {
        return habitacion;
    }


    public int getImpuesto() {
        return impuesto;
    }


    public int getTarifaTotal() {
        return tarifaTotal;
    }


    public boolean isPagado() {
        return pagado;
    }


    public Factura getFactura() {
        return factura;
    }

    
    
}
