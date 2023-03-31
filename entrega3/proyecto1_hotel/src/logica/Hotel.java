package logica;

import java.io.*;
import java.util.*;

public class Hotel {

    public HashMap<Integer, Habitacion> habitaciones = new HashMap<>();
    public HashMap<String, Plato> platos = new HashMap<>();
    public HashMap<String, Servicios> servicios = new HashMap<>();
    public HashMap<Integer, Huesped> huespedes = new HashMap<>();
    public HashMap<Integer, Factura> facturas = new HashMap<>();
    public HashMap<Integer, Reserva> reservas = new HashMap<>();
    public HashMap<String, String> database = new HashMap<>();
    public HashMap<String, Integer> tarifasEstandar = new HashMap<>();
    public HashMap<String, Integer> tarifasSuite = new HashMap<>();
    public HashMap<String, Integer> tarifasSuite2 = new HashMap<>();
    public Empleado empleado;

    public void cargarDatabase() {
        System.out.println("Cargando DataBase de Usuarios");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(
                    "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/database.txt")));
            String linea;
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String usuario = partes[0];
                String contrasena = partes[1];

                database.put(usuario, contrasena);

                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(String usuario, String contrasena) {

        System.out.println(database.get(usuario));
        if (contrasena.equals(database.get(usuario))) {
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
        guardarInfoHabitacion(habitaciones);
        guardarTarifa(tarifasEstandar, "tarifa.txt");
        guardarTarifa(tarifasSuite, "tarifa2.txt");
        guardarTarifa(tarifasSuite2, "tarifa3.txt");
        guardarPlato(platos);
    }

    public void cargarInformacion() {
        try {
            BufferedReader br;
            String linea;

            br = new BufferedReader(new FileReader(new File(
                    "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/huesped.txt")));
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                String correo = partes[2];
                String celular = partes[3];
                String fecha = partes[4];
                Huesped nuevo_huesped = new Huesped(nombre, id, correo, celular, fecha);
                huespedes.put(id, nuevo_huesped);
                linea = br.readLine();
            }
            br.close();

            // br = new BufferedReader(new FileReader(new
            // File("C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER
            // SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/reserva.txt")));
            // linea = br.readLine();
            // while (linea != null)
            // {
            // String[] partes = linea.split(";");
            // String nombre = partes[0];
            // int id = Integer.parseInt(partes[1]);
            // String correo = partes[2];
            // String celular = partes[3];
            // String fecha = partes[4];
            // Huesped nuevo_huesped=new Huesped(nombre,id,correo,celular,fecha);
            // huespedes.put(id,nuevo_huesped);
            // linea = br.readLine();
            // }
            // br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void guardarInfoHabitacion(HashMap<Integer, Habitacion> lista) {

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/habitaciones.txt")))) {
            String cadena = "";
            for (Object k : lista.keySet()) {
                String licor = lista.get(k).toString();
                cadena += licor;
            }
            bw.write(cadena);
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void guardarTarifa(HashMap<String, Integer> lista, String archivo) {

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/"
                                + archivo)))) {
            String cadena = "";
            for (Object k : lista.keySet()) {
                cadena += k + ";";
                String licor = lista.get(k).toString();
                cadena += licor;
                cadena += "\n";
            }
            bw.write(cadena);
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void guardarPlato(HashMap<String, Plato> lista) {

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/menu.txt")))) {
            String cadena = "";
            for (Object k : lista.keySet()) {
                String licor = lista.get(k).toString();
                cadena += licor;
            }
            bw.write(cadena);
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private void mostrarInfoStaff() {
        int opcion;
        Staff empleado = new Staff();
        do {
            System.out.println("Opciones Staff");
            System.out.println("1.) Regitrar Servicio ");
            System.out.println("2.) Generar Factura ");
            System.out.println("3.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
                // empleado.registrarServicio();
            } else if (opcion == 2) {
                // empleado.generarFactura();
            } else if (opcion == 3) {
                logOut();
            } else {
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 3);
    }

    private void mostrarInfoRecep() {
        int opcion;
        Recepcionista empleado = new Recepcionista("lf", "are", "Luis");
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
                // empleado.darCotizacion();
            } else if (opcion == 2) {
                Recepcionista.cre
            } else if (opcion == 3) {
                // empleado.finalizarReserva();
            } else if (opcion == 4) {
                // empleado.cancelarReserva();
            } else if (opcion == 5) {
                // empleado.RegistrarHuesped();
            } else if (opcion == 6) {
                // empleado.registrarSalida();
            } else if (opcion == 7) {
                // empleado.generarFactura();
            } else if (opcion == 8) {
                logOut();
            } else {
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 8);
    }

    private void mostrarInfoAdmin() {
        int opcion;
        Administrador empleado = new Administrador();
        do {
            System.out.println("Opciones Administrador");
            System.out.println("1.) Cargar Habitaciones ");
            System.out.println("2.) Crear Habitacion ");
            System.out.println("3.) Cargar Tarifa ");
            System.out.println("4.) Cambiar Tarifa ");
            System.out.println("5.) Cargar Menú ");
            System.out.println("6.) Configurar Plato ");
            System.out.println("7.) Cerrar Sesión ");
            opcion = Integer.parseInt(input("\nSeleccione una opcion"));
            if (opcion == 1) {
                File archivoHabitaciones = new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/habitaciones.txt");
                empleado.cargarHabitaciones(archivoHabitaciones, this.tarifasEstandar, this.tarifasSuite,
                        this.tarifasSuite2, this.habitaciones);
            } else if (opcion == 2) {
                empleado.ejecutar_crearHabitacion(this.tarifasEstandar, this.tarifasSuite, this.tarifasSuite2,
                        habitaciones);
            } else if (opcion == 3) {
                File archivoTarifaEstandar = new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/tarifa.txt");
                File archivoTarifaSuite = new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/tarifa2.txt");
                File archivoTarifaSuite2 = new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/tarifa3.txt");
                empleado.cargarTarifa(archivoTarifaEstandar, this.tarifasEstandar);
                empleado.cargarTarifa(archivoTarifaSuite, this.tarifasSuite);
                empleado.cargarTarifa(archivoTarifaSuite2, this.tarifasSuite2);
            } else if (opcion == 4) {
                empleado.cambiarTarifa(this.tarifasEstandar, this.tarifasSuite, this.tarifasSuite2);
            } else if (opcion == 5) {
                File archivoMenu = new File(
                        "C:/Users/Santiago/Documents/UNIVERSIDAD ANDES/TERCER SEMESTRE/DPO/Proyecto1_Hotel/Proyecto1/entrega3/proyecto1_hotel/data/menu.txt");
                empleado.cargarMenu(archivoMenu, platos);
            } else if (opcion == 6) {
                String nombrePlato = input("Ingrese el nombre del plato a modificar");
                int opcion2 = Integer.parseInt(input(
                        "Que desea modificar? (NombrePlato: 1 NombreBebida: 2 Precio: 3 RangoHora: 4  Ubicacion:5)"));
                String mod = input("Ingrese la modificacion");
                empleado.configurarPlato(nombrePlato, opcion2, mod, this.platos);
            } else if (opcion == 7) {
                logOut();
            } else {
                System.out.println("Opcion Inválida");
            }
        } while (opcion != 7);
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
