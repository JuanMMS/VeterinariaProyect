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

    /*
    Metodos getter y setter de la clase Mascota
     */
    public String getNombre() {
        return nombre;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public int getEdad() {
        return edad;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public String getIDVeterinario() {
        return IDVeterinario;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public void setIDVeterinario(String IDVeterinario) {
        this.IDVeterinario = IDVeterinario;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public TipoEspecie getTipoEspecie() {
        return tipoEspecie;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public void setTipoEspecie(TipoEspecie tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /*
    Metodos getter y setter de la clase Mascota
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
}
