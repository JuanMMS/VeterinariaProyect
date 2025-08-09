package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Cita {
    private String IDCita;
    private String fecha;
    private String hora;
    private LugarCita lugarCita;
    private Veterinario veterinario;
    private Mascota mascota;
    private Propietario propietario;
    private PersonalApoyo personalApoyo;

    public Cita(String IDCita, String fecha, String hora, LugarCita lugarCita, Veterinario veterinario, Mascota mascota, Propietario propietario, PersonalApoyo personalApoyo) {
        this.IDCita = IDCita;
        this.fecha = fecha;
        this.hora = hora;
        this.lugarCita = lugarCita;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.propietario = propietario;
        this.personalApoyo = personalApoyo;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public String getIDCita() {
        return IDCita;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setIDCita(String IDCita) {
        this.IDCita = IDCita;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public String getFecha() {
        return fecha;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public String getHora() {
        return hora;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public LugarCita getLugarCita() {
        return lugarCita;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setLugarCita(LugarCita lugarCita) {
        this.lugarCita = lugarCita;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public Veterinario getVeterinario() {
        return veterinario;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public Mascota getMascota() {
        return mascota;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public PersonalApoyo getPersonalApoyo() {
        return personalApoyo;
    }

    /*
    Metodos getter y setter de la clase CITA
     */
    public void setPersonalApoyo(PersonalApoyo personalApoyo) {
        this.personalApoyo = personalApoyo;
    }
}
