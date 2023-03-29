package logica;

public class GuiaTuristica extends Servicios {
    public int precio;
    public String ubicacion;
    public String horario;

    public GuiaTuristica(int precio, String ubicacion, String horario) {
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.horario = horario;
    }

    public int getPrecio() {
        return this.precio;
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

}
