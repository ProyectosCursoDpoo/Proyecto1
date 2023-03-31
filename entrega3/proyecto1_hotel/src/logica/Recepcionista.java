package logica;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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

    public void iniciarReserva(HashMap<Integer, Huesped> huespedes, HashMap<Integer, reserva> reservas,
            HashMap<Integer, Habitacion> habitaciones) {
        // creo otro arraylist
        ArrayList<Huesped> huespedes_reserva = new ArrayList<Huesped>();

        // pregunto por los huespedes

        System.out.println("Vamos a empezar con agregar la informacion de los huespedes \n Empecemos: ");
        do {
            System.out.println("Ingrese la informacion del huesped: ");
            int id = Integer.parseInt(input("Ingrese el id del huesped"));
            System.out.println(huespedes);
            if (huespedes.containsKey(id)) {
                System.out.println("El huesped ya existe");
                huespedes_reserva.add(huespedes.get(id));
            } else {
                System.out.println("El huesped no existe");
                String nombre_huesped = input("Ingrese el nombre del huesped");
                String correo = input("Ingrese el correo del huesped");
                String celular = input("Ingrese el celular del huesped");
                String fecha = input("Ingrese la fecha de nacimiento del huesped");
                Huesped nuevo_huesped = new Huesped(nombre_huesped, id, correo, celular, fecha);
                huespedes.put(id, nuevo_huesped);
                huespedes_reserva.add(nuevo_huesped);
            }
        } while (input("Desea agregar otro huesped? (S/N)").equals("S"));
        // pregunto la habitacion que quiere
        System.out.println("Ahora te presentaremos la informacion de las habitaciones para que escojas: ");
        for (Object k : habitaciones.keySet()) {
            System.out.println("Habitacion #" + k + ": \n ");
            Habitacion habitacion = habitaciones.get(k);
            System.out.println("Ubicacion: " + habitacion.getUbicacion() + "\n");
            System.out.println("Capacidad: " + habitacion.getCapacidad() + "\n");
            System.out.println("Camas: " + habitacion.getCamas() + "\n");
            System.out.println("\n");
        }

        // numero reserva es el # de habitacion

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

    public String input(String mensaje) {
        try {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

}
