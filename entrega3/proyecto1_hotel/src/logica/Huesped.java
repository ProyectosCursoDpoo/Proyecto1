package logica;
import java.util.ArrayList;


public class Huesped {
    public String nombre;
    public int identificacion;
    public String correo;
    public String celular;
    public String fechaNacimiento;
    private ArrayList<Consumo> consumosPendientes;
    private ArrayList<Consumo> consumosPagos;
    private double saldoPendiente;

    
    public Huesped(String nombre, int identificacion, String correo, String celular, String fechaNacimiento) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.consumosPendientes = new ArrayList<Consumo>();
        this.consumosPagos = new ArrayList<Consumo>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Consumo> getConsumosPendientes() {
        return consumosPendientes;
    }

    public ArrayList<Consumo> getConsumosPagos(){
        return consumosPagos;
    }

    public double getSaldoPendiente(){
        return saldoPendiente;
    }
    
    public void agregarConsumoPendiente(Consumo consumo){
        consumosPendientes.add(consumo);
        saldoPendiente += consumo.getPrecioIndv(); //iqoprepjdaklsmdakmdqoiwjepqejapwd
    }

    public void agregarConsumoPago(Consumo consumo){
        consumosPagos.add(consumo);
    }
    
}
