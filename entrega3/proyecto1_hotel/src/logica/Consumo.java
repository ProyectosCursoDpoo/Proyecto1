package logica;

public class Consumo {

    public reserva reserva;
    public Servicios servicio;
    public int precioIndv;
    public int precioTotal;
    public boolean estado;
    public int id;

    public Consumo(reserva reserva, Servicios servicio, boolean estado, int id) {
        this.id = id;
        this.reserva = reserva;
        this.estado = estado;
        this.servicio = servicio;
        this.precioIndv = servicio.getPrecio();
        this.precioTotal = precioIndv * reserva.getGrupo().getHuespedes().size();

    }

    public boolean getEstadoPago() { // true = pagado, false = pendiente
        return estado;
    }

    public int getId() {
        return id;
    }

    public reserva getReserva() {
        return this.reserva;
    }

    public void setReserva(reserva reserva) {
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

    @Override
    public String toString() {
        String cadena = "";
        cadena += getId();
        cadena += getPrecioIndv() + ";";
        cadena += getEstadoPago() + ";";
        cadena += getPrecioTotal() + ";";

        return cadena;
    }
}
