package com.userstest.users.dao;
import com.userstest.users.Models.Usuario;
import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);
}
