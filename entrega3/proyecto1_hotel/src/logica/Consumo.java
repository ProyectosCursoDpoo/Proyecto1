package logica;
import java.util.ArrayList;


public class Consumo {

    public ArrayList<Huesped> huesped;
    public Servicios servicios;
    public int precioIndv;


    public Consumo(ArrayList<Huesped> huesped, Servicios servicios) {
        this.huesped = huesped;
        this.servicios = servicios;
        this.precioIndv = servicios.getPrecio();
        
    }

    public void sethuesped(ArrayList<Huesped> huesped) {
        this.huesped = huesped;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public void setprecioIndv(int precioIndv) {
        this.precioIndv = precioIndv;
    }

    public ArrayList<Huesped> gethuesped() {
        return huesped;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public int getPrecioIndv() {
        return precioIndv;
    }

    
    //public double getTotal(){
      //  return precioIndv * huesped.size();
    //}
    
}
