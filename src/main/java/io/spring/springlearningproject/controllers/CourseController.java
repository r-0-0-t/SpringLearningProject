package io.spring.springlearningproject.controllers;

import io.spring.springlearningproject.schemas.Course;
import io.spring.springlearningproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(@Qualifier("courseService") CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("id") int id) {
        Optional<Course> course = courseService.getCourse(id);
        if(course.isPresent()) {
            return course.get();
        }
        return null;
    }

}
