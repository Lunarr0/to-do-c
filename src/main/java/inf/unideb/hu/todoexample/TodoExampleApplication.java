package inf.unideb.hu.todoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "inf.unideb.hu.todoexample.Repositories")
@EntityScan(basePackages = "inf.unideb.hu.todoexample.Models")
public class TodoExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoExampleApplication.class, args);
    }

}
