package logica;

import java.util.*;

public class Hotel {

    ArrayList<Habitacion> habitaciones;
    ArrayList<Servicios> servicios;
    ArrayList<Huesped> huespedes;
    ArrayList<Factura> facturas;
    ArrayList<Reserva> reservas;

    public void login(String usuario, String contrasena){
        System.out.println("LOGIN");

    }

    public void logOut(){
        System.out.println("Logout");
    }

    public void cargarInformacion(){
        System.out.println("cargarInfo");
    }

    public void guardarInfo(){
        System.out.println("guardarInfo");
    }

    
    
}
