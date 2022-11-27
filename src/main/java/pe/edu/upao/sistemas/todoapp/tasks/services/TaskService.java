package pe.edu.upao.sistemas.todoapp.tasks.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.tasks.models.Task;
import pe.edu.upao.sistemas.todoapp.tasks.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    final private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> list() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        task.title = task.title.toUpperCase();
        return taskRepository.save(task);
    }
}
