package co.edu.uniquindio.poo.veterinariaproyect.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioTest {

    @Test
    void consultarHistorialMedico() {
        ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos", "222");
        Propietario propietario = new Propietario("Ana Gómez", "456", 322222222, "Cra 15 #8-50");
        Mascota mascota = new Mascota("Firulais", 5, "000", TipoEspecie.PERRO, propietario);
        clinica.agregarMascota(mascota);
        Veterinario veterinario = new Veterinario("Laura", "888", 312741, EspecialidadVeterinario.GENERAL, "GNU", true);
        clinica.agregarPersona(veterinario);
        PersonalApoyo personalApoyo = new PersonalApoyo("Manuel", "PPP", 312724);
        Cita cita = new Cita("888", "12/09/25", "5:00AM", LugarCita.SEDENORTE, veterinario, mascota, propietario, personalApoyo);
        Tratamiento tratamiento = new Tratamiento("T01", "Desparasitación", "7 días", "Ivermectina");
        clinica.agregarTratamiento(tratamiento);
        Consulta consulta = new Consulta("2025-08-16", "C01", "10:00 AM", "dolor", cita, tratamiento);
        clinica.agregarConsulta(consulta);
        String historial = veterinario.consultarHistorialMedico(clinica, "C01", "T01");

        assertTrue(historial.contains("C01"));
        assertTrue(historial.contains("T01"));
        assertTrue(historial.contains("dolor"));
        assertTrue(historial.contains("Ivermectina"));
    }
}