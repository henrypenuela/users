package com.userstest.users.controllers.TareasTest;

import com.userstest.users.controllers.TareasController;
import com.userstest.users.dao.TareaDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EliminarTareasControllerTest {

    @Mock
    private TareaDao tareaDao;

    @InjectMocks
    private TareasController tareas;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void eliminar() {
        doNothing().when(tareaDao).eliminar(1L);
        tareas.eliminar(1L);
        verify(tareaDao, times(1)).eliminar(1L);
    }
}