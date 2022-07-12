package com.userstest.users.dao;
import com.userstest.users.Models.Tareas;
import java.util.List;

public interface TareaDao {
    List<Tareas> getTareas();

    void eliminar(Long id);

    void registrar(Tareas tareas);
}
