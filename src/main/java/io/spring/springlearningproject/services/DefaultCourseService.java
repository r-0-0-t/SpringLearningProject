package io.spring.springlearningproject.services;

import io.spring.springlearningproject.repository.RepositoryContext;
import io.spring.springlearningproject.schemas.Course;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * @author Ishan
 * Date: Jan 16, 2022
 */
@Service
public class DefaultCourseService implements CourseService {


    private final RepositoryContext repositoryContext;

    @Autowired
    public DefaultCourseService(RepositoryContext repositoryContext) {
        this.repositoryContext = repositoryContext;
    }

    @Override
    public List<Course> getCourses() {
        return repositoryContext.getAllItems(Course.class);
    }

    @Override
    public Course addNewCourse(Course course) {
        return repositoryContext.saveOne(course);
    }

    @Override
    public long deleteCourse(Object id) {
        return repositoryContext.deleteById(Course.class, id);
    }

    @Override
    public Optional<Course> getCourse(String  id) {
        return Optional.of(repositoryContext.getItemById(Course.class, id));
    }

}
