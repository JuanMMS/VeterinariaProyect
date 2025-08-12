package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import co.edu.uniquindio.poo.veterinariaproyect.model.Persona;
import co.edu.uniquindio.poo.veterinariaproyect.model.Propietario;
import co.edu.uniquindio.poo.veterinariaproyect.model.TipoEspecie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

import static co.edu.uniquindio.poo.veterinariaproyect.App.clinica1;

public class MascotaController {

    public MascotaController() {
    }

    public ObservableList<Mascota> obtenerMascotas() {
        if (clinica1 != null && clinica1.getListMascotas() != null) {
            return FXCollections.observableArrayList(clinica1.getListMascotas());
        }
        return FXCollections.observableArrayList();
    }

    public void agregarMascota(Mascota mascota) {
        if (clinica1 != null) {
            clinica1.agregarMascota(mascota);
        }
    }

    public void eliminarMascota(Mascota mascota) {
        if (clinica1 != null) {
            clinica1.eliminarMascota(mascota);
        }
    }

    public ObservableList<TipoEspecie> obtenerEspecies(){
        return FXCollections.observableArrayList(TipoEspecie.values());
    }

    public ObservableList<Propietario> obtenerPropietarios() {
        ObservableList<Propietario> propietarios = FXCollections.observableArrayList();
        if (clinica1 != null && clinica1.getListPersonas() != null) {
            List<Persona> listPersonas = clinica1.getListPersonas();
            for (Persona persona : listPersonas) {
                if (persona instanceof Propietario) {
                    propietarios.add((Propietario) persona);
                }
            }
        }
        return propietarios;
    }
}