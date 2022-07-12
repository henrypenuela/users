package com.userstest.users.controllers.TareasTest;

import com.userstest.users.Models.Tareas;
import com.userstest.users.controllers.TareasController;
import com.userstest.users.dao.TareaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TareasControllerTest {

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
    void getTareas() {
        when(tareaDao.getTareas()).thenReturn(Arrays.asList(tarea));
        assertNotNull(tareas.getTareas());
    }
}