package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Veterinario extends Persona{

    private String especialidad;
    private String licencia;
    private boolean disponibilidad;

    public Veterinario(String nombre, String ID, int telefono, String especialidad, String licencia, boolean disponibilidad) {
        super(nombre, ID, telefono);
        this.especialidad = especialidad;
        this.licencia = licencia;
        this.disponibilidad = disponibilidad;

    }

}
