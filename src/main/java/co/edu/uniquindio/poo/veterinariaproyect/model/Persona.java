package co.edu.uniquindio.poo.veterinariaproyect.model;

public abstract class Persona {

    protected String nombre;
    protected String ID;
    protected int telefono;

    public Persona(String nombre, String ID, int telefono) {
        this.nombre = nombre;
        this.ID = ID;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Este método es abstracto y debe ser implementado por cada clase hija.
    public abstract String getRol();

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", ID='" + ID + '\'' +
                ", telefono=" + telefono +
                '}';
    }

}