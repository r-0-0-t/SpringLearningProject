package io.spring.springlearningproject.repository;

import io.spring.springlearningproject.repository.conditions.Condition;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
/**
 * @author Ishan
 * Date: Jan 17, 2022
 */
@NoRepositoryBean
public interface RepositoryContext {
    <T> List<T> getAllItems(Class<T> tClass);
    <T> T getItemById(Class<T> tClass, String id);
    <T> T saveOne(T t);
    <T> long deleteById(Class<T> tClass, Object id);
    <T> List<T> getItemsByCondition(Class<T> tClass, Condition condition);
}
