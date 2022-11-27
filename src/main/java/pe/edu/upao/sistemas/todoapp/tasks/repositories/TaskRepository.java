package pe.edu.upao.sistemas.todoapp.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.accounts.repositories.UserRepositoryJPA;
import pe.edu.upao.sistemas.todoapp.tasks.models.Task;

import java.util.ArrayList;
import java.util.List;

@Service
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("select t from Task t")
    List<Task> listByUser(Integer id);
}
