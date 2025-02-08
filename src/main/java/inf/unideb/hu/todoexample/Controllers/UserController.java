package inf.unideb.hu.todoexample.Controllers;

import inf.unideb.hu.todoexample.Models.TodoUser;
import inf.unideb.hu.todoexample.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Implement an endpoint to find a user by their token
    @GetMapping("/{token}")
    public ResponseEntity<TodoUser> getUserByToken(@PathVariable String token) {
       TodoUser user = userService.getUserByToken(token);
       if (user == null) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return  ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //Implement endpoint that adds a new user
    @PostMapping
    public ResponseEntity<TodoUser> createUser(@RequestBody TodoUser todoUser) {
        TodoUser user = userService.createUser(todoUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
