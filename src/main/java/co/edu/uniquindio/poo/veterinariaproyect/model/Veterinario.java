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

    /*
    Metodos getter y setter de la clase Veterinario
     */

    public String getEspecialidad() {
        return especialidad;
    }

    /*
    Metodos getter y setter de la clase Veterinario
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /*
    Metodos getter y setter de la clase Veterinario
     */
    public String getLicencia() {
        return licencia;
    }

    /*
    Metodos getter y setter de la clase Veterinario
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /*
    Metodos getter y setter de la clase Veterinario
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /*
    Metodos getter y setter de la clase Veterinario
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
