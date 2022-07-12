package com.userstest.users.controllers;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.userstest.users.Models.Tareas;
import com.userstest.users.dao.TareaDao;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TareasController {

    @Autowired
    private TareaDao tareaDao;

    @Operation(summary = "lista las tareas existentes")
    @RequestMapping(value = "api/tareas" , method = RequestMethod.GET)
    public List<Tareas> getTareas()
    {
        return tareaDao.getTareas();
    }

    @Operation(summary = "api con filtro por Id", description = "Formato -> Numerico")
    @RequestMapping(value = "api/tareasfilter" , method = RequestMethod.GET)
    public List<Tareas> getTareasFilter(@RequestParam Long id)
    {
        List<Tareas> result = tareaDao.getTareas();
        return  result.stream().
                filter(p -> p.getId().equals(id)).
                findFirst().stream().toList();
    }

    @Operation(summary = "api con filtro - Trae datos con fechas mayor que", description = "Formato -> Mes/Dia/Año Ejemplo -> 07/01/2022")
    @JsonFormat(pattern="yyyy-MM-dd")
    @RequestMapping(value = "api/tareasfilterDate" , method = RequestMethod.GET)
    public List<Tareas> getTareasFilterDate(@RequestParam Date date)
    {
        List<Tareas> result = tareaDao.getTareas();
        return  result.stream().filter(u -> u.getFecha().after(date))
                    .collect(Collectors.toList());
    }

    @Operation(summary = "Registra las tareas")
    @RequestMapping(value = "api/tareas" , method = RequestMethod.POST)
    public void registrarTarea(@RequestBody  Tareas tareas)
    {
        tareaDao.registrar(tareas);
    }

    @Operation(summary = "Elimina la tarea por ID")
    @RequestMapping(value = "api/tareas/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id)
    {
        tareaDao.eliminar(id);
    }
}