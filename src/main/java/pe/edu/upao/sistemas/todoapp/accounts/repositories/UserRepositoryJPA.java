package pe.edu.upao.sistemas.todoapp.accounts.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.sistemas.todoapp.accounts.models.User;

import java.util.List;

@Repository
@Profile("jpa")
public interface UserRepositoryJPA extends IUserRepository, CrudRepository<User, Integer> {
    @Override
    @Query("SELECT u from User u")
    List<User> list();

    @Override
    default User create(User user) {
        this.save(user);
        return user;
    }
}
