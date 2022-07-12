package com.userstest.users.dao;
import com.userstest.users.Models.Tareas;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TareaDaoImp implements TareaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Tareas> getTareas() {
        String query = "FROM Tareas";
        List<Tareas> resultado = entityManager.createQuery(query).getResultList();
        return  resultado;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Tareas tareas = entityManager.find(Tareas.class, id);
        entityManager.remove(tareas);
    }

    @Override
    public void registrar(Tareas tareas) {
        entityManager.merge(tareas);
    }
}
