package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Propietario extends Persona {
    private String direccion;

    public Propietario(String nombre, String id, int telefono, String direccion) {
        super(nombre, id, telefono);
        this.direccion = direccion;


    }

    /*
    Metodos getter y setter de la clase Propietario
     */

<<<<<<< HEAD
=======
    /*
    Metodos getter y setter de la clase Propietario
     */

>>>>>>> 64668e7ce8245b7e57df2a72b22b4669e292f0dc
    public String getDireccion() {
        return direccion;
    }

    /*
    Metodos getter y setter de la clase Propietario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
<<<<<<< HEAD
=======


>>>>>>> 64668e7ce8245b7e57df2a72b22b4669e292f0dc
}
