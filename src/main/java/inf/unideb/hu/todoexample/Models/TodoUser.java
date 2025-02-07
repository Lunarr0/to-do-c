package inf.unideb.hu.todoexample.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class TodoUser {
    //Implement me here :D

    String userToken;
    String userName;
}
