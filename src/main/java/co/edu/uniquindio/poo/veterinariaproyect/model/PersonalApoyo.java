package co.edu.uniquindio.poo.veterinariaproyect.model;

public class PersonalApoyo extends Persona {


<<<<<<< HEAD
=======
    private Cita cita;

    public PersonalApoyo(String nombre, String ID, int telefono, Cita cita) {
        super(nombre, ID, telefono);
        this.cita = cita;


    }

    /**
     * Metodo agendarCita con validacion que sea en diferente hora, lugar y sede y
     * se almacene en la lista de la clinica Veterinaria
     * @param cita
     * @param clinicaVeterinaria
     * @return
     */
    public boolean agendarCita(Cita cita, ClinicaVeterinaria clinicaVeterinaria) {
        for (Cita citaExistente : clinicaVeterinaria.getListCitas()) {
            boolean mismaFecha = citaExistente.getFecha().equals(cita.getFecha());
            boolean mismaHora = citaExistente.getHora().equals(cita.getHora());
            boolean mismaSede = citaExistente.getLugarCita() == cita.getLugarCita();

            if (mismaFecha && mismaHora && mismaSede) {
                return false;
            }
        }
        clinicaVeterinaria.getListCitas().add(cita);
        return true;
    }






>>>>>>> 64668e7ce8245b7e57df2a72b22b4669e292f0dc

    public PersonalApoyo(String nombre, String ID, int telefono) {
        super(nombre, ID, telefono);



    }

<<<<<<< HEAD
    /**
     * Metodo agendarCita con validacion que sea en diferente hora, lugar y sede y
     * se almacene en la lista de la clinica Veterinaria
     * @param cita
     * @param clinicaVeterinaria
     * @return
     */
=======


>>>>>>> 64668e7ce8245b7e57df2a72b22b4669e292f0dc
}
