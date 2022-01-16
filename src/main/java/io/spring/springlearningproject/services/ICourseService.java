package io.spring.springlearningproject.services;


import io.spring.springlearningproject.schemas.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
public interface ICourseService {
    void addCourse(Course course);
    Optional<Course> getCourse(int id);
    List<Course> getCourses();

}
