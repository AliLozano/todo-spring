package pe.edu.upao.sistemas.todoapp.tasks.models;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id = -1;
    public String title;

    public boolean done;
}
