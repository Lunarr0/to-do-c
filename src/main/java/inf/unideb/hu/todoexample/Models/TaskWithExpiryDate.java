package inf.unideb.hu.todoexample.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskWithExpiryDate extends Task {

    //Implement me here :D
    @Column(name = "due_date", nullable = false)
    LocalDateTime expiryDate;
}