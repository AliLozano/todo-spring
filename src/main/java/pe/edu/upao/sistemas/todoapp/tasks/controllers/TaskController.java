package pe.edu.upao.sistemas.todoapp.tasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
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
    List<Task> listTasks() {
        return taskService.list();
    }


    @PostMapping("/")
    Task createTask(@RequestBody Task task) {
        return taskService.create(task);
    }
}
