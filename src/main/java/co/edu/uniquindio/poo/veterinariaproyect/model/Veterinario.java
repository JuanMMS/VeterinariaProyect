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


    /**
     * Metodo para ver el historial que lleva el toString de la consuta y el tratamiento
     * @param clinica
     * @param IDConsulta
     * @param IDTratamiento
     * @return
     */
    public String consultarHistorialMedico(ClinicaVeterinaria clinica, String IDConsulta, String IDTratamiento) {
        Consulta consultaEncontrada = null;
        Tratamiento tratamientoEncontrado = null;

        for (Consulta consulta : clinica.getListConsultas()) {
            if (consulta.getID().equals(IDConsulta)) {
                consultaEncontrada = consulta;
                break;
            }
        }

        for (Tratamiento tratamiento : clinica.getListTratamientos()) {
            if (tratamiento.ID().equals(IDTratamiento)) {
                tratamientoEncontrado = tratamiento;
                break;
            }
        }

        return consultaEncontrada.toString() + "\n" + tratamientoEncontrado.toString();
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
