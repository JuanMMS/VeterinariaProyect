package co.edu.uniquindio.poo.veterinariaproyect.model;

public class Mascota {

    private String nombre;
    private int edad;
    private String IDVeterinario;
    private TipoEspecie tipoEspecie;
    private Propietario propietario;

    public Mascota(String nombre, int edad, String IDVeterinario, TipoEspecie tipoEspecie, Propietario propietario) {
        this.nombre = nombre;
        this.edad = edad;
        this.IDVeterinario = IDVeterinario;
        this.tipoEspecie = tipoEspecie;
        this.propietario = propietario;

    }
}
