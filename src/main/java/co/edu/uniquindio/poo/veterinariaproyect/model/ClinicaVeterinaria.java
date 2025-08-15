package co.edu.uniquindio.poo.veterinariaproyect.model;

import java.util.ArrayList;
import java.util.List;

public class ClinicaVeterinaria {

    private String nombre;
    private String ID;
    private List<Persona> listPersonas;
    private List<Mascota> listMascotas;
    private List<Consulta> listConsultas;
    private List<Cita> listCitas;
    private List<Tratamiento> listTratamientos;


    public ClinicaVeterinaria(String nombre, String ID) {
        this.nombre = nombre;
        this.ID = ID;
        this.listPersonas = new ArrayList<>();
        this.listMascotas= new ArrayList<>();
        this.listConsultas= new ArrayList<>();
        this.listCitas= new ArrayList<>();
        this.listTratamientos= new ArrayList<>();

    }

    /*
    Metodo para agregar tratamientos desde la clase ClinicaVeterinaria
     */
    public void agregarTratamiento(Tratamiento tratamiento) {
        listTratamientos.add(tratamiento);
    }

    /*
    Metodo para agregar Personas desde la clase ClinicaVeterinaria
     */
    public void agregarPersona(Persona persona) {
        listPersonas.add(persona);
    }

    /*
    Metodo para agregar Mascotas desde la clase ClinicaVeterinaria
     */
    public void agregarMascota(Mascota mascota) {
        listMascotas.add(mascota);
    }

    /*
    Metodo para agregar Consultas desde la clase ClinicaVeterina
     */
    public void agregarConsulta(Consulta consulta) {
        listConsultas.add(consulta);
    }

    /*
    Metodo para agregar Citas desde la clase ClinicaVeterinaria
    */
    public void agregarCita(Cita cita) {
        listCitas.add(cita);
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public String getNombre() {
        return nombre;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public String getID() {
        return ID;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    /*Metodos getter y setter de la clase ClinicaVeterinaria

     */
    public List<Consulta> getListConsultas() {
        return listConsultas;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setListConsultas(List<Consulta> listConsultas) {
        this.listConsultas = listConsultas;
    }

    /*
    Metodos getter y setter de la clase CliniicaVeterinaria
     */
    public List<Cita> getListCitas() {
        return listCitas;
    }

    /*
    Metodos getter y setter de la clase ClinicaVeterinaria
     */
    public void setListCitas(List<Cita> listCitas) {
        this.listCitas = listCitas;
    }

    /*
    Metodos getter y setter de la clase Clinica Veterinaria
     */

    public List<Tratamiento> getListTratamientos() {
        return listTratamientos;
    }

    /*
    Metodos getter y setter de la clase Clinica Veterinaria
     */
    public void setListTratamientos(List<Tratamiento> listTratamientos) {
        this.listTratamientos = listTratamientos;
    }

    /*
        Metodo eliminar persona desde la clase ClinicaVeterinaria
         */
    public void eliminarPersona(Persona persona) {
        listPersonas.remove(persona);
    }

    /*
     Metodo eliminar una mascota desde la clase ClinicaVeterinaria
     */
    public void eliminarMascota(Mascota mascota) {
        listMascotas.remove(mascota);
    }

    /*
    Metodo eliminar una consultas desde la clase ClinicaVeterinaria
     */
    public void eliminarConsultas(Consulta consulta) {
        listConsultas.remove(consulta);
    }

    /*
    Metodo eliminar citas desde la clase ClinicaVeterinaria
     */
    public void eliminarCitas(Cita cita) {
        listCitas.remove(cita);
    }

    /*
    Metodo eliminar tratamiento desde la clase ClinicaVeterinaria
     */
    public void eliminarTratamiento(Tratamiento tratamiento) {
        listTratamientos.remove(tratamiento);
    }


<<<<<<< Updated upstream

=======
    /**
     * Metodo para consultar citas de una fecha especifica
     * @param fechaBuscada
     * @return
     */

    public List<Cita> consultarCitasDiaEspecifico(String fechaBuscada) {
        List<Cita> citasEncontradas = new ArrayList<>();

        for (Cita cita : listCitas) {
            if (cita.getFecha().equals(fechaBuscada)) {
                citasEncontradas.add(cita);
            }
        }

        return citasEncontradas;
    }
>>>>>>> Stashed changes
}
