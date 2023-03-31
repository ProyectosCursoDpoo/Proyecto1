package logica;

import java.util.Date;
//import java.util.ArrayList;

public class Recepcionista extends Empleado {
    private String usuario;
    private String contrasena;
    private String nombre;

    public Recepcionista(String usuario, String contrasena, String nombre) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public reserva crear_reserva(int numero_reserva, Grupo grupo, int tarifa_reserva, String estado,
            Date fecha_realizada, String rango_fecha_reserva, Empleado empleado) {
        reserva reserva = new reserva(numero_reserva, grupo, tarifa_reserva, estado, fecha_realizada,
                rango_fecha_reserva, empleado);
        return reserva;
    }

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
