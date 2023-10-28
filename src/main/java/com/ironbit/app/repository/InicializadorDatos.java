package com.ironbit.app.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ironbit.app.entity.Empleado;

@Component
public class InicializadorDatos implements CommandLineRunner {
    private final EmpleadosRepository empleadoRepository;

    public InicializadorDatos(EmpleadosRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void run(String... args) throws ParseException {
       SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
       empleadoRepository.save(new Empleado("Juan", "Carlos", "González", "Pérez", 28, "Masculino", formatoFecha.parse("15-01-1985"), "Gerente de Proyectos"));
       empleadoRepository.save(new Empleado("María", "Isabel", "López", "Martínez", 32, "Femenino", formatoFecha.parse("15-02-1986"), "Analista de Datos"));
       empleadoRepository.save(new Empleado("Pedro", "Antonio", "Ramírez", "Rodríguez", 25, "Masculino", formatoFecha.parse("15-03-1987"), "Desarrollador Senior"));
       empleadoRepository.save(new Empleado("Laura", "Patricia", "Díaz", "Fernández", 29, "Femenino", formatoFecha.parse("15-04-1988"), "Diseñadora Gráfica"));
       empleadoRepository.save(new Empleado("Roberto", "José", "Sánchez", "Gómez", 35, "Masculino", formatoFecha.parse("15-04-1989"), "Ingeniero de Software"));
       empleadoRepository.save(new Empleado("Ana", "María", "Hernández", "López", 27, "Femenino", formatoFecha.parse("15-06-1990"), "Analista de Negocios"));
       empleadoRepository.save(new Empleado("Carlos", "Andrés", "Martínez", "García", 30, "Masculino", formatoFecha.parse("15-07-1991"), "Desarrollador Frontend"));
       empleadoRepository.save(new Empleado("Sofía", "Cristina", "Pérez", "Fuentes", 31, "Femenino", formatoFecha.parse("15-08-1992"), "Gerente de Recursos Humanos"));
       empleadoRepository.save(new Empleado("Luis", "Fernando", "Gómez", "Vargas", 33, "Masculino", formatoFecha.parse("15-09-1993"), "Arquitecto de Soluciones"));
       empleadoRepository.save(new Empleado("Elena", "Isabel", "Rodríguez", "Torres", 26, "Femenino", formatoFecha.parse("15-10-1994"), "Analista de QA"));
    }
}
