package logica;

public class GuiaTuristica extends Servicios {
    public int precio = 30000;
    public String ubicacion = "Recepcion";
    public String horario = "8:00 - 16:00";
    public int cantidadPersonas;

    public int getPrecio() {
        return this.precio;
    }

    public void setCantidadPersonas(int cantidad){
        this.cantidadPersonas = cantidad;
    }

    public int getPrecioFinal(){
        return this.precio * this.cantidadPersonas;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombre(){
        return "Guia Turistica";
    }
}
