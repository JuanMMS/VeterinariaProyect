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

}
