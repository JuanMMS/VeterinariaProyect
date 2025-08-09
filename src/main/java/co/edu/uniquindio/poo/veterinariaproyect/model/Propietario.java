package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Propietario extends Persona {
    private String direccion;

    public Propietario(String nombre, String id, int telefono, String direccion) {
        super(nombre, id, telefono);
        this.direccion = direccion;


    }


}
