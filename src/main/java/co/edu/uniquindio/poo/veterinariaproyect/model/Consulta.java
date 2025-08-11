package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Consulta {
    private String fecha;
    private String iD;
    private String hora;
    private String motivo;
    private Cita cita;

    public Consulta(String fecha, String iD, String hora, String motivo, Cita cita) {
        this.fecha = fecha;
        this.iD = iD;
        this.hora = hora;
        this.motivo = motivo;
        this.cita = cita;
    }

    /**
     * Métodos getter y setter de los atributos de la clase Consulta
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
