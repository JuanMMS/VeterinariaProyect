package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class CitasController {

    public ObservableList<Cita> obtenerTodasLasCitas() {
        List<Cita> citas = App.clinica1.getListCitas();
        return FXCollections.observableArrayList(citas);
    }

    public void crearNuevaCita(String fecha, String hora, LugarCita lugarCita, Veterinario veterinario, Mascota mascota, Propietario propietario, PersonalApoyo personalApoyo) {
        String id = "CITA-" + (App.clinica1.getListCitas().size() + 1);
        Cita nuevaCita = new Cita(id, fecha, hora, lugarCita, veterinario, mascota, propietario, personalApoyo);
        App.clinica1.getListCitas().add(nuevaCita);
    }

    public void eliminarCita(Cita cita) {
        App.clinica1.getListCitas().remove(cita);
    }

    public void actualizarCita(Cita citaOriginal, String nuevaFecha, String nuevaHora, LugarCita nuevoLugar, Veterinario nuevoVeterinario, Mascota nuevaMascota, Propietario nuevoPropietario, PersonalApoyo nuevoPersonalApoyo, String nuevoID) {
        citaOriginal.setFecha(nuevaFecha);
        citaOriginal.setHora(nuevaHora);
        citaOriginal.setLugarCita(nuevoLugar);
        citaOriginal.setVeterinario(nuevoVeterinario);
        citaOriginal.setMascota(nuevaMascota);
        citaOriginal.setPropietario(nuevoPropietario);
        citaOriginal.setPersonalApoyo(nuevoPersonalApoyo);
        citaOriginal.setIDCita(nuevoID);
    }
}