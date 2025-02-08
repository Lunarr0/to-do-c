package inf.unideb.hu.todoexample.Services;

import inf.unideb.hu.todoexample.Models.TodoUser;
import inf.unideb.hu.todoexample.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<TodoUser> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by token
    public TodoUser getUserByToken(String token) {
        Optional<TodoUser> user = userRepository.findByToken(token);
        return user.orElse(null); // Return null if not found
    }

    // Create a new user
    public TodoUser createUser(TodoUser todoUser) {
        return userRepository.save(todoUser);
    }

    //To-Do update users
}
