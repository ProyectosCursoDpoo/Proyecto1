package logica;

import java.util.*;

public class Factura {

    public int id;
    public String fecha;
    public Grupo grupo;
    public ArrayList<Servicios> serviciosExtra;
    public int impuesto;
    public int tarifaTotal;

    public Factura(int id, String fecha, Grupo grupo, ArrayList<Servicios> serviciosExtra, int impuesto,
            int tarifaTotal) {
        this.id = id;
        this.fecha = fecha;
        this.grupo = grupo;
        this.serviciosExtra = serviciosExtra;
        this.impuesto = impuesto;
        this.tarifaTotal = tarifaTotal;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setServiciosExtra(ArrayList<Servicios> serviciosExtra) {
        this.serviciosExtra = serviciosExtra;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public void setTarifaTotal(int tarifaTotal) {
        this.tarifaTotal = tarifaTotal;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public ArrayList<Servicios> getServiciosExtra() {
        return serviciosExtra;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public int getTarifaTotal() {
        return tarifaTotal;
    }

}
