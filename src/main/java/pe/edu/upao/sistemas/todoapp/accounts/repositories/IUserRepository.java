package pe.edu.upao.sistemas.todoapp.accounts.repositories;

import pe.edu.upao.sistemas.todoapp.accounts.models.User;

import java.util.List;

public interface IUserRepository {
    List<User> list() ;

    User create(User user);
}
