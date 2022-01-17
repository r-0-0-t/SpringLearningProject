package io.spring.springlearningproject.schemas;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
@Document
@Data
public class Course {

    @Id
    private String id;
    private String courseName;
    private String author;

    public Course(String id, String courseName, String author) {
        this.id = id;
        this.courseName = courseName;
        this.author = author;
    }

}
