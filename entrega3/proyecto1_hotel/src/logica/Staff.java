package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.time.LocalDateTime;

public class Staff extends Empleado {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String ocupacion;
    public Random random = new Random();

    public HashMap<Integer, Consumo> registrarServicio(HashMap<Integer, reserva> reserva, HashMap<String, Plato> menu,
            boolean pago,
            HashMap<Integer, Consumo> consumos_actualizados) {
        int numReserva = Integer.parseInt(input("Ingrese su numero de reserva"));
        int nombreServicios = Integer.parseInt(input(
                "Ingrese el numero del servicio que desea pagar: \n 1. Spa \n 2. Restaurante \n 3. Guia Turistica"));

        reserva reservaActual = reserva.get(numReserva);
        Servicios servicio = null;
        if (nombreServicios == 1) {
            System.out.println("El servicio elegido es spa");
            servicio = new Spa();
        } else if (nombreServicios == 2) {

            servicio = new Restaurante();
            mostrarMenuRestaurante(menu, (Restaurante) servicio);

        } else if (nombreServicios == 3) {
            int cantidad = Integer.parseInt(input("Ingrese la cantidad de personas que desea tomar la guia turistica"));
            servicio = new GuiaTuristica();
            ((GuiaTuristica) servicio).setCantidadPersonas(cantidad);

        } else {
            System.out.println("Porfavor ingrese un numero valido");
        }

        int id = 0;
        do {
            id = random.nextInt(1001);
        } while (consumos_actualizados.containsKey(id));
        Consumo consumo = new Consumo(reservaActual, servicio, pago, id);
        reservaActual.agregarConsumo(consumo);

        if (pago) {
            generarFactura(consumo);
        }
        consumos_actualizados.put(id, consumo);
        return consumos_actualizados;
    }

    public void mostrarMenuRestaurante(HashMap<String, Plato> menu, Restaurante servicio) {
        int n = 1;
        ArrayList<Plato> platos = new ArrayList<Plato>();
        LocalDateTime actual = LocalDateTime.now();
        int hora = actual.getHour();
        System.out.println("Los productos disponibles en el Menu en este momento (" + hora + "h) son: ");
        for (Map.Entry<String, Plato> entry : menu.entrySet()) {
            if (entry.getValue().getHoraInicio() <= hora && entry.getValue().getHoraFin() >= hora) {
                System.out.println(n + ". " + entry.getKey() + " " + entry.getValue().getNombrePlato() + " "
                        + entry.getValue().getPrecio());
                platos.add(entry.getValue());
                n += 1;
            }

        }

        realizarPedidoRestaurante(platos, servicio);
    }

    public void realizarPedidoRestaurante(ArrayList<Plato> platos, Restaurante servicio) {
        boolean terminarOrden = false;
        while (!terminarOrden) {
            int opcion = Integer.parseInt(input("Ingrese el numero del plato que desea ordenar"));
            Plato plato = platos.get(opcion - 1);
            servicio.agregarPlato(plato);

            String continuar = input("Desea agregar otro plato? (s/n)");
            if (continuar.equals("n")) {
                terminarOrden = true;
            }
        }
    }

    public void generarFactura(Consumo consumo) {
        if (consumo.getServicio().getNombre().equals("Restaurante")) {
            Restaurante restaurante = (Restaurante) consumo.getServicio();
            System.out.println("Factura Restaurante: ");
            System.out.println("---------------------");
            ArrayList<Plato> platos = restaurante.getPlatos();
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Platos ordenados:");
            int total = 0;
            for (Plato plato : platos) {
                System.out.println(plato.getNombrePlato() + " - $" + plato.getPrecio());
                total += plato.getPrecio();
            }
            System.out.println("---------------------");
            System.out.println("Precio total: $" + total);
        } else if (consumo.getServicio().getNombre().equals("Spa")) {
            System.out.println("Factura del Spa: ");
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Precio por persona por servicio de spa: " + consumo.getPrecioIndv());
        } else if (consumo.getServicio().getNombre().equals("GuiaTuristica")) {
            System.out.println("Factura de Guia turistica: ");
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Cantidad de personas: " + consumo.getCantidad());
            System.out.println("Precio por persona: " + consumo.getPrecioIndv());
            System.out.println("Precio total: " + consumo.getPrecioTotal());
        }
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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
