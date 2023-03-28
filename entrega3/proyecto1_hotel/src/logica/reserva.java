package logica;

import java.util.Date;

public class Reserva {
    private Grupo grupo;
    private int tarifaReserva;
    private String estado;
    private Date fechaRealizada;
    private String rangoFechaReserva;
    private Empleado empleado;

    public Reserva(Grupo grupo, int tarifaReserva, String estado, Date fechaRealizada, String rangoFechaReserva,
            Empleado empleado) {
        this.grupo = grupo;
        this.tarifaReserva = tarifaReserva;
        this.estado = estado;
        this.fechaRealizada = fechaRealizada;
        this.rangoFechaReserva = rangoFechaReserva;
        this.empleado = empleado;
    }

    /**
     * @return Grupo return the grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * @return int return the tarifaReserva
     */
    public int getTarifaReserva() {
        return tarifaReserva;
    }

    /**
     * @param tarifaReserva the tarifaReserva to set
     */
    public void setTarifaReserva(int tarifaReserva) {
        this.tarifaReserva = tarifaReserva;
    }

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return Date return the fechaRealizada
     */
    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    /**
     * @param fechaRealizada the fechaRealizada to set
     */
    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    /**
     * @return String return the rangoFechaReserva
     */
    public String getRangoFechaReserva() {
        return rangoFechaReserva;
    }

    /**
     * @param rangoFechaReserva the rangoFechaReserva to set
     */
    public void setRangoFechaReserva(String rangoFechaReserva) {
        this.rangoFechaReserva = rangoFechaReserva;
    }

    /**
     * @return Empleado return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}