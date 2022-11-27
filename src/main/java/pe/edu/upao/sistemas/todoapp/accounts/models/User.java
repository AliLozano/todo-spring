package pe.edu.upao.sistemas.todoapp.accounts.models;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id = -1;

    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;
}
