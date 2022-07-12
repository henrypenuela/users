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

class RegistrarUsuarioControllerTest {

    @Mock
    private UsuarioDao usuarioDao;

    @InjectMocks
    private UsuarioController usuarios;

    private Usuario usuario;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("PruebaTest1");
        usuario.setApellido("PruebaTest2");
        usuario.setEmail("PruebaTest3");
        usuario.setTelefono("PruebaTest4");
        usuario.setPassword("PruebaTest5");
    }

    @Test
    void registrarUsuario() {
        doNothing().when(usuarioDao).registrar(usuario);
        usuarios.registrarUsuario(usuario);
        verify(usuarioDao, times(1)).registrar(usuario);

    }
}