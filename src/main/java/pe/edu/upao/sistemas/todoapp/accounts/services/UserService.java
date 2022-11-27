package pe.edu.upao.sistemas.todoapp.accounts.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.accounts.models.User;
import pe.edu.upao.sistemas.todoapp.accounts.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.list();
    }

    public User create(User user) {
        user.username = user.username.toLowerCase();
        return userRepository.create(user);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        Optional<User> userFound = userRepository.list().stream().filter(user -> user.username.equals(username)).findFirst();

        if(userFound.isPresent()) {
            User user = userFound.get();
            if(user.password.equals(password)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
