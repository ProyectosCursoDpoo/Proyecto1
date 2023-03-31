package logica;


public class Consumo {

    public Reserva reserva;
    public Servicios servicio;
    public int precioIndv;
    public int precioTotal;

    public Consumo(Reserva reserva, Servicios servicio) {
        this.reserva = reserva;
        this.servicio = servicio;
        this.precioIndv = servicio.getPrecio();
        this.precioTotal = precioIndv * reserva.getGrupo().getHuespedes().size();
        
    }

    public Reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public void setprecioIndv(int precioIndv) {
        this.precioIndv = precioIndv;
    }

    public Servicios getServicio() {
        return servicio;
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
