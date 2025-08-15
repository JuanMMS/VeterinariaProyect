package co.edu.uniquindio.poo.veterinariaproyect.model;

public class PersonalApoyo extends Persona {




    public PersonalApoyo(String nombre, String ID, int telefono, Cita cita) {
        super(nombre, ID, telefono);


    }

    /**
     * Metodo agendarCita con validacion que sea en diferente hora, lugar y sede y
     * se almacene en la lista de la clinica Veterinaria
     * @return
     */
    //public boolean agendarCita(Cita cita, ClinicaVeterinaria clinicaVeterinaria) {
        //for (Cita citaExistente : clinicaVeterinaria.getListCitas()) {
           // boolean mismaFecha = citaExistente.getFecha().equals(cita.getFecha());
           // boolean mismaHora = citaExistente.getHora().equals(cita.getHora());
           // boolean mismaSede = citaExistente.getLugarCita() == cita.getLugarCita();

          //  if (mismaFecha && mismaHora && mismaSede) {
             //   return false;
          //  }
       // }
      //  clinicaVeterinaria.getListCitas().add(cita);
       // return true;
   // }
    public PersonalApoyo(String nombre, String ID, int telefono) {
        super(nombre, ID, telefono);



    }
    @Override
    public String getRol() {
        return "Personal Apoyo";
    }

}
