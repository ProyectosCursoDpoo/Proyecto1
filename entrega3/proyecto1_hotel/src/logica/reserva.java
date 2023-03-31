package logica;

import java.util.ArrayList;

public class reserva {

  private int numeroReserva;
  private Grupo grupo;
  private int tarifaReserva;
  private String estado;
  private String fechaRealizada;
  private String rangoFechaReserva;
  private Empleado empleado;
  private ArrayList<Consumo> consumosPendientes;
  private ArrayList<Consumo> consumosPagos;
  private double saldoPendiente;

  public reserva(
      int numeroReserva,
      Grupo grupo,
      int tarifaReserva,
      String fechaRealizada,
      String rangoFechaReserva,
      Empleado empleado) {
    this.numeroReserva = numeroReserva;
    this.grupo = grupo;
    this.tarifaReserva = tarifaReserva;
    this.estado = "INICIADA";
    this.fechaRealizada = fechaRealizada;
    this.rangoFechaReserva = rangoFechaReserva;
    this.empleado = empleado;
    this.consumosPendientes = new ArrayList<Consumo>();
    this.consumosPagos = new ArrayList<Consumo>();
  }

  public int getNumeroReserva() {
    return this.numeroReserva;
  }

  public void setNumeroReserva(int numeroReserva) {
    this.numeroReserva = numeroReserva;
  }

  /**
   * @return Grupo return the grupo
   */
  public Grupo getGrupo() {
    return grupo;
  }

  /**
   * @param grupo the grupo to set
   */
  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  /**
   * @return int return the tarifaReserva
   */
  public int getTarifaReserva() {
    return tarifaReserva;
  }

  /**
   * @param tarifaReserva the tarifaReserva to set
   */
  public void setTarifaReserva(int tarifaReserva) {
    this.tarifaReserva = tarifaReserva;
  }

  /**
   * @return String return the estado
   */
  public String getEstado() {
    return estado;
  }

  /**
   * @param estado the estado to set
   */
  public void setEstado(String estado) {
    this.estado = estado;
  }

  /**
   * @return Date return the fechaRealizada
   */
  public String getFechaRealizada() {
    return fechaRealizada;
  }

  /**
   * @param fechaRealizada the fechaRealizada to set
   */
  public void setFechaRealizada(String fechaRealizada) {
    this.fechaRealizada = fechaRealizada;
  }

  /**
   * @return String return the rangoFechaReserva
   */
  public String getRangoFechaReserva() {
    return rangoFechaReserva;
  }

  /**
   * @param rangoFechaReserva the rangoFechaReserva to set
   */
  public void setRangoFechaReserva(String rangoFechaReserva) {
    this.rangoFechaReserva = rangoFechaReserva;
  }

  /**
   * @return Empleado return the empleado
   */
  public Empleado getEmpleado() {
    return empleado;
  }

  /**
   * @param empleado the empleado to set
   */
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public ArrayList<Consumo> getConsumosPendientes() {
    return consumosPendientes;
  }

  public ArrayList<Consumo> getConsumosPagos() {
    return consumosPagos;
  }

  public double getSaldoPendiente() {
    return saldoPendiente;
  }

  public void agregarConsumoPendiente(Consumo consumo) {
    consumosPendientes.add(consumo);
    saldoPendiente += consumo.getPrecioTotal(); // iqoprepjdaklsmdakmdqoiwjepqejapwd
  }

  public void agregarConsumoPago(Consumo consumo) {
    consumosPagos.add(consumo);
  }

  @Override
  public String toString() {
    String cadena = "";
    cadena += getNumeroReserva() + ";";
    cadena += getGrupo().getId() + ";";
    cadena += getTarifaReserva() + ";";
    cadena += getFechaRealizada().substring(0, 5).replace(".", "") + ";";
    cadena += getRangoFechaReserva() + ";";
    cadena += getEmpleado().getUsuario() + "\n";

    return cadena;
  }
}
