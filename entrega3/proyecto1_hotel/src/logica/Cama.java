package logica;

public class Cama {
    private int tamanio;
    private String uso;
    private int capacidad;

    public Cama(int tamanio, String uso, int capacidad) {
        this.tamanio = tamanio;
        this.uso = uso;
        this.capacidad = capacidad;
    }

    /**
     * @return int return the tamanio
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * @return String return the uso
     */
    public String getUso() {
        return uso;
    }

    /**
     * @param uso the uso to set
     */
    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     * @return int return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
