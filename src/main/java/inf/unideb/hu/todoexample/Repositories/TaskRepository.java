package inf.unideb.hu.todoexample.Repositories;

import inf.unideb.hu.todoexample.Models.Task;
import inf.unideb.hu.todoexample.Models.TaskWithExpiryDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Find tasks by userToken
    List<Task> findByUserToken(String userToken);

    // Find only TaskWithExpiryDate entities by userToken
    List<TaskWithExpiryDate> findByUserTokenAndExpiryDateIsNotNull(String userToken);

    List<TaskWithExpiryDate> findByExpiryDateBefore(LocalDateTime date);
}