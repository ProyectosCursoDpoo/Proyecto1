package logica;


public class Consumo {

    public Reserva reserva;
    public Servicios servicios;
    public int precioIndv;
    public int precioTotal;

    public Consumo(Reserva reserva, Servicios servicios) {
        this.reserva = reserva;
        this.servicios = servicios;
        this.precioIndv = servicios.getPrecio();
        this.precioTotal = precioIndv * reserva.getGrupo().getHuespedes().size();
        
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public void setprecioIndv(int precioIndv) {
        this.precioIndv = precioIndv;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public int getPrecioIndv() {
        return precioIndv;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public int getCantidad() {
        return reserva.getGrupo().getHuespedes().size();
    }
    
}
