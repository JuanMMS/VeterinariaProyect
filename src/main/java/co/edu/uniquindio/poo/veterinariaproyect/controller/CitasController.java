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

    // Este método ahora devuelve un booleano para indicar si la cita se agregó o no.
    public boolean crearNuevaCita(String id, String fecha, String hora, LugarCita lugarCita, Veterinario veterinario, Mascota mascota, Propietario propietario, PersonalApoyo personalApoyo) {
        Cita nuevaCita = new Cita(id, fecha, hora, lugarCita, veterinario, mascota, propietario, personalApoyo);

        // agendarCita devuelve true si se agrega, y false si hay un duplicado.
        boolean citaAgendada = personalApoyo.agendarCita(nuevaCita, App.clinica1);

        return citaAgendada;
    }

    public void eliminarCita(Cita cita) {
        App.clinica1.eliminarCitas(cita);
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