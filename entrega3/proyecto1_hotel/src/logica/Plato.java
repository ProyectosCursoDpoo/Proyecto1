package logica;
public class Plato {
    
    public String nombrePlato;
    public String nombreBebida;
    public int precio;
    public String rangoHora;
    public String lugar;

    public Plato(String nombrePlato, String nombreBebida, int precio, String rangoHora, String lugar) {
        this.nombrePlato = nombrePlato;
        this.nombreBebida = nombreBebida;
        this.precio = precio;
        this.rangoHora = rangoHora;
        this.lugar = lugar;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getRangoHora() {
        return rangoHora;
    }

    public void setRangoHora(String rangoHora) {
        this.rangoHora = rangoHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
