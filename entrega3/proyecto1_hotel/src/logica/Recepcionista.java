package logica;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.*;
//import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

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
            HashMap<Integer, Habitacion> habitaciones, Empleado empleado) {
        // creo arraylist de apoyo
        ArrayList<Huesped> huespedes_reserva = new ArrayList<Huesped>();
        ArrayList<Habitacion> habitaciones_reserva = new ArrayList<Habitacion>();
        // int tarifa_reserva = 0;
        // pregunto por los huespedes
        System.out.println("Vamos a empezar con agregar la informacion de los huespedes \n Empecemos: ");
        do {
            System.out.println("Ingrese la informacion del huesped: ");
            int id = Integer.parseInt(input("Ingrese el id del huesped"));
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
        do {
            for (Object k : habitaciones.keySet()) {
                System.out.println("Habitacion #" + k + ": \n ");
                Habitacion habitacion = habitaciones.get(k);
                System.out.println("Ubicacion: " + habitacion.getUbicacion() + "\n");
                System.out.println("Capacidad: " + habitacion.getCapacidad() + "\n");
                System.out.println("Camas: \n");
                ArrayList<Cama> camas = habitacion.getCamas();
                for (Cama cama : camas) {
                    System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                    System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                }
                System.out.println("\n");
            }
            int numero_habitacion = Integer
                    .parseInt(input("Ingresa el numero de la habitacion que sea de tu interes: "));
            // Numero de la reserva
            Habitacion habitacion_elegida = habitaciones.get(numero_habitacion);
            habitacion_elegida.setEstado("OCUPADO");
            habitaciones_reserva.add(habitacion_elegida);
            System.out.println(habitacion_elegida.getPrecio());
        } while (input("Deseas Elegir otra habitacion? (S/N)").equals("S"));
        int numero_reserva = habitaciones_reserva.get(0).getNumero();
        // Se crea el grupo de la reserva
        Grupo grupo_reserva = new Grupo(huespedes_reserva, habitaciones_reserva);
        String fecha_realizada = ZonedDateTime.now(ZoneId.of("America/Bogota"))
                .format(DateTimeFormatter.ofPattern("MM.dd.yyy, hh.mm.ss a"));
        String fecha_final = input(
                "Ingresa hasta que dia deseas tu reserva, (Recuerda ingresarla en el formato MM.dd.yyy): ");
        // int dias = Integer.parseInt(fecha_final.substring(3, 5)) -
        // Integer.parseInt(fecha_realizada.substring(3, 5));
        reserva reserva = new reserva(numero_reserva, grupo_reserva, 0, fecha_realizada, fecha_final, empleado);
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
