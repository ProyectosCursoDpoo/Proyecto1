package logica;

import java.io.*;
import java.util.*;
import java.time.*;
//import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Recepcionista extends Empleado {
    private String usuario;
    private String contrasena;
    private String nombre;
    public Random random = new Random();
    public Recepcionista(String usuario, String contrasena, String nombre) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public reserva iniciarReserva(HashMap<Integer, Huesped> huespedes, HashMap<Integer, reserva> reservas,
            HashMap<Integer, Habitacion> habitaciones, Empleado empleado, HashMap<String, Integer> tarifasEstandar, HashMap<String, Integer> tarifasSuite, HashMap<String, Integer> tarifasSuiteDoble, HashMap<Integer, Grupo> grupos) {
        // creo arraylist de apoyo
        ArrayList<Huesped> huespedes_reserva = new ArrayList<Huesped>();
        ArrayList<Habitacion> habitaciones_reserva = new ArrayList<Habitacion>();
        int tarifa_reserva = 0;
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

        //Fecha de reserva
        String fecha_realizada = ZonedDateTime.now(ZoneId.of("America/Bogota"))
                .format(DateTimeFormatter.ofPattern("MM.dd.yyy"));
        String fecha_final = input(
                "Ingresa hasta que dia deseas tu reserva, (Recuerda ingresarla en el formato MM.dd.yyy): ");
        String rango_fecha = fecha_realizada + "-" + fecha_final;
        String inicial = fecha_realizada.substring(0,5).replace(".", "");
        String f_final = fecha_final.substring(0,5).replace(".", "");

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
            if (habitacion_elegida instanceof Estandar){
                Estandar habitacion = (Estandar) habitacion_elegida;
                System.out.println("Seleccionaste una Estandar \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasEstandar,  String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            }
            else if (habitacion_elegida instanceof Suite){
                System.out.println("Seleccionaste una suite \n");
                Suite habitacion = (Suite) habitacion_elegida;
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasSuite,  String.valueOf(fecha_ini));
                    fecha_ini++;
                }

            }
            else if (habitacion_elegida instanceof Suite_doble){
                Suite_doble habitacion = (Suite_doble) habitacion_elegida;
                System.out.println("Seleccionaste una Suite Doble \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasSuiteDoble,  String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            }
        } while (input("Deseas Elegir otra habitacion? (S/N)").equals("S"));
        int numero_reserva = habitaciones_reserva.get(0).getNumero();
        System.out.println(tarifa_reserva);
        // Se crea el grupo de la reserva
        int id = 0;
        do{
            id = random.nextInt(101);
        }while(grupos.containsKey(id));
        Grupo grupo_reserva = new Grupo(huespedes_reserva, habitaciones_reserva,id );
    
        reserva reserva = new reserva(numero_reserva, grupo_reserva, tarifa_reserva, fecha_realizada, rango_fecha, empleado);
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
