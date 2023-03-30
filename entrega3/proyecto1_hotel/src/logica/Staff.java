package logica;
import java.util.*; 

public class Staff extends Empleado {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String ocupacion;

    public Staff(String usuario, String contrasena, String nombre, String ocupacion) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
    }
    
    public void registrarServicioPago(int numReserva, HashMap<Integer, Reserva> reserva, String nombreServicios){
        Reserva reservaActual = reserva.get(numReserva); 
        Servicios servicio = null;
        if (nombreServicios.equals("Spa")){
            servicio = new Spa();
        }
        else if (nombreServicios.equals("Restaurante")){
            servicio = new Restaurante();
        }
        else if (nombreServicios.equals("GuiaTuristica")){
            servicio = new GuiaTuristica();
        }
    
        
        Consumo consumo = new Consumo(reservaActual, servicio);
        reservaActual.agregarConsumoPago(consumo);
        generarFactura(consumo);
        
    }

    public void registrarServicioPendiente(int numReserva, HashMap<Integer, Reserva> reserva, String nombreServicios){
        Reserva reservaActual = reserva.get(numReserva); 
        Servicios servicio = null;
        if (nombreServicios.equals("Spa")){
            servicio = new Spa();
        }
        else if (nombreServicios.equals("Restaurante")){
            servicio = new Restaurante();
        }
        else if (nombreServicios.equals("GuiaTuristica")){
            servicio = new GuiaTuristica();
        }
    
        
        Consumo consumo = new Consumo(reservaActual, servicio);
        reservaActual.agregarConsumoPendiente(consumo);
    }


    public void generarFactura(Consumo consumo){
        if (consumo.getServicios().getNombre().equals("Restaurante")) {
            System.out.println("Factura Restaurante: ");
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());

        }
        else{
            System.out.println("Factura: ");
            System.out.println("Reserva numero: " + consumo.getReserva().getNumeroReserva());
            System.out.println("Servicio: " + consumo.getServicios().getNombre());
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

    
}
