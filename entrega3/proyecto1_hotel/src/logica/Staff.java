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


    
    public void registrarServicioPago(HashMap<Integer, Reserva> reserva, HashMap<String, Plato> menu, boolean pago){
        int numReserva = Integer.parseInt(input("Ingrese su numero de reserva"));
        int nombreServicios = Integer.parseInt(input("Ingrese el numero del servicio que desea pagar: \n 1. Spa \n 2. Restaurante \n 3. Guia Turistica"));

        Reserva reservaActual = reserva.get(numReserva); 
        Servicios servicio = null;
        if (nombreServicios == 1){
            servicio = new Spa();
        }
        else if (nombreServicios == 2){

            servicio = new Restaurante();
            mostrarMenuRestaurante(menu, (Restaurante) servicio);

        }
        else if (nombreServicios == 3){
            servicio = new GuiaTuristica();
        }
        else{
            System.out.println("Porfavor ingrese un numero valido");
        }

        Consumo consumo = new Consumo(reservaActual, servicio);

        if (pago){
            reservaActual.agregarConsumoPago(consumo);
            generarFactura(consumo);
            System.out.println("Factura generada para el servicio - pago realizado");
        }
        else{
            reservaActual.agregarConsumoPendiente(consumo);
            System.out.println("El consumo del servicio se ha agregado a su cuenta pendiente");
        }
    }

    public void mostrarMenuRestaurante(HashMap<String, Plato> menu, Restaurante servicio){
        int n = 1;
        ArrayList<Plato> platos = new ArrayList<Plato>();
        LocalDateTime actual = LocalDateTime.now();
        int hora = actual.getHour();
        System.out.println("Los productos disponibles en el Menu en este momento (" + hora + "h) son: ");
        for (Map.Entry<String, Plato> entry : menu.entrySet()) {
            if (entry.getValue().getHoraInicio() <= hora && entry.getValue().getHoraFin() >= hora){
                System.out.println(n + ". " + entry.getKey() + " " + entry.getValue().getNombrePlato() + " " + entry.getValue().getPrecio());
                platos.add(entry.getValue());
            }
            n += 1;
        }

        realizarPedidoRestaurante(platos, servicio);
    }

    public void realizarPedidoRestaurante(ArrayList<Plato> platos, Restaurante servicio){
        boolean terminarOrden = false;
        while (!terminarOrden){
            int opcion = Integer.parseInt(input("Ingrese el numero del plato que desea ordenar"));
            Plato plato = platos.get(opcion);
            servicio.agregarPlato(plato);

            String continuar = input("Desea agregar otro plato? (s/n)");
            if (continuar.equals("n")){
                terminarOrden = true;
            }
        }
    }
    
    public void generarFactura(Consumo consumo){
        if (consumo.getServicio().getNombre().equals("Restaurante")){
            Restaurante restaurante = (Restaurante) consumo.getServicio();
            System.out.println("Factura Restaurante: ");
            System.out.println("---------------------");
            ArrayList<Plato> platos = restaurante.getPlatos();
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Platos ordenados:");
            int total = 0;
            for (Plato plato : platos){
                System.out.println(plato.getNombrePlato() + " - $" + plato.getPrecio());
                total += plato.getPrecio();
            }
            System.out.println("---------------------");
            System.out.println("Precio total: $" + total);    
        } 
        else{
            System.out.println("Factura: ");
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Servicio: " + consumo.getServicio().getNombre());
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
