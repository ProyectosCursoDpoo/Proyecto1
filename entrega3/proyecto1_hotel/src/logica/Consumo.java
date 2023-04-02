package logica;

public class Consumo {
    public reserva reserva;
    public Servicios servicio;
    public int precioIndv;
    public boolean estado;
    public int id;
    public int cantidad;

    public Consumo(reserva reserva, Servicios servicio, boolean estado, int id) {
        this.id = id;
        this.reserva = reserva;
        this.estado = estado;
        this.servicio = servicio;
        this.precioIndv = servicio.getPrecio();
        this.cantidad = servicio.getCantidadPersonas();        

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   public int getPrecioTotal() {
        return precioIndv * cantidad;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += getId() + ";";
        cadena += (getEstadoPago()) ? "TRUE;" : "FALSE;";
        cadena += getReserva().getNumeroReserva() + ";";
        cadena += getServicio().getNombre() + ";";
        cadena += getPrecioTotal() + "\n";

        return cadena;
    }
}
