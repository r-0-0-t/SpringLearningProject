package io.spring.springlearningproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Course API", version = "1.0.0", description = "Learning Spring Framework\nWorks done:\n\t1. Dependency Injection in Spring Framework,\n\t2. Swagger"))
public class SpringLearningProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLearningProjectApplication.class, args);
    }

}
