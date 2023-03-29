package logica;
import java.util.ArrayList;


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

    private void registrarServicio(ArrayList<Huesped> huesped, Servicios servicio, Factura factura, boolean pago){
        System.out.println("Registrar Servicio");
    }

    private void generarFactura(ArrayList<Huesped> huesped, Servicios servicio){
        System.out.println("Generar Factura");
    }

    private void getHuesped(){
        System.out.println("Get Huesped");
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
