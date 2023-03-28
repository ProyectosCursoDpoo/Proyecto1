package logica;

import java.util.ArrayList;

public class Grupo {

    public ArrayList<Huesped> huespedes;
    public ArrayList<Habitacion> habitaciones;

    public Grupo(ArrayList<Huesped> huespedes, ArrayList<Habitacion> habitaciones) {
        this.huespedes = huespedes;
        this.habitaciones = habitaciones;


        
    }

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
     

}
