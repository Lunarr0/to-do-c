package inf.unideb.hu.todoexample.Services;

import inf.unideb.hu.todoexample.Models.NewTaskRequest;
import inf.unideb.hu.todoexample.Models.Task;
import inf.unideb.hu.todoexample.Models.TaskWithExpiryDate;
import inf.unideb.hu.todoexample.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(NewTaskRequest task) {
        if(task.getDueDate() == null){
            Task newTask = new Task();
            newTask.setUserToken(task.getUserToken());
            newTask.setTitle(task.getTitle());
            newTask.setDescription(task.getDescription());
            newTask.setCreateTime(LocalDateTime.now());
            newTask.setModifyTime(LocalDateTime.now());

            return taskRepository.save(newTask);
        }

        TaskWithExpiryDate taskWithExpiryDate = new TaskWithExpiryDate();
        taskWithExpiryDate.setUserToken(task.getUserToken());
        taskWithExpiryDate.setTitle(task.getTitle());
        taskWithExpiryDate.setDescription(task.getDescription());
        taskWithExpiryDate.setCreateTime(LocalDateTime.now());
        taskWithExpiryDate.setModifyTime(LocalDateTime.now());
        taskWithExpiryDate.setExpiryDate(task.getDueDate());

        return taskRepository.save(taskWithExpiryDate);
    }

    public Task saveTask(Task task) {
        if (task instanceof TaskWithExpiryDate taskWithExpiryDate) {

            return taskRepository.save(taskWithExpiryDate);
        }
        return taskRepository.save(task);
    }

    // Get Task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksForUser(String token) {
        return taskRepository.findByUserToken(token);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Delete Task by ID
    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with ID " + id + " does not exist.");
        }
        taskRepository.deleteById(id);
    }
}