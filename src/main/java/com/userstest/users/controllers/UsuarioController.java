package com.userstest.users.controllers;

import com.userstest.users.Models.Usuario;
import com.userstest.users.dao.UsuarioDao;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Operation(summary = "lista los Usuarios existentes")
    @RequestMapping(value = "api/usuarios" , method = RequestMethod.GET)
    public List<Usuario> getUsuarios()
    {
        return usuarioDao.getUsuarios();
    }

    @Operation(summary = "api con filtro por apellido", description = "Formato -> String")
    @RequestMapping(value = "api/usuariosfilter" , method = RequestMethod.GET)
    public List<Usuario> getUsuariosfilter(@RequestParam String apellido)
    {
        List<Usuario> result = usuarioDao.getUsuarios();
        return  result.stream().
            filter(p -> p.getApellido().equals(apellido)).
            findFirst().stream().toList();
    }

    @Operation(summary = "Registra la usuario por ID")
    @RequestMapping(value = "api/usuarios" , method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody  Usuario usuario)
    {
        usuarioDao.registrar(usuario);
    }

    @Operation(summary = "Elimina la usuario por ID")
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id)
    {
        usuarioDao.eliminar(id);
    }

}
