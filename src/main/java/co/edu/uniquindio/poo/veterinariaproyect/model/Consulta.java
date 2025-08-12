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

    /*
    Metodos getter and setter de la clase Consulta
     */
    public String getFecha() {
        return fecha;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public String getiD() {
        return iD;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public String getHora() {
        return hora;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public String getMotivo() {
        return motivo;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public Cita getCita() {
        return cita;
    }

    /*
    Metodos getter and setter de la clase Consulta
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

}
