package pe.edu.upao.sistemas.todoapp.accounts.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.accounts.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("array")
public class UserRepositoryArray implements IUserRepository {
    private ArrayList<User> db = new ArrayList<>();

    UserRepositoryArray() {
        this.initializeDb();
    }

    private void initializeDb() {
        User admin = new User();
        admin.username = "admin";
        admin.password = "admin";
        this.create(admin);
    }

    @Override
    public List<User> list() {
        return db;
    }

    @Override
    public User create(User user) {
        user.id = db.size() + 1;
        db.add(user);
        return user;
    }

}
