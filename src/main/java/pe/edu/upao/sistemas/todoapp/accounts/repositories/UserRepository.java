package pe.edu.upao.sistemas.todoapp.accounts.repositories;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.accounts.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private ArrayList<User> db = new ArrayList<>();

    UserRepository() {
        this.initializeDb();
    }

    private void initializeDb() {
        User admin = new User();
        admin.username = "admin";
        admin.password = "admin";
        this.create(admin);
    }

    public List<User> list() {
        return db;
    }

    public User create(User user) {
        user.id = db.size() + 1;
        db.add(user);
        return user;
    }

}
