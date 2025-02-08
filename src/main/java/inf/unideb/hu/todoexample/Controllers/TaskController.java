package inf.unideb.hu.todoexample.Controllers;

import inf.unideb.hu.todoexample.Models.NewTaskRequest;
import inf.unideb.hu.todoexample.Models.Task;
import inf.unideb.hu.todoexample.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Implement adding a task
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody NewTaskRequest task) {
        Task savedTask = taskService.createTask(task);


        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    //Implement getting all tasks from the user
    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getTaskForUser(
    @PathVariable String id
    ){
        return ResponseEntity.ok(taskService.getTasksForUser(id));
    }

    //Implement what to do when you recieve a request to delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
