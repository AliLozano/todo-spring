package pe.edu.upao.sistemas.todoapp.tasks.controllers.serializers;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TaskSerializer {
    public Integer id = -1;
    public String title;
    public boolean done;
}
