package io.spring.springlearningproject.controllers;

import io.spring.springlearningproject.schemas.Course;
import io.spring.springlearningproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
@RestController
@RequestMapping(path = "/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(@Qualifier("courseService") CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Course insertCourse(@RequestBody Course course) {
        return courseService.addNewCourse(course);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable("id") String id) {
        return String.format("Delete Count: %s", courseService.deleteCourse(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("id") String id) {
        Optional<Course> course = courseService.getCourse(id);
        return course.orElse(null);
    }

}
