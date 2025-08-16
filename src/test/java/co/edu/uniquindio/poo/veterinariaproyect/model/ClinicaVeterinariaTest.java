package co.edu.uniquindio.poo.veterinariaproyect.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClinicaVeterinariaTest {

    @Test
    void agregarTratamiento() {
                ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos", "222");
                Tratamiento tratamiento = new Tratamiento("T001", "Vacunación", "1 dosis", "Rabia");
                clinica.agregarTratamiento(tratamiento);
                assertEquals(1, clinica.getListTratamientos().size());
                assertEquals("Vacunación", clinica.getListTratamientos().get(0).nombre());
                assertEquals("Rabia", clinica.getListTratamientos().get(0).medicamento());
            }



    @Test
    void agregarPersona() {
        ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos", "222");
        Propietario propietario = new Propietario("Juan Pérez", "123", 311111111, "Calle 10 #5-20");
        clinica.agregarPersona(propietario);
        assertEquals(1, clinica.getListPersonas().size());
        assertEquals("Juan Pérez", clinica.getListPersonas().get(0).getNombre());
        assertEquals("123", clinica.getListPersonas().get(0).getID());
    }

    @Test
    void agregarMascota() {
        ClinicaVeterinaria clinica = new ClinicaVeterinaria("Clínica Animalitos", "222");
        Propietario propietario = new Propietario("Ana Gómez", "456", 322222222, "Cra 15 #8-50");
        Veterinario veterinario = new Veterinario("Laura", "888", 312741, EspecialidadVeterinario.GENERAL, "GNU", true);

        Mascota mascota = new Mascota("Firulais", 5, "000", TipoEspecie.PERRO, propietario);

        clinica.agregarMascota(mascota);

        assertEquals(1, clinica.getListMascotas().size());
        assertEquals("Firulais", clinica.getListMascotas().get(0).getNombre());
        assertEquals(TipoEspecie.PERRO, clinica.getListMascotas().get(0).getTipoEspecie());
    }


    @Test
    void agregarConsulta() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.agregarConsulta(consulta);
        assertEquals(1, clinica.getListConsultas().size());

    }

    @Test
    void agregarCita() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.agregarCita(cita);
        assertEquals(1, clinica.getListCitas().size());

    }

    @Test
    void eliminarPersona() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.eliminarPersona(propietario);
        clinica.eliminarPersona(personalApoyo);
        clinica.eliminarPersona(veterinario);
        assertEquals(0, clinica.getListPersonas().size());

    }

    @Test
    void eliminarMascota() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.eliminarMascota(mascota);
        assertEquals(0, clinica.getListMascotas().size());

    }

    @Test
    void eliminarConsultas() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.eliminarConsultas(consulta);
        assertEquals(0, clinica.getListConsultas().size());

    }

    @Test
    void eliminarCitas() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.eliminarCitas(cita);
        assertEquals(0, clinica.getListCitas().size());

    }

    @Test
    void eliminarTratamiento() {
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
        Consulta consulta = new Consulta("C01", "2025-08-16", "10:00 AM", "dolor", cita, tratamiento);
        clinica.eliminarTratamiento(tratamiento);
        assertEquals(0, clinica.getListTratamientos().size());

    }

    @Test
    void consultarCitasDiaEspecifico() {
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
        assertEquals(1, clinica.getListConsultas().size());
        assertNotNull(consulta);
        assertEquals("C01", consulta.getID());
        assertEquals("Firulais", consulta.getCita().getMascota().getNombre());
        assertEquals("Laura", consulta.getCita().getVeterinario().getNombre());
        assertEquals(LugarCita.SEDENORTE, consulta.getCita().getLugarCita());
    }
}