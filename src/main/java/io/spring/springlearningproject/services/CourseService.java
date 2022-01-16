package io.spring.springlearningproject.services;

import io.spring.springlearningproject.schemas.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
@Service
@Qualifier("courseService")
public class CourseService implements ICourseService  {

    public List<Course> courses;

    public CourseService() {
        super();
        this.courses = new ArrayList<Course>();
        this.courses.add(new Course(1, "Java Course", "Herbert Schildt"));
        this.courses.add(new Course(2, "C++ Course", "Bala Guru"));
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Optional<Course> getCourse(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst();
    }

    @Override
    public void addCourse(Course course) {
        this.courses.add(course);
    }

}
