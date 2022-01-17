package io.spring.springlearningproject.services;


import io.spring.springlearningproject.schemas.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
public interface CourseService {
    Optional<Course> getCourse(String id);
    List<Course> getCourses();
    Course addNewCourse(Course course);
    long deleteCourse(Object id);
}
