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

    public HashMap<Integer, reserva> iniciarReserva(HashMap<Integer, Huesped> huespedes,
            HashMap<Integer, reserva> reservas,
            HashMap<Integer, Habitacion> habitaciones, Empleado empleado, HashMap<String, Integer> tarifasEstandar,
            HashMap<String, Integer> tarifasSuite, HashMap<String, Integer> tarifasSuiteDoble,
            HashMap<Integer, Grupo> grupos) {
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

        // Fecha de reserva
        String fecha_realizada = ZonedDateTime.now(ZoneId.of("America/Bogota"))
                .format(DateTimeFormatter.ofPattern("MM.dd.yyy"));
        String fecha_final = input(
                "Ingresa hasta que dia deseas tu reserva, (Recuerda ingresarla en el formato MM.dd.yyy): ");
        String rango_fecha = fecha_realizada.substring(0, 5).replace(".", "") + "-"
                + fecha_final.substring(0, 5).replace(".", "");
        String inicial = fecha_realizada.substring(0, 5).replace(".", "");
        String f_final = fecha_final.substring(0, 5).replace(".", "");

        // pregunto la habitacion que quiere
        System.out.println("Ahora te presentaremos la informacion de las habitaciones para que escojas: ");
        do {
            for (Object k : habitaciones.keySet()) {
                Habitacion habitacion = habitaciones.get(k);
                if (habitacion instanceof Estandar) {
                    Estandar habiEstandar = (Estandar) habitacion;
                    if (habiEstandar.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiEstandar.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiEstandar.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiEstandar.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                } else if (habitacion instanceof Suite) {
                    Suite habiSuite = (Suite) habitacion;
                    if (habiSuite.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiSuite.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiSuite.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiSuite.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                } else if (habitacion instanceof Suite_doble) {
                    Suite_doble habiSuite2 = (Suite_doble) habitacion;
                    if (habiSuite2.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiSuite2.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiSuite2.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiSuite2.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                }
            }
            int numero_habitacion = Integer
                    .parseInt(input("Ingresa el numero de la habitacion que sea de tu interes: "));
            // Numero de la reserva
            Habitacion habitacion_elegida = habitaciones.get(numero_habitacion);
            if (habitacion_elegida instanceof Estandar) {
                Estandar habitacion = (Estandar) habitacion_elegida;
                System.out.println("Seleccionaste una Estandar \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasEstandar, String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            } else if (habitacion_elegida instanceof Suite) {
                System.out.println("Seleccionaste una suite \n");
                Suite habitacion = (Suite) habitacion_elegida;
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    System.out.println("Infinito");
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasSuite, String.valueOf(fecha_ini));
                    fecha_ini++;
                }

            } else if (habitacion_elegida instanceof Suite_doble) {
                Suite_doble habitacion = (Suite_doble) habitacion_elegida;
                System.out.println("Seleccionaste una Suite Doble \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_reserva += habitacion.getPrecioAhora(tarifasSuiteDoble, String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            }
        } while (input("Deseas Elegir otra habitacion? (S/N)").equals("S"));
        int numero_reserva = habitaciones_reserva.get(0).getNumero();
        System.out.println(tarifa_reserva);
        // Se crea el grupo de la reserva
        int id = 0;
        do {
            id = random.nextInt(101);
        } while (grupos.containsKey(id));
        Grupo grupo_reserva = new Grupo(huespedes_reserva, habitaciones_reserva, id);

        reserva reserva = new reserva(numero_reserva, grupo_reserva, tarifa_reserva, fecha_realizada, rango_fecha,
                empleado);
        reservas.put(id, reserva);
        return reservas;
    }

    public void darCotizacion(HashMap<Integer, Huesped> huespedes, HashMap<Integer, Habitacion> habitaciones,
            HashMap<String, Integer> tarifasEstandar, HashMap<String, Integer> tarifasSuite,
            HashMap<String, Integer> tarifasSuiteDoble) {
        System.out.println(
                "A Continuacion te pedire informacion sobre las habitaciones de tu interes, y los dias de tu estadia para sacar el precio de cotizacion. \n");
        // Fecha de reserva
        String fecha_realizada = input(
                "Ingresa hasta que desde que dias deseas tu reserva, (Recuerda ingresarla en el formato MM.dd.yyy): ");
        String fecha_final = input(
                "Ingresa hasta que dia deseas tu reserva, (Recuerda ingresarla en el formato MM.dd.yyy): ");
        String rango_fecha = fecha_realizada + "-" + fecha_final;
        String inicial = fecha_realizada.substring(0, 5).replace(".", "");
        String f_final = fecha_final.substring(0, 5).replace(".", "");

        // Desplegar info habitaciones
        int tarifa_cotizacion = 0;
        System.out.println("Ahora te presentaremos la informacion de las habitaciones para que escojas: ");
        System.out.println(habitaciones);
        do {
            for (Object k : habitaciones.keySet()) {
                Habitacion habitacion = habitaciones.get(k);
                if (habitacion instanceof Estandar) {
                    Estandar habiEstandar = (Estandar) habitacion;
                    if (habiEstandar.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiEstandar.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiEstandar.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiEstandar.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                } else if (habitacion instanceof Suite) {
                    Suite habiSuite = (Suite) habitacion;
                    if (habiSuite.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiSuite.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiSuite.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiSuite.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                } else if (habitacion instanceof Suite_doble) {
                    Suite_doble habiSuite2 = (Suite_doble) habitacion;
                    if (habiSuite2.getEstado().equals("DISPONIBLE")) {
                        System.out.println("Habitacion #" + k + ": \n ");
                        System.out.println("Ubicacion: " + habiSuite2.getUbicacion() + "\n");
                        System.out.println("Capacidad: " + habiSuite2.getCapacidad() + "\n");
                        System.out.println("Camas: \n");
                        ArrayList<Cama> camas = habiSuite2.getCamas();
                        for (Cama cama : camas) {
                            System.out.println("\tCapacidad: " + cama.getCapacidad() + "\n");
                            System.out.println("\tTamaño: " + cama.getTamanio() + "\n");

                        }
                        System.out.println("\n");
                    }
                }
            }
            int numero_habitacion = Integer
                    .parseInt(input("Ingresa el numero de la habitacion que sea de tu interes: "));
            // Numero de la reserva
            Habitacion habitacion_elegida = habitaciones.get(numero_habitacion);
            if (habitacion_elegida instanceof Estandar) {
                Estandar habitacion = (Estandar) habitacion_elegida;
                System.out.println("Seleccionaste una Estandar \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_cotizacion += habitacion.getPrecioAhora(tarifasEstandar, String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            } else if (habitacion_elegida instanceof Suite) {
                System.out.println("Seleccionaste una suite \n");
                Suite habitacion = (Suite) habitacion_elegida;
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    System.out.println("Infinito");
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_cotizacion += habitacion.getPrecioAhora(tarifasSuite, String.valueOf(fecha_ini));
                    fecha_ini++;
                }

            } else if (habitacion_elegida instanceof Suite_doble) {
                Suite_doble habitacion = (Suite_doble) habitacion_elegida;
                System.out.println("Seleccionaste una Suite Doble \n");
                int fecha_ini = Integer.parseInt(inicial);
                int fecha_fin = Integer.parseInt(f_final);

                while (fecha_ini != fecha_fin) {
                    if (fecha_ini % 100 == 32) {
                        fecha_ini = (fecha_ini - 31) + 100;
                    }
                    tarifa_cotizacion += habitacion.getPrecioAhora(tarifasSuiteDoble, String.valueOf(fecha_ini));
                    fecha_ini++;
                }
            }
        } while (input("Deseas Elegir otra habitacion? (S/N)").equals("S"));

        System.out.format(
                "\n El precio en el que saldria la reserva seria: %d pesos colombianos, en este rango de fecha %s \n ",
                tarifa_cotizacion, rango_fecha);
    }

    public HashMap<Integer, reserva> cancelarReserva(Integer numero_reserva, HashMap<Integer, reserva> reservas) {
        reserva reserva = reservas.get(numero_reserva);
        Grupo grupo = reserva.getGrupo();
        ArrayList<Habitacion> habitaciones = grupo.getHabitaciones();
        // ArrayList<Huesped> huespedes = grupo.getHuespedes();

        for (Habitacion habitacion : habitaciones) {
            habitacion.setEstado("DISPONIBLE");
        }

        reservas.remove(numero_reserva);

        return reservas;
    }

    public void registrarSalida(Integer numero_reserva, HashMap<Integer, reserva> reservas) {
        System.out.println(
                "A continuacion te mostrate tu factura para que hagas el respectivo pago y poder registrar tu factura: ");
        reserva reserva = reservas.get(numero_reserva);
        generarFactura(numero_reserva);
        int tarifa_final = reserva.getTarifaReserva();
        int saldo = Integer.parseInt(input("Ingresa el saldo correspondiente a tarifa final: "));
        if (saldo == tarifa_final) {
            System.out.println("Gracias por visitar el hotel, salida registrada");
        } else {
            System.out.format("Te hizo faltar una parte, aun debes pagar %d", tarifa_final);
        }

    }

    public void generarFactura(Integer numero_reserva) {

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
