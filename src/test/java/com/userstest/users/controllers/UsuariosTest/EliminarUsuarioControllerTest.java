package com.userstest.users.controllers.UsuariosTest;

import com.userstest.users.Models.Usuario;
import com.userstest.users.controllers.UsuarioController;
import com.userstest.users.dao.UsuarioDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EliminarUsuarioControllerTest {

    @Mock
    private UsuarioDao usuarioDao;

    @InjectMocks
    private UsuarioController usuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void eliminar() {
        doNothing().when(usuarioDao).eliminar(1L);
        usuarios.eliminar(1L);
        verify(usuarioDao, times(1)).eliminar(1L);
    }
}