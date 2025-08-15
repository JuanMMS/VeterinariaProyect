package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Consulta {

    private String fecha;
    private String ID;
    private String hora;
    private String motivo;
    private Cita cita;

    public Consulta(String fecha, String ID, String hora, String motivo, Cita cita) {
        this.fecha = fecha;
        this.ID = ID;
        this.hora = hora;
        this.motivo = motivo;
        this.cita = cita;
    }

    // Metodos getter and setter de la clase Consulta
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha='" + fecha + '\'' +
                ", ID='" + ID + '\'' +
                ", hora='" + hora + '\'' +
                ", motivo='" + motivo + '\'' +
                ", cita=" + cita +
                '}';
    }
}