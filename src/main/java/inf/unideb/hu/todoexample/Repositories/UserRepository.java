package inf.unideb.hu.todoexample.Repositories;

import inf.unideb.hu.todoexample.Models.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TodoUser, String> {
    Optional<TodoUser> findByToken(String token);
}
