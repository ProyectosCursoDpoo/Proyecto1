package logica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Administrador extends Empleado {

    private String usuario;
    private String contrasena;

    // public Administrador(String usuario, String contrasena) {
    //     this.usuario = usuario;
    //     this.contrasena = contrasena;
    // }

    private void cargarHabitaciones(File archivo, Hashtable habitaciones){
        System.out.println("Cargar Habitaciones");
    }

    private void crearHabitacion(int numero, String ubicacion, int capacidad,String tipo, boolean vista, boolean balcon, boolean cocina, ArrayList<Cama> camas, String estado, int precio){
        System.out.println("Crear Habitacion");
    }

    private void cargarTarifa(File archivo){
        System.out.println("Cargar Tarifa");
    }

    private void cambiarTarifa(Habitacion habitacion, int nueva_tarifa){
        System.out.println("Cambiar Tarifa");
    }

    private void cargarMenu(File archivo){
        System.out.println("Cargar Menu");
    }

    private void configurarPlato(Plato plato, int opcion, String modificacion){
        System.out.println("Configurar Plato");
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    

    
}
