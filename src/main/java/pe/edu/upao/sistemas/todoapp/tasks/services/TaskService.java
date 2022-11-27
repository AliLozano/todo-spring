package pe.edu.upao.sistemas.todoapp.tasks.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.tasks.models.Task;
import pe.edu.upao.sistemas.todoapp.tasks.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Task update(Task task) {
        Optional<Task> taskResult = taskRepository.findById(task.id);
        if (taskResult.isPresent()) {
            Task taskToUpdate = taskResult.get();
            taskToUpdate.done = task.done;
            taskRepository.save(taskToUpdate);
        }
        return task;
    }
}
