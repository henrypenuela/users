package com.userstest.users.controllers.TareasTest;

import com.userstest.users.Models.Tareas;
import com.userstest.users.controllers.TareasController;
import com.userstest.users.dao.TareaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class registrarTareasControllerTest {

    @Mock
    private TareaDao tareaDao;

    @InjectMocks
    private TareasController tareas;

    private Tareas tarea;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tarea = new Tareas();
        tarea.setId(1L);
        tarea.setActividad("PruebaTest");
    }

    @Test
    void registrarTarea() {
        doNothing().when(tareaDao).registrar(tarea);
        tareas.registrarTarea(tarea);
        verify(tareaDao, times(1)).registrar(tarea);
    }
}