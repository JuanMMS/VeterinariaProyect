package co.edu.uniquindio.poo.veterinariaproyect.controller;

import co.edu.uniquindio.poo.veterinariaproyect.App;
import co.edu.uniquindio.poo.veterinariaproyect.model.Cita;
import co.edu.uniquindio.poo.veterinariaproyect.model.LugarCita;
import co.edu.uniquindio.poo.veterinariaproyect.model.Veterinario;
import co.edu.uniquindio.poo.veterinariaproyect.model.Mascota;
import co.edu.uniquindio.poo.veterinariaproyect.model.Propietario;
import co.edu.uniquindio.poo.veterinariaproyect.model.PersonalApoyo;
import java.util.List;
import java.util.Optional;
public class CitasController {

    public List<Cita> obtenerTodasLasCitas() {
        return App.clinica1.getListCitas();
    }

    public Cita crearNuevaCita(String idCita, String fecha, String hora, LugarCita lugarCita, Veterinario veterinario, Mascota mascota, Propietario propietario, PersonalApoyo personalApoyo) {
        // Verifica si ya existe una cita con el mismo ID.
        Optional<Cita> citaExistente = App.clinica1.getListCitas().stream()
                .filter(c -> c.getIDCita().equals(idCita))
                .findFirst();

        if (citaExistente.isPresent()) {
            return null; // Retorna null si la cita ya existe.
        }

        Cita nuevaCita = new Cita(idCita, fecha, hora, lugarCita, veterinario, mascota, propietario, personalApoyo);
        App.clinica1.getListCitas().add(nuevaCita);
        return nuevaCita; // Retorna el objeto Cita recién creado.
    }

    public void eliminarCita(Cita cita) {
        App.clinica1.getListCitas().remove(cita);
    }

    public void actualizarCita(Cita citaOriginal, String nuevaFecha, String nuevaHora, LugarCita nuevoLugar, Veterinario nuevoVeterinario, Mascota nuevaMascota, Propietario nuevoPropietario, PersonalApoyo nuevoPersonalApoyo, String nuevoID) {
        citaOriginal.setIDCita(nuevoID);
        citaOriginal.setFecha(nuevaFecha);
        citaOriginal.setHora(nuevaHora);
        citaOriginal.setLugarCita(nuevoLugar);
        citaOriginal.setVeterinario(nuevoVeterinario);
        citaOriginal.setMascota(nuevaMascota);
        citaOriginal.setPropietario(nuevoPropietario);
        citaOriginal.setPersonalApoyo(nuevoPersonalApoyo);
    }
}