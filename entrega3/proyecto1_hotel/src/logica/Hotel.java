package logica;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hotel {

    public ArrayList<Habitacion> habitaciones;
    public ArrayList<Servicios> servicios;
    public ArrayList<Huesped> huespedes;
    public ArrayList<Factura> facturas;
    public ArrayList<Reserva> reservas;
    public HashMap<String, String> database;
    public Empleado empleado;

    public void login(String usuario, String contrasena) {

        if (contrasena == database.get(usuario)) {
            if (usuario.contains("Staff")) {
                mostrarInfoStaff();
            } else if (usuario.contains("Recept")) {
                mostrarInfoRecep();
            } else {
                mostrarInfoAdmin();
            }
        } else {
            System.out.println("Usuario o contraseña incorrecta");
        }

    }

    public void logOut() {
        System.out.println("Logout");
        this.empleado = null;
    }

    public void cargarInformacion() {
        System.out.println("cargarInfo");
    }

    public void guardarInfo() {
        System.out.println("guardarInfo");
    }

    private void mostrarInfoStaff() {
        int opcion;
        do {
            System.out.println("Opciones Staff");
            System.out.println("1.) Regitrar Servicio ");
            System.out.println("2.) Generar Factura ");
            System.out.println("3.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
                empleado.registrarServicio();
            } else if (opcion == 2) {
                empleado.generarFactura();
            } else if (opcion == 3) {
                logOut();
            }
            else{
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 3);
    }

    private void mostrarInfoRecep() {
        int opcion;
        do {
            System.out.println("Opciones Recepcionista");
            System.out.println("1.) Dar Cotización ");
            System.out.println("2.) Iniciar Reserva ");
            System.out.println("3.) Finalizar Reserva ");
            System.out.println("4.) Cancelar Reserva ");
            System.out.println("5.) Registrar Huésped ");
            System.out.println("6.) Registrar Salida ");
            System.out.println("7.) Generar Factura ");
            System.out.println("8.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
                empleado.darCotizacion();
            } else if (opcion == 2) {
                empleado.iniciarReserva();
            } 
            else if (opcion == 3) {
                empleado.finalizarReserva();
            }
            else if (opcion == 4) {
                empleado.cancelarReserva();
            }
            else if (opcion == 5) {
                empleado.RegistrarHuesped();
            }
            else if (opcion == 6) {
                empleado.registrarSalida();
            }
            else if (opcion == 7) {
                empleado.generarFactura();
            }
            else if (opcion == 8) {
                logOut();
            }
            else{
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 8);
    }

    private void mostrarInfoAdmin() {
        int opcion;
        Empleado empleado=new Administrador();
        do {
            System.out.println("Opciones Administrador");
            System.out.println("1.) Cargar Habitaciones ");
            System.out.println("2.) Crear Habitacion ");
            System.out.println("3.) Cargar Tarifa ");
            System.out.println("4.) Cargar Menú ");
            System.out.println("5.) Configurar Plato ");
            System.out.println("6.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
                empleado.cargarHabitaciones();
            } else if (opcion == 2) {
                empleado.crearHabitacion();
            }
            else if (opcion == 3) {
                empleado.cargarTarifa();
            }
            else if (opcion == 4) {
                empleado.cargarMenu();
            }
            else if (opcion == 5) {
                empleado.configurarPlato();
            }
            else if (opcion == 6) {
                logOut();
            }
            else{
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 6);
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
