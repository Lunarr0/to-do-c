package inf.unideb.hu.todoexample.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class TodoUser {
    //Implement me here :D
    @Id
    @Column(name = "user_token")
    String userToken;
    @Column(name = "user_name")
    String userName;
}
