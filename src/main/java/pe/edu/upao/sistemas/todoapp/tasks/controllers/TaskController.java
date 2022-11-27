package pe.edu.upao.sistemas.todoapp.tasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.todoapp.tasks.controllers.serializers.TaskSerializer;
import pe.edu.upao.sistemas.todoapp.tasks.models.Task;
import pe.edu.upao.sistemas.todoapp.tasks.services.TaskService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{id}")
    Task getTask(@PathVariable String id) {
        // TODO
        throw new IllegalArgumentException("");
    }

    @GetMapping("/")
    @RolesAllowed("ROLE_APIUSER")
    List<TaskSerializer> listTasks() {
        return taskService.list().stream().map(task -> new TaskSerializer(task.id, task.title, task.done)).toList();
    }


    @PostMapping("/")
    TaskSerializer createTask(@RequestBody TaskSerializer task) {
        Task taskCreated = taskService.create(new Task(-1, task.title, task.done));
        return new TaskSerializer(taskCreated.id, taskCreated.title, taskCreated.done);
    }

    @PostMapping("/update")
    TaskSerializer updateTask(@RequestBody TaskSerializer task) {
        Task taskUpdated = taskService.update(new Task(task.id, task.title, task.done));
        return new TaskSerializer(taskUpdated.id, taskUpdated.title, taskUpdated.done);
    }
}
