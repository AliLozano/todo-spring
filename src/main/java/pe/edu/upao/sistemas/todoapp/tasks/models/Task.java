package pe.edu.upao.sistemas.todoapp.tasks.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id = -1;
    public String title;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    public boolean done;
}
